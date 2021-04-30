package com.example.demo;

import com.example.demo.model.Response;
import com.example.demo.model.Student;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppStartupRunner implements ApplicationRunner {

    public static Response response;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        response = new Response();
        createData(response);
    }

    private void createData(Response response){
        for(int i=0 ; i<response.metaData.frames ; i++){
            Student s = new Student(i, "abc");
            response.students.add(s);

            List<String> content = Util.readFile(Util.userDirectory + "\\src\\main\\java\\com\\example\\demo\\text.txt");
            s.randomText  = content;
        }
    }

}
