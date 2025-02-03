package com.rocs.medical.records.application.model.MedicalRecords;

import com.rocs.medical.records.application.data.dao.impl.medicalrecordsDaoImpl;

public class MedicalRecords {

    public medicalrecordsDaoImpl medicalrecordsDao;
    private String StudentName;

    private String Symptoms;

    private String Remarks;

    private int Temperature;

    private int Date;

    private int TimeVisit;

    private int MedicationAdministered;

    public MedicalRecords() {
    }

    public MedicalRecords(String StudentName, String Symptoms, String Remarks, int Temperature, int Date, int TimeVisit, int MedicationAdministered) {
        this.StudentName = StudentName;
        this.Symptoms = Symptoms;
        this.Remarks = Remarks;
        this.Temperature = Temperature;
        this.Date = Date;
        this.TimeVisit = TimeVisit;
        this.MedicationAdministered = MedicationAdministered;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) { this.StudentName = StudentName; }

    public String getSymptoms() {
        return Symptoms;
    }

    public void setSymptoms(String Symptoms) { this.Symptoms = Symptoms; }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public int getTemperature() {
        return Temperature;
    }

    public void setTemperature(int Temperature) {
        this.Temperature = Temperature;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int Date) { this.Date = Date; }

    public int getTimeVisit() {
        return TimeVisit;
    }

    public void setTimeVisit(int TimeVisit) {
        this.TimeVisit = TimeVisit;
    }

    public int getMedicationAdministered() {
        return MedicationAdministered;
    }

    public void setMedicationAdministered( int MedicationAdministered ) {
        this.MedicationAdministered = MedicationAdministered;
    }
}
