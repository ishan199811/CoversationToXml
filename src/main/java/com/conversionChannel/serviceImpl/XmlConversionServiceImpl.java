package com.conversionChannel.serviceImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.conversionChannel.model.Audio;
import com.conversionChannel.model.FileDump;
import com.conversionChannel.model.FileTransferEnd;
import com.conversionChannel.model.FileTransferStarted;
import com.conversionChannel.model.Invite;
import com.conversionChannel.model.Message;
import com.conversionChannel.model.ParticipentEnter;
import com.conversionChannel.model.ParticipentLeft;
import com.conversionChannel.model.RequestFileDump;
import com.conversionChannel.repository.AudioRepository;
import com.conversionChannel.repository.FileTransferEndRepository;
import com.conversionChannel.repository.FileTransferStartRepository;
import com.conversionChannel.repository.InviteRepository;
import com.conversionChannel.repository.MessageRepository;
import com.conversionChannel.repository.ParticipentEnterRepository;
import com.conversionChannel.repository.ParticipentLeftRepository;
import com.conversionChannel.repository.RequestFileDumpRepository;
import com.conversionChannel.service.ValidationService;
import com.conversionChannel.service.XmlConversionService;




@Service
public class XmlConversionServiceImpl implements XmlConversionService{
	@Autowired
	InviteRepository inviteRepository;
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	ParticipentEnterRepository participentEnterRepository;
	
	@Autowired
	ParticipentLeftRepository participentLeftRepository;
	
	@Autowired
	FileTransferStartRepository filetransferStartRepository;
	
	@Autowired
	FileTransferEndRepository fileTransferEndRepository;
	
	@Autowired
	RequestFileDumpRepository requestFileDumpRepository;
	
	@Autowired
	AudioRepository audioRepository;
	
	@Autowired
	ValidationService validationService;
	
	
	private static final Logger log = LoggerFactory.getLogger( XmlConversionServiceImpl.class);

	
	@Override
	 public  ResponseEntity<?> creatingXML(Long id, int i)  throws  IOException, ParseException  {
		 
		log.info("--------Creating xml method called---------");
		// input string
		String s = "2022.07.19 11:42:30:423";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SSS");
		// parse to a millis
		Date date = formatter.parse(s);
		// get epoch millisecond
		long millis = date.getTime();
		System.out.println(millis); // 1500475350423
          FileDump fileDump = new FileDump();
	 	  XmlConversionServiceImpl cxs=new XmlConversionServiceImpl();
	 	
	 	  RequestFileDump requestFileDump= requestFileDumpRepository.getById(id);
	 	  List<Invite> inviteList=inviteRepository.findAll();  	
	 	  List<Message> messageList=messageRepository.findAll();
	 	    	List<ParticipentEnter> list= participentEnterRepository.findAll();
	 	    	List<FileTransferStarted> fileList=filetransferStartRepository.findAll();
	 	    	List<FileTransferEnd> fileList1=fileTransferEndRepository.findAll();
	 	    	List<ParticipentLeft> list2= participentLeftRepository.findAll();
	 	    	List<Audio> audioList=audioRepository.findAll();
	 	    	fileDump.setRoomId(requestFileDump.getRoomId());
	          	fileDump.setStartTimeUtc(millis);
	 	        fileDump.setEndTimeUtc(millis);
	 	        fileDump.setBase64Content(requestFileDump.getBase64Content());
	 	    	fileDump.setLoginName(requestFileDump.getLoginName());
	 	    	fileDump.setParticipentEntered(list);
	 	    	fileDump.setMessage(messageList);
	 	    	fileDump.setInvite(inviteList);
	 	    	fileDump.setAudio(audioList);
	 	    	fileDump.setCallInitiator(requestFileDump.getCallInitiator());
	 	    	fileDump.setCallType(requestFileDump.getCallType());
	 	    	fileDump.setFileTransferedEnd(fileList1);
	 	    	fileDump.setFileTransferedStarted(fileList);
	 	    	fileDump.setParticipentExit(list2);
	 	    	fileDump.setVendor(requestFileDump.getVendor());
	 	    	fileDump.setNetwork(requestFileDump.getNetwork());
	 	    	fileDump.setCorporateEmailId(requestFileDump.getCorporateEmailId());
	 	    	fileDump.setStatus(requestFileDump.getStatus());
	 	 
	 	    	//Validating Elements 
	 	    	ResponseEntity<?> re = validationService.validateTheXmlElements(fileDump);
	 	    	if(re!=null) {
	 	    		return ResponseEntity.ok(re);
	 	    	}
	 	    	
	 	    	//checking file type if i value is 2,3,5 then it will create  XMLForChatInteraction
	 	    	if(i==3||i==5||i==2) {
	 	    		return ResponseEntity.ok(cxs.coustomXMLForChatInteraction(fileDump,i));	
	 	    	}
	 	    	
	 	    	//else it will create file for XMLForRoomChatInteraction
	 	    	return ResponseEntity.ok(cxs.coustomXMLForRoomChatInteraction(fileDump));
	 	    	
	 	    	}
	
	
	//Creating String for ChatInteraction Xml Elements
	public  ResponseEntity<?>  coustomXMLForChatInteraction( FileDump fileDump, int i) throws  IOException, ParseException {
		
		log.info("-----------coustomXMLForChatInteraction method called-----------");
	    	String xmlElementString=""; 	
	    //Adding Head Elements
	    	xmlElementString=xmlElementString+"<FileDump xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
	 				+"\n"+"<Conversation Perspective=\"Abend term Finance disussion group channel\">"
	 				+"\n"+"<RoomId>"+fileDump.getRoomId()+"</RoomId>"
	 				+"\n"+"<StartTimeUtc>"+fileDump.getStartTimeUtc()+"<StartTimeUtc/>"
	 				+"\n"+"<CallInitiator>"+fileDump.getCallInitiator()+"</CallInitiator>"
	 				+"\n"+"<CallType>"+fileDump.getCallType()+"</CallType>"
	 				+"\n"+"<Vendor>"+fileDump.getVendor()+"</Vendore>"
	 				+"\n"+"<Network>"+fileDump.getNetwork()+"</Network>"
	 				+"\n"+"<Channel>"+fileDump.getChannel()+"</Channel>"
	 				+"\n";
	    	
	    //AddingElement for Invite
	    	for(Invite invite:fileDump.getInvite()) {
	    		log.info(invite.toString());
	    		invite.setLoginName(fileDump.getLoginName());
	    		invite.setDateTimeUtc(fileDump.getStartTimeUtc());
	    		invite.setContent(fileDump.getBase64Content());
	    		invite.setBase64Content(fileDump.getBase64Content());
	    		invite.setCorporateEmailId(fileDump.getCorporateEmailId());
	    		xmlElementString = xmlElementString+"\n"+"<Invite>"
		      			+"\n"+"<LoginName>"+invite.getLoginName()+"</LoginName>"
		      			+"\n"+"<DateTimeUTC>"+invite.getDateTimeUtc()+"</DateTimeUTC>"
		      	+"\n"+"<Content>"+invite.getContent()+"</Content>"
		      	+"\n"+"<Base64Content>"+invite.getBase64Content()+"<Base64Content/>"
		      	+"\n"+"<CorporateEmailId>"+invite.getCorporateEmailId()+"<CorporateEmailID>"
		      	+"\n"+"</Invite>"
		      	+"\n";
	    	}
	    	//Adding  ParticipentEnter Elements 
	    	for(ParticipentEnter pe:fileDump.getParticipentEntered()) {
	      		pe.setDateTimeUtc(fileDump.getEndTimeUtc());
	      		pe.setLoginName(fileDump.getLoginName());
	      		pe.setCorporateEmailid(fileDump.getCorporateEmailId());
	    xmlElementString= xmlElementString+"\n"+"<ParticipantEntered>"
	      			+"\n"+"<LoginName>"+pe.getLoginName()+"</LoginName>"
	      			+"\n"+"<DateTimeUTC>"+pe.getDateTimeUtc()+"</DateTimeUTC>"
	      	+"\n"+"<InternalFlag>"+pe.getInternalFlag()+"</InternalFlag>"
	      	+"\n"+"<ConversationID>"+pe.getConversionId()+"<ConversationID/>"
	      	+"\n"+"<CorporateEmailId>"+pe.getCorporateEmailid()+"<CorporateEmailID>"
	      	+"\n"+"</ParticipantEntered>"
	      	+"\n";
 }
	    	//Creating date for message content 
	    	java.util.Date temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS")
	                  .parse("2012-07-10 14:58:00.000000");
	    	  
	    	  //Adding Message Elements
	 		for(Message m:fileDump.getMessage()) {
	 			
	 			m.setDateTimeUtc(fileDump.getEndTimeUtc());
	      		m.setLoginName(fileDump.getLoginName());
	      		m.setCorporateEmailId(fileDump.getCorporateEmailId());
	 			xmlElementString= xmlElementString +"<Message>"
	 	      			+"\n"+"<LoginName>"+m.getLoginName()+"</LoginName>"
	 	      			+"\n"+"<DateTimeUTC>"+m.getDateTimeUtc()+"</DateTimeUTC>"
	 	      	+"\n"+"<CorporateEmailId>"+m.getCorporateEmailId()+"</CorporateEmailId>";
	 	      	if(i==5) {
	 			xmlElementString=xmlElementString+"\n"+"<Content>"+"<![CDATA[ViewedHistory = start Id#End Id#No of Messages#startTimeUtc#endtimeUTC = "+"\n"+m.getMessageId()+"#"+m.getMessageId()+"#"+fileDump.getMessage().size()+"#"+temp+"#"+temp+"]]>"+"</Content>"
	 	      	+"\n"+"<MessageType>"+m.getMessageType()+"</MessageType>"
	 	      	+"\n"+"<MessageId>"+m.getMessageId()+"</MessageId>"
	 	      	+"\n"+"</Message>"
	 	      	+"\n"+"\n";
	 	      	}
	 	      	//Checking message elements 
	 	      	if(i==3) {
	 	      		xmlElementString=xmlElementString+"\n"+"<Content>"+"<![CDATA[ViewedHistory = start Id#End Id#No of Messages= "+"\n"+m.getMessageId()+"#"+m.getMessageId()+"#"+fileDump.getMessage().size()+"#"+"]]>"+"</Content>"
	 	   	 	      	+"\n"+"<MessageType>"+m.getMessageType()+"</MessageType>"
	 	   	 	      	+"\n"+"<MessageId>"+m.getMessageId()+"</MessageId>"
	 	   	 	      	+"\n"+"</Message>"
	 	   	 	      	+"\n"+"\n";
	 	      	}
	 	      	else {
	 	      		xmlElementString=xmlElementString+"\n"+"<Content>"+m.getMessageContent()+"</Content>"
		 	   	 	      	+"\n"+"<MessageType>"+m.getMessageType()+"</MessageType>"
		 	   	 	      	+"\n"+"<MessageId>"+m.getMessageId()+"</MessageId>"
		 	   	 	      	+"\n"+"</Message>"
		 	   	 	      	+"\n"+"\n";
	 	      	}
	 	      	}
	 		//Adding element for audio
	 	for(Audio audio:fileDump.getAudio()) {
	 		audio.setDateTimeUtc(fileDump.getEndTimeUtc());;
      		audio.setLoginName(fileDump.getLoginName());
      		audio.setFileName(fileDump.getCorporateEmailId());
 			xmlElementString= xmlElementString +"<Audio>"
 	      	+"\n"+"<LoginName>"+audio.getLoginName()+"</LoginName>"
 	        +"\n"+"<DateTimeUTC>"+audio.getDateTimeUtc()+"</DateTimeUTC>"
 	      	+"\n"+"<FileName>"+audio.getFileName()+"</FileName>"
 	      	+"\n"+"<FileSize>"+audio.getFileSize()+"</FileSize>"
 	      	+"\n"+"<FileType>"+audio.getFiletype()+"</FileType>"
 	      	+"\n"+"<RecordingDuration>"+audio.getRecordingDuration()+"</RecordingDuration>"
 	        +"\n"+"<CallDirection>"+audio.getCallDuration()+"</CallDirection>"
 	    	+"\n"+"<AudioCodec>"+audio.getAudioCodec()+"</AudioCodec>"
 	    	+"\n"+"<RecordingType>"+audio.getRecordingType()+"</RecordingType>"
 	    	+"\n"+"<FileEventType>"+audio.getFileEventType()+"</FileEventType>"
 	        +"\n"+"<FileId>"+audio.getFiled()+"</FileId>"
 	        +"\n"+"<Attributes>"+audio.getAttributes()+"</Attributes>"
         	+"\n"+"</Audio>"
 	      	+"\n"+"\n";
	 	}
	 		
	 		//Adding FiletranferStarted Elements
	 		log.info("-------Adding FiletranferStarted Elements--------");
	 		for(FileTransferStarted fts:fileDump.getFileTransferedStarted()) {
	      		fts.setDateTimeUtc(fileDump.getEndTimeUtc());
	      		fts.setLoginName(fileDump.getLoginName());
	      		xmlElementString= xmlElementString +"<FileTransferStarted>"
	 	      			+"\n"+"<LoginName>"+fts.getLoginName()+"</LoginName>"
	 	      			+"\n"+"<DateTimeUTC>"+fts.getDateTimeUtc()+"</DateTimeUTC>"
	 	      	+"\n"+"<UserFileName>"+fts.getUserFileName()+"</UserFileName>"
	 	      	+"\n"+"<FileName>"+fts.getFileName()+"</FileName>"
	 	      	+"\n"+"<Status>"+fts.getFileTranferedId()+"</Status>"
	 	      	+"\n"+"</FileTransferStarted>"
	 	      	+"\n"+"\n";
	      	}
	 		
	 		//Adding FileTransferEnd Element
	 		for(FileTransferEnd fts:fileDump.getFileTransferedEnd()) {
	      		fts.setDateTimeUtc(fileDump.getEndTimeUtc());
	      		fts.setLoginName(fileDump.getLoginName());
	      		xmlElementString= xmlElementString +"<FileTransferEnd>"
	 	      			+"\n"+"<LoginName>"+fts.getLoginName()+"</LoginName>"
	 	      			+"\n"+"<DateTimeUTC>"+fts.getDateTimeUtc()+"</DateTimeUTC>"
	 	      	+"\n"+"<UserFileName>"+fts.getUserFileName()+"</UserFileName>"
	 	      	+"\n"+"<FileName>"+fts.getFileName()+"</FileName>"
	 	      	+"\n"+"<Status>"+fts.getStatus()+"</Status>"
	 	      	+"\n"+"</FileTransferEnd>"
	 	      	+"\n"+"\n";
	      	}
	 		
	 		//Adding ParticipentLeft Elements 
	 		for(ParticipentLeft pe:fileDump.getParticipentExit()) {
	      		pe.setDateTimeUtc(fileDump.getEndTimeUtc());
	      		pe.setLoginName(fileDump.getLoginName());
	      		pe.setCorporateEmailId(fileDump.getCorporateEmailId());
	    xmlElementString= xmlElementString +"<ParticipantLeft>"
	      			+"\n"+"<LoginName>"+pe.getLoginName()+"</LoginName>"
	      			+"\n"+"<DateTimeUTC>"+pe.getDateTimeUtc()+"</DateTimeUTC>"
	      	+"\n"+"<InternalFlag>"+pe.getInternalFlag()+"</InternalFlag>"
	      	+"\n"+"<ConversationID>"+pe.getConversionId()+"<ConversationID/>"
	      	+"\n"+"<CorporateEmailId>"+pe.getCorporateEmailId()+"<CorporateEmailID>"
	      	+"\n"+"</ParticipantLeft>"
	      	+"\n"+"\n";
	   	}
	 		
	 		//Adding Fotter Elements
	 		 xmlElementString= xmlElementString+"<EndTimeUTC>"+fileDump.getEndTimeUtc()+"<EndTimeUtc/>"
	 			        +"\n" +"</Conversation>"
	 			        +"\n"+"</FileDump>" ; 
	 		
	 		 //returning the final created string of Elements
	 		 String finalXmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n"+xmlElementString ;  
	 		
	 		 //writing xml for 3 attribute message
	 		 if(i==3) {
	 		 //Writing Converted Xml String into the file
	 			FileWriter file1 = new FileWriter("/Applications/untitled folder/XML/XmlForChatInteraction3.xml");
			    file1.write(finalXmlString);   
	            file1.flush();  
	            log.info("------------Your XML data is successfully written into XmlForChatInteraction3.xml---------");  
	            file1.close();         
	 		return ResponseEntity.ok("Your XML data is successfully written into XmlForChatInteraction3.xml");
	 		 }
	 		 
	 		 //writing xml for 5 message attribute
	 		 if(i==5) {
		 		 //Writing Converted Xml String into the file
		 			FileWriter file1 = new FileWriter("/Applications/untitled folder/XML/XmlForChatInteraction5.xml");
				    file1.write(finalXmlString);   
		            file1.flush();  
		            log.info("------------Your XML data is successfully written into XmlForChatInteraction5.xml---------");  
		            file1.close();         
		 		return ResponseEntity.ok("Your XML data is successfully written into XmlForChatInteraction5.xml");
		 		 }
	 		 else {
	 		return ResponseEntity.ok("Your XML data is successfully written into XmlForChatInteraction.xml");
	 		 }
	}
	
	     //Creating String for RoomChatInteraction Xml Elements
		public  ResponseEntity<?>  coustomXMLForRoomChatInteraction( FileDump fileDump) throws  IOException, ParseException {
			
			log.info("-----------coustomXMLForRoomChatInteraction method called-----------");
		    	String xmlElementString=""; 	
		    //Adding Head Elements
		    	xmlElementString=xmlElementString+"<FileDump xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
		 				+"\n"+"<Conversation Perspective=\"Abend term Finance disussion group channel\">"
		 				+"\n"+"<RoomId>"+fileDump.getRoomId()+"</RoomId>"
		 				+"\n"+"<StartTimeUtc>"+fileDump.getStartTimeUtc()+"<StartTimeUtc/>"
		 				+"\n";
		    	
		   
		    	//Adding  ParticipentEnter Elements 
		    	for(ParticipentEnter pe:fileDump.getParticipentEntered()) {
		      		pe.setDateTimeUtc(fileDump.getEndTimeUtc());
		      		pe.setLoginName(fileDump.getLoginName());
		      		pe.setCorporateEmailid(fileDump.getCorporateEmailId());
		    xmlElementString= xmlElementString+"\n"+"<ParticipantEntered>"
		      			+"\n"+"<LoginName>"+pe.getLoginName()+"</LoginName>"
		      			+"\n"+"<DateTimeUTC>"+pe.getDateTimeUtc()+"</DateTimeUTC>"
		      	+"\n"+"<InternalFlag>"+pe.getInternalFlag()+"</InternalFlag>"
		      	+"\n"+"<ConversationID>"+pe.getConversionId()+"<ConversationID/>"
		      	+"\n"+"<CorporateEmailId>"+pe.getCorporateEmailid()+"<CorporateEmailID>"
		      	+"\n"+"</ParticipantEntered>"
		      	+"\n";
	 }
		    
		    	  
		    	  //Adding Message Elements
		 		for(Message m:fileDump.getMessage()) {
		 			
		 			m.setDateTimeUtc(fileDump.getEndTimeUtc());
		      		m.setLoginName(fileDump.getLoginName());
		      		m.setCorporateEmailId(fileDump.getCorporateEmailId());
		 			xmlElementString= xmlElementString +"<Message>"
		 	      			+"\n"+"<LoginName>"+m.getLoginName()+"</LoginName>"
		 	      			+"\n"+"<DateTimeUTC>"+m.getDateTimeUtc()+"</DateTimeUTC>"
		 	      	+"\n"+"<CorporateEmailId>"+m.getCorporateEmailId()+"</CorporateEmailId>";
		 	      xmlElementString=xmlElementString+"\n"+"<Content>"+m.getMessageContent()+"</Content>"
			 	   	 	      	+"\n"+"<MessageType>"+m.getMessageType()+"</MessageType>"
			 	   	 	      	+"\n"+"<MessageId>"+m.getMessageId()+"</MessageId>"
			 	   	 	      	+"\n"+"</Message>"
			 	   	 	      	+"\n"+"\n";
		 	      	
		 	      	}
		 		
		 		
		 		//Adding FiletranferStarted Elements
		 		log.info("-------Adding FiletranferStarted Elements--------");
		 		for(FileTransferStarted fts:fileDump.getFileTransferedStarted()) {
		      		fts.setDateTimeUtc(fileDump.getEndTimeUtc());
		      		fts.setLoginName(fileDump.getLoginName());
		      		xmlElementString= xmlElementString +"<FileTransferStarted>"
		 	      			+"\n"+"<LoginName>"+fts.getLoginName()+"</LoginName>"
		 	      			+"\n"+"<DateTimeUTC>"+fts.getDateTimeUtc()+"</DateTimeUTC>"
		 	      	+"\n"+"<UserFileName>"+fts.getUserFileName()+"</UserFileName>"
		 	      	+"\n"+"<FileName>"+fts.getFileName()+"</FileName>"
		 	      	+"\n"+"<Status>"+fts.getFileTranferedId()+"</Status>"
		 	      	+"\n"+"</FileTransferStarted>"
		 	      	+"\n"+"\n";
		      	}
		 		
		 		//Adding FileTransferEnd Element
		 		for(FileTransferEnd fts:fileDump.getFileTransferedEnd()) {
		      		fts.setDateTimeUtc(fileDump.getEndTimeUtc());
		      		fts.setLoginName(fileDump.getLoginName());
		      		xmlElementString= xmlElementString +"<FileTransferEnd>"
		 	      			+"\n"+"<LoginName>"+fts.getLoginName()+"</LoginName>"
		 	      			+"\n"+"<DateTimeUTC>"+fts.getDateTimeUtc()+"</DateTimeUTC>"
		 	      	+"\n"+"<UserFileName>"+fts.getUserFileName()+"</UserFileName>"
		 	      	+"\n"+"<FileName>"+fts.getFileName()+"</FileName>"
		 	      	+"\n"+"<Status>"+fts.getStatus()+"</Status>"
		 	      	+"\n"+"</FileTransferEnd>"
		 	      	+"\n"+"\n";
		      	}
		 		
		 		//Adding ParticipentLeft Elements 
		 		for(ParticipentLeft pe:fileDump.getParticipentExit()) {
		      		pe.setDateTimeUtc(fileDump.getEndTimeUtc());
		      		pe.setLoginName(fileDump.getLoginName());
		      		pe.setCorporateEmailId(fileDump.getCorporateEmailId());
		    xmlElementString= xmlElementString +"<ParticipantLeft>"
		      			+"\n"+"<LoginName>"+pe.getLoginName()+"</LoginName>"
		      			+"\n"+"<DateTimeUTC>"+pe.getDateTimeUtc()+"</DateTimeUTC>"
		      	+"\n"+"<InternalFlag>"+pe.getInternalFlag()+"</InternalFlag>"
		      	+"\n"+"<ConversationID>"+pe.getConversionId()+"<ConversationID/>"
		      	+"\n"+"<CorporateEmailId>"+pe.getCorporateEmailId()+"<CorporateEmailID>"
		      	+"\n"+"</ParticipantLeft>"
		      	+"\n"+"\n";
		   	}
		 		
		 		//Adding Fotter Elements
		 		 xmlElementString= xmlElementString+"<EndTimeUTC>"+fileDump.getEndTimeUtc()+"<EndTimeUtc/>"
		 			        +"\n" +"</Conversation>"
		 			        +"\n"+"</FileDump>" ; 
		 		
		 		 //returning the final created string of Elements
		 		 String finalXmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n"+xmlElementString ;  
		 			       
		 		//Writing Converted Xml String into the file
		 			FileWriter file1 = new FileWriter("/Applications/untitled folder/XML/XmlForRoomChatInteraction.xml");
				    file1.write(finalXmlString);   
		            file1.flush();  
		            log.info("------------Your XML data is successfully written into XmlForRoomChatInteraction.xml---------");  
		            file1.close();         
		 		return ResponseEntity.ok("Your XML data is successfully written into XmlForRoomChatInteraction.xml");
		 		    }
	}