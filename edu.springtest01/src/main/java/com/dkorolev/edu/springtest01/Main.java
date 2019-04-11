package com.dkorolev.edu.springtest01;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dkorolev.edu.springtest01.domain.Person;
import com.dkorolev.edu.springtest01.service.PersonService;

public class Main {

    public static void main(String[] args) throws IOException {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
		"spring-context.xml");
	PersonService personService = context.getBean(PersonService.class);

	Person ivan = personService.getByName("Ivan");
	System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
	context.close();
    }
}
