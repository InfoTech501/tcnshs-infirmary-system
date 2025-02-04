package com.rocs.infirmary.system.data.dao.patient.impl;

import com.rocs.infirmary.system.data.connection.ConnectionNurse;
import com.rocs.infirmary.system.data.dao.patient.PatientDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PatientDaoImpl implements PatientDao {


    @Override
    public static findPatientById(String id) {
                PatientFrequentVisit = null;

        try (Connection con = ConnectionNurse.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM patient WHERE id = 1");
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                patient = new com.rocs.infirmary.system.model.patient.PatientFrequentVisit();
                PatientFrequentVisit.setId(rs.getString("id"));
                PatientFrequentVisit.setPatient_id(rs.getString("patient_id"));
                PatientFrequentVisit.setStudent_number(rs.getString("student_number"));
                PatientFrequentVisit.setFirst_name(rs.getString("first_name"));
                PatientFrequentVisit.setMiddle_name(rs.getString("middle_name"));
                PatientFrequentVisit.setLast_name(rs.getString("last_name"));
                PatientFrequentVisit.setVisit_date(rs.getString("visit_date"));

            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception Occurred." + e.getMessage());
        }
        return PatientFrequentVisit;
    }

        @Override
    public List<com.rocs.infirmary.system.model.patient.PatientFrequentVisit> findAllPatient() {
        return null;
    }

    @Override
    public static findVisitDate(String visit_date) {
        com.rocs.infirmary.system.model.patient.PatientFrequentVisit patient = null;

        try (Connection con = ConnectionNurse.getConnection()){
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM patient WHERE visit_date BETWEEN ? AND ? ORDER BY visit_date");
            stmt.setString(1, visit_date);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                patient = new com.rocs.infirmary.system.model.patient.PatientFrequentVisit();
                patient.setVisit_date(rs.getString("visit_date"));
                patient.setPatient_id(rs.getString("patient_id"));
                patient.setStudent_number(rs.getString("student_number"));
                patient.setFirst_name(rs.getString("first_name"));
                patient.setMiddle_name(rs.getString("middle_name"));
                patient.setLast_name(rs.getString("last_name"));
                patient.setSymptoms(rs.getString("symptoms"));
                patient.setAdded_remarks(rs.getString("added_remarks"));
                patient.setTemperature_readings(rs.getString("temperature_readings"));
                patient.setTime_in(rs.getString("time_in"));
                patient.setTime_out(rs.getString("time_out"));
                patient.setMedications_administered(rs.getString("medications_administered"));
                patient.setNurse_in_charge(rs.getString("nurse_in_charge"));


            }
        } catch (SQLException e) {
            System.out.println("An SQL Exception Occurred." + e.getMessage());
        }
        return patient;
    }
}
