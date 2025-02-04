package com.rocs.medical.records.application.app.facade.MedicalRecords.impl;

import com.rocs.medical.records.application.app.facade.MedicalRecords.MedicalRecordsFacade;
import com.rocs.medical.records.application.model.MedicalRecords.MedicalRecords;


public class MedicalRecordsFacadeImpl implements MedicalRecordsFacade {

    public boolean patient (MedicalRecords medicalRecords) {
        return medicalRecords.medicalrecordsDao.addMedicalRecords(medicalRecords);
    }
}
