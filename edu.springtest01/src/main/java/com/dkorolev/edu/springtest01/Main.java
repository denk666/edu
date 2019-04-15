package com.dkorolev.edu.springtest01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dkorolev.edu.springtest01.service.QuestionService;
import com.dkorolev.edu.springtest01.util.Utils;

public class Main {

    public static void main(String[] args) throws IOException {
	Reader in = null;
	ClassPathXmlApplicationContext context = null;
	try {
	    context = new ClassPathXmlApplicationContext("spring-context.xml");

	    QuestionService questionService = context.getBean(QuestionService.class);

	    in = new InputStreamReader(new FileInputStream(Utils.defineDataLocation()), StandardCharsets.UTF_8);
	    questionService.run(in);

	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (in != null) {
		    in.close();
		}
		if (context != null) {
		    context.close();
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
}
