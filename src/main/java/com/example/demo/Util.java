package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Util {

    public static void printAllRequestParams(String heading, HttpServletRequest request){
        Enumeration enumeration = request.getParameterNames();
        Map<String, Object> modelMap = new HashMap<>();
        while(enumeration.hasMoreElements()){
            String parameterName = (String) enumeration.nextElement();
            modelMap.put(parameterName, request.getParameter(parameterName));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(heading + " - ");
        sb.append(modelMap);
        Logs.println( sb.toString() );
    }

    public static String toJson(Object frames) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(frames);
    }
}
