package com.rocs.medical.records.application;

import com.rocs.medical.records.application.data.repository.commonAilmentsReport.CommonAilmentsReportRepository;
import com.rocs.medical.records.application.model.reports.CommonAilmentsReport;
import com.rocs.medical.records.application.service.commonAilmentsReport.CommonAilmentsReportService;

import java.util.Date;
import java.util.List;

public class InfirmarySystemApplication {
    public static void main(String[] args) {
        CommonAilmentsReportRepository repository = (startDate, endDate, gradeLevel, section) -> List.of();

        CommonAilmentsReportService service = new CommonAilmentsReportService(repository);

        Date startDate = new Date();
        Date endDate = new Date();
        String gradeLevel = "Grade 11";
        String section = "St.Fatima";

        try {
            CommonAilmentsReport report = service.generateAilmentsReport(startDate, endDate, gradeLevel, section);
            System.out.println("Report generated: " + report);
        } catch (RuntimeException e) {
            System.err.println("error: " + e.getMessage());
        }
    }
}
