package com.example.clone_quizlet.repository;

import com.example.clone_quizlet.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
