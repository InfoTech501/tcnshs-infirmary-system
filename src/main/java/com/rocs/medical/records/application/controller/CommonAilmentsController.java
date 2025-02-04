package com.rocs.medical.records.application.controller;

import com.rocs.medical.records.application.data.facade.commonAilmentsReport.CommonAilmentsReportFacade;
import com.rocs.medical.records.application.model.reports.CommonAilmentsReport;
import com.rocs.medical.records.application.service.commonAilmentsReport.CommonAilmentsReportService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CommonAilmentsController {
    public void ViewCommonAilments() {
        try (Scanner scanner = new Scanner(System.in)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);

            System.out.println("Common ailments report");

            Date startDate = getValidDate(scanner, dateFormat, "Enter start date (yyyy-MM-dd): ");
            Date endDate = getValidDate(scanner, dateFormat, "Enter end date (yyyy-MM-dd): ");

            System.out.print("Enter grade level: ");
            String gradeLevel = scanner.nextLine();

            System.out.print("Enter section: ");
            String section = scanner.nextLine();

            CommonAilmentsReportFacade repository = (sDate, eDate, gLevel, sec) -> List.of();
            CommonAilmentsReportService service = new CommonAilmentsReportService(repository);

            CommonAilmentsReport report = service.generateAilmentsReport(startDate, endDate, gradeLevel, section);

            if (report != null) {
                System.out.println("\nReport generated!:" );
                System.out.println(report);
            }

        } catch (RuntimeException e) {
            System.err.println("Error generating: " + e.getMessage());
        }
    }

    private Date getValidDate(Scanner scanner, SimpleDateFormat dateFormat, String prompt) {
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
