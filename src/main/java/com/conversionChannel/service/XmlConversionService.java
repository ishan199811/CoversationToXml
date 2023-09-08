package com.conversionChannel.service;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.http.ResponseEntity;

import com.conversionChannel.model.RequestFileJson;

public interface XmlConversionService {


	

	

	ResponseEntity<?> creatingXML(Long id, int i) throws IOException, ParseException;

	

	ResponseEntity<?> creatingXMLwithJson(RequestFileJson requestFileDump, int i) throws IOException, ParseException;

}
