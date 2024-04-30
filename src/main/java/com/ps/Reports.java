package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Scanner;

import static com.ps.Ledger.transactions;

public class Reports {

    public static void loadReports(){

        // Allows the user to run pre-defined reports or run a custom search
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to your Accounts Reports!");
        System.out.println("What would you like to do?");

        int reportsInput;
        String vendorInput;

        do {
            System.out.println("\nPlease select one of the following Reports you would like to view:");
                System.out.println("\t(1) Month to Date");
                System.out.println("\t(2) Previous Month");
                System.out.println("\t(3) Year to Date");
                System.out.println("\t(4) Previous Year");
                System.out.println("\t(5) Search by Vendor");
                System.out.println("\t(0) Return to Ledger");

            reportsInput = scanner.nextInt();


            switch (reportsInput) {

                case 1:
                    monthToDate();
                    break;

                case 2:
                    previousMonth();
                    break;

                case 3:
                    yearToDate();
                    break;

                case 4:
                    previousYear();
                    break;

                case 5:
                // Search by vendor
                    // Prompts user for vendor name
                    System.out.println("Please enter in the vendor name:");
                    vendorInput = scanner.nextLine().trim();

                    // Displays all entries for that vendor
                    searchVendor();
                    break;

                case 0:
                // Back to ledger page
                    System.out.println("Returning to Ledger...");
                    break;

                default:
                    System.out.println("Command not found. Please select one of the options and try again.");
            }
        } while (reportsInput != 0);
    }

    public static void readFile() {

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("transactions.txt"));
            String file;
            while ((file = buffReader.readLine()) != null) {
                transactions.add(file);
            }

        } catch (IOException e) {
            System.out.println("Error!!");
            e.printStackTrace();
        }
    }

    public static void monthToDate() {

        System.out.println("           * Month to Date Report *            ");
        System.out.println("              -- Transactions --               ");
        System.out.println("Date -- Time -- Description -- Vendor -- Amount\n");

        for (String transactions: transactions) {

            String[] splitFile = transactions.split("\\|");
                LocalDate date = LocalDate.parse(splitFile[0]);
                LocalTime time = LocalTime.parse(splitFile[1]);
                String description = splitFile[2];
                String vendor = splitFile[3];
                float amount = Float.parseFloat(splitFile[4]);

            Transaction tempTransactions = new Transaction(date, time, description, vendor, amount);

            LocalDate transactionDate = tempTransactions.getDate();
            LocalDate currentDate = LocalDate.now();

            if (transactionDate.getMonthValue() == currentDate.getMonthValue()) {
                System.out.printf("~ %s -- %s -- %s -- %s -- $%.2f\n",
                        tempTransactions.getDate(),
                        tempTransactions.getTime(),
                        tempTransactions.getDescription(),
                        tempTransactions.getVendor(),
                        tempTransactions.getAmount());
            }
        }

    }

    public static void previousMonth() {
        System.out.println("           * Previous Month Report *             ");
        System.out.println("              -- Transactions --                 ");
        System.out.println("Date -- Time -- Description -- Vendor -- Amount\n");

        for (String transactions: transactions) {

            String[] splitFile = transactions.split("\\|");
            LocalDate date = LocalDate.parse(splitFile[0]);
            LocalTime time = LocalTime.parse(splitFile[1]);
            String description = splitFile[2];
            String vendor = splitFile[3];
            float amount = Float.parseFloat(splitFile[4]);

            Transaction tempTransactions = new Transaction(date, time, description, vendor, amount);

            LocalDate currentDate = LocalDate.now();
            LocalDate transactionDate = tempTransactions.getDate();
            LocalDate previousMonth = currentDate.minusMonths(1);

            if (previousMonth.getMonthValue() == transactionDate.getMonthValue()&&
                    previousMonth.getYear() == transactionDate.getYear()) {
                System.out.printf("~ %s -- %s -- %s -- %s -- $%.2f\n",
                        tempTransactions.getDate(),
                        tempTransactions.getTime(),
                        tempTransactions.getDescription(),
                        tempTransactions.getVendor(),
                        tempTransactions.getAmount());
            }
        }

    }

    public static void yearToDate() {

        System.out.println("            * Year to Date Report *              ");
        System.out.println("              -- Transactions --                 ");
        System.out.println("Date -- Time -- Description -- Vendor -- Amount\n");

        for (String transactions: transactions) {

            String[] splitFile = transactions.split("\\|");
            LocalDate date = LocalDate.parse(splitFile[0]);
            LocalTime time = LocalTime.parse(splitFile[1]);
            String description = splitFile[2];
            String vendor = splitFile[3];
            float amount = Float.parseFloat(splitFile[4]);

            Transaction tempTransactions = new Transaction(date, time, description, vendor, amount);

            LocalDate transactionDate = tempTransactions.getDate();
            LocalDate currentDate = LocalDate.now();

            if (transactionDate.getYear() == currentDate.getYear()) {
                System.out.printf("~ %s -- %s -- %s -- %s -- $%.2f\n",
                        tempTransactions.getDate(),
                        tempTransactions.getTime(),
                        tempTransactions.getDescription(),
                        tempTransactions.getVendor(),
                        tempTransactions.getAmount());
            }
        }

    }

    public static void previousYear() {

        System.out.println("           * Previous Year Report *              ");
        System.out.println("              -- Transactions --                 ");
        System.out.println("Date -- Time -- Description -- Vendor -- Amount\n");

        for (String transactions: transactions) {

            String[] splitFile = transactions.split("\\|");
            LocalDate date = LocalDate.parse(splitFile[0]);
            LocalTime time = LocalTime.parse(splitFile[1]);
            String description = splitFile[2];
            String vendor = splitFile[3];
            float amount = Float.parseFloat(splitFile[4]);

            Transaction tempTransactions = new Transaction(date, time, description, vendor, amount);

            LocalDate transactionDate = tempTransactions.getDate();
            LocalDate currentDate = LocalDate.now();
            LocalDate previousYear = currentDate.minusYears(1);

            if (previousYear.getYear() == transactionDate.getYear()) {
                System.out.printf("~ %s -- %s -- %s -- %s -- $%.2f\n",
                        tempTransactions.getDate(),
                        tempTransactions.getTime(),
                        tempTransactions.getDescription(),
                        tempTransactions.getVendor(),
                        tempTransactions.getAmount());
            }
        }
    }

    public static void searchVendor() {

    }
}
