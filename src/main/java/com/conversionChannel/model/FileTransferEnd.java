package com.conversionChannel.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileTransferEnd {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileTransferEndId;
	
	String loginName;
	
	Long dateTimeUtc;
	
	String userFileName;
	
	String fileName;
	
	String status;
	
	String corporateEmailId;
	
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

	public String getCorporateEmailId() {
		return corporateEmailId;
	}

	public void setCorporateEmailId(String corporateEmailId) {
		this.corporateEmailId = corporateEmailId;
	}


	
	

	public Long getFileTransferEndId() {
		return fileTransferEndId;
	}

	public void setFileTransferEndId(Long fileTransferEndId) {
		this.fileTransferEndId = fileTransferEndId;
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

	public String getUserFileName() {
		return userFileName;
	}

	public void setUserFileName(String userFileName) {
		this.userFileName = userFileName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
