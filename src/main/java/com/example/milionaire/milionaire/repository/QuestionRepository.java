package com.example.milionaire.milionaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.milionaire.milionaire.entity.Question;
//repository for questions
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByProfileId(Long profileId);
}