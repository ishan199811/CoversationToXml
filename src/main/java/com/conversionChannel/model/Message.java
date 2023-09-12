package com.conversionChannel.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
	String loginName;
	Long dateTimeUtc;
	String messageType;
	String corporateEmailId;
	String messageContent;
	 Long participentId;
	

	public Long getParticipentId() {
		return participentId;
	}

	public void setParticipentId(Long participentId) {
		this.participentId = participentId;
	}

	public void setDateTimeUtc(Long dateTimeUtc) {
		this.dateTimeUtc = dateTimeUtc;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public long getDateTimeUtc() {
		return dateTimeUtc;
	}

	public void setDateTimeUtc(long dateTimeUtc) {
		this.dateTimeUtc = dateTimeUtc;
	}

	public String getCorporateEmailId() {
		return corporateEmailId;
	}

	public void setCorporateEmailId(String corporateEmailId) {
		this.corporateEmailId = corporateEmailId;
	}
}
