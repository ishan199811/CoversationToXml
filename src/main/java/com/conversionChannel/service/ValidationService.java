package com.conversionChannel.service;

import org.springframework.http.ResponseEntity;

import com.conversionChannel.model.FileDump;

public interface ValidationService {

	ResponseEntity<?> validateTheXmlElements(FileDump fileDump);

}
