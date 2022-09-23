package com.example.clone_quizlet.dto2;

import com.example.clone_quizlet.entity2.Answer;
import com.example.clone_quizlet.entity2.Question;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 생성
@Getter // getter 자동 생성
/* DTO를 생성하는 이유
 * Entity 를 사용하여 DB와 직접적인 연결을 피하기 위함
 * Controller <-> Service 사이에 DTO로 정보를 전달
 * Service <-> JpaRepository 사이에 DB에 직접적인 연결이 필요할 때
 * Service가 DTO를 Entity로 변환하여 JpaRepositrory로 CRUD 진행
 */
public class QuestionDto {
    private Long id;
    private String content;

    private List<Answer> answers;

    /* Entity를 DTO로 변환 */
    public static QuestionDto toDto(Question question) {
        return new QuestionDto(
            question.getId(),
            question.getContent(),
            question.getAnswers()
        );
    }
}
