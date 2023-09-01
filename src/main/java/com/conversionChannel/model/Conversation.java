package com.conversionChannel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Conversation {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long conversationId;
	
String conversationType;
}
