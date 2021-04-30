package com.example.demo.model;

import com.example.demo.AppStartupRunner;
import com.example.demo.Util;

import java.util.ArrayList;
import java.util.List;

public class Response {

    public MetaData metaData = new MetaData();
    public List<Student> students = new ArrayList<>();

    public static String getMetadata(){
        Response rsp = new Response();
        rsp.students = null;
        rsp.metaData = AppStartupRunner.response.metaData;
        return Util.toJson(rsp);
    }

    public static String getData(int fi){
        Response rsp = new Response();
        if( fi == -1 ) {
            rsp.students = AppStartupRunner.response.students;
        }
        else{
            rsp.students.add( AppStartupRunner.response.students.get(fi) );
        }
        rsp.metaData = AppStartupRunner.response.metaData;
        return Util.toJson(rsp);
    }

}
