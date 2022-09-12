package com.example.clone_quizlet.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 회원 번호
    @Column(nullable = false, unique = true)
    private String userId; // 회원 아이디
//    @Column(nullable = false)
//    private String name; // 회원 이름
//    @Column(nullable = false)
//    private String email; // 회원 이메일
    @Column(nullable = false)
    private String password; // 회원 비밀번호
//    @Column(nullable = false)
//    private String nickname; // 회원 닉네임
    @Column(nullable = false)
    private String role;

    @Builder
    public User(String userId, String password, String role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    // 사용자의 권한을 콜렉션 형태로 반환
    // 단, 클래스 자료형은 GrantedAuthority를 구현해야함
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : role.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public String getPassword() { return password;}

    @Override // 계정 만료되었는지 확인하는 로직
    public boolean isAccountNonExpired() {
        return true;
    } // true -> 만료되지 않았음

    @Override // 계정 잠금 여부 반환
    public boolean isAccountNonLocked() {
        return true;
    } // true -> 잠금되지 않았음

    @Override // 패스워드 만료 여부 반환
    public boolean isCredentialsNonExpired() {
        return true;
    } // true -> 만료되지 않았음

    @Override // 계정 사용 가능 여부 반환
    public boolean isEnabled() {
        return true;
    } // true -> 사용가능

}
