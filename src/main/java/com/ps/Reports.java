package com.ps;

import java.util.Scanner;

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
                // Month to date
                    System.out.println("Displaying Month to current date report:");
                    break;
                case 2:
                // Previous Month
                    System.out.println("Displaying Previous Month report:");
                    break;
                case 3:
                // Year to Date
                    System.out.println("Displaying Year to current date report");
                    break;
                case 4:
                // Previous Year
                    System.out.println("Displaying Previous Year report:");
                    break;
                case 5:
                // Search by vendor
                    // Prompts user for vendor name
                    System.out.println("Please enter in the vendor name:");
                    vendorInput = scanner.nextLine().trim();

                    // Displays all entries for that vendor
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
}
