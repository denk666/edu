package com.dkorolev.edu.springtest01.util;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
    public static String defineDataLocation() {
	String path = "data.csv";
	if (Files.isReadable(Paths.get(path))) {
	    return path;
	}
	path = "/data.csv";
	if (Files.isReadable(Paths.get(path))) {
	    return path;
	}
	path = "src/main/resources/data.csv";
	if (Files.isReadable(Paths.get(path))) {
	    return path;
	}
	
	return null;
    }
}
