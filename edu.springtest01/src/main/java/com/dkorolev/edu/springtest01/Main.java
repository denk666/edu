package com.dkorolev.edu.springtest01;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dkorolev.edu.springtest01.service.QuestionService;

public class Main {

    public static void main(String[] args) throws IOException {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
	// PersonService personService = context.getBean(PersonService.class);
	//
	// Person ivan = personService.getByName("Ivan");
	// System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
	// context.close();

	String sourcePath = "src/main/resources/test.csv";
	QuestionService questionService = context.getBean(QuestionService.class);

	Reader in = null;
	try {
	    in = new FileReader(sourcePath);
	    questionService.run(in);

	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (in != null) {
		    in.close();
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
}
