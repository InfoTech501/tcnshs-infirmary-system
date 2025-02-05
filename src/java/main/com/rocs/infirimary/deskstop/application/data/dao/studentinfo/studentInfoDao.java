package main.com.rocs.infirimary.deskstop.application.data.dao.studentinfo;

import main.com.rocs.infirimary.deskstop.application.model.StudentInfo.studentInfo;

public interface studentInfoDao {
    studentInfo searchStudentbyLRN(long LRN);

    studentInfo searchStudentsbyFullName(String firstname, String lastname);
}
