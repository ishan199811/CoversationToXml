package com.conversionChannel.serviceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.conversionChannel.model.FileDump;
import com.conversionChannel.service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService{



@Override
public ResponseEntity<?> validateTheXmlElements(FileDump fileDump){
	System.out.println("------------validation methiod called----------");
	
	if(fileDump.getCorporateEmailId()!=null) {
		System.out.println("------------validation methiod called----------");
		return ResponseEntity.ok("CorporateEmailId Not valid");
	}
	
	
	
	
	
	
	
	
	
	
	return null;
	
	
}















}
