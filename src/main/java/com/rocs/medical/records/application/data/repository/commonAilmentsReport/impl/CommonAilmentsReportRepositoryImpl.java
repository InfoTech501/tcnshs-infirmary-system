package com.rocs.medical.records.application.data.repository.commonAilmentsReport.impl;

import com.rocs.medical.records.application.data.dao.commonAilmentsReport.CommonAilmentsReportDAO;
import com.rocs.medical.records.application.data.dao.commonAilmentsReport.impl.AilmentsReportDaoImpl;
import com.rocs.medical.records.application.data.repository.commonAilmentsReport.CommonAilmentsReportRepository;
import com.rocs.medical.records.application.model.reports.CommonAilmentsReport;

import java.util.Date;
import java.util.List;

public class CommonAilmentsReportRepositoryImpl implements CommonAilmentsReportRepository {
    CommonAilmentsReportDAO ailmentsReportDAO = new AilmentsReportDaoImpl();

    @Override
    public List<CommonAilmentsReport> generateReport(Date startDate, Date endDate, String gradeLevel, String section) {
        return this.ailmentsReportDAO.generateReport(startDate, endDate, gradeLevel, section);
    }
}
