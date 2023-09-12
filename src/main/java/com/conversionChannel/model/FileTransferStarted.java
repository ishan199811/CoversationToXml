package com.conversionChannel.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileTransferStarted {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileTranferedId;
	 
	String loginName;
	
	Long dateTimeUtc;
	
	String userFileName;
	
	String fileName;
	
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

	
	
	
	public Long getFileTranferedId() {
		return fileTranferedId;
	}

	public void setFileTranferedId(Long fileTranferedId) {
		this.fileTranferedId = fileTranferedId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

}
