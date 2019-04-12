package com.dkorolev.edu.springtest01.converter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.dkorolev.edu.springtest01.domain.Question;

public class QuestionConverterImpl implements QuestionConverter {
    public List<Question> convertSourceToQuestions(List<List<String>> source){
	List<Question> result = new LinkedList<Question>();
	if (source != null) {
	    for (List<String> rawQuestion : source) {
		Question question= new Question();
		question.setQuestion(rawQuestion.get(0));
		List<String> answers = new ArrayList<String>(4);
		answers.add(rawQuestion.get(1));
		answers.add(rawQuestion.get(2));
		answers.add(rawQuestion.get(3));
		answers.add(rawQuestion.get(4));
		question.setAnswers(answers);
		question.setCorrectAnsweIndex(Integer.valueOf(rawQuestion.get(5)));
		result.add(question);
	    }
	}
	return result;
    }
}
