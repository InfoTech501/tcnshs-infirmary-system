package com.rocs.medical.records.application.service.commonAilmentsReport;

import com.rocs.medical.records.application.data.repository.commonAilmentsReport.CommonAilmentsReportRepository;
import com.rocs.medical.records.application.model.reports.CommonAilmentsReport;

import java.util.Date;
import java.util.List;

public class CommonAilmentsReportService {
    private final CommonAilmentsReportRepository repository;

    public CommonAilmentsReportService(CommonAilmentsReportRepository repository) {
        this.repository = repository;
    }

    public CommonAilmentsReport generateAilmentsReport(
            Date startDate,
            Date endDate,
            String gradeLevel,
            String section
    ) {
        List<CommonAilmentsReport> reports = repository.generateReport(
                startDate, endDate, gradeLevel, section
        );

        if (reports.isEmpty()) {
            throw new RuntimeException(
                    "no data available for the selected criteria!"
            );
        }

        return aggregateReports(reports);
    }

    private CommonAilmentsReport aggregateReports(List<CommonAilmentsReport> reports) {
        return new CommonAilmentsReport();
    }
}
