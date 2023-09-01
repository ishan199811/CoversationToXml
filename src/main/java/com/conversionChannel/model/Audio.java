package com.conversionChannel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Audio {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long audioId;
	 
	 String loginName;
	 
	 String dateTimeUtc;
	 
	 String fileName;
	 
	 String filetype;
	 
	 String fileSize;
	 
	 String recordingDuration;
	 
	 String callDuration;
	 
	 String audioCodec;
	 
	 String recordingType;
	 
	 String fileEventType;
	 
	 String filed;
	 
	 String  attributes;

	public Long getAudioId() {
		return audioId;
	}

	public void setAudioId(Long audioId) {
		this.audioId = audioId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getDateTimeUtc() {
		return dateTimeUtc;
	}

	public void setDateTimeUtc(String dateTimeUtc) {
		this.dateTimeUtc = dateTimeUtc;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getRecordingDuration() {
		return recordingDuration;
	}

	public void setRecordingDuration(String recordingDuration) {
		this.recordingDuration = recordingDuration;
	}

	public String getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(String callDuration) {
		this.callDuration = callDuration;
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

	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	

}
