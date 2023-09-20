package com.conversionChannel.model.response;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlSchemaType;

import com.conversionChannel.model.Audio;
import com.conversionChannel.model.FileTransferEnd;
import com.conversionChannel.model.FileTransferStarted;
import com.conversionChannel.model.Invite;
import com.conversionChannel.model.Message;
import com.conversionChannel.model.ParticipentEnter;
import com.conversionChannel.model.ParticipentLeft;



public class ResponseFileDump {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	long fileDumpId;

	protected String roomId;
    protected String base64Content;
    protected String base64FileName;
    protected String callInitiator;
    protected String callType;
    protected String channel;
    protected String corporateEmailId;
    @XmlSchemaType(name = "dateTime")
    protected Long endTimeUtc;
    protected String fileTransferStatus;
   String loginName2;
   
   
    public String getLoginName2() {
	return loginName2;
}
public void setLoginName2(String loginName2) {
	this.loginName2 = loginName2;
}
	protected String loginName;
   String dateTimeUtc;
    public String getDateTimeUtc() {
	return dateTimeUtc;
}
public void setDateTimeUtc(String dateTimeUtc) {
	this.dateTimeUtc = dateTimeUtc;
}
public String getN() {
	return n;
}
public void setN(String n) {
	this.n = n;
}
public Long getEndTimeUtc() {
	return endTimeUtc;
}
	protected String messageId;
    protected String messageType;
    protected String network;
    protected String participantEntered;
    protected String n;
    @XmlSchemaType(name = "dateTime")
    protected String startTimeUtc;
    protected String status;
    protected String threadId;
    protected String userFileName;
    protected String vendor;
    List<ParticipentEnter> participentEntered;
    List<ParticipentLeft> participentExit;
    List<FileTransferStarted> fileTransferedStarted;
    List<Message> message;
    List<FileTransferEnd> fileTransferedEnd;
    List<Audio> audio;
    List<Invite> invite;
    
    
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
	
    public long getFileDumpId() {
		return fileDumpId;
	}
	public void setFileDumpId(long fileDumpId) {
		this.fileDumpId = fileDumpId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getBase64Content() {
		return base64Content;
	}
	public void setBase64Content(String base64Content) {
		this.base64Content = base64Content;
	}
	public String getBase64FileName() {
		return base64FileName;
	}
	public void setBase64FileName(String base64FileName) {
		this.base64FileName = base64FileName;
	}
	public String getCallInitiator() {
		return callInitiator;
	}
	public void setCallInitiator(String callInitiator) {
		this.callInitiator = callInitiator;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
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
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getParticipantEntered() {
		return participantEntered;
	}
	public void setParticipantEntered(String participantEntered) {
		this.participantEntered = participantEntered;
	}
	
	public String getStartTimeUtc() {
		return startTimeUtc;
	}
	public void setStartTimeUtc(String startTimeUtc) {
		this.startTimeUtc = startTimeUtc;
	}
	public void setEndTimeUtc(Long endTimeUtc) {
		this.endTimeUtc = endTimeUtc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getThreadId() {
		return threadId;
	}
	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}
	public String getUserFileName() {
		return userFileName;
	}
	public void setUserFileName(String userFileName) {
		this.userFileName = userFileName;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
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
	
}