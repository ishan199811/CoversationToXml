package com.conversionChannel.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ParticipentLeft {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participentExitId;

	Long dateTimeUtc;
	
	Boolean internalFlag;
	
	String corporateEmailId ;
String conversionId;

String loginName;
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

	public Long getParticipentExitId() {
		return participentExitId;
	}

	public void setParticipentExitId(Long participentExitId) {
		this.participentExitId = participentExitId;
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

public Boolean getInternalFlag() {
	return internalFlag;
}

public void setInternalFlag(Boolean internalFlag) {
	this.internalFlag = internalFlag;
}

public String getCorporateEmailId() {
	return corporateEmailId;
}

public void setCorporateEmailId(String corporateEmailId) {
	this.corporateEmailId = corporateEmailId;
}

public String getConversionId() {
	return conversionId;
}

public void setConversionId(String conversionId) {
	this.conversionId = conversionId;
}

	


}


