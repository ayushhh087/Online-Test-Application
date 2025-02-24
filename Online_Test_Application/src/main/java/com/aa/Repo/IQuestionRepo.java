package com.aa.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.Model.QuestionModel;

public interface IQuestionRepo extends JpaRepository<QuestionModel, Long>{

}
