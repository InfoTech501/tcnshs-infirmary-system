package com.rocs.medical.records.application;

import com.rocs.medical.records.application.app.facade.MedicalRecords.MedicalRecordsFacade;
import com.rocs.medical.records.application.app.facade.MedicalRecords.impl.MedicalRecordsFacadeImpl;
import com.rocs.medical.records.application.model.MedicalRecords.MedicalRecords;

import java.util.Scanner;

public class MedicalRecordsApplication {

    public static void main(String args) {

        MedicalRecordsFacade itemFacade = new MedicalRecordsFacadeImpl(); // Though declared, it's not used. Consider removing if not needed.
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Medical Records System");
        System.out.println("Please enter your selection:");
        System.out.println("1. Student Record Application");
        System.out.println("2. Return");
        System.out.println("Press other keys to exit.");
        System.out.print("Enter your choice: ");

        int input = sc.nextInt();

        switch (input) {
            case 1:
                int choice;
                System.out.println("Medical Records");
                System.out.println("Please select an option:");
                System.out.println("1. Add a Record");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: {
                        System.out.println("Adding a record");
                        System.out.println("Enter student Name: ");
                        String studentName = sc.nextLine();
                        System.out.println("Enter Symptoms: ");
                        String symptoms = sc.nextLine();
                        System.out.println("Enter Remarks: ");
                        String remarks = sc.nextLine();
                        System.out.println("Enter Temperature: ");
                        double temperature = sc.nextDouble();
                        System.out.println("Enter Visit Day: ");
                        int dayVisit = sc.nextInt();
                        System.out.println("Enter Visit Hour: ");
                        int visitHour = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Medication Administered: ");
                        String medicationAdministered = sc.nextLine();

                        MedicalRecords medicalRecords = new MedicalRecords();
                        medicalRecords.setStudentName(studentName);
                        medicalRecords.setSymptoms(symptoms);
                        medicalRecords.setRemarks(remarks);
                        medicalRecords.setTemperature(temperature);
                        medicalRecords.setMedicationAdministered(medicationAdministered);

                        boolean result = itemFacade.patient(medicalRecords);

                        if (result) {
                            System.out.println("Record successfully added.");
                        } else {
                            System.out.println("Record cannot be added.");
                        }

                        break;
                    }
                    default:
                        System.out.println("Invalid choice for adding a record.");
                }
                break;

            default:
                System.out.println("Exiting the application.");
                break;
        }
        sc.close();
    }
}