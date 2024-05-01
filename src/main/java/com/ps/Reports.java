package com.ps;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static com.ps.Ledger.transactions;

public class Reports {
    static Scanner scanner = new Scanner(System.in);

    public static void loadReports(){

        System.out.println("\nWelcome to your Accounts Reports!");
        System.out.println("What would you like to do?");

        String reportsInput;

        do {
            System.out.println("\nPlease select one of the following Reports you would like to view:");
                System.out.println("\t(1) Month to Date");
                System.out.println("\t(2) Previous Month");
                System.out.println("\t(3) Year to Date");
                System.out.println("\t(4) Previous Year");
                System.out.println("\t(5) Search by Vendor");
                System.out.println("\t(0) Return to Ledger");

            reportsInput = scanner.nextLine().trim();

            switch (reportsInput) {

                case "1":
                    monthToDate();
                    break;

                case "2":
                    previousMonth();
                    break;

                case "3":
                    yearToDate();
                    break;

                case "4":
                    previousYear();
                    break;

                case "5":
                    searchVendor();
                    break;

                case "0":
                    System.out.println("  --  Welcome back to your Accounts Ledger!  --");
                    break;

                default:
                    System.out.println("       ** Command not found **");
                    System.out.println("        - Please try again -");
            }
        } while (!reportsInput.equals("0"));
    }

    public static void monthToDate() {

        boolean mRecord = false;

        System.out.println("             ** Month to Date Report **");
        System.out.println("                  - Transactions -");
        System.out.println("  * Date -- Time -- Description -- Vendor -- Amount *\n");

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
                mRecord = true;
                System.out.printf("~ %s -- %s -- %s -- %s -- $%.2f\n",
                        tempTransactions.getDate(),
                        tempTransactions.getTime(),
                        tempTransactions.getDescription(),
                        tempTransactions.getVendor(),
                        tempTransactions.getAmount());
                break;
            }
        } if (!mRecord) {
            System.out.println("          ** Could not find any transactions **");
            System.out.println("                 - Please try again -");
        }
    }

    public static void previousMonth() {
        System.out.println("              ** Previous Month Report **");
        System.out.println("                   - Transactions -");
        System.out.println("   * Date -- Time -- Description -- Vendor -- Amount *\n");

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

        System.out.println("              ** Year to Date Report **");
        System.out.println("                  - Transactions -");
        System.out.println("  * Date -- Time -- Description -- Vendor -- Amount *\n");

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

        System.out.println("              ** Previous Year Report **");
        System.out.println("                  - Transactions -");
        System.out.println("  * Date -- Time -- Description -- Vendor -- Amount *\n");

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

        String vendorInput;

        System.out.println("* Please enter in the vendor name:");
        vendorInput = scanner.nextLine().trim();
        boolean vendorFound = false;
        String vendorOutput = vendorInput.substring(0,1).toUpperCase()+vendorInput.substring(1);

        System.out.println("                 --  Vendor Result  --");
        System.out.println("  * Date -- Time -- Description -- Vendor -- Amount *\n");

        for(String vendorSearch: transactions) {

            String[] splitFile = vendorSearch.split("\\|");
            LocalDate date = LocalDate.parse(splitFile[0]);
            LocalTime time = LocalTime.parse(splitFile[1]);
            String description = splitFile[2];
            String vendor = splitFile[3];
            float amount = Float.parseFloat(splitFile[4]);

            Transaction tempTransactions = new Transaction(date, time, description, vendor, amount);

            if (vendorOutput.equals(tempTransactions.getVendor())) {
                vendorFound = true;
                System.out.printf("~ %s -- %s  --  '%s' --  Vendor: %s  --  Amount: %.2f\n",
                        tempTransactions.getDate(),
                        tempTransactions.getTime(),
                        tempTransactions.getDescription(),
                        tempTransactions.getVendor(),
                        tempTransactions.getAmount());
            }
        }
        if(!vendorFound) {
            System.out.println("              ** Could not find vendor **");
            System.out.println("                 - Please try again -    ");
        }

    }
}
