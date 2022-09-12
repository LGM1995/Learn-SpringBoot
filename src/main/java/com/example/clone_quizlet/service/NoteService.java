package com.example.clone_quizlet.service;


import com.example.clone_quizlet.dto.CommentDto;
import com.example.clone_quizlet.dto.NoteDto;
import com.example.clone_quizlet.entity.Article;
import com.example.clone_quizlet.entity.Comment;
import com.example.clone_quizlet.entity.Member;
import com.example.clone_quizlet.entity.Note;
import com.example.clone_quizlet.repository.MemberRepository;
import com.example.clone_quizlet.repository.NoteRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<NoteDto> notes(Long memberId) {
        // 반환
        return noteRepository.findByMemberId(memberId).stream()
            .map(note -> NoteDto.createNoteDto(note))
            .collect(Collectors.toList());
    }

    @Transactional
    public NoteDto create(Long memberID, NoteDto dto) {
        // 단어장 조회 및 예외 발생
        Member member = memberRepository.findById(memberID)
            .orElseThrow(() -> new IllegalArgumentException("단어장 생성 실패! 대상 회원이 없습니다."));

        // 단어장 엔티티 생성
        Note note = Note.createNote(dto, member);

        // 단어장 엔티티를 DB로 저장
        Note created = noteRepository.save(note);

        // DTO로 변경하여 변환
        return NoteDto.createNoteDto(created);
    }

    @Transactional
    public NoteDto update(Long id, NoteDto dto) {
        // 단어장 조회 및 예외 발생
        Note target = noteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("단어장 수정 실패! 대상 단어장이 없습니다."));

        // 단어장 수정
        target.patch(dto);

        // DB로 갱신
        Note updated = noteRepository.save(target);

        // 단어장 엔티티를 DTO로 변환 및 반환
        return NoteDto.createNoteDto(updated);
    }

    @Transactional
    public NoteDto delete(Long id) {
        // 댓글 조회 및 예외 발생
        Note target = noteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("단어장 삭제 실패! 대상이 없습니다."));

        // 댓글 DB에서 삭제
        noteRepository.delete(target);

        // 삭제 댓글을 DTO로 반환
        return NoteDto.createNoteDto(target);
    }
}
