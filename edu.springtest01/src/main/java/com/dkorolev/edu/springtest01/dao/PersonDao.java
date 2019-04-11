package com.dkorolev.edu.springtest01.dao;

import com.dkorolev.edu.springtest01.domain.Person;

public interface PersonDao {

    Person findByName(String name);
}
