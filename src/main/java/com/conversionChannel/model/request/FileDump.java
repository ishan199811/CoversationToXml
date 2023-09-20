package com.conversionChannel.model.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileDump {

	 @JsonProperty("Conversations") 
	    public ArrayList<Conversation> conversations;

	public List<Conversation> getConversations() {
		return conversations;
	}

	public void setConversations(ArrayList<Conversation> conversations) {
		this.conversations = conversations;
	}

	
	
}
