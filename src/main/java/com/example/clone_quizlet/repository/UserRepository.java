package com.example.clone_quizlet.repository;

import com.example.clone_quizlet.entity.Article;
import com.example.clone_quizlet.entity.User;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    ArrayList<User> findAll();
}
