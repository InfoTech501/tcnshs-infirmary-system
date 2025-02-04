package com.rocs.medical.records.application.app.facade.MedicalRecords.impl;

import com.rocs.medical.records.application.app.facade.MedicalRecords.MedicalRecordsFacade;
import com.rocs.medical.records.application.model.MedicalRecords.MedicalRecords;


public class MedicalRecordsFacadeImpl implements MedicalRecordsFacade {

    @Override
    public boolean addMedicalRecords(MedicalRecords MedicalRecords) {
        return MedicalRecords.medicalrecordsDao.addMedicalRecords(MedicalRecords);
    }
}
