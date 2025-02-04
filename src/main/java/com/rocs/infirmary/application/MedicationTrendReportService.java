package com.rocs.infirmary.application;

import com.rocs.infirmary.application.app.facade.reportMedicationTrend.reportMedicationTrendFacade;
import com.rocs.infirmary.application.model.report.MedicationTrendReport;

import java.util.Date;
import java.util.List;

public class MedicationTrendReportService {
    private reportMedicationTrendFacade repository;

    public MedicationTrendReportService(reportMedicationTrendFacade repository) {
    }

    public MedicationTrendReport generateMedTrendReport(
            Date startingDate,
            Date endDate
    ) {
        List<MedicationTrendReport> reports = repository.generateReport(startingDate, endDate);

        if (reports.isEmpty()) {
            throw new RuntimeException("no data available/ no data to show");
        }

        return aggregateReports(reports);
    }

    private MedicationTrendReport aggregateReports(List<MedicationTrendReport> reports) {
        return new MedicationTrendReport();
    }

    public MedicationTrendReport generateReport(Date startingDate, Date endDate) {
        return null;
    }
}
