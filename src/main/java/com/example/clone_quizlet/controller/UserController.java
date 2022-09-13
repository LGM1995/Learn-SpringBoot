package com.example.clone_quizlet.controller;

import com.example.clone_quizlet.dto.ArticleForm;
import com.example.clone_quizlet.dto.UserDto;
import com.example.clone_quizlet.entity.Article;
import com.example.clone_quizlet.entity.User;
import com.example.clone_quizlet.repository.UserRepository;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users/new")
    public String newUserForm() {
        return "users/new";
    }

    @PostMapping("/users/create")
    public String createUser(UserDto userDto, HttpSession session) {
        log.info(userDto.toString());

        // 1. Dto를 변환! Entity!
        User user = userDto.toEntity();
        log.info(user.toString());

        // 2. Repository에게 Entity를 DB안에 저장하게 함!
        User saved = userRepository.save(user);
        log.info(saved.toString());

        // 3. 회원가입 정보를 session에 저장하고 리다이렉트 한다.
        session.setAttribute("userName", user.getUsername());
        System.out.println(session.getAttribute("userName"));
        System.out.println(user.getUsername());
        return "redirect:/";
    }
}
