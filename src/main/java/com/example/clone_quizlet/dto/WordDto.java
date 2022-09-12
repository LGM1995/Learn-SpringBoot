package com.example.clone_quizlet.dto;

import com.example.clone_quizlet.entity.Note;
import com.example.clone_quizlet.entity.Word;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class WordDto {
    private Long id;
    @JsonProperty("note_id")
    private Long noteId;
    private String name;
    private String mean;
//    private String img;

    public static WordDto createWordDto(Word word) {
        return new WordDto(
            word.getId(),
            word.getNote().getId(),
            word.getName(),
            word.getMean()
//            word.getImg()
        );
    }
}
