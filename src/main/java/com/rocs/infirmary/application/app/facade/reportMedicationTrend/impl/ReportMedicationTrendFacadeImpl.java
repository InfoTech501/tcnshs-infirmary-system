package com.rocs.infirmary.application.app.facade.reportMedicationTrend.impl;

import com.rocs.infirmary.application.app.facade.reportMedicationTrend.reportMedicationTrendFacade;
import com.rocs.infirmary.application.data.dao.reportMedicationTrend.impl.ReportMedicationTrendDaoImpl;
import com.rocs.infirmary.application.data.dao.reportMedicationTrend.reportMedicationTrendDao;
import com.rocs.infirmary.application.model.report.MedicationTrendReport;

import java.util.Date;
import java.util.List;

public class ReportMedicationTrendFacadeImpl implements reportMedicationTrendFacade {
    reportMedicationTrendDao medTrendDao = new ReportMedicationTrendDaoImpl();

    @Override
    public List<MedicationTrendReport> generateReport(Date startingDate, Date endDate) {
        return List.of();
    }
}
