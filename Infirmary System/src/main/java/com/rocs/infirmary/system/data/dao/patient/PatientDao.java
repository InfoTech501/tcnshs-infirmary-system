package com.rocs.infirmary.system.data.dao.patient;


import java.util.List;

public interface PatientDao {

     patient findPatientById(String id);

    List<Patient> findAllPatient();

    findVisitDate(String visit_date);
}
