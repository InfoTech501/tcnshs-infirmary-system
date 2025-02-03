package com.rocs.medical.records.application;

import com.rocs.medical.records.application.app.facade.MedicalRecords.MedicalRecordsFacade;
import com.rocs.medical.records.application.app.facade.MedicalRecords.impl.MedicalRecordsFacadeImpl;
import com.rocs.medical.records.application.model.MedicalRecords.MedicalRecords;

import java.util.Scanner;

public class MedicalRecordsApplication {

    public static void main(String[] args) {

        MedicalRecordsFacade itemFacade = new MedicalRecordsFacadeImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Medical Records");
        System.out.println("Please enter your selection:");
        System.out.println("1. Create Student Record");
        System.out.println("Press other keys to exit.");
        System.out.print("Enter you choice: ");
        int input = sc.nextInt();
    }

switch(input)

    {
        case 1: {
            System.out.println("Medical Records");
            System.out.println("Please select an option:");
            System.out.println("1. Add an Record");
            System.out.print("Enter you choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    sc.nextLine();

                    System.out.println("Adding an item");
                    System.out.println("Enter StudentName: ");
                    String StudentName = sc.nextLine();
                    System.out.println("Enter Symptoms: ");
                    String Symptoms = sc.nextLine();
                    System.out.println("Enter Remarks: ");
                    String Remarks = sc.nextLine();
                    System.out.println("Enter Temperature: ");
                    int Temperature = sc.nextInt();
                    System.out.println("Enter Date: ");
                    int Date = sc.nextInt();
                    System.out.println("Enter TimeVisit: ");
                    int TimeVisit = sc.nextInt();
                    System.out.println("Enter MedicationAdministered: ");
                    int MedicationAdministered = sc.nextInt();

                    MedicalRecords MedicalRecords = new MedicalRecords();
                    MedicalRecords.setStudentName(StudentName);
                    MedicalRecords.setSymptoms(Symptoms);
                    MedicalRecords.setRemarks(Remarks);
                    MedicalRecords.setTemperature(Temperature);
                    MedicalRecords.setDate(Date);
                    MedicalRecords.setTimeVisit(TimeVisit);
                    MedicalRecords.setMedicationAdministered(MedicationAdministered);

                    boolean result = MedicalRecordsFacade.addMedicalRecords(MedicalRecords);

                    if(result) {
                        System.out.println("Record successfully added.");
                    } else {
                        System.out.println("Record cannot be added.");
                    }

                    break;
                }
            }
            System.out.println("Quitting the application.");
        }
    }
}
