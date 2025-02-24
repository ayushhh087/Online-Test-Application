package com.aa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aa.Model.QuestionModel;
import com.aa.Service.IQuestionService;



@Controller
public class TestController {
	@Autowired
	IQuestionService repo;
	
	@GetMapping("/")
	public String home()
	{
		return "/Home";
	}
	
	@GetMapping("/addQuestions")
	public String addQuestions()
	{
		return "addQuestions";
	}
	
	@PostMapping("/addQ")
	public String getMethodName(@ModelAttribute QuestionModel question,RedirectAttributes redirect) {
		repo.addQuestion(question);
		System.out.println(question.getQuestion()+"\n"+"Options"+question.getOptions());
		redirect.addFlashAttribute("msg", "Question Added");
		return "redirect:/addQuestions";
	}
	
}
