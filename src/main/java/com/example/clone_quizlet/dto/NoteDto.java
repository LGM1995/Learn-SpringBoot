package com.example.clone_quizlet.dto;

import com.example.clone_quizlet.entity.Note;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class NoteDto {
    private Long id;
    @JsonProperty("member_id")
    private Long memberId;
    private String title;

    public static NoteDto createNoteDto(Note note) {
        return new NoteDto(
            note.getId(),
            note.getMember().getId(),
            note.getTitle()
        );
    }
}
