package com.conversionChannel.service;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.http.ResponseEntity;

public interface XmlConversionService {


	

	

	ResponseEntity<?> creatingXML(Long id, int i) throws IOException, ParseException;

}
