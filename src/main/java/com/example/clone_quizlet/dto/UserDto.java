package com.example.clone_quizlet.dto;

import com.example.clone_quizlet.entity.Role;
import com.example.clone_quizlet.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private Role role;

    public User toEntity() {
        return new User(id, username, password);
    }

}
