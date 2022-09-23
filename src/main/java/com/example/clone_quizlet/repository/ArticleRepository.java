package com.example.clone_quizlet.repository;

import com.example.clone_quizlet.entity.Article;
import com.example.clone_quizlet.entity.Comment;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Override
    ArrayList<Article> findAll();

    @Query(value =
        "SELECT * " +
            "FROM article " +
            "WHERE title = :title",
        nativeQuery = true)
    List<Article> findByTitle(@Param("title") String title);

}

