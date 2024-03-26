package com.santhosh.Interviewpanelmanagement.model;

import java.util.Objects;

public class Candidate {
	private String candidateName;
	private int candidateId;
	private String mailId;
	private long phoneNumber;
	private String skill;
	private String location;
	private Double rating;
	private String result;
	private String status;

	

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Candidate that = (Candidate) o;
		return Objects.equals( candidateName, that.candidateName) && Objects.equals(candidateId, that.candidateId)
				&& Objects.equals(mailId, this.mailId)
				&& Objects.equals(phoneNumber, that.phoneNumber)&&Objects.equals(skill, that.skill)&&Objects.equals(status, that.status)&&Objects.equals(location, that.location)&&Objects.equals(rating, that.rating)&&Objects.equals(result, that.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(candidateName, candidateName, mailId, phoneNumber,skill,status,location,rating,result);
	}
  
	@Override
	public String toString() {
		return "\n Candidate Details :\n Candidate Name = " + candidateName + "\n Candidate ID = " + candidateId + "\n Mail ID = " + mailId
				+ "\n Phone Number = " + phoneNumber + "\n Skill = " + skill + "\n location = " + location + "\n Rating = " + rating
				+ "\n Result = " + result;
	}

}
