package com.rocs.medical.records.application.data.dao.impl;

import com.rocs.medical.records.application.data.connection.ConnectionHelper;
import com.rocs.medical.records.application.data.dao.medicalrecordsDao;
import com.rocs.medical.records.application.model.MedicalRecords.MedicalRecords;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class medicalrecordsDaoImpl {

    public boolean patient (MedicalRecords medicalRecords) {

        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO patient (studentName, getSymptoms, getRemarks, getTemperature, dayVisit, visitHour, medicationAdministered) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, medicalRecords.getStudentName());
            stmt.setString(2, medicalRecords.getSymptoms());
            stmt.setString(3, medicalRecords.getRemarks());
            stmt.setInt(4, medicalRecords.getTemperature());
            stmt.setInt(5, medicalRecords.getdayVisit());
            stmt.setInt(6, medicalRecords.getTimeVisit());
            stmt.setString(7, medicalRecords.getMedicationAdministered());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
            return false;
        }

    }

}
