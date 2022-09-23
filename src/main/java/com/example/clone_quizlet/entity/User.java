package com.example.clone_quizlet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class User {

    @Id // 대표값을 지정! like a 주민등록번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id를 자동 생성 에노테이션!
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    // 현재는 비밀번호 수정만 가능
    public void patch(User user) {
        if (user.password != null)
            this.password = user.password;
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = true;
        this.role = Role.USER;
    }
}
