package com.conversionChannel.serviceImpl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.conversionChannel.model.request.Root;
import com.conversionChannel.service.IConnectionRequestService;

@Service
public class IConnectionRequestServiceImpl implements IConnectionRequestService{

	@Autowired
	XmlCovesationJsonServiceImpl xmlCovesationJsonServiceImpl;
	@Override
	public  ResponseEntity<?> getApiRequest() throws IOException, ParseException {
        
		
		String authToken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBZG1pbkNvbXBhbnkiOiJUcnVlIiwiQWRtaW5Mb2dnZWRJbkFzIjoiRmFsc2UiLCJD"
				+ "bGllbnRJRCI6IjEiLCJDb21wYW55SUQiOjEsIkNvbXBhbnlUeXBlSUQiOjQsIkNvbnRhY3RHVUlEIjoiOUQ4QTY2NTMtMThFQi1FQjExLUFBODAtMEEwQzQw"
				+ "OTI2MEZDIiwiQ29udGFjdElEIjo5MDQ3LCJFbWFpbCI6ImJmb3N0ZXJAaWNvbm5lY3Rpb25zLmlvIiwiRmlyc3ROYW1lIjoiQnJ5Y2UiLCJJbWFnZVVSTCI6Imh0dH"
				+ "BzOi8vYXNzZXRzLmljb25uZWN0aW9ucy5pby9oZWFkc2hvdHMvOTA0Ny5wbmciLCJMYXN0TmFtZSI6IkZvc3RlciIsIlNraXBUZXJtcyI6IkZhbHNlIiwiU3Vic2NyaWJ"
				+ "lciI6IlRydWUiLCJleHAiOjE2OTU1MjkwOTQsImZpcnN0TmFtZSI6IkJyeWNlIiwiaWF0IjoxNjk1MDQ5MDk0LCJpZCI6OTA0NywibGFzdE5hbWUiOiJGb3N0ZXIiLCJuYX"
				+ "ZpZ2F0aW9uVXNlckRhdGEiOnsiaW1hZ2VVUkwiOiJodHRwczovL2Fzc2V0cy5pY29ubmVjdGlvbnMuaW8vaGVhZHNob3RzLzkwNDcucG5nIiwiaW5pdGlhbHMiOiJCRiIsIn"
				+ "Nob3dWZXJpZmllZFN0YXR1cyI6ZmFsc2UsInZlcmlmaWVkU3RhdHVzIjpmYWxzZX0sIm5iZiI6MTY5NTA0OTA5NH0"
				+ ".cD8DJX4mS_NY_9Ct1X3VuA-RR8YNxbmzbyF8sPi43QE";
		
		RestTemplate restTemplate=new RestTemplate();
        // Get 10th record data
        URL getUrl = new URL("https://bff.staging.iconnections.io/api/message/history");
        String apiUrl=getUrl.toString();
       
        
            // Create HttpHeaders and set the authorization token
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + authToken);
           // HttpURLConnection conection = (HttpURLConnection) getUrl.openConnection();
          
            
            // Create an HttpEntity with the headers
            HttpEntity<String> entity = new HttpEntity<>(headers);
        
            // Make the GET request with the entity
            ResponseEntity<Root> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Root.class);    
          
           
            
	      // JSONObject json = new JSONObject(response.getBody().toString());
	      return ResponseEntity.ok(xmlCovesationJsonServiceImpl.creatingXMLwithJson(response.getBody(), 0));
	    }
  
	
	
	
	
	
}
