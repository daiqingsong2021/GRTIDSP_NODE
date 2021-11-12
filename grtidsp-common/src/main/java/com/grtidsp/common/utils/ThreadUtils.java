package com.grtidsp.common.utils;


import java.util.Map;

public class ThreadUtils {


    private static final ThreadLocal<Map<String, Object>> userHolder = new ThreadLocal<>();


    public static void setUserHolder(Map<String, Object> map){
        userHolder.set(map);
    }

    public static Map<String, Object> getUserHolder(){
        return userHolder.get();
    }

    public static void remove(){
        userHolder.remove();
    }

}