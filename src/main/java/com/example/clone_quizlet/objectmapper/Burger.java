package com.example.clone_quizlet.objectmapper;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Burger {
    private String name;
    private int price;
    private List<String> ingredients;
}
