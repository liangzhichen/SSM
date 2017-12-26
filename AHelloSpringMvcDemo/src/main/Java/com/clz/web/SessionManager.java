package com.clz.web;

import com.clz.User.bean.UserInfo;

import java.util.Locale;
import java.util.Map;


public class SessionManager {
    private static ThreadLocal s_locale = new ThreadLocal();
    private static ThreadLocal s_user = new ThreadLocal();
    private static ThreadLocal s_reqData = new ThreadLocal();
    private static ThreadLocal s_reqResult = new ThreadLocal();
    private static ThreadLocal s_startTime = new ThreadLocal();

    public static UserInfo getUser() {
        return (UserInfo) s_user.get();
    }

    /**
     * 设置登录用户信息
     *
     * @param user
     *            UserInfoInterface
     */
    public static void setUser(UserInfo user) {
        s_user.set(user);
    }
    public static Map getData() {
        return (Map) s_reqData.get();
    }

    public static void setData(Map map) {
        s_reqData.set(map);
    }

    public static Map getResult() {
        return (Map) s_reqResult.get();
    }

    public static void setResult(Map map) {
        s_reqResult.set(map);
    }


    public static Locale getLocale() {
        if (s_locale == null || s_locale.get() == null) {
            return null;
        }
        Locale locale = (Locale) s_locale.get();
        return locale;
    }

    public static void setLocale(Locale locale) {
        s_locale.set(locale);
    }
    public static Long getStartTime() {
        return (Long) s_startTime.get();
    }

    public static void setStartTime(long startTime) {
        s_startTime.set(startTime);
    }
}
