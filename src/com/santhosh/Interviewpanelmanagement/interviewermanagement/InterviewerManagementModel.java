package com.santhosh.Interviewpanelmanagement.interviewermanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.santhosh.Interviewpanelmanagement.model.Candidate;
import com.santhosh.Interviewpanelmanagement.model.Interviewer;
import com.santhosh.Interviewpanelmanagement.storagemanagement.DatabaseSystem;

public class InterviewerManagementModel {
	private InterviewerManagementView interviewerManagementView;

	InterviewerManagementModel(InterviewerManagementView interviewerManagementView) {
		this.interviewerManagementView = interviewerManagementView;
	}

	public void validateInterview(String name, String password) {
		Interviewer interviewer = isValidInterviewerName(name);
		if (isValidInterviewerName(name) != null) {
			if (isValidPassword(password, interviewer)) {
				System.out.println("login Successfully");
				interviewerManagementView.interviewerOptions(name);
			} else {
				interviewerManagementView.showAlert("Invalid Password");
				interviewerManagementView.interviewerLogin();
			}
		} else {
			interviewerManagementView.showAlert("Invalid Interviewer Name");
			interviewerManagementView.interviewerLogin();
		}
	}

	public Interviewer isValidInterviewerName(String name) {
		List<Interviewer> interviewers = DatabaseSystem.getInstance().showInterviewers();
		for (Interviewer interviewer : interviewers) {
			if (name.equalsIgnoreCase(interviewer.getInterviewerName())) {
				interviewer.setStatus("Free");
				return interviewer;
			}
		}
		return null;
	}

	private boolean isValidPassword(String password, Interviewer interviewer) {
		if (interviewer.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public void setCandidateRating(String name,String candidateName, double rating) {
//		List<Candidate> candidates = DatabaseSystem.getInstance().showCandidates();
//		for (Candidate candidate : candidates) {
//			if (candidate.getCandidateName().equals(candidateName)) {
//				candidate.setRating(rating);
//				System.out.println("Interview Completed and Rating Given to the Candidate "+candidate.getCandidateName());
//				if (rating > 4) {
//					
//					candidate.setResult("Selected");
//					DatabaseSystem.getInstance().insertSelectedCandidate(candidate);
//				}
//				candidate.setRating(rating);
//				candidate.setResult("Not Selected");
//			}
//		}
		Interviewer interviewer=isValidInterviewerName(name);
		Candidate candidate=isValidCandidate(name,candidateName);
		candidate.setRating(rating);
		if(rating>=4) {
			candidate.setResult("Selected");
			DatabaseSystem.getInstance().insertSelectedCandidate(candidate);
		}
		else {
			candidate.setResult("Not Selected");
		}
		if(interviewer.getCount()==3) {
			interviewer.setStatus("Free");
		}
		candidate.setStatus("Completed");
	}

	public Candidate isValidCandidate(String name, String candidateName) {
		Interviewer interviewer=isValidInterviewerName(name);
		   List<Candidate> candidates=interviewer.getCandidates();
		   for(Candidate candidate:candidates) {
			   if(candidate.getCandidateName().equals(candidateName)) {
				   return candidate; 
			   }
		   }
		   return null;
	}
	
}
