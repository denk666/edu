package com.dkorolev.edu.springtest01.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

import com.dkorolev.edu.springtest01.dao.QuestionDao;
import com.dkorolev.edu.springtest01.domain.Question;

public class QuestionServiceImpl implements QuestionService {
    private QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
	this.questionDao = questionDao;
    }

    public void run(Reader in) throws IOException {
	List<Question> questionList = questionDao.read(in, 6);
	

//	System.out.println(questionList);
	
	BufferedReader console
	    = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("press ENTER to start quiz");
	console.readLine();
	Collections.shuffle(questionList);
	int correctAnswersCount = 0;
	for (int i = 0; i < questionList.size(); i++) {
	    Question q = questionList.get(i);
	    
	    StringBuilder sb = new StringBuilder("Question ");
	    sb.append(i + 1);
	    sb.append("/");
	    sb.append(questionList.size());
	    sb.append(": ");
	    sb.append(q.getQuestion());
	    sb.append("\n");
	    sb.append("Answers: ");
	    for (int j = 0; j < q.getAnswers().size(); j++) {
		sb.append(j + 1);
		sb.append(". ");
		sb.append(q.getAnswers().get(j));
		sb.append(". ");
	    }
	    System.out.println(sb);
	    
	    String userAnswerStr = console.readLine();
	    int userAnswer = -1;
	    try {
		userAnswer = Integer.valueOf(userAnswerStr);
	    } catch (NumberFormatException e) {
	    }
	    if (userAnswer == q.getCorrectAnsweIndex()) {
		correctAnswersCount++;
	    }
	}
	
	System.out.println(new StringBuffer("Quiz has been completed. Result: ")
		.append(correctAnswersCount).append("/").append(questionList.size()));
    }
}
