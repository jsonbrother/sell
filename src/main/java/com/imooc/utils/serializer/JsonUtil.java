package com.imooc.utils.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by TongHaiJun
 * 2019/8/4 22:39
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
