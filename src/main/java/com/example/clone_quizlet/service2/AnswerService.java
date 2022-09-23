package com.example.clone_quizlet.service2;

import com.example.clone_quizlet.entity2.Answer;
import com.example.clone_quizlet.repository2.AnswerRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 서비스 객체를 스트링 부트에 생성
@Slf4j // log 사용을 위함
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

}
