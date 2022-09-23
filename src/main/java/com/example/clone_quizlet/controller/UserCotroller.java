package com.example.clone_quizlet.controller;

import com.example.clone_quizlet.dto.UserDto;
import com.example.clone_quizlet.entity.User;
import com.example.clone_quizlet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserCotroller {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("login")
    public String login(UserDto userDto) {
        User log = userDto.toEntity();
        userRepository.findById(log.getId());
        System.out.println(log.getUsername());
        System.out.println(userDto.getPassword());
        log.toString();
        return "/articles";

    }

}
