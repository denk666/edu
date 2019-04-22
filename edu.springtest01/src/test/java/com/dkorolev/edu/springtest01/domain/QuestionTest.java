package com.dkorolev.edu.springtest01.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuestionTest {
    
    private Question question;
    
    @Before
    public void before() {
	question = new Question();
    }
    
    @After
    public void after() {
	question = null;
    }
    
    @Test
    private void testQuaestionField() {
	question.setQuestion("questionTest");
	Assert.assertEquals(question.getQuestion(), "questionTest");
    }
    
    @Test
    private void testCorrectAnsweIndex() {
	question.setCorrectAnsweIndex(100500);
	Assert.assertEquals(question.getCorrectAnsweIndex(), 100500);
    }
    
    @Test
    private void testAnswers() {
    }
}
