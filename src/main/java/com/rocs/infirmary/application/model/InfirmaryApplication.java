package com.rocs.infirmary.application.model;

import com.rocs.infirmary.application.MedicationTrendReportService;
import com.rocs.infirmary.application.app.facade.reportMedicationTrend.reportMedicationTrendFacade;
import com.rocs.infirmary.application.model.report.MedicationTrendReport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InfirmaryApplication {
    public static void main(String[] args) {

            try (Scanner scanner = new Scanner(System.in)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);

                System.out.println("Welcome to Medication Trend Report");

                Date startingDate = getValidDate(scanner, dateFormat, "Please enter start date (yyyy-MM-dd): ");
                Date endDate = getValidDate(scanner, dateFormat, "Please enter end date (yyyy-MM-dd): ");

                reportMedicationTrendFacade repository = (startingDateDate, endDateDate) -> List.of();
                MedicationTrendReportService service = new MedicationTrendReportService(repository);

                MedicationTrendReport report = service.generateReport(startingDate, endDate);

                if (report != null) {
                    System.out.println("\nReport generated!:" );
                    System.out.println(report);
                } else {
                    System.out.println("No data available for the selected criteria.");
                }
            } catch (RuntimeException e) {
                System.err.println("Error generating: " + e.getMessage());
            }
        }

        private static Date getValidDate(Scanner scanner, SimpleDateFormat dateFormat, String prompt) {
            while (true) {
                try {
                    System.out.print(prompt);
                    return dateFormat.parse(scanner.nextLine());
                } catch (ParseException e) {
                    System.err.println("Invalid date, please use yyyy-MM-dd.");
                }
            }
        }
    }
