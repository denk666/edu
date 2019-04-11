package com.dkorolev.edu.springtest01.service;

import com.dkorolev.edu.springtest01.dao.PersonDao;
import com.dkorolev.edu.springtest01.domain.Person;

public class PersonServiceImpl implements PersonService {

    private PersonDao dao;

//    public PersonServiceImpl(PersonDao dao) {
//        this.dao = dao;
//    }
    
    public void setDao(PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
