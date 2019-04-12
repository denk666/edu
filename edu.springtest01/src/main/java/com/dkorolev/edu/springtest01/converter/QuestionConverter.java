package com.dkorolev.edu.springtest01.converter;

import java.util.List;

import com.dkorolev.edu.springtest01.domain.Question;

public interface QuestionConverter {
    List<Question> convertSourceToQuestions(List<List<String>> source);
}
