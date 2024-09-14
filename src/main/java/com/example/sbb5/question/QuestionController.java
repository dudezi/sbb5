package com.example.sbb5.question;

import com.example.sbb5.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String questionList(Model model) {
        List<Question> questionsList = this.questionService.getList();
        model.addAttribute("questionList", questionsList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String questionDetail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.questionCreate(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list"; // 저장 후 목록을 돌아간다.
    }
}
