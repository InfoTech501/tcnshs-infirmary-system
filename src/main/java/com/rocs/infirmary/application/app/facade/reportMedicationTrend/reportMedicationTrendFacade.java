package com.rocs.infirmary.application.app.facade.reportMedicationTrend;

import com.rocs.infirmary.application.model.report.MedicationTrendReport;

import java.util.Date;
import java.util.List;

public interface reportMedicationTrendFacade {
        List<MedicationTrendReport> generateReport(
                Date startingDate,
                Date endDate
        );
}
