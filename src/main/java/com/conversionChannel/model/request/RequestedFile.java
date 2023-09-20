package com.conversionChannel.model.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestedFile {

	public ArrayList<ChatRoom> chatRooms;

	public ArrayList<ChatRoom> getChatRooms() {
		return chatRooms;
	}

	public void setChatRoom(ArrayList<ChatRoom> chatRooms) {
		this.chatRooms= chatRooms;
	}
	
}
