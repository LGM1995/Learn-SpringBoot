package com.example.clone_quizlet.dto;

import com.example.clone_quizlet.entity.Article;
import com.example.clone_quizlet.entity.User;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserDto {
    private Long id; // 회원 넘버
    private String username; // 회원 아이디
    private String email; // 회원 이메일
    private String password; // 회원 비밀번호
    private String nickname; // 회원 닉네임

    public User toEntity() {
        return new User(id, username, email, password, nickname);
    }
}
