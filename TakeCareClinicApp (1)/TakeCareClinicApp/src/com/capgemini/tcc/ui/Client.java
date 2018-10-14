package com.capgemini.tcc.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;
import com.capgemini.tcc.service.*;

public class Client {

	static IPatientService patientService = new PatientService();
	static Logger logger = Logger.getLogger("logfile");

	public static void main(String[] args) throws PatientException {
		PropertyConfigurator.configure("resources//log4j.properties");
		Scanner scan = new Scanner(System.in);
		char ch;
		int option;
		l1: do {
			//DISPLAYING MENU
			System.out.println("*********************************************");
			System.out.println("\tTAKE CARE CLINIC MENU");
			System.out.println("*********************************************");
			System.out.println("1. Add Patient Information");
			System.out.println("2. Search Patient by Id");
			System.out.println("3. Exit");
			System.out.println("*********************************************");
			System.out.println("Enter a choice: ");
			option = scan.nextInt();
			switch (option) {

			case 1:
				System.out.println("Patient ID is auto-generated");
				
				//Getting Patient Details
				System.out.println("Enter the name of the Patient: ");
				String patientName = scan.next();
				System.out.println("Enter Patient age: ");
				int age = scan.nextInt();
				System.out.println("Enter Patient phone number: ");
				long phoneNo = scan.nextLong();
				scan.nextLine();
				System.out.println("Enter Description: ");
				String description = scan.nextLine();

				PatientBean patient = new PatientBean(patientName, age,
						phoneNo, description);

				PatientService patientValidate = new PatientService();
				
				//Validating Patient object
				try {
					patientValidate.validateDetails(patient);
				} catch (PatientException pe) {
					logger.error("Validation Error");
					System.err.println(pe.getMessage() + "Try Again.....");
					break l1;
				}

				//Adding patient object to database(calls service layer)
				int pid = patientService.addPatientDetails(patient);

				if (pid > 0) {
					System.out
							.println("Patient Information stored successfully for <"
									+ pid + ">");
				}
				break;

			case 2:
				//Getting patient ID to search
				System.out.println("Enter Patient ID: ");
				pid = scan.nextInt();
				patientValidate = new PatientService();
				
				//PatientID validation
				if(!patientValidate.isValidId(pid)){
					logger.error("Invalid ID entered");
					System.err.println("Invalid ID - ID must be 4 digits long..");
					break l1;
				}
				patient = new PatientBean();

				//Getting patient details from database(calls service layer)
				patient = patientService.getPatientDetails(pid);

				if (patient != null) {
					logger.info("Patient Information displayed");
					patient.toString(patient);
				} else {
					logger.error("There is no patient with given ID");
					System.err.println("There is no patient with this ID");
					break l1;
				}

				break;
			case 3:
				System.exit(0);
			default:
				logger.warn("Invalid Option");
				System.err.println("Invalid option. Try again!");
			}
			System.out.println("Do you wish to continue?");
			ch = scan.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');

	}
}