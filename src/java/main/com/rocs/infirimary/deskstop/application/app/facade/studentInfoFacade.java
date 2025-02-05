package main.com.rocs.infirimary.deskstop.application.app.facade;



import main.com.rocs.infirimary.deskstop.application.model.StudentInfo.studentInfo;

public interface studentInfoFacade {
    studentInfo searchStudentbyLRN(long var1);

    studentInfo searchStudentsbyFullName(String var1, String var2);
}
