package com.example.clone_quizlet.dto;

public class ArticleForm {

    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
            "title='" + title + '\'' +
            ", content='" + content + '\'' +
            '}';
    }
}
