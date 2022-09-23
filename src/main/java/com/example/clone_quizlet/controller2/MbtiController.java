package com.example.clone_quizlet.controller2;

import com.example.clone_quizlet.dto2.QuestionDto;
import com.example.clone_quizlet.service2.AnswerService;
import com.example.clone_quizlet.service2.QuestionService;
import com.example.clone_quizlet.service2.ResultService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MbtiController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ResultService resultService;

    @GetMapping("/mbti")
    public String mbti(Model model) {
        List<QuestionDto> qDto = questionService.read();

        model.addAttribute("questions", qDto);
        return "mbti/mbti";
    }
}
