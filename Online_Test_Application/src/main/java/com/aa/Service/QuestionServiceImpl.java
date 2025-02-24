package com.aa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.Model.QuestionModel;
import com.aa.Repo.IQuestionRepo;

@Service
public class QuestionServiceImpl implements IQuestionService{
	
	@Autowired
	IQuestionRepo questRepo;

	@Override
	public void addQuestion(QuestionModel question) {
		questRepo.save(question);
		
	}

	@Override
	public List<QuestionModel> getQuestions() {
		// TODO Auto-generated method stub
		return questRepo.findAll();
	}
	
	
}
