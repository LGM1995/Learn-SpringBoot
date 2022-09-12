package com.example.clone_quizlet.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/")
    public ModelAndView getTest() {

        log.info("111111");

        ModelAndView mav = new ModelAndView("test.html");
        return mav;
    }
//    public ResponseEntity<?> getTest() {
//        return new ResponseEntity<String>("test", HttpStatus.OK);
//    }
//    public ModelAndView testPage() {
//        System.out.println("11111");
//        ModelAndView mav = new ModelAndView("test");
//
//        return mav;
//    }
}
