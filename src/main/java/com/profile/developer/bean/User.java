package com.profile.developer.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name ="profile_pic")
	private String profilePic;
	

	@Column(name ="carrierObjective")
	private String carrierObjective;
	
	
	 




	public User(int userId, String userName, Date dateOfBirth, String profilePic, String carrierObjective,
			String technicalSkill, String educationDetails, String experiencedDetails, String projectDetails,
			String personalDetails) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.profilePic = profilePic;
		this.carrierObjective = carrierObjective;
		this.technicalSkill = technicalSkill;
		this.educationDetails = educationDetails;
		this.experiencedDetails = experiencedDetails;
		this.projectDetails = projectDetails;
		this.personalDetails = personalDetails;
	}





	public String getProjectDetails() {
		return projectDetails;
	}





	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}





	public String getPersonalDetails() {
		return personalDetails;
	}





	public void setPersonalDetails(String personalDetails) {
		this.personalDetails = personalDetails;
	}





	@Column(name ="technicalSkill")
	private String technicalSkill;
	
	
	

	@Column(name ="educationDetails")
	private String educationDetails;


	@Column(name ="experiencedDetails")
	private String experiencedDetails;


	@Column(name ="projectDetails")
	private String projectDetails;
	
	@Column(name ="personalDetails")
	private String personalDetails;
		
	
	
	
	


	public User() {
		
	}
	
	
	
	

	public String getProfilePic() {
		return profilePic;
	}





	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}





	




	public String getCarrierObjective() {
		return carrierObjective;
	}





	public void setCarrierObjective(String carrierObjective) {
		this.carrierObjective = carrierObjective;
	}





	public String getTechnicalSkill() {
		return technicalSkill;
	}





	public void setTechnicalSkill(String technicalSkill) {
		this.technicalSkill = technicalSkill;
	}





	public String getEducationDetails() {
		return educationDetails;
	}





	public void setEducationDetails(String educationDetails) {
		this.educationDetails = educationDetails;
	}





	public String getExperiencedDetails() {
		return experiencedDetails;
	}





	




	public void setExperiencedDetails(String experiencedDetails) {
		this.experiencedDetails = experiencedDetails;
	}





	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getUserId() {
		return userId;
	}





	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", dateOfBirth=" + dateOfBirth + ", profilePic="
				+ profilePic + "]";
	}

	
	
}
