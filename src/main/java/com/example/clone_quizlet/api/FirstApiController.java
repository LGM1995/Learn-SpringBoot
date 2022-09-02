package com.example.clone_quizlet.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestAPI용 컨트롤러 ! JSON을 반환!
public class FirstApiController {


    @GetMapping("/api/hello")
    public String hello() {
        return "hello world!";
    }
}
