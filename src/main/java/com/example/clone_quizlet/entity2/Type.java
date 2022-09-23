package com.example.clone_quizlet.entity2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 생성
@NoArgsConstructor // 파라미터가 없는 기본 생성자 생성
@Getter // Getter 자동 생성
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 컬럼 추가시 자동 생성
    private Long id;

    @Column
    @Enumerated(EnumType.STRING) // Enum 타입을 String 으로 지정
    private Mbti Mbti;

    @Column
    @Enumerated(EnumType.STRING) // Enum 타입을 String 으로 지정
    private Mbti sameType;

    @Column
    @Enumerated(EnumType.STRING) // Enum 타입을 String 으로 지정
    private Mbti otherType;

    @OneToMany(mappedBy = "type")
    private List<Result> results = new ArrayList<>();

}
