package com.santhosh.Interviewpanelmanagement.login;

import java.util.Scanner;

import com.santhosh.Interviewpanelmanagement.InterviewPanelApplication;
import com.santhosh.Interviewpanelmanagement.adminmanagement.AdminView;
import com.santhosh.Interviewpanelmanagement.interviewermanagement.InterviewerManagementView;
import com.santhosh.Interviewpanelmanagement.model.Candidate;
import com.santhosh.Interviewpanelmanagement.model.Credential;
import com.santhosh.Interviewpanelmanagement.model.Interviewer;
import com.santhosh.Interviewpanelmanagement.storagemanagement.DatabaseSystem;



public class LoginView {

	private LoginModel loginModel;

	public LoginView() {
		loginModel = new LoginModel(this);
	}

	
	public void adminLogin() {
		try {
			System.out.println("\n----------------Admin Page------------------");
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("Enter your Admin name");
			String adminName = sc.next();
			System.out.println("Enter your Password");
			String password = sc.next();
			loginModel.validateAdmin(adminName, password);
			System.out.println("\n\n        Welcome to Interview Panel System\n");
		} catch (Exception e) {
			adminLogin();
		}
	}

	public void showAlert(String massage) {
		System.out.println(massage);
	}

//	public void setInterviewersDetails() {
//		DatabaseSystem.getInstance()
//				.insertInterviewers(new Interviewer("Ramesh", 1, "ramesh@gmail.com", "Free", "Ramesh123"));
//		DatabaseSystem.getInstance()
//				.insertInterviewers(new Interviewer("Suresh", 2, "suresh@gmail.com", "Free", "Suresh123"));
//		DatabaseSystem.getInstance()
//				.insertInterviewers(new Interviewer("Sathish", 3, "sathish@gmail.com", "Free", "Sathish123"));
//		DatabaseSystem.getInstance()
//		.insertInterviewers(new Interviewer("Dinesh", 4, "dinesh@gmail.com", "Free", "Dinesh123"));
//		DatabaseSystem.getInstance()
//		.insertInterviewers(new Interviewer("Sripathy", 5, "sripathy@gmail.com", "Free", "sripathy123"));
//	}
//	
//	public void setCandidatesDetails() {
//		DatabaseSystem.getInstance()
//		.insertCandidate(new Candidate("Akash", 1, "akash@gmail.com", 1234567890, "Java", "Tirunelveli", null, null,"pending"));
//		DatabaseSystem.getInstance()
//		.insertCandidate(new Candidate("Sachin", 2, "sachin@gmail.com", 1234567891, "Python", "Madurai", null, null,"pending"));
//		DatabaseSystem.getInstance()
//		.insertCandidate(new Candidate("Dhoni", 3, "dhoni@gmail.com", 1234567892, "C", "chennai", null, null,"pending"));
//		DatabaseSystem.getInstance()
//		.insertCandidate(new Candidate("Virat", 4, "virat@gmail.com", 1234567893, "C++", "Coimbatore", null, null,"pending"));
//		DatabaseSystem.getInstance()
//		.insertCandidate(new Candidate("Rohit", 5, "rohit@gmail.com", 1234567894, "Java", "Salem", null, null,"pending"));
//		DatabaseSystem.getInstance()
//		.insertCandidate(new Candidate("Raina", 6, "raina@gmail.com", 1234567895, "Rust", "Dindigul", null, null,"pending"));
//		DatabaseSystem.getInstance()
//		.insertCandidate(new Candidate("Rahul", 7, "rahul@gmail.com", 1234567896, "Java", "Virudhunage", null, null,"pending"));
//		DatabaseSystem.getInstance()
//		.insertCandidate(new Candidate("Hardik", 8, "hardik@gmail.com", 1234567897, "JavaScript", "Nagercoil", null, null,"pending"));
//		DatabaseSystem.getInstance()
//		.insertCandidate(new Candidate("Yuvraj", 9, "yuvraj@gmail.com", 1234567898, "Python", "Tenkasi", null, null,"pending"));
//		DatabaseSystem.getInstance()
//		.insertCandidate(new Candidate("Karthik", 10, "karthik@gmail.com", 1234567899, "C++", "Thoothukudi", null, null,"pending"));
//		
//	}
	
	public void startCompanySetup() {
		try {
			System.out.println("\n--------------Company Details---------------");
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter the Company Name");
			String companyName = sc.nextLine();
			System.out.println("Enter the Company Mail ID");
			String mailId = sc.nextLine();
			System.out.println("Enter the Company Contact Number");
			long phoneNumber = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter the Company Address");
			String address = sc.nextLine();
			if (loginModel.checkMailId(mailId) && loginModel.checkPhoneNumber(phoneNumber)) {
				loginModel.setCompanyDetails(companyName, phoneNumber, mailId, address);
			} else {
				System.out.println("Invalid Mail Id or Phone Number");
				startCompanySetup();
			}
		} catch (Exception e) {
			startCompanySetup();
		}
		}
	
	public void startCandidateSetup() {
		System.out.println("\n\n        Welcome to Interview Panel System");
		AdminView adminView = new AdminView();
//		setInterviewersDetails();
//		setCandidatesDetails();
		adminView.onSetupComplete();
	}

	public void adminInit() {
		Credential credentials = new Credential();
		credentials.setUserName("zoho");
		credentials.setPassword("interview");
		loginModel.createCredentials(credentials);
	}
	
	public void startMenu() {
		System.out.println("\n----------------------Home Page--------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.println("\n 1.Admin \n 2.Interviewer \n 3.Exit");
		System.out.println("\nEnter your choice");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:
			loginModel.init();
			break;
		case 2:
			new InterviewerManagementView().interviewerLogin();
			break;
		case 3:
			System.out.println(
					"\n-- Thanks for using " + InterviewPanelApplication.getInstance().getAppName() + " --");
		    System.exit(0);
			break;
		default :
			System.out.println("InValid Input");
			startMenu();
		}
	}
}
