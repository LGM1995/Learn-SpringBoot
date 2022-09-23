package com.example.clone_quizlet.service2;

import com.example.clone_quizlet.dto2.QuestionDto;
import com.example.clone_quizlet.repository2.QuestionRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 서비스 객체를 스트링 부트에 생성
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    // 조인된 모든 question을 가져와 dto로 변환시킨다.
    @Transactional
    public List<QuestionDto> read() {
        return questionRepository.findAll().stream().map(question -> QuestionDto.toDto(question)).collect(
            Collectors.toList());
    }
}
