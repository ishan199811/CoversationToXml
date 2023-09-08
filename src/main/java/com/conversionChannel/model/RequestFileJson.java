package com.conversionChannel.model;

import java.util.Date;
import java.util.List;

public class RequestFileJson {
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getRecordingDuration() {
		return recordingDuration;
	}
	public void setRecordingDuration(String recordingDuration) {
		this.recordingDuration = recordingDuration;
	}
	public String getCallDirection() {
		return callDirection;
	}
	public void setCallDirection(String callDirection) {
		this.callDirection = callDirection;
	}
	public String getAudioCodec() {
		return audioCodec;
	}
	public void setAudioCodec(String audioCodec) {
		this.audioCodec = audioCodec;
	}
	public String getRecordingType() {
		return recordingType;
	}
	public void setRecordingType(String recordingType) {
		this.recordingType = recordingType;
	}
	public String getFileEventType() {
		return fileEventType;
	}
	public void setFileEventType(String fileEventType) {
		this.fileEventType = fileEventType;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public List<ParticipentEnter> getParticipentEntered() {
		return participentEntered;
	}
	public void setParticipentEntered(List<ParticipentEnter> participentEntered) {
		this.participentEntered = participentEntered;
	}
	public List<ParticipentLeft> getParticipentExit() {
		return participentExit;
	}
	public void setParticipentExit(List<ParticipentLeft> participentExit) {
		this.participentExit = participentExit;
	}
	public List<FileTransferStarted> getFileTransferedStarted() {
		return fileTransferedStarted;
	}
	public void setFileTransferedStarted(List<FileTransferStarted> fileTransferedStarted) {
		this.fileTransferedStarted = fileTransferedStarted;
	}
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
	public List<FileTransferEnd> getFileTransferedEnd() {
		return fileTransferedEnd;
	}
	public void setFileTransferedEnd(List<FileTransferEnd> fileTransferedEnd) {
		this.fileTransferedEnd = fileTransferedEnd;
	}
	public List<Audio> getAudio() {
		return audio;
	}
	public void setAudio(List<Audio> audio) {
		this.audio = audio;
	}
	public List<Invite> getInvite() {
		return invite;
	}
	public void setInvite(List<Invite> invite) {
		this.invite = invite;
	}
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
	 
	List<ParticipentEnter> participentEntered;
    List<ParticipentLeft> participentExit;
    List<FileTransferStarted> fileTransferedStarted;
    List<Message> message;
    List<FileTransferEnd> fileTransferedEnd;
    List<Audio> audio;
    List<Invite> invite;
}
