package com.santhosh.Interviewpanelmanagement.mappingCandidateandInterviewerManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.santhosh.Interviewpanelmanagement.adminmanagement.AdminView;
import com.santhosh.Interviewpanelmanagement.model.Candidate;
import com.santhosh.Interviewpanelmanagement.model.Interviewer;
import com.santhosh.Interviewpanelmanagement.storagemanagement.DatabaseSystem;

public class mappingCandidateandInterviewerModel {

	private mappingCandidateandInterviewerView interviewerManageView;

	public mappingCandidateandInterviewerModel(mappingCandidateandInterviewerView interviewerManageView) {
		this.interviewerManageView = interviewerManageView;
	}
	public boolean checkInterviewer(String interviewerName) {
		List<Interviewer> interviewers = DatabaseSystem.getInstance().showInterviewers();
		for (Interviewer interviewer : interviewers) {
			if(interviewer.getCount()!=3) {
			if(interviewerName.equalsIgnoreCase(interviewer.getInterviewerName())) {
				interviewer.setStatus("Allocated");
				interviewer.setCount(interviewer.getCount()+1);
				return true;
			}
			}
			else {
				System.out.println("Interviewer Slots Filled");
				new AdminView().onSetupComplete(); 
			}
		}
		return false;
	}

	public Candidate checkCandidate(String candidateName) {
		List<Candidate> candidates = DatabaseSystem.getInstance().showCandidates();
		for (Candidate candidate : candidates) {
			if (candidateName.equalsIgnoreCase(candidate.getCandidateName())) {
				return candidate;
			}
		}
		return null;
	}

	public void mapCandidateInterviewer(String candidateName,String intervieweName) {
//		HashMap<String, String> mapcustomerandinterviewer = new HashMap();
//		mapcustomerandinterviewer.put(name, interviewerName);
//		DatabaseSystem.getInstance().insertMapedcandidate(mapcustomerandinterviewer);
//		System.out.println("Hello");
		List<Interviewer> interviewers=DatabaseSystem.getInstance().showInterviewers();
		Candidate candidate=checkCandidate(candidateName);
		for(Interviewer interviewer : interviewers)
		{
			if(interviewer.getInterviewerName().equals(intervieweName)) {
				interviewer.setCandidates(candidate);
				candidate.setStatus("Allocated");
			}
		}
	}

	
}
