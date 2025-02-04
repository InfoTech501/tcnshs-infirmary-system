package com.rocs.infirmary.application.data.dao.reportMedicationTrend.impl;

import com.rocs.infirmary.application.data.connection.ConnectionHelper;
import com.rocs.infirmary.application.data.dao.reportMedicationTrend.reportMedicationTrendDao;
import com.rocs.infirmary.application.model.report.MedicationTrendReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ReportMedicationTrendDaoImpl implements reportMedicationTrendDao {

    @Override
    public List<MedicationTrendReport> generateReport(Date startingDate, Date endDate) {
        try (Connection connection = ConnectionHelper.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("SELECT inventory.medicine_name, inventory.quantity_used, inventory.quantity_available \n" +
                    "FROM patient\n" +
                    "JOIN inventory ON patient.medications_administered = inventory.medicine_name\n" +
                    "WHERE patient.visit_date BETWEEN ? AND ?\n" +
                    "ORDER BY inventory.quantity_used DESC;");
            stmt.setDate(1, new java.sql.Date(startingDate.getTime()));
            stmt.setDate(2, new java.sql.Date(endDate.getTime()));
//            stmt.setString(3,medName);
//            stmt.setLong(4, quantityAvailable);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                MedicationTrendReport medication = new MedicationTrendReport();
                medication.setQuantityUsed(rs.getInt("quantity_used"));
                medication.setMedName(rs.getString("med_name"));
                medication.setQuantityAvailable(rs.getInt("quantity_available"));
            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception Occurred." + e.getMessage());;
        }

        return List.of();
    }

}
