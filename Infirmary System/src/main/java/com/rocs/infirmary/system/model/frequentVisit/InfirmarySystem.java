package com.rocs.infirmary.system.model.frequentVisit;

import com.rocs.infirmary.system.data.dao.patient.PatientDao;
import com.rocs.infirmary.system.data.dao.patient.impl.PatientDaoImpl;

public class InfirmarySystem {

    public static void main(String[] args) {

        PatientDao patientDao = new PatientDaoImpl();

        com.rocs.infirmary.system.model.patient.PatientFrequentVisit patient = new com.rocs.infirmary.system.model.patient.PatientFrequentVisit();
        patient = patientDao.getPatientById("1");

        if(patient != null){
            System.out.println(patient.getFirst_name());
            System.out.println(patient.getMiddle_name());

            System.out.print("Enter grade level: ");
            String gradeLevel = patient.getId();

            System.out.print("Enter section: ");
            String section = patient.getId();

        }else{
            System.out.println("No Patient ID found");
        }
    }
}
