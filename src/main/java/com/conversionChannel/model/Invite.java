package com.conversionChannel.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invite {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long inviteId;
	 
	 String inviteLoginName;
	 
	 String loginName;
	 
	 Long dateTimeUtc;
	 
	 String content;
	 
	 String base64Content;
	 
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

	public Long getInviteId() {
		return inviteId;
	}

	public void setInviteId(Long inviteId) {
		this.inviteId = inviteId;
	}

	public String getInviteLoginName() {
		return inviteLoginName;
	}

	public void setInviteLoginName(String inviteLoginName) {
		this.inviteLoginName = inviteLoginName;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBase64Content() {
		return base64Content;
	}

	public void setBase64Content(String base64Content) {
		this.base64Content = base64Content;
	}

	public String getCorporateEmailId() {
		return corporateEmailId;
	}

	public void setCorporateEmailId(String corporateEmailId) {
		this.corporateEmailId = corporateEmailId;
	}
	 
	 
}
