package com.example.clone_quizlet.repository2;

import com.example.clone_quizlet.entity2.Question;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    // 전체 질문 리스트 가져오기
    // 리스트엔 join된 answer들도 같이 들어있다.
    @Override
    @EntityGraph(attributePaths = {"answers"})
    List<Question> findAll();

}
