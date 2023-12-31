package com.conversionChannel.model;


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

Long dateTimeUtc;

String internalFlag;

Long fileDumpId;
public Long getFileDumpId() {
	return fileDumpId;
}

public void setFileDumpId(Long fileDumpId) {
	this.fileDumpId = fileDumpId;
}

public void setDateTimeUtc(Long dateTimeUtc) {
	this.dateTimeUtc = dateTimeUtc;
}

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

	

public long getDateTimeUtc() {
	return dateTimeUtc;
}

public void setDateTimeUtc(long date) {
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

