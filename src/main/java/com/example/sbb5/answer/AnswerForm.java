package com.example.sbb5.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message = "내용을 등록해주세요.")
    private String content;
}
