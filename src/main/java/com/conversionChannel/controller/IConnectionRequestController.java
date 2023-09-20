package com.conversionChannel.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conversionChannel.model.request.Conversation;
import com.conversionChannel.model.request.RequestedFile;
import com.conversionChannel.model.request.Root;
import com.conversionChannel.service.IConnectionRequestService;
import com.conversionChannel.serviceImpl.XmlCovesationJsonServiceImpl;

@RestController
public class IConnectionRequestController {
	@Autowired
	   IConnectionRequestService  iConnectionRequestService;
	@Autowired
	 XmlCovesationJsonServiceImpl  xmlCovesationJsonServiceImpl;
	
	    @GetMapping("/json-data")
	    public ResponseEntity<?> getJsonData() throws IOException, ParseException {
	        return iConnectionRequestService.getApiRequest();
	    }
	    
	    @GetMapping("/json-dataa")
	    public ResponseEntity<?> getJsonDataa(@RequestBody Root fileDump) throws IOException, ParseException {
	       return xmlCovesationJsonServiceImpl.creatingXMLwithJson(fileDump, 0);
	    
	   // return ResponseEntity.ok(xmlCovesationJsonServiceImpl.creatingXMLwithJson(fileDump, 0));
	    }
	    
}
