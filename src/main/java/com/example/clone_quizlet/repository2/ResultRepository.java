package com.example.clone_quizlet.repository2;

import com.example.clone_quizlet.entity2.Result;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {

    // type 리스트를 포함한 모든 result
    @Override
    @EntityGraph(attributePaths = {"type"})
    List<Result> findAll();
}
