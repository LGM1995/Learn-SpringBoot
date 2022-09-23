package com.example.clone_quizlet.api2;

import com.example.clone_quizlet.entity2.Mbti;
import com.example.clone_quizlet.entity2.Result;
import com.example.clone_quizlet.service2.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultApiController {
    @Autowired
    private ResultService resultService;


}
