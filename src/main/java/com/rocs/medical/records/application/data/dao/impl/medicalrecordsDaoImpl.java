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

    public boolean addMedicalRecords(MedicalRecords MedicalRecords) {

        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO ITEM (StudentName, Symptoms, Remarks, Temperature, Date, TimeVisit, MedicationAdministered) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, MedicalRecords.getStudentName());
            stmt.setString(2, MedicalRecords.getSymptoms());
            stmt.setString(3, MedicalRecords.getRemarks());
            stmt.setInt(4, MedicalRecords.getTemperature());
            stmt.setInt(5, MedicalRecords.getDate());
            stmt.setInt(6, MedicalRecords.getTimeVisit());
            stmt.setInt(7, MedicalRecords.getMedicationAdministered());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
            return false;
        }

    }

}
