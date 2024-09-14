package com.example.sbb5.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionRepository questionRepository;

    @GetMapping("/list")
    public String questionList(Model model) {
        List<Question> questionsList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionsList);
        return "question_list";
    }
}
