package com.rocs.infirmary.system.facade.patient;

import java.util.List;

public interface PatientFacade {
    public getPatientById(String id);

    List<com.rocs.infirmary.system.model.patient.PatientFrequentVisit> getAllPatient();

    public getVisitDate(String visit_date);
}
