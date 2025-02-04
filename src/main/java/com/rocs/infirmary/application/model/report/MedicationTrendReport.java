package com.rocs.infirmary.application.model.report;

import java.util.Date;

public class MedicationTrendReport {

    private int id;
    private Date startingDate;
    private Date endDate;
    private String medName;
    private int quantityUsed;
    private int quantityAvailable;

    public MedicationTrendReport(int id, Date startingDate, Date endDate, String medName, int quantityUsed, int quantityAvailable) {
        this.id = id;
        this.startingDate = startingDate;
        this.endDate = endDate;
        this.medName = medName;
        this.quantityUsed = quantityUsed;
        this.quantityAvailable = quantityAvailable;
    }

    public MedicationTrendReport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(int medTotalUsage) {
        this.quantityUsed = medTotalUsage;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    @Override
    public String toString() {
        return "MedicationTrendsReport{" +
                "id=" + id +
                ", startingDate=" + startingDate +
                ", endDate=" + endDate +
                ", medName='" + medName + '\'' +
                ", quantityUsed=" + quantityUsed +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }

}
