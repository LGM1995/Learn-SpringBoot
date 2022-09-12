package com.example.clone_quizlet.repository;

import com.example.clone_quizlet.entity.Comment;
import com.example.clone_quizlet.entity.Note;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoteRepository extends JpaRepository<Note, Long> {

    // 특정 아이디의 모든 노트 조회
    @Query(value =
        "SELECT * " +
            "FROM note " +
            "WHERE member_id = :memberId",
        nativeQuery = true)
    List<Note> findByMemberId(@Param("memberId") Long memberId);

    // 특정 이름의 모든 단어장 조회
    List<Note> findByTitle(@Param("title") String title);
}
