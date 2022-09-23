package com.example.clone_quizlet.dto2;

import com.example.clone_quizlet.entity2.Mbti;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 생성
@NoArgsConstructor // 파라미터가 없는 기본 생성자 생성
@Getter // Getter 자동 생성
@Builder // Setter를 사용하지 않고 Builder와 Constructor를 사용하여 객체의 안전성과 일관성 보장
public class ResultDto {
    private Long id;
    private String name;
    private String title;
    private String content;
    private Long count;
    private Mbti mbti;

}
