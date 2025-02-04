package com.rocs.infirmary.application.data.dao.reportMedicationTrend;

import com.rocs.infirmary.application.model.report.MedicationTrendReport;

import java.util.Date;
import java.util.List;

public interface reportMedicationTrendDao {
    List<MedicationTrendReport> generateReport(Date startingDate, Date endDate);
}
