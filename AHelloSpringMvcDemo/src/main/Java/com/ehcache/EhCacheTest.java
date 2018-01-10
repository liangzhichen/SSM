package com.ehcache;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/10.
 */
public class EhCacheTest {
    private static final String NAME = "cacheTest";

    public static void main(String[] args) {
        EhCacheUtil.getInstance().put(NAME,"userEch","test001");
        String value = (String) EhCacheUtil.getInstance().get(NAME,"userEch");

        List<JSONObject> jsons = new ArrayList<JSONObject>();
        JSONObject json1 = new JSONObject();
        json1.put("json","json1");
        JSONObject json2 = new JSONObject();
        json2.put("json","json2");
        JSONObject json3 = new JSONObject();
        json3.put("json","json3");
        jsons.add(json1);
        jsons.add(json2);
        jsons.add(json3);

        EhCacheUtil.getInstance().put(NAME,"jsons",jsons);
        List<JSONObject> jsonObjects = (List<JSONObject>)EhCacheUtil.getInstance().get(NAME,"jsons");
        for (JSONObject jsonObject : jsonObjects){
            System.out.println(jsonObject.get("json"));
        }

    }
}
