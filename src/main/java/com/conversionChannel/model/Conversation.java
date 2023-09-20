package com.conversionChannel.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.conversionChannel.model.request.Participants;



@Entity
public class Conversation {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long conversationId;
	
	
String conversationType;
}
