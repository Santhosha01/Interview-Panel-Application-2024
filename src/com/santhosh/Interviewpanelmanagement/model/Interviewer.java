package com.santhosh.Interviewpanelmanagement.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Interviewer {
	private String interviewerName;
	private int interviewerId;
	private String mailId;
	private String password;
	private String status;
	private int count;
	
   private List<Candidate> candidates=new ArrayList<Candidate>();
	
	public String getInterviewerName() {
		return interviewerName;
	}

public void setInterviewerName(String interviewerName) {
	this.interviewerName = interviewerName;
}
	public int getInterviewId() {
		return interviewerId;
	}

public void setInterviewId(int interviewId) {
	this.interviewerId = interviewId;
}
	public String getMailId() {
		return mailId;
	}

public void setMailId(String mailId) {
	this.mailId = mailId;
}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}
    public void setPassword(String password) {
    	this.password=password;
    }

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(Candidate candidate) {
//		this.candidates = candidates;
		candidates.add(candidate);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Interviewer that = (Interviewer) o;
		return Objects.equals(interviewerId, that.interviewerId) && Objects.equals(interviewerName, that.interviewerName)
				&& Objects.equals(mailId, this.mailId)
				&& Objects.equals(password, that.password)&&Objects.equals(status, that.status)&&Objects.equals(count, that.count);
	}

	@Override
	public int hashCode() {
		return Objects.hash(interviewerId, interviewerName, mailId, password,status,count);
	}
  
}
