package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Util {

    public static final String userDirectory = System.getProperty("user.dir");
    public static final String outputDirectory = userDirectory + File.separatorChar + "output" + File.separatorChar;
    public static final String inputDirectory = userDirectory + File.separatorChar + "Input" + File.separatorChar;


    public static List<String> readFile(String filePath) {
        Logs.println("Reading : " + filePath);
        List<String> contents = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            do {
                line = br.readLine();
                if (line != null) {
                    contents.add(line);
                }
            } while (line != null);
            Logs.println("Reading Done : " + contents.size());
            return contents;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

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
