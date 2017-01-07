package com.rohmanhakim.beritaku.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 19:44.
 */
public class ConverterUtils {
    public static String getDetikLargeCoverImage(String imageUrl){
        String[] buffers = imageUrl.split("\\?");
        return buffers[0] + "?width=480";
    }

    public static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }
}
