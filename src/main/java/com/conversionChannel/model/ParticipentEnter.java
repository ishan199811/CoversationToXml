package com.conversionChannel.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParticipentEnter {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participentEnterId;

String corporateId ;

String loginName;

Date dateTimeUtc;

String internalFlag;

public String getInternalFlag() {
	return internalFlag;
}

public void setInternalFlag(String internalFlag) {
	this.internalFlag = internalFlag;
}

String conversionId;

String corporateEmailid;

	public Long getParticipentEnterId() {
		return participentEnterId;
	}

	public void setParticipentEnterId(Long participentEnterId) {
		this.participentEnterId = participentEnterId;
	}

	public String getCorporateId() {
		return corporateId;
	}

	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	

public Date getDateTimeUtc() {
	return dateTimeUtc;
}

public void setDateTimeUtc(java.util.Date date) {
	this.dateTimeUtc = date;
}


public String getConversionId() {
	return conversionId;
}

public void setConversionId(String conversionId) {
	this.conversionId = conversionId;
}

public String getCorporateEmailid() {
	return corporateEmailid;
}

public void setCorporateEmailid(String corporateEmailid) {
	this.corporateEmailid = corporateEmailid;
}
	

	
	

}

