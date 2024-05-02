package com.ps;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Reports {
    static Scanner scanner = new Scanner(System.in);

    public static void loadReports(ArrayList<Transaction> transactionsList) {

        Collections.reverse(transactionsList);

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
            System.out.println("\t(6) Custom Search");
            System.out.println("\t(0) Return to Ledger");

            reportsInput = scanner.nextLine().trim();

            switch (reportsInput) {

                case "1":
                    monthToDate(transactionsList);
                    break;

                case "2":
                    previousMonth(transactionsList);
                    break;

                case "3":
                    yearToDate(transactionsList);
                    break;

                case "4":
                    previousYear(transactionsList);
                    break;

                case "5":
                    searchVendor(transactionsList);
                    break;

                case "6":
                    customSearch(transactionsList);
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

    public static void monthToDate(ArrayList<Transaction> transactionsList) {

        boolean mRecord = false;

        System.out.println("             ** Month to Date Report **");
        System.out.println("                  - Transactions -");
        System.out.println("  * Date -- Time -- Description -- Vendor -- Amount *\n");

        for (Transaction transactions : transactionsList) {

            LocalDate transactionDate = transactions.getDate();
            LocalDate currentDate = LocalDate.now();

            if (transactionDate.getMonthValue() == currentDate.getMonthValue()) {
                mRecord = true;
                System.out.printf("~ %s -- %s -- %s -- %s -- $%.2f\n",
                        transactions.getDate(),
                        transactions.getTime(),
                        transactions.getDescription(),
                        transactions.getVendor(),
                        transactions.getAmount());
            }
        } if (!mRecord) {
            System.out.println("          ** Could not find any transactions **");
            System.out.println("                 - Please try again -");
        }
    }

    public static void previousMonth(ArrayList<Transaction> transactionsList) {

        boolean pRecord = false;

        System.out.println("              ** Previous Month Report **");
        System.out.println("                   - Transactions -");
        System.out.println("   * Date -- Time -- Description -- Vendor -- Amount *\n");

        for (Transaction transactions : transactionsList) {

            LocalDate currentDate = LocalDate.now();
            LocalDate transactionDate = transactions.getDate();
            LocalDate previousMonth = currentDate.minusMonths(1);

            if (previousMonth.getMonthValue() == transactionDate.getMonthValue() &&
                    previousMonth.getYear() == transactionDate.getYear()) {
                pRecord = true;
                System.out.printf("~ %s -- %s -- %s -- %s -- $%.2f\n",
                        transactions.getDate(),
                        transactions.getTime(),
                        transactions.getDescription(),
                        transactions.getVendor(),
                        transactions.getAmount());
            }
        } if (!pRecord) {
            System.out.println("          ** Could not find any transactions **");
            System.out.println("                 - Please try again -");
        }

    }

    public static void yearToDate(ArrayList<Transaction> transactionsList) {

        boolean yRecord = false;

        System.out.println("              ** Year to Date Report **");
        System.out.println("                  - Transactions -");
        System.out.println("  * Date -- Time -- Description -- Vendor -- Amount *\n");

        for (Transaction transactions : transactionsList) {

            LocalDate transactionDate = transactions.getDate();
            LocalDate currentDate = LocalDate.now();

            if (transactionDate.getYear() == currentDate.getYear()) {
                yRecord = true;
                System.out.printf("~ %s -- %s -- %s -- %s -- $%.2f\n",
                        transactions.getDate(),
                        transactions.getTime(),
                        transactions.getDescription(),
                        transactions.getVendor(),
                        transactions.getAmount());
            }
        } if (!yRecord) {
            System.out.println("          ** Could not find any transactions **");
            System.out.println("                 - Please try again -");
        }
    }

        public static void previousYear (ArrayList < Transaction > transactionsList) {

            boolean pYRecord = false;

            System.out.println("              ** Previous Year Report **");
            System.out.println("                  - Transactions -");
            System.out.println("  * Date -- Time -- Description -- Vendor -- Amount *\n");

            for (Transaction transactions : transactionsList) {

                LocalDate transactionDate = transactions.getDate();
                LocalDate currentDate = LocalDate.now();
                LocalDate pYear = currentDate.minusYears(1);

                if (pYear.getYear() == transactionDate.getYear()) {
                    pYRecord = true;
                    System.out.printf("~ %s -- %s -- %s -- %s -- $%.2f\n",
                            transactions.getDate(),
                            transactions.getTime(),
                            transactions.getDescription(),
                            transactions.getVendor(),
                            transactions.getAmount());
                }
            } if (!pYRecord) {
                System.out.println("          ** Could not find any transactions **");
                System.out.println("                 - Please try again -");
            }
        }

        public static void searchVendor (ArrayList < Transaction > transactionsList) {

            String vendorInput;

            System.out.println("* Please enter in the vendor name:");
            vendorInput = scanner.nextLine().trim();
            boolean vendorFound = false;
            String vendorOutput = vendorInput.substring(0, 1).toUpperCase() + vendorInput.substring(1);

            System.out.println("                       --  Vendor Result  --");
            System.out.println("         * Date -- Time -- Description -- Vendor -- Amount *\n");

            for (Transaction vendorSearch : transactionsList) {

                if (vendorOutput.equals(vendorSearch.getVendor())) {
                    vendorFound = true;
                    System.out.printf("~ %s -- %s  --  '%s' --  Vendor: %s  --  Amount: %.2f\n",
                            vendorSearch.getDate(),
                            vendorSearch.getTime(),
                            vendorSearch.getDescription(),
                            vendorSearch.getVendor(),
                            vendorSearch.getAmount());
                }
            } if (!vendorFound) {
                System.out.println("              ** Could not find vendor **");
                System.out.println("                 - Please try again -    ");
            }

        }

        public static void customSearch (ArrayList<Transaction> transactionsList) {

            System.out.println();

        }


    }

