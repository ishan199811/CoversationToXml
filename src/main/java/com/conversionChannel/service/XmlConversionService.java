package com.conversionChannel.service;

import java.io.IOException;



import org.springframework.http.ResponseEntity;

public interface XmlConversionService {


	

	ResponseEntity<?> creatingXML(Long id) throws IOException;

}
