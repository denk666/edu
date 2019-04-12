package com.dkorolev.edu.springtest01.dao;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.dkorolev.edu.springtest01.converter.QuestionConverter;
import com.dkorolev.edu.springtest01.converter.QuestionConverterImpl;
import com.dkorolev.edu.springtest01.domain.Question;

public class CSVQuestionDaoImpl implements QuestionDao {
    public static void main(String[] args) {
	Reader in = null;
	try {
	    in = new FileReader("src/main/resources/test.csv");
	    System.out.println(new CSVQuestionDaoImpl(new QuestionConverterImpl()).read(in, 6));
	} catch (Exception e) {
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

    private QuestionConverter converter;

    public CSVQuestionDaoImpl(QuestionConverter converter) {
	this.converter = converter;
    }

    public List<Question> read(Reader in, int width) throws IOException {
	List<List<String>> rawDataList = new LinkedList<List<String>>();
	Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
	for (CSVRecord csvRecord : records) {
	    List<String> list = new LinkedList<String>();
	    rawDataList.add(list);
	    for (int i = 0; i < width; i++) {
		list.add(csvRecord.get(i));
	    }
	}

	return converter.convertSourceToQuestions(rawDataList);
    }
}
