package main.com.rocs.infirimary.deskstop.application;


import main.com.rocs.infirimary.deskstop.application.app.facade.studInfo.impl.studentImplFacadeImpl;
import main.com.rocs.infirimary.deskstop.application.app.facade.studentInfoFacade;
import main.com.rocs.infirimary.deskstop.application.model.StudentInfo.studentInfo;

import java.util.Scanner;

public class infirmaryDesktopApplication {
    public infirmaryDesktopApplication() {
    }

    public static void main(String[] args) {
        studentInfoFacade studentInfoFacade = new studentImplFacadeImpl();

        Scanner sc = new Scanner(System.in);
        System.out.println("Choice to search ");

        System.out.println("1. LRN");
        System.out.println("2, Name");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                System.out.println("Search for students LRN : ");

                long LRN = sc.nextLong();

                studentInfo studentInfo = studentInfoFacade.searchStudentbyLRN(LRN);
                if (studentInfo == null) {

                    System.out.println("Not Student Found!");
                    break;
                } else {
                    System.out.println("Student Info ");
                    System.out.println("Firstname : " + studentInfo.getFirstName());
                    System.out.println("Middlename : " + studentInfo.getMiddleName());
                    System.out.println("Lastname : " + studentInfo.getLastName());
                    System.out.println("Address : " + studentInfo.getAddress());
                    System.out.println("Age : " + studentInfo.getAge());
                    System.out.println("Birthdate : " + studentInfo.getBirthDate());
                    System.out.println("Gender : " + studentInfo.getGender());
                    System.out.println("Email : " + studentInfo.getGmail());
                    System.out.println("ContactNumber : " + studentInfo.getContactNumber());
                    System.out.println("Guardian ContactNumber  : " + studentInfo.getGuardianContactNumber());
                }
            case 2:
                System.out.println("Enter a firstname : ");
                String firstname = sc.nextLine();
                System.out.println("Enter a lastname : ");
                String lastname = sc.nextLine();
// Initial Commit//
                studentInfo = studentInfoFacade.searchStudentsbyFullName(firstname, lastname);

                if (studentInfo != null) {
                    System.out.println("Student Info ");
                    System.out.println("Firstname : " + studentInfo.getFirstName());
                    System.out.println("Middlename : " + studentInfo.getMiddleName());
                    System.out.println("Lastname : " + studentInfo.getLastName());
                    System.out.println("Address : " + studentInfo.getAddress());
                    System.out.println("Age : " + studentInfo.getAge());
                    System.out.println("Birthdate : " + studentInfo.getBirthDate());
                    System.out.println("Gender : " + studentInfo.getGender());
                    System.out.println("Email : " + studentInfo.getGmail());
                    System.out.println("ContactNumber : " + studentInfo.getContactNumber());
                    System.out.println("Guardian ContactNumber  : " + studentInfo.getGuardianContactNumber());
                } else {

                    System.out.println("Not Student Found!");
                }
        }

    }
}


