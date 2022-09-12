package com.example.clone_quizlet.entity;

import com.example.clone_quizlet.dto.CommentDto;
import com.example.clone_quizlet.dto.WordDto;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "note_id")
    private Note note;

    @Column
    private String name;

    @Column
    private String mean;

//    @Column
//    private String img;

    public static Word createWord(WordDto dto, Note note) {
        // 예외 처리
        if (dto.getId() != null)
            throw new IllegalArgumentException("단어 등록 실패! 단어의 id가 없어야 합니다.");
        if (dto.getNoteId() != note.getId())
            throw new IllegalArgumentException("단어 등록 실패! 노트의 id가 잘못되었습니다.");

        // 엔티티 생성 및 반환
        return new Word(
            dto.getId(),
            note,
            dto.getName(),
            dto.getMean()
//            dto.getImg()
        );
    }

    public void patch(WordDto dto) {
        // 예외 발생
        if (this.id != dto.getId())
            throw  new IllegalArgumentException("단어 수정 실패! 잘못된 id가 입력되었습니다!");

        // 객체를 갱신
        if (dto.getName() != null);
        this.name = dto.getName();

        if (dto.getMean() != null);
        this.mean = dto.getMean();

//        if (dto.getImg() != null);
//        this.img = dto.getImg();
    }
}
