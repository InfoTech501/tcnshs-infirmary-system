package com.rocs.medical.records.application.data.repository.commonAilmentsReport;

import com.rocs.medical.records.application.model.reports.CommonAilmentsReport;

import java.util.Date;
import java.util.List;

public interface CommonAilmentsReportRepository {
    List<CommonAilmentsReport> generateReport(
            Date startDate,
            Date endDate,
            String gradeLevel,
            String section
    );
}
