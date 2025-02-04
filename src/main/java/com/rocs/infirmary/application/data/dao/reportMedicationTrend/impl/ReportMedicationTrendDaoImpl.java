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

//    @Override
//    public List<MedicationTrendReport> generateReport(Date startDate, Date endDate, String gradeLevel, String section) {
//        List<MedicationTrendReport> reports = new ArrayList<>();
//
//
//             PreparedStatement statement = createStatement(connection, startDate, endDate, gradeLevel, section)) {
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                MedicationTrendReport report = new MedicationTrendReport();
//                report.setMedName(resultSet.getString("Medicine"));
//                report.setMedTotalUsage(resultSet.getInt("Total Usage"));
//
//                List<MedicationLog> medicationLog = new ArrayList<>();
//                do {
//                    MedicationLog medication = new MedicationLog();
//                    medication.setStudentNumber(resultSet.getInt("student_number"));
//                    medication.setFirstName(resultSet.getString("first_name"));
//                    medication.setLastName(resultSet.getString("last_name"));
//                    medication.setLrn(resultSet.getInt("lrn"));
//                    medication.setSymptoms(resultSet.getString("symptoms"));
//                    medication.setMedicationAdministered(resultSet.getString("medication administered"));
//                    medication.add(medicationLog);
//                } while (resultSet.next() && resultSet.getString("ailment").equals(report.getAilment()));
//
//                report.setMedicationLog (medicationLog);
//                reports.add(report);
//            }
//        } catch (Exception e) {
//            System.out.println("Error generating report in medication trends..." + e);
//        }
//
//        return reports;
//    }
//
//    private PreparedStatement createStatement(Connection connection, Date medTrendDate, String gradeLevel, String section) throws SQLException, SQLException {
//        String sql = "SELECT p.symptoms AND p.medications_administered, COUNT(*) AS quantity_used, s.grade_level, s.section "
//                + "FROM patient p "
//                + "JOIN student s ON p.patient_id = s.patient_id "
//                + "WHERE p.visit_date BETWEEN ? AND ? "
//                + "AND (? IS NULL OR s.grade_level = ?) "
//                + "AND (? IS NULL OR s.section = ?) "
//                + "GROUP BY p.symptoms, s.grade_level, s.section, s.age "
//                + "ORDER BY med_total_usage DESC";
//
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setDate(1, new java.sql.Date(medTrendDate.getTime()));
//        statement.setString(2, gradeLevel);
//        statement.setString(3, gradeLevel);
//        statement.setString(4, section);
//        statement.setString(5, section);
//        return statement;
//    }

}
