package com.santhosh.Interviewpanelmanagement.storagemanagement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.santhosh.Interviewpanelmanagement.model.Candidate;
import com.santhosh.Interviewpanelmanagement.model.Company;
import com.santhosh.Interviewpanelmanagement.model.Credential;
import com.santhosh.Interviewpanelmanagement.model.Interviewer;
import com.santhosh.librarymanagement.model.Book;


public class DatabaseSystem {
	private static DatabaseSystem databaseSystem;
	private Company company;
	private Credential credential;
	private List<Candidate> candidates;
	private List<Interviewer> interviewers;
	private List<Candidate> selectedCandiate;
	private List<HashMap<String, String>> mappedCandidates;
    ObjectMapper obj=new ObjectMapper();
	private String candidateFile= "C:\\Users\\santh\\eclipse-workspace\\InterviewPanelManagement\\src\\com\\santhosh\\Interviewpanelmanagement\\JsonFile\\Candidates.json";
	private String interviewerFile= "C:\\Users\\santh\\eclipse-workspace\\InterviewPanelManagement\\src\\com\\santhosh\\Interviewpanelmanagement\\JsonFile\\Interviewers.json";
	private String mappedCandidateFile= "C:\\Users\\santh\\eclipse-workspace\\InterviewPanelManagement\\src\\com\\santhosh\\Interviewpanelmanagement\\JsonFile\\MappedCandidates.json";
	private String companyFile= "C:\\Users\\santh\\eclipse-workspace\\InterviewPanelManagement\\src\\com\\santhosh\\Interviewpanelmanagement\\JsonFile\\Company.json";
    
	
	private DatabaseSystem() {
		this.candidates = new ArrayList<>();
		this.interviewers = new ArrayList<>();
		this.mappedCandidates = new ArrayList<>();
		this.selectedCandiate = new ArrayList<Candidate>();
	}

	public static DatabaseSystem getInstance() {
		if (databaseSystem == null) {
			databaseSystem = new DatabaseSystem();
		}
		return databaseSystem;
	}

	public boolean insertCandidate(Candidate candidate) {
		ObjectMapper candidateObj = new ObjectMapper();
		try {
			File fileCandidate = new File(candidateFile);
			if (!fileCandidate.exists()) {
				fileCandidate.createNewFile();}
			if (fileCandidate.length() > 0) {
				candidates = candidateObj.readValue(new File(candidateFile), new TypeReference<List<Candidate>>() {
				});
				for (Candidate cand : candidates) {
					if (candidate.getMailId().equals(cand.getMailId()))
						{return false;}
				}
				candidates.add(candidate);
				candidateObj.writeValue(fileCandidate, candidates);
				return true;
			} else { 

				candidates.add(candidate);
				candidateObj.writeValue(fileCandidate, candidates);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Candidate> showCandidates() {
		
		ObjectMapper candidateObj = new ObjectMapper();
		try {
			return candidates = candidateObj.readValue(new File(candidateFile),
					new TypeReference<List<Candidate>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public boolean insertInterviewers(Interviewer interviewer) {
		
		ObjectMapper interviewerObj = new ObjectMapper();
		try {
			File fileCandidate = new File(interviewerFile);
			if (!fileCandidate.exists())
				fileCandidate.createNewFile();
			if (fileCandidate.length() > 0) {// verifying that the length of the file is not empty
				interviewers = interviewerObj.readValue(new File(interviewerFile), new TypeReference<List<Interviewer>>() {
				});
				for (Interviewer inter : interviewers) {
					if (interviewer.getMailId().equals(inter.getMailId()))
						return false;
				}
				interviewers.add(interviewer);
				interviewerObj.writeValue(fileCandidate, interviewers);
				return true;
			} else { 
				interviewers.add(interviewer);
				interviewerObj.writeValue(fileCandidate, interviewers);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("interviewer");
		}
		return false;
		
	}

	public List<Interviewer> showInterviewers() {

		ObjectMapper interviewerObj = new ObjectMapper();
		try {
			return interviewers = interviewerObj.readValue(new File(interviewerFile),
					new TypeReference<List<Interviewer>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	public void insertMapedcandidate(HashMap<String, String> mapcustomerandinterviewer) {
		
		mappedCandidates.add(mapcustomerandinterviewer);
		try {

            File file = new File(mappedCandidateFile);
            if (!file.exists()) {
                file.createNewFile();
                obj.writeValue(file, new ArrayList<>());
            }
            List<HashMap<String, String>> existingMappedCandidates =  obj.readValue(file,
                    new TypeReference<List<HashMap<String, String>>>() {});
            existingMappedCandidates.add(mapcustomerandinterviewer);

            obj.writeValue(file, existingMappedCandidates);
           
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}

	public List<HashMap<String, String>> showMapedCandidates() {
		try {
			mappedCandidates = obj.readValue(new File(mappedCandidateFile),
                    new TypeReference<List<HashMap<String, String>>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
		return mappedCandidates;
	}

	public void insertSelectedCandidate(Candidate candidate) {
		selectedCandiate.add(candidate);
		try {
            File file = new File("C:\\Users\\santh\\eclipse-workspace\\InterviewPanelManagement\\src\\com\\santhosh\\Interviewpanelmanagement\\JsonFile\\SelectedCandidates.json");
            if (!file.exists()) {
                file.createNewFile();
                obj.writeValue(file, new ArrayList<>());
            }

            List<Candidate> existingSelectedCandidates =  obj.readValue(file,
                    new TypeReference<List<Candidate>>() {});
            existingSelectedCandidates.add(candidate);

            obj.writeValue(file, existingSelectedCandidates);
           
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}

	public List<Candidate> showSelectedCandidate() {
		try {
			selectedCandiate = obj.readValue(new File("C:\\Users\\santh\\eclipse-workspace\\InterviewPanelManagement\\src\\com\\santhosh\\Interviewpanelmanagement\\JsonFile\\SelectedCandidates.json"),
                    new TypeReference<List<Candidate>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
		return selectedCandiate;
	}

	public void insertCompanyDetails(Company company) {
		this.company = company;
		try {
			File file = new File(companyFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(file, company);
		} catch (Exception e) {
		}
	}
	
	public Company getCompany() {
		ObjectMapper companyObj = new ObjectMapper();
		try {
			return companyObj.readValue(new File(companyFile), Company.class);
		} catch (Exception e) {
			return null;
		}
	}

	public void insertCredentials(Credential credential) {
	       this.credential=credential;
		}
		
		public Credential getCredentials() {
			return credential;
		}
	
}
