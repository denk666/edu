package com.dkorolev.edu.springtest01.domain;

import java.util.List;

public class Question {
    String question;
    List<String> answers;
    int correctAnsweIndex;

    public String getQuestion() {
	return question;
    }

    public void setQuestion(String question) {
	this.question = question;
    }

    public List<String> getAnswers() {
	return answers;
    }

    public void setAnswers(List<String> answers) {
	this.answers = answers;
    }

    public int getCorrectAnsweIndex() {
	return correctAnsweIndex;
    }

    public void setCorrectAnsweIndex(int correctAnsweIndex) {
	this.correctAnsweIndex = correctAnsweIndex;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((answers == null) ? 0 : answers.hashCode());
	result = prime * result + correctAnsweIndex;
	result = prime * result + ((question == null) ? 0 : question.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Question other = (Question) obj;
	if (answers == null) {
	    if (other.answers != null)
		return false;
	} else if (!answers.equals(other.answers))
	    return false;
	if (correctAnsweIndex != other.correctAnsweIndex)
	    return false;
	if (question == null) {
	    if (other.question != null)
		return false;
	} else if (!question.equals(other.question))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Question [question=");
	builder.append(question);
	builder.append(", answers=");
	builder.append(answers);
	builder.append(", correctAnsweIndex=");
	builder.append(correctAnsweIndex);
	builder.append("]");
	return builder.toString();
    }
}
