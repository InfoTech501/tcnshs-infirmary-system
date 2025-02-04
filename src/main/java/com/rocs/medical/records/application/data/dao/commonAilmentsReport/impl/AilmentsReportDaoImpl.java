package com.rocs.medical.records.application.data.dao.commonAilmentsReport.impl;


import com.rocs.medical.records.application.data.connection.ConnectionHelper;
import com.rocs.medical.records.application.data.dao.commonAilmentsReport.CommonAilmentsReportDAO;
import com.rocs.medical.records.application.model.reportAffectedStudents.ReportAffectedStudents;
import com.rocs.medical.records.application.model.reports.CommonAilmentsReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AilmentsReportDaoImpl implements CommonAilmentsReportDAO {

    @Override
    public List<CommonAilmentsReport> generateReport(Date startDate, Date endDate, String gradeLevel, String section) {
        List<CommonAilmentsReport> reports = new ArrayList<>();

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement statement = createStatement(connection, startDate, endDate, gradeLevel, section)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CommonAilmentsReport report = new CommonAilmentsReport();
                report.setAilment(resultSet.getString("ailment"));
                report.setOccurrences(resultSet.getInt("occurrences"));

                List<ReportAffectedStudents> affectedStudents = new ArrayList<>();
                do {
                    ReportAffectedStudents affectedStudent = new ReportAffectedStudents();
                    affectedStudent.setStudentNumber(resultSet.getString("student_number"));
                    affectedStudent.setFirstName(resultSet.getString("first_name"));
                    affectedStudent.setLastName(resultSet.getString("last_name"));
                    affectedStudent.setGradeLevel(resultSet.getString("grade_level"));
                    affectedStudent.setSection(resultSet.getString("section"));
                    affectedStudent.setAge(resultSet.getInt("age"));
                    affectedStudents.add(affectedStudent);
                } while (resultSet.next() && resultSet.getString("ailment").equals(report.getAilment()));

                report.setReportAffectedStudents(affectedStudents);
                reports.add(report);
            }
        } catch (Exception e) {
            System.out.println("Error generating common ailments report" + e);
        }

        return reports;
    }

    private PreparedStatement createStatement(Connection connection, Date startDate, Date endDate, String gradeLevel, String section) throws SQLException, SQLException {
        String sql = "SELECT p.symptoms AS ailment, COUNT(*) AS occurrences, s.grade_level, s.section, s.age "
                + "FROM patient p "
                + "JOIN student s ON p.patient_id = s.patient_id "
                + "WHERE p.visit_date BETWEEN ? AND ? "
                + "AND (? IS NULL OR s.grade_level = ?) "
                + "AND (? IS NULL OR s.section = ?) "
                + "GROUP BY p.symptoms, s.grade_level, s.section, s.age "
                + "ORDER BY occurrences DESC";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, new java.sql.Date(startDate.getTime()));
        statement.setDate(2, new java.sql.Date(endDate.getTime()));
        statement.setString(3, gradeLevel);
        statement.setString(4, gradeLevel);
        statement.setString(5, section);
        statement.setString(6, section);
        return statement;
    }
}
