package com.example.clone_quizlet.repository;

import com.example.clone_quizlet.entity.Comment;
import com.example.clone_quizlet.entity.Member;
import com.example.clone_quizlet.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    ArrayList<User> findAll();


    @Query(value =
        "SELECT * " +
            "FROM user " +
            "WHERE username = :username",
        nativeQuery = true)
    User findByUserName(@Param("username") String username);

}
