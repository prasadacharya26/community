package com.community.auth.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONUtil {

    static Gson gson = new Gson();

    public static String toJSON(Object obj) {
        return gson.toJson(obj);
    }

    public static Object fromJson(String jsonStr, Class<? extends Object> class1) {
        if (null == jsonStr) {
            System.out.println("NO DATA");
        }
        Object object = null;
        try {
            object = gson.fromJson(jsonStr, class1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return object;
    }

    public static Object fromJsonArray(String jsonArrayStr,@SuppressWarnings("rawtypes") TypeToken token) {

        if (null == jsonArrayStr || token == null) {
            System.out.println("NO DATA");
        }
        Object object = null;
        try {
            object = gson.fromJson(jsonArrayStr, token.getType());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return object;
    };

}
