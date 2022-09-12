package com.example.clone_quizlet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    SUPERADMIN("ROLE_ADMIN,ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String value;

}
