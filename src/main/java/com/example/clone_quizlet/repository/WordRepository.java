package com.example.clone_quizlet.repository;

import com.example.clone_quizlet.entity.Note;
import com.example.clone_quizlet.entity.Word;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WordRepository extends JpaRepository<Word, Long> {

    // 특정 아이디의 모든 노트 조회
    @Query(value =
        "SELECT * " +
            "FROM word " +
            "WHERE note_id = :noteId",
        nativeQuery = true)
    List<Word> findByNoteId(@Param("noteId") Long noteId);

    // 특정 이름의 모든 단어 조회
    List<Word> findByName(@Param("name") String name);

}
