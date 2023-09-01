package com.conversionChannel.serviceImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.conversionChannel.model.FileDump;
import com.conversionChannel.model.FileTransferEnd;
import com.conversionChannel.model.FileTransferStarted;
import com.conversionChannel.model.Message;
import com.conversionChannel.model.ParticipentEnter;
import com.conversionChannel.model.ParticipentLeft;
import com.conversionChannel.model.RequestFileDump;
import com.conversionChannel.repository.FileTransferEndRepository;
import com.conversionChannel.repository.FileTransferStartRepository;
import com.conversionChannel.repository.MessageRepository;
import com.conversionChannel.repository.ParticipentEnterRepository;
import com.conversionChannel.repository.ParticipentLeftRepository;
import com.conversionChannel.repository.RequestFileDumpRepository;
import com.conversionChannel.service.ValidationService;
import com.conversionChannel.service.XmlConversionService;




@Service
public class XmlConversionServiceImpl implements XmlConversionService{
	
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
	ValidationService validationService;
	
	
	private static final Logger log = LoggerFactory.getLogger( XmlConversionServiceImpl.class);

	
	@Override
	 public  ResponseEntity<?> creatingXML(Long id)  throws  IOException  {
		 
		log.info("--------Creating xml method called---------");
		Date date = new Date();    
          FileDump fileDump = new FileDump();
	 	  XmlConversionServiceImpl cxs=new XmlConversionServiceImpl();
	 	
	 	  RequestFileDump requestFileDump= requestFileDumpRepository.getById(id);
	 	    	List<Message> messageList=messageRepository.findAll();
	 	    	List<ParticipentEnter> list= participentEnterRepository.findAll();
	 	    	List<FileTransferStarted> fileList=filetransferStartRepository.findAll();
	 	    	List<FileTransferEnd> fileList1=fileTransferEndRepository.findAll();
	 	    	List<ParticipentLeft> list2= participentLeftRepository.findAll();
	 	    	
	 	    	fileDump.setRoomId(requestFileDump.getRoomId());
	          	fileDump.setStartTimeUtc(date);
	 	        fileDump.setEndTimeUtc(date);
	 	        fileDump.setBase64Content(requestFileDump.getBase64Content());
	 	    	fileDump.setLoginName(requestFileDump.getLoginName());
	 	    	fileDump.setParticipentEntered(list);
	 	    	fileDump.setMessage(messageList);
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
	 	    	//calling coustomXml
	 	    	String finalxmlElementString=cxs.coustomXML(fileDump);
		     	
	 	    	
	 	    	//Writing Converted Xml String into the file
	 			FileWriter file1 = new FileWriter("/Applications/untitled folder/XML/XmlFor.xml");
			    file1.write(finalxmlElementString);   
	            file1.flush();  
	            log.info("------------Your XML data is successfully written into XmlFor.xml---------");  
	            file1.close();  
	 	      return ResponseEntity.ok("Your XML data is successfully written into XmlFor.xml");
	 	    	
	 	    	}
	
	
	//Creating String for Xml Elements
	public  String  coustomXML( FileDump fileDump) throws  IOException {
		
		log.info("---------Coustomxml method called-----------");
	    	Date date = new Date();    
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
	    	
	    
	    	//Adding  ParticipentEnter Elements 
	    	for(ParticipentEnter pe:fileDump.getParticipentEntered()) {
	      		pe.setDateTimeUtc( date);
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
	 			m.setDateTimeUtc( date);
	      		m.setLoginName(fileDump.getLoginName());
	      		m.setCorporateEmailId(fileDump.getCorporateEmailId());
	 			xmlElementString= xmlElementString +"<Message>"
	 	      			+"\n"+"<LoginName>"+m.getLoginName()+"</LoginName>"
	 	      			+"\n"+"<DateTimeUTC>"+m.getDateTimeUtc()+"</DateTimeUTC>"
	 	      	+"\n"+"<CorporateEmailId>"+m.getCorporateEmailId()+"</CorporateEmailId>"
	 	      	+"\n"+"<Content>"+m.getMessageContent()+"</Content>"
	 	      	+"\n"+"<MessageType>"+m.getMessageType()+"</MessageType>"
	 	      	+"\n"+"<MessageId>"+m.getMessageId()+"</MessageId>"
	 	      	+"\n"+"</Message>"
	 	      	+"\n"+"\n";
	 		}
	 		
	 		
	 		//Adding FiletranferStarted Elements
	 		log.info("-------Adding FiletranferStarted Elements--------");
	 		for(FileTransferStarted fts:fileDump.getFileTransferedStarted()) {
	      		fts.setDateTimeUtc( date);
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
	      		fts.setDateTimeUtc( date);
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
	      		pe.setDateTimeUtc( date);
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
	 			       
	 		return finalXmlString;
	 		    }
	}