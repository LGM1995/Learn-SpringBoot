package com.example.clone_quizlet.repository;

import com.example.clone_quizlet.entity.Member;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

    @Override
    ArrayList<Member> findAll();
}
