package com.conversionChannel.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.conversionChannel.model.FileDump;
import com.conversionChannel.service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService{

	private static final Logger log = LoggerFactory.getLogger( ValidationServiceImpl.class);

@Override
public ResponseEntity<?> validateTheXmlElements(FileDump fileDump){
	log.info("------------Validation method called----------");
	
	if(fileDump.getCorporateEmailId()==null) {
	
		return ResponseEntity.ok("CorporateEmailId Not valid");
}
	if(fileDump.getCallInitiator()==null) {
	
		return ResponseEntity.ok("CallInitiator Not valid");
	}
	if(fileDump.getEndTimeUtc()==null) {
		
		return ResponseEntity.ok("EndTimeUtc Not valid");
	}
	if(fileDump.getStartTimeUtc()==null) {
		
		return ResponseEntity.ok("StartTimeUtc Not valid");
	}
if(fileDump.getCorporateEmailId()==null) {
		
		return ResponseEntity.ok("CorporateEmailId Not valid");
	}
if(fileDump.getVendor()==null) {
	
	return ResponseEntity.ok("Vendor Not valid");
}
if(fileDump.getParticipentEntered()==null) {
	
	return ResponseEntity.ok("ParticipentEntered Not valid");
}
if(fileDump.getParticipentExit()==null) {
	
	return ResponseEntity.ok("ParticipentLeft Not valid");
}
if(fileDump.getFileTransferedStarted()==null) {
	
	return ResponseEntity.ok("FileTransferedStarted Not valid");
}
if(fileDump.getFileTransferedEnd()==null) {
	
	return ResponseEntity.ok("FileTransferedEnd Not valid");
}
if(fileDump.getLoginName()==null) {
	
	return ResponseEntity.ok("LoginName Not valid");
}
	return null;
}
}















