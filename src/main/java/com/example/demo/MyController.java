package com.example.demo;

import com.example.demo.model.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(maxAge = 3600)
@RestController
public class MyController {

    @GetMapping("/test")
    public String test(@RequestParam(defaultValue = "data") String dt,
                                 @RequestParam(defaultValue = "-1") int fi,
                                 HttpServletRequest request) {
        Util.printAllRequestParams("w3schools_os_1", request );
        if( dt.equalsIgnoreCase("metadata") ){
            return Response.getMetadata();
        }
        return Response.getData(fi);

    }
}
