package com.example.clone_quizlet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id // 대표 값 회원 번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 회원 넘버
    @Column
    private String username; // 회원 아이디
    @Column
    private String email; // 회원 이메일
    @Column
    private String password; // 회원 비밀번호
    @Column
    private String nickname; // 회원 별명
}
