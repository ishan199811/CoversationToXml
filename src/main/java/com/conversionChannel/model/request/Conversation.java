package com.conversionChannel.model.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Conversation {
	 
	 @JsonProperty("CallInitiator") 
	    public String callInitiator;
	    @JsonProperty("RoomId") 
	    public String roomId;
	    @JsonProperty("StartTimeUtc") 
	    public String startTimeUtc;
	    @JsonProperty("Participants") 
	    public ArrayList<Participant> participants;
		public String getCallInitiator() {
			return callInitiator;
		}
		public void setCallInitiator(String callInitiator) {
			this.callInitiator = callInitiator;
		}
		public String getRoomId() {
			return roomId;
		}
		public void setRoomId(String roomId) {
			this.roomId = roomId;
		}
		public String getStartTimeUtc() {
			return startTimeUtc;
		}
		public void setStartTimeUtc(String startTimeUtc) {
			this.startTimeUtc = startTimeUtc;
		}
		public ArrayList<Participant> getParticipants() {
			return participants;
		}
		public void setParticipants(ArrayList<Participant> participants) {
			this.participants = participants;
		}
	 
}
