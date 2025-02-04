
package main.com.rocs.infirimary.deskstop.application.data.dao.studentinfo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.com.rocs.infirimary.deskstop.application.data.dao.studentinfo.studentInfoDao;
import main.com.rocs.infirimary.deskstop.application.data.dbConnector.ConnectorHelper;
import main.com.rocs.infirimary.deskstop.application.model.StudentInfo.studentInfo;

public class studentInfoDaoImpl implements studentInfoDao {
    public studentInfoDaoImpl() {
    }

    public studentInfo searchStudentbyLRN(long LRN) {
        studentInfo Studentinfo = null;

        try {
            try (Connection con = ConnectorHelper.getConnection()) {

                PreparedStatement stmt = con.prepareStatement("SELECT * FROM STUDENT WHERE LRN = ?");
                stmt.setLong(1, LRN);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    Studentinfo = new studentInfo();
                    Studentinfo.setId(rs.getInt("ID"));
                    Studentinfo.setFirstName(rs.getString("FIRST_NAME"));
                    Studentinfo.setMiddleName(rs.getString("MIDDLE_NAME"));
                    Studentinfo.setLastName(rs.getString("LAST_NAME"));
                    Studentinfo.setAddress(rs.getString("ADDRESS"));
                    Studentinfo.setAge(rs.getInt("AGE"));
                    Studentinfo.setStrand(rs.getString("STRAND"));
                    Studentinfo.setLRN(rs.getBigDecimal("LRN").longValueExact());
                    Studentinfo.setBirthDate(rs.getString("BIRTHDATE"));
                    Studentinfo.setGender(rs.getString("GENDER"));
                    Studentinfo.setEmail(rs.getString("EMAIL"));
                    Studentinfo.setContactNumber(rs.getString("CONTACT_NUMBER"));
                    Studentinfo.setGuardianContactNumber(rs.getString("GUARDIAN_CONTACT_NUMBER"));
                }
            }

            return Studentinfo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public studentInfo searchStudentsbyFullName(String firstname, String Lastname) {
        studentInfo studentInfo = null;

        try {
            try (Connection con = ConnectorHelper.getConnection()) {
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM STUDENT WHERE FIRST_NAME = ? AND LAST_NAME = ?");
                stmt.setString(1, firstname);
                stmt.setString(2, Lastname);
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    studentInfo = new studentInfo();
                    studentInfo.setId(rs.getInt("ID"));
                    studentInfo.setFirstName(rs.getString("FIRST_NAME"));
                    studentInfo.setMiddleName(rs.getString("MIDDLE_NAME"));
                    studentInfo.setLastName(rs.getString("LAST_NAME"));
                    studentInfo.setAddress(rs.getString("ADDRESS"));
                    studentInfo.setAge(rs.getInt("AGE"));
                    studentInfo.setStrand(rs.getString("STRAND"));
                    studentInfo.setLRN(rs.getBigDecimal("LRN").longValueExact());
                    studentInfo.setBirthDate(rs.getString("BIRTHDATE"));
                    studentInfo.setGender(rs.getString("GENDER"));
                    studentInfo.setEmail(rs.getString("EMAIL"));
                    studentInfo.setContactNumber(rs.getString("CONTACT_NUMBER"));
                    studentInfo.setGuardianContactNumber(rs.getString("GUARDIAN_CONTACT_NUMBER"));
                }
            }

            return studentInfo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
