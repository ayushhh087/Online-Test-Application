package com.aa.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aa.Model.QuestionModel;
import com.aa.Model.ResultModel;
import com.aa.Service.IQuestionService;

@Controller
public class TestController {
    @Autowired
    IQuestionService repo;

    @GetMapping("/")
    public String home() {
        return "/Home";
    }

    @GetMapping("/addQuestions")
    public String addQuestions() {
        return "addQuestions";
    }	

    @PostMapping("/addQ")
    public String getMethodName(@ModelAttribute QuestionModel question, RedirectAttributes redirect) {
        repo.addQuestion(question);
        System.out.println(question.getQuestion() + "\n" + "Options:" + question.getOptions());
        redirect.addFlashAttribute("msg", "Question Added");
        return "redirect:/addQuestions";
    }

    @GetMapping("/Quiz")
    public String showQuiz(Model model) {
        List<QuestionModel> questions = repo.getQuestions(); // ✅ DB se questions fetch karo
        model.addAttribute("questions", questions);
        return "Quiz";
    }
    
    @PostMapping("/submitQuiz")
    public String submitQuiz(@RequestParam Map<String, String> userAnswers, Model model) {
        List<QuestionModel> questions = repo.getQuestions(); 

        int score = 0;
        int totalQuestions = questions.size();

        for (int i = 0; i < totalQuestions; i++) {
            String selectedAnswer = userAnswers.get("q" + i);
            String correctAnswer = questions.get(i).getCorrectAnswer();

            if (selectedAnswer != null && selectedAnswer.equals(correctAnswer)) {
                score++;
            }
        }

        // ✅ ResultModel ka object banao
        ResultModel result = new ResultModel(score, totalQuestions);

        // ✅ Model me result add karo
        model.addAttribute("result", result);

        // ✅ Result page return karo
        return "Result"; // Ensure Thymeleaf template ka naam yahi ho
    }

}
