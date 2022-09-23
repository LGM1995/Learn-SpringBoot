package com.example.clone_quizlet.entity2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // DB가 해당 객체를 인식하여 클래스로 테이블을 자동 생성 DB테이블과 직접적인 1:1 매핑
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 생성
@NoArgsConstructor // 파라미터가 없는 기본 생성자 생성
@Getter // Getter 자동 생성
@Builder // Setter를 사용하지 않고 Builder와 Constructor를 사용하여 객체의 안전성과 일관성 보장
public class Question {
    @Id // 대표값 pk 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 값을 순차적으로 자동생성
    private Long id;

    @Column // 테이블 생성시 해당 변수명으로 자동 매핑하여 생성(name = "xxx";)로 변경가능
    private String content; // 질문의 내용

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

}
