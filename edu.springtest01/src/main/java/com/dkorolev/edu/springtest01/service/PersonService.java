package com.dkorolev.edu.springtest01.service;

import com.dkorolev.edu.springtest01.domain.Person;

public interface PersonService {

    Person getByName(String name);
}
