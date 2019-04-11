package com.dkorolev.edu.springtest01.dao;

import com.dkorolev.edu.springtest01.domain.Person;

public class PersonDaoSimple implements PersonDao {

    public int defaultAge;
    
    public Person findByName(String name) {
        return new Person(name, defaultAge);
    }

    public void setDefaultAge(int defaultAge) {
        this.defaultAge = defaultAge;
    }
}
