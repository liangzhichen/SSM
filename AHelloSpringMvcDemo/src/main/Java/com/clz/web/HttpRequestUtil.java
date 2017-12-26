package com.clz.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HttpRequestUtil {

	private static transient Log log = LogFactory.getLog(HttpRequestUtil.class);

	public static Long getParamAsLong(Map map, String param) throws IOException {
		Object obj = map.get(param);
		if (obj == null) {
			return null;
		} else if (obj instanceof String) {
			if (obj.equals("")) {
				return null;
			} else {
				long l = Long.parseLong((String) obj);
				return l;
			}
		} else if (obj instanceof Integer) {
			return Long.valueOf(obj + "");
		} else {
			return (Long) obj;
		}
	}

	public static Integer getParamAsInteger(Map map, String param)
			throws IOException {
		Object obj = map.get(param);
		if (obj == null) {
			return null;
		} else if (obj instanceof String) {
			if (obj.equals("")) {
				return null;
			} else {
				Integer l = Integer.parseInt((String) obj);
				return l;
			}
		} else if (obj instanceof Long) {
			return Integer.valueOf(obj + "");
		} else {
			return (Integer) obj;
		}
	}

	public static String getParamAsString(Map map, String param)
			throws IOException {
		Object obj = map.get(param);
		if (obj == null) {
			return null;
		} else if (obj instanceof String) {
			return (String) obj;
		} else {
			return obj + "";
		}
	}

	public static Map getData(HttpServletRequest request) throws IOException {
		return getData(request, false);
	}

	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		// 最外层解析
		if (jsonStr != null && jsonStr.startsWith("{") && jsonStr.endsWith("}")) {
			Map<String, Object> map = new HashMap<String, Object>();

			JSONObject json = JSON.parseObject(jsonStr);
			for (Object k : json.keySet()) {

				Object v = json.get(k);
				// 如果内层还是数组的话，继续解析
				if (v instanceof JSONArray) {
					List list = new ArrayList();

					JSONArray ja = (JSONArray) v;
					for (int i = 0; i < ja.size(); i++) {
						Object oobj = ja.get(i);
						if (oobj.toString().startsWith("{")) {
							JSONObject json2 = (JSONObject) oobj;
							list.add(parseJSON2Map(json2.toString()));
						} else {
							list.add(oobj);
						}
					}
					map.put(k.toString(), list);
				} else {
					Map<String, Object> m = parseJSON2Map(v.toString());
					if (m == null) {
						map.put(k.toString(), v);
					} else {
						map.put(k.toString(), m);
					}
				}
			}
			return map;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param request
	 * @param b
	 *            true表示从流里面获取，false表示从缓存里面获取(为了方便H5调试导致的问题，上了生产就不用了)
	 * @return
	 * @throws IOException
	 */
	public static Map getData(HttpServletRequest request, boolean b)
			throws IOException {
		if (b) {
			BufferedReader bufferedReader = null;
			String data = "";
			try {
				// request.setCharacterEncoding("UTF-8");

				ServletInputStream in = request.getInputStream();

				byte[] bytes = new byte[1024 * 1024];

				int nRead = 1;
				int nTotalRead = 0;
				while (nRead > 0) {
					nRead = in.read(bytes, nTotalRead, bytes.length
							- nTotalRead);
					if (nRead > 0)
						nTotalRead = nTotalRead + nRead;
				}
				data = new String(bytes, 0, nTotalRead, "utf-8");

			} catch (IOException ex) {
				throw ex;
			} finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException ex) {
						throw ex;
					}
				}
			}
            if(request.getRequestURL().toString().endsWith("healthPage.html")){
            	
            }else{
            	log.debug(request.getRequestURL() + " data:" + data);
            }
			Map map = new HashMap();
			if (data != null && data.length() != 0) {
				map = parseJSON2Map(data);
			}
			return map;
		} else {
			return SessionManager.getData();
		}
	}

	public static List<Map> createMapByDataContainer(List dc, String wantAttr) {
		return createMapByDataContainer(dc, wantAttr, null, null);
	}

	/**
	 * 将需要返回给前台的数据包装下
	 * 
	 * @param dc
	 * @param wantAttr
	 * @param renameAttrMap
	 * @param timeFormat
	 * @return
	 */
	public static List<Map> createMapByDataContainer(List dc, String wantAttr,
			Map<String, String> renameAttrMap, String timeFormat) {
		List<Map> result = new ArrayList<Map>();

		for (Object d : dc) {
			Map resultMap = createMapByDataContainer(d, wantAttr,
					renameAttrMap, timeFormat);

			result.add(resultMap);
		}

		return result;
	}

	public static Map createMapByDataContainer(Object d, String wantAttr) {
		return createMapByDataContainer(d, wantAttr, null, null);
	}

	public static Map createMapByDataContainer(Object d, String wantAttr,
			Map<String, String> renameAttrMap, String timeFormat) {
		if (timeFormat == null || timeFormat.equals("")) {
			timeFormat = "yyyy-MM-dd HH:mm:ss";// 2016-12-12 20:00:00
		}
		DateFormat sdf = new SimpleDateFormat(timeFormat);

		String[] wantAttrs = wantAttr.split("\\|");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		for (String key : wantAttrs) {
			if (key.equals("")) {
				continue;
			}

			String methodName = "get" + key.substring(0, 1).toUpperCase()
					+ key.substring(1);
			Object value = null;
			try {
				Method method = d.getClass().getMethod(methodName);
				value = method.invoke(d);
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			String newKey = key;
			if (renameAttrMap != null && renameAttrMap.containsKey(key)) {
				newKey = renameAttrMap.get(key);
			}
			if (value == null) {
				value = "";
			} else {

			}
			if (value instanceof Timestamp || value instanceof Date) {
				String tsStr = "";
				try {
					// 方法一
					tsStr = sdf.format(value);
				} catch (Exception e) {
					e.printStackTrace();
				}

				resultMap.put(newKey, tsStr);
			} else {
				resultMap.put(newKey, value);
			}

		}
		return resultMap;
	}

	public static String checkNullByDataContainer(Map d, String wantAttr,
			boolean ifThrow) {

		String[] wantAttrs = wantAttr.split("\\|");
		String nullAttr = null;
		for (String key : wantAttrs) {
			if (key.equals("")) {
				continue;
			}

			Object value = null;
			try {
				if (d.get(key) == null
						|| d.get(key).toString().trim().equals("")) {
					nullAttr = key;
					break;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		if (nullAttr != null) {
			if (ifThrow) {
				//throw new ZMCCInternalException(1, nullAttr + "不能为空");
			}
		}
		return nullAttr;
	}

	// 修改banner校验提交参数是 否有空
	public static String checkNullByDataContainer(Map d) {

		String nullAttr = null;
		for (Object key : d.keySet()) {
			if (key.equals("")) {
				continue;
			}

			Object value = null;
			try {
				if (d.get(key) == null
						|| d.get(key).toString().trim().equals("")) {
					nullAttr = key.toString();
					break;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return nullAttr;
	}

	public static Object setFieldValue(Object bean, Map valMap) {
		return setFieldValue(bean, valMap, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将传入的数据塞入bean里面
	 * 
	 * @param bean
	 * @param valMap
	 */
	public static Object setFieldValue(Object bean, Map valMap, String format) {
		Class<?> cls = bean.getClass();
		// 取出bean里的所有方法
		Method[] methods = cls.getDeclaredMethods();
		Field[] fields = cls.getDeclaredFields();
		for (Method met : methods) {
			String metName = met.getName();
			if (metName.startsWith("set")
					&& met.getParameterTypes().length == 1) {
				Class paramCls = met.getParameterTypes()[0];
				String fieldname = metName.substring(3, 4).toLowerCase()
						+ metName.substring(4, metName.length());
				Object strValue = valMap.get(fieldname);
				if (strValue != null && !strValue.equals("")) {
					Object obj = null;
					if (paramCls == strValue.getClass()) {
						obj = strValue;
					} else if (paramCls == String.class) {
						obj = strValue.toString();
					} else if (paramCls == Integer.class) {
						obj = Integer.parseInt(strValue.toString());
					} else if (paramCls == Long.class) {
						obj = Long.parseLong(strValue.toString());
					} else if (paramCls == Short.class) {
						obj = Short.parseShort(strValue.toString());
					} else if (paramCls == Date.class) {
						obj = parseDate(strValue.toString(), format);
					} // TODO 还有别的类型
					try {
						met.invoke(bean, obj);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						System.out.println(met.getName() + "参数类型不对，应该是"
								+ paramCls + "，实际是" + obj.getClass());
						e.printStackTrace();
					} catch (InvocationTargetException e) {

						e.printStackTrace();
					}
				}
			}
		}
		return bean;
	}

	public static Date parseDate(String datestr, String format) {
		if (null == datestr || "".equals(datestr)) {
			return null;
		}
		try {
			String fmtstr = null;
			if (format != null && !format.equals("")) {
				fmtstr = format;
			} else if (datestr.indexOf(':') > 0) {
				fmtstr = "yyyy-MM-dd HH:mm:ss";
			} else {
				fmtstr = "yyyy-MM-dd";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(fmtstr);
			return sdf.parse(datestr);
		} catch (Exception e) {
			return null;
		}
	}

	public static String parSetName(String fieldName) {
		if (null == fieldName || "".equals(fieldName)) {
			return null;
		}
		int startIndex = 0;
		if (fieldName.charAt(0) == '_')
			startIndex = 1;
		return "set"
				+ fieldName.substring(startIndex, startIndex + 1).toUpperCase()
				+ fieldName.substring(startIndex + 1);
	}

	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}

}