package com.example.clone_quizlet.api;

import com.example.clone_quizlet.annotation.RunningTime;
import com.example.clone_quizlet.dto.CommentDto;
import com.example.clone_quizlet.dto.WordDto;
import com.example.clone_quizlet.service.WordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordApiController {

    @Autowired
    private WordService wordService;

    // 단어 목록 조회
    @GetMapping("/api/quizlet/{noteId}/words")
    public ResponseEntity<List<WordDto>> words(@PathVariable Long noteId) {
        // 서비스에게 위임
        List<WordDto> dtos = wordService.words(noteId);

        // 결과 응답
        return  ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // 단어 생성
    @PostMapping("/api/quizlet/{noteId}/words")
    public ResponseEntity<WordDto> create(@PathVariable Long noteId,
        @RequestBody WordDto dto) {
        // 서비스에게 위임
        WordDto createdDto = wordService.create(noteId, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    // 단어 수정
    @PatchMapping("/api/words/{id}")
    public ResponseEntity<WordDto> update(@PathVariable Long id,
        @RequestBody WordDto dto) {
        // 서비스에게 위임
        WordDto updatedDto = wordService.update(id, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    // 단어 삭제
    @RunningTime
    @DeleteMapping("/api/words/{id}")
    public ResponseEntity<WordDto> delete(@PathVariable Long id) {
        // 서비스에게 위임
        WordDto updatedDto = wordService.delete(id);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }
}
