package com.dkorolev.edu.springtest01.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.dkorolev.edu.springtest01.domain.Question;

public interface QuestionDao {
    List<Question> read(Reader in, int width) throws IOException;
}
