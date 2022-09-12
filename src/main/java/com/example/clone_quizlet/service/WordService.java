package com.example.clone_quizlet.service;

import com.example.clone_quizlet.dto.NoteDto;
import com.example.clone_quizlet.dto.WordDto;
import com.example.clone_quizlet.entity.Member;
import com.example.clone_quizlet.entity.Note;
import com.example.clone_quizlet.entity.Word;
import com.example.clone_quizlet.repository.NoteRepository;
import com.example.clone_quizlet.repository.WordRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private NoteRepository noteRepository;

    public List<WordDto> words(Long noteId) {
        return wordRepository.findByNoteId(noteId).stream()
            .map(word -> WordDto.createWordDto(word))
            .collect(Collectors.toList());
    }

    @Transactional
    public WordDto create(Long noteId, WordDto dto) {
        // 단어 조회 및 예외 발생
        Note note = noteRepository.findById(noteId)
            .orElseThrow(() -> new IllegalArgumentException("단어 생성 실패! 대상 단어장이 없습니다."));

        // 단어장 엔티티 생성
        Word word = Word.createWord(dto, note);

        // 단어 엔티티를 DB로 저장
        Word created = wordRepository.save(word);

        // DTO로 변경하여 변환
        return WordDto.createWordDto(created);
    }

    @Transactional
    public WordDto update(Long id, WordDto dto) {
        // 단어 조회 및 예외 발생
        Word target = wordRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("단어 수정 실패! 대상 단어가 없습니다."));

        // 단어 수정
        target.patch(dto);

        // DB로 갱신
        Word updated = wordRepository.save(target);

        // 단어 엔티티를 DTO로 변환 및 반환
        return WordDto.createWordDto(updated);
    }

    @Transactional
    public WordDto delete(Long id) {
        // 단어 조회 및 예외 발생
        Word target = wordRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("단어 삭제 실패! 대상이 없습니다."));

        // 댓글 DB에서 삭제
        wordRepository.delete(target);

        // 삭제 댓글을 DTO로 반환
        return WordDto.createWordDto(target);
    }
}
