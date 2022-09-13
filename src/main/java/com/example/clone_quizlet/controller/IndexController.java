package com.example.clone_quizlet.controller;

import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        String userName = session.getAttribute("userName").toString();

        log.info("{}", userName + "님 로그아웃");
        session.invalidate();

        return "redirect:/";
    }

}
