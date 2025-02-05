package main.com.rocs.infirimary.deskstop.application.app.facade.studInfo.impl;


import main.com.rocs.infirimary.deskstop.application.app.facade.studentInfoFacade;
import main.com.rocs.infirimary.deskstop.application.data.dao.studentinfo.impl.studentInfoDaoImpl;
import main.com.rocs.infirimary.deskstop.application.data.dao.studentinfo.studentInfoDao;
import main.com.rocs.infirimary.deskstop.application.model.StudentInfo.studentInfo;

public class studentImplFacadeImpl implements studentInfoFacade {
    private final studentInfoDao StudentInfoDao = new studentInfoDaoImpl();

    public studentImplFacadeImpl() {
    }

    public studentInfo searchStudentbyLRN(long LRN) {
        studentInfo StudentInfo = this.StudentInfoDao.searchStudentbyLRN(LRN);
        return StudentInfo;
    }

    public studentInfo searchStudentsbyFullName(String firstname, String Lastname) {
        studentInfo studentInfo = this.StudentInfoDao.searchStudentsbyFullName(firstname, Lastname);
        return studentInfo;
    }
}