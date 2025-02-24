package com.aa.Service;

import java.util.List;

import com.aa.Model.QuestionModel;

public interface IQuestionService {
	
	void addQuestion(QuestionModel question);
	
	List<QuestionModel> getQuestions();
}
