package com.example.clone_quizlet.api;

import com.example.clone_quizlet.annotation.RunningTime;
import com.example.clone_quizlet.dto.CommentDto;
import com.example.clone_quizlet.dto.NoteDto;
import com.example.clone_quizlet.service.NoteService;
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
public class NoteApiController {

    @Autowired
    private NoteService noteService;

    // 단어장 목록 조회
    @GetMapping("api/quizlet/{memberId}/notes")
    public ResponseEntity<List<NoteDto>> notes(@PathVariable Long memberId) {
        // 서비스에게 위임
        List<NoteDto> dtos = noteService.notes(memberId);

        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // 단어장 생성
    @PostMapping("/api/quizlet/{memberId}/notes")
    public ResponseEntity<NoteDto> create(@PathVariable Long memberId,
        @RequestBody NoteDto dto) {
        // 서비스에게 위임
        NoteDto createdDto = noteService.create(memberId, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    // 단어장 수정
    @PatchMapping("/api/notes/{id}")
    public ResponseEntity<NoteDto> update(@PathVariable Long id,
        @RequestBody NoteDto dto) {
        // 서비스에게 위임
        NoteDto updatedDto = noteService.update(id, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    // 단어장 삭제
    @RunningTime
    @DeleteMapping("/api/notes/{id}")
    public ResponseEntity<NoteDto> delete(@PathVariable Long id) {
        // 서비스에게 위임
        NoteDto updatedDto = noteService.delete(id);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }
}
