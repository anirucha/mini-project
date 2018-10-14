package com.capgemini.tcc.bean;

import java.sql.Date;

public class PatientBean {

	public PatientBean() {
		
	}
	
	private int patientId;
	private String patientName;
	private int age;
	private long phoneNo;
	private String description;
	private Date consultationDate;
	
	public PatientBean(String patientName, int age, long phoneNo,
			String description) {
		super();
		this.patientName = patientName;
		this.age = age;
		this.phoneNo = phoneNo;
		this.description = description;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getConsultationDate() {
		return consultationDate;
	}

	public void setConsultationDate(Date consultationDate) {
		this.consultationDate = consultationDate;
	}
	
	//DISPLAYING PATIENT DETAILS
	public void toString(PatientBean patient){
		System.out.println("======================================================");
		System.out.println("\t Take Care Clinic - Patient Details");
		System.out.println("======================================================");
		System.out.println("Name of the Patient: "+patient.getPatientName());
		System.out.println("Age: "+patient.getAge());
		System.out.println("Phone Number: "+patient.getPhoneNo());
		System.out.println("Description: "+patient.getDescription());
		System.out.println("Consultation Date: "+patient.getConsultationDate());
		System.out.println("======================================================");
	}

}
