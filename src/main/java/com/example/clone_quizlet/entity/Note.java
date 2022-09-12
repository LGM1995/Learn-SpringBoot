package com.example.clone_quizlet.entity;

import com.example.clone_quizlet.dto.CommentDto;
import com.example.clone_quizlet.dto.NoteDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // 해당 노트 엔티티 여러개가, 하나의 Member에 연관된다!
    @OnDelete(action = OnDeleteAction.CASCADE) // 참조 무결성으로 인해 회원 삭제시 모든 데이터가 지워지도록 한다.
    @JoinColumn(name = "member_id")
    private Member member;

    @Column
    private String title;

    public static Note createNote(NoteDto dto, Member member) {
        // 예외 처리
        if (dto.getId() != null)
            throw new IllegalArgumentException("단어장 생성 실패! 단어장의 id가 없어야 합니다.");
        if (dto.getMemberId() != member.getId())
            throw new IllegalArgumentException("단어장 생성 실패! 회원의 id가 잘못되었습니다.");

        // 엔티티 생성 및 반환
        return new Note(
            dto.getId(),
            member,
            dto.getTitle()
        );
    }

    public void patch(NoteDto dto) {
        // 예외 발생
        if (this.id != dto.getId())
            throw  new IllegalArgumentException("단어장 수정 실패! 잘못된 id가 입력되었습니다!");

        // 객체를 갱신
        if (dto.getTitle() != null);
        this.title = dto.getTitle();
    }
}
