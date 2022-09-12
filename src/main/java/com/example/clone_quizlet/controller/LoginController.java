package com.example.clone_quizlet.controller;

import com.example.clone_quizlet.dto.ArticleForm;
import com.example.clone_quizlet.entity.Article;
import javax.persistence.Column;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class LoginController {
    @GetMapping({"/",""})
    public String loginForm() {
        return "loginFrom";
    }

    @PostMapping({"/",""})
    public String update(ArticleForm form) {
        System.out.println("wow");
        return "redirect:/articles/";
    }
}
