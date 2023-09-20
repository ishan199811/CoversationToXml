package com.conversionChannel.service;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.http.ResponseEntity;

public interface IConnectionRequestService {

	ResponseEntity<?> getApiRequest() throws IOException, ParseException;

}
