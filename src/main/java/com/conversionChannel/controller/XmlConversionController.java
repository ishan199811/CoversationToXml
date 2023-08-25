package com.conversionChannel.controller;

import java.io.IOException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.conversionChannel.service.XmlConversionService;

@RestController
public class XmlConversionController {
	
	
	@Autowired
	XmlConversionService xmlConversionService;
	
	
	@GetMapping("/createXml/{id}")
	public ResponseEntity<?> createXmlFile(@PathVariable Long id ) throws IOException{
		
		return ResponseEntity.ok(xmlConversionService.creatingXML(id));
	}

}
