package com.example.clone_quizlet.dto;

import com.example.clone_quizlet.entity.Member;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {


    private Long id; // 회원 아이디

    private String name; // 회원 이름

    private String email; // 회원 이메일

    private String password; // 회원 비밀번호

    private String nickname; // 회원 별명

//    private String photo; // 회원 사진

//    private Time birthday; // 회원 생일

    public Member toEntity() {
        return new Member(id, name, email, password, nickname);
    }

}
