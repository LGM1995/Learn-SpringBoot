package com.example.clone_quizlet.service2;

import com.example.clone_quizlet.entity2.Mbti;
import com.example.clone_quizlet.entity2.Result;
import com.example.clone_quizlet.repository2.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 서비스 객체를 스트링 부트에 생성
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;



}
