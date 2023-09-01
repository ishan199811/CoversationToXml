package com.conversionChannel.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class RequestFileDump {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	
	String roomId;
	
	Date startTimeUtc;
	
	String callType;
	
	String callInitiator;
	
	String vendor ;
	
	String network;
	
	String channel;
	
	Date endTimeUtc;
	
	String loginName;
	
	String base64Content;
	
	String messageType;
	
	String corporateEmailId;
	
	String fileTransferStatus;
	
	String threadId;
	
	String messageId;
	
	String userFileName;
	
	String base64FileName;
	
	String fileTransferedEnd;
	
	String status;
	
	String participantEntered;
	
	String content;
	
	String fileSize;
	
	String fileType;
	
	String recordingDuration;
	
	String callDirection;
	
	String audioCodec;
	
	String recordingType;
	
	String fileEventType;
	
	String fileId;
	
	String attributes;
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Date getStartTimeUtc() {
		return startTimeUtc;
	}

	public void setStartTimeUtc(Date startTimeUtc) {
		this.startTimeUtc = startTimeUtc;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getCallInitiator() {
		return callInitiator;
	}

	public void setCallInitiator(String callInitiator) {
		this.callInitiator = callInitiator;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Date getEndTimeUtc() {
		return endTimeUtc;
	}

	public void setEndTimeUtc(Date endTimeUtc) {
		this.endTimeUtc = endTimeUtc;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getBase64Content() {
		return base64Content;
	}

	public void setBase64Content(String base64Content) {
		this.base64Content = base64Content;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getCorporateEmailId() {
		return corporateEmailId;
	}

	public void setCorporateEmailId(String corporateEmailId) {
		this.corporateEmailId = corporateEmailId;
	}

	public String getFileTransferStatus() {
		return fileTransferStatus;
	}

	public void setFileTransferStatus(String fileTransferStatus) {
		this.fileTransferStatus = fileTransferStatus;
	}

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getUserFileName() {
		return userFileName;
	}

	public void setUserFileName(String userFileName) {
		this.userFileName = userFileName;
	}

	public String getBase64FileName() {
		return base64FileName;
	}

	public void setBase64FileName(String base64FileName) {
		this.base64FileName = base64FileName;
	}

	public String getFileTransferedEnd() {
		return fileTransferedEnd;
	}

	public void setFileTransferedEnd(String fileTransferedEnd) {
		this.fileTransferedEnd = fileTransferedEnd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParticipantEntered() {
		return participantEntered;
	}

	public void setParticipantEntered(String participantEntered) {
		this.participantEntered = participantEntered;
	}
}


