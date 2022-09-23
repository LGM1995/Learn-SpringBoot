package com.example.clone_quizlet.entity2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor // final 필드나 , @NonNull 이 붙은 필드에 대해 생성자를 생성
@Getter
public enum Mbti {

    ENFJ("ENFJ"), ENTJ("ENTJ"), ENFP("ENFP"),
    ENTP("ENTP"), ESFP("ESFP"), ESFJ("ESFJ"),
    ESTP("ESTP"), ESTJ("ESTJ"), INFP("INFP"),
    INFJ("INFJ"), INTP("INTP"), ISTP("ISTP"),
    ISFP("ISFP"), ISFJ("ISFJ"), ISTJ("ISTJ"),
    INTJ("INTJ");

    private final String value;

}
