package com.conversionChannel.serviceImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.conversionChannel.model.request.Action;
import com.conversionChannel.model.request.ChatRoom;
import com.conversionChannel.model.request.Conversation;
import com.conversionChannel.model.request.FileDump;
import com.conversionChannel.model.request.Participant;
import com.conversionChannel.model.request.RequestedFile;
import com.conversionChannel.model.request.Root;
import com.conversionChannel.model.response.ResponseFileDump;


@Service
public class XmlCovesationJsonServiceImpl {
	
	private static final Logger log = LoggerFactory.getLogger( XmlCovesationJsonServiceImpl.class);

	
	 public  ResponseEntity<?> creatingXMLwithJson(Root requestFileDump, int i)  throws  IOException, ParseException  {
		 String s = "2022.07.19 11:42:30:423";
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SSS");
			// parse to a millis
			Date date = formatter.parse(s);
			// get epoch millisecond
			long millis = date.getTime();
		 
		 List<ChatRoom> cl=new ArrayList<>();
	  XmlCovesationJsonServiceImpl xcjs=new  XmlCovesationJsonServiceImpl();
		List<Participant> participants=new ArrayList<>();
		
		for(ChatRoom cr:requestFileDump.getChatRooms()) {
			
			if(cr.getParticipants()!=null) {
			cl.add(cr);
				for(Participant p:cr.getParticipants()) {
					participants.add(p);
				}
			}
		}
		
		 return ResponseEntity.ok(xcjs.createXmlFormat(cl));
	 }
	 
	 public ResponseEntity<?> createXmlFormat(List<ChatRoom> cl  ) throws IOException, ParseException{
		String  xmlElementString="";
	
		 XmlCovesationJsonServiceImpl xcjs=new  XmlCovesationJsonServiceImpl();
		
		List<Participant> participants=new ArrayList<>();
	List<Action> action1=new ArrayList<>();
	
		
	for(ChatRoom c:cl) {
		
		
		log.info("------------"+c.getRoomId()+"-----------------");
	}
	
	
	
	xmlElementString=xmlElementString+"<FileDump xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
	 				+"\n";
		
		
		for(ChatRoom c:cl) {
		
			//Adding Head Elements
	    	xmlElementString=xmlElementString+"\n"+"<Conversation Perspective=\"Abend term Finance disussion group channel\">"+
			"\n"+"<RoomId>"+c.getRoomId()+"</RoomId>"
	 				+"\n"+"<StartTimeUtc>"+c.getStartTimeUtc()+"<StartTimeUtc/>"
	 				+"\n"+"<CallInitiator>"+c.getCallInitiator()+"</CallInitiator>"
//	 				+"\n"+"<CallType>"+fileDump.getCallType()+"</CallType>"
//	 				+"\n"+"<Vendor>"+fileDump.getVendor()+"</Vendore>"
//	 				+"\n"+"<Network>"+fileDump.getNetwork()+"</Network>"
//	 				+"\n"+"<Channel>"+fileDump.getChannel()+"</Channel>"
	 				+"\n";
	    	if(c.getParticipants()!=null) {
			for(Participant p:c.getParticipants()) {
				
				
				//Adding  ParticipentEnter Elements 
				 xmlElementString= xmlElementString+"\n"+"<ParticipantEntered>"
			      			+"\n"+"<LoginName>"+p.getLoginName()+"</LoginName>"
//			      			+"\n"+"<DateTimeUTC>"+action.getDateTimeUTC()+"</DateTimeUTC>"
//			      	+"\n"+"<InternalFlag>"+pe.getInternalFlag()+"</InternalFlag>"
//			      	+"\n"+"<ConversationID>"+pe.getConversionId()+"<ConversationID/>"
			      	+"\n"+"<CorporateEmailId>"+p.getCorporateEmailId()+"<CorporateEmailID>"
			      	+"\n"+"</ParticipantEntered>"
			      	+"\n"+"\n";
				 if(p.getActions()!=null) {
			for(Action action:p.getActions()) {
				
				action1.addAll(p.getActions());
				
				//Adding element for invite
				if(action.getType().contains("Invite")) {
					 xmlElementString = xmlElementString+"\n"+"<Invite>"
							 +"\n"+"<InviterLoginName>"+action.getInviterLoginName()+"</InviterLoginName>"
				      			+"\n"+"<LoginName>"+action.getLoginName()+"</LoginName>"
				      			+"\n"+"<DateTimeUTC>"+action.getDateTimeUTC()+"</DateTimeUTC>"
				      	+"\n"+"<Content>"+action.getContent()+"</Content>"
				     // 	+"\n"+"<Base64Content>"+action.getContent()+"<Base64Content/>"
				    //  	+"\n"+"<CorporateEmailId>"+p.getCorporateEmailId()+"<CorporateEmailID>"
				      	+"\n"+"</Invite>"
				      	+"\n";
				
		}
				
					
					
					 
//					 if(action.getType().contains("Message")) {
						
					  //Adding Message Elements
					 xmlElementString= xmlElementString +"<Message>"
			 	      			+"\n"+"<LoginName>"+p.getLoginName()+"</LoginName>"
			 	      			+"\n"+"<DateTimeUTC>"+action.getDateTimeUTC()+"</DateTimeUTC>"
			 	      	+"\n"+"<CorporateEmailId>"+p.getCorporateEmailId()+"</CorporateEmailId>"
			 	      +"\n"+"<Content>"+action.getContent()+"</Content>"
//				 	   	 	      	+"\n"+"<MessageType>"+m.getMessageType()+"</MessageType>"
//				 	   	 	      	+"\n"+"<MessageId>"+m.getMessageId()+"</MessageId>"
				 	   	 	      	+"\n"+"</Message>"
				 	   	 	      	+"\n"+"\n";
				//	 }
					//Adding FiletranferStarted Elements
					 if(action.getType().contains("Filetranfer")) {

				      		xmlElementString= xmlElementString +"<FileTransferStarted>"
				 	      			+"\n"+"<LoginName>"+action.getLoginName()+"</LoginName>"
				 	      			+"\n"+"<DateTimeUTC>"+action.getDateTimeUTC()+"</DateTimeUTC>"
				 	      	+"\n"+"<UserFileName>"+action.getUserFileName()+"</UserFileName>"
				 	      	+"\n"+"<FileName>"+action.getFileName()+"</FileName>"
				 	      	+"\n"+"<Status>"+action.getStatus()+"</Status>"
				 	      	+"\n"+"</FileTransferStarted>"
				 	      	+"\n"+"\n";
				      		
				      		
				      	//Adding FiletranferEnd Elements
				     		xmlElementString= xmlElementString +"<FileTransferEnd>"
				 	      			+"\n"+"<LoginName>"+action.getLoginName()+"</LoginName>"
				 	      			+"\n"+"<DateTimeUTC>"+action.getDateTimeUTC()+"</DateTimeUTC>"
				 	      	+"\n"+"<UserFileName>"+action.getUserFileName()+"</UserFileName>"
				 	      	+"\n"+"<FileName>"+action.getFileName()+"</FileName>"
				 	      	+"\n"+"<Status>"+action.getStatus()+"</Status>"
				 	      	+"\n"+"</FileTransferEnd>"
				 	      	+"\n"+"\n";
					 
					 }	
			}
				//Adding ParticipentLeft Elements			 
				 xmlElementString= xmlElementString +"<ParticipantLeft>"
			      			+"\n"+"<LoginName>"+p.getLoginName()+"</LoginName>"
			      			//+"\n"+"<DateTimeUTC>"+p.getDateTimeUtc()+"</DateTimeUTC>"
//			      	+"\n"+"<InternalFlag>"+pe.getInternalFlag()+"</InternalFlag>"
//			      	+"\n"+"<ConversationID>"+pe.getConversionId()+"<ConversationID/>"
			      	+"\n"+"<CorporateEmailId>"+p.getCorporateEmailId()+"<CorporateEmailID>"
			      	+"\n"+"</ParticipantLeft>"
			      	+"\n"+"\n";
					 }
			}
	    	}
			
	    	 xmlElementString= xmlElementString+"<EndTimeUTC>"+"123456"+"<EndTimeUtc/>"
				        +"\n" +"</Conversation>"+"\n";
		}	
		
		//Adding Fotter Elements
		 xmlElementString= xmlElementString
			        +"\n"+"</FileDump>" ; 
		
		
		//returning the final created string of Elements
		 String finalXmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n"+xmlElementString ;
		
		 FileWriter file1 = new FileWriter("/Applications/untitled folder/XML/NewXmlFronJson.xml");
	    	file1.write(finalXmlString);   
         file1.flush();  
         log.info("------------Your XML data is successfully written into XmlForRoomChatInteractionJson.xml---------");  
         file1.close();       	
         return ResponseEntity.ok("Your XML data is successfully written into XmlForRoomChatInteractionJson.xml");	   
		// return ResponseEntity.ok(cl);
	 }
	 
	 public String getTimeFormatInEpoch(String time) throws ParseException {
		 String s = time;
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SSS");
			// parse to a millis
			Date date = formatter.parse(s);
			// get epoch millisecond
			long millis = date.getTime();
			String epochTimeFormat = millis+"";
			return epochTimeFormat;
	 }
	 }

