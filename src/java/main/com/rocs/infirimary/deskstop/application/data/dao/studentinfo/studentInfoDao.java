package main.com.rocs.infirimary.deskstop.application.data.dao.studentinfo;

import main.com.rocs.infirimary.deskstop.application.model.StudentInfo.studentInfo;

public interface studentInfoDao {
    studentInfo searchStudentbyLRN(long var1);

    studentInfo searchStudentsbyFullName(String var1, String var2);
}
