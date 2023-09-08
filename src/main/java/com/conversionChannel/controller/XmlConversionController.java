package com.conversionChannel.controller;

import java.io.IOException;
import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conversionChannel.model.RequestFileJson;
import com.conversionChannel.service.XmlConversionService;


@RestController
public class XmlConversionController {
	
	
	@Autowired
	XmlConversionService xmlConversionService;
	
	private static final Logger log = LoggerFactory.getLogger(XmlConversionController.class);
	
	@GetMapping("/createXml/{id}/{i}")
	public ResponseEntity<?> createXmlFile(@PathVariable Long id , @PathVariable int i ) throws IOException, ParseException{
		log.info("---- /createXml/{id} -----url called-------");
		return ResponseEntity.ok(xmlConversionService.creatingXML(id,i));
	}
	@GetMapping("/createXmlWithJson/{i}")
	public ResponseEntity<?> createXmlFileWithJsonBody(@RequestBody RequestFileJson requestFileJson , @PathVariable int i ) throws IOException, ParseException{
		log.info("---- /createXml/{id} -----url called-------");
		return ResponseEntity.ok(xmlConversionService.creatingXMLwithJson(requestFileJson,i));
	}

}
