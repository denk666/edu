package com.dkorolev.edu.springtest01.service;

import java.io.IOException;
import java.io.Reader;

public interface QuestionService {
    void run(Reader in) throws IOException;
}
