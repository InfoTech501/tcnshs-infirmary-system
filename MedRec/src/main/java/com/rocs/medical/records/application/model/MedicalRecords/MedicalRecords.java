package com.rocs.medical.records.application.model.MedicalRecords;

public class MedicalRecords {


    private String studentName;

    private String getSymptoms;

    private String getRemarks;

    private int getTemperature;

    private int dayVisit;

    private int visitHour;

    private String medicationAdministered;

    public MedicalRecords() {
    }

    public MedicalRecords(String studentName, String getSymptoms, String getRemarks, int getTemperature, int dayOfMonth, int visitHour, String medicationAdministered) {
        this.studentName = studentName;
        this.getSymptoms = getSymptoms;
        this.getRemarks = getRemarks;
        this.getTemperature = getTemperature;
        this.dayVisit = dayVisit;
        this.visitHour = visitHour;
        this.medicationAdministered = medicationAdministered;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String StudentName) { this.studentName = StudentName; }

    public String getSymptoms() {
        return getSymptoms;
    }

    public void setgetSymptoms(String getSymptoms) { this.getSymptoms = getSymptoms; }

    public String getRemarks() {
        return getRemarks;
    }

    public void setgetRemarks(String getRemarks) {
        this.getRemarks = getRemarks;
    }

    public int getTemperature() {
        return getTemperature;
    }

    public void setgetTemperature(int getTemperature) {
        this.getTemperature = getTemperature;
    }

    public int getdayVisit() {
        return dayVisit;
    }

    public void setdayVisit(int dayVisit) { this.dayVisit = this.dayVisit; }

    public int getTimeVisit() {
        return visitHour;
    }

    public void setTimeVisit(int TimeVisit) {
        this.visitHour = visitHour;
    }

    public String getMedicationAdministered() {
        return medicationAdministered;
    }

    public void setmedicationAdministered( String medicationAdministered ) {
        this.medicationAdministered = medicationAdministered;
    }
}
