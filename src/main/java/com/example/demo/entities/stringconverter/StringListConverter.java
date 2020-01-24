package com.example.demo.entities.stringconverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

	
	 private static final String SPLIT_CHAR = ",";

	    @Override
	    public String convertToDatabaseColumn(List<String> stringList) {
	        return String.join(SPLIT_CHAR, stringList);
	    }

	    @Override
	    public List<String> convertToEntityAttribute(String string) {
	    	
	    	List<String> list = new ArrayList<>(Arrays.asList(string)); 
	    	
	        return  list;
	    }
}
