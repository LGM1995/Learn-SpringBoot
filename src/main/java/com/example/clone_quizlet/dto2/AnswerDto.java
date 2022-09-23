package com.example.clone_quizlet.dto2;

import com.example.clone_quizlet.entity2.Answer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 생성
@NoArgsConstructor // 파라미터가 없는 기본 생성자 생성
@Getter // Getter 자동 생성
@Builder // Setter를 사용하지 않고 Builder와 Constructor를 사용하여 객체의 안전성과 일관성 보장
public class AnswerDto {
    private Long id;
    private String content;
    private String personality;

    /* JSON 은 xx_xx식의 스네이크 표기법을 사용하고
     * Java는 xxxXx식의 카멜 표기법을 사용하기 때문에
     * JsonProperty를 두어 이름을 매핑 시켜준다.
     * class에 걸어서 전체를 컬럼에 대하여 사용할 수도 있다.
     */
    @JsonProperty("question_id")
    private Long questionId;

    /* Entity를 DTO로 변환 */
    public static AnswerDto toDto(Answer answer) {
        return new AnswerDto(
            answer.getId(),
            answer.getContent(),
            answer.getPersonality(),
            answer.getQuestion().getId()
        );
    }

}
