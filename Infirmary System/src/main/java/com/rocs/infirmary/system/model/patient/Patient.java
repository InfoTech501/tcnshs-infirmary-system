package com.rocs.infirmary.system.model.frequentVisit;

public class PatientFrequentVisit {
    private String id;
    private String patient_id;
    private String student_number;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String visit_date;

    public PatientFrequentVisit(String id, String patient_id, String student_number, String first_name, String middle_name, String last_name, String visit_date){
        this.id = id;
        this.patient_id = patient_id;
        this.student_number = student_number;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.visit_date = visit_date;

    }
    public PatientFrequentVisit(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(String visit_date) {
        this.visit_date = visit_date;
    }
}

