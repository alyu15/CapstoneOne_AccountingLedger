package com.ps;

import java.util.Scanner;

public class Ledger {

    public static void checkLedger(){
        Scanner scanner = new Scanner(System.in);
        String ledgerInput;

        System.out.println("\nWelcome to your Ledger!");
        System.out.println("What would you like to do?");

        do {
            System.out.println("\nPlease select one of the following options:");
                System.out.println("\t(A) Display all entries");
                System.out.println("\t(D) View Deposits");
                System.out.println("\t(P) View Payments");
                System.out.println("\t(R) View Reports");
                System.out.println("\t(H) Return to HOME menu");

            ledgerInput = scanner.next().toUpperCase().trim();

            switch (ledgerInput){
                case "A":
                    // Display all entries, showing only the newest entries first
                    break;
                case "D":
                    // Deposits - Display only deposits into account
                    break;
                case "P":
                    // Displays only the negative entries/Payments from account
                    break;
                case "R":
                    // Reports
                    Reports.loadReports();
                    break;
                case "H":
                    // Back to home menu
                    System.out.println("Returning to HOME menu...");
                    break;
                default:
                    System.out.println("Command not found. Please select one of the options and try again.");
            }
        } while (!ledgerInput.equals("H"));
    }
}
