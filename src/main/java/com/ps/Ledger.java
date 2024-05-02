package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ledger {

    public static void checkLedger(ArrayList<Transaction> transactionsList){
        Scanner scanner = new Scanner(System.in);
        String ledgerInput;

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("transactions.txt"));
            String file;
            while ((file = buffReader.readLine()) != null) {

                String[] splitFile = file.split("\\|");
                LocalDate date = LocalDate.parse(splitFile[0]);
                LocalTime time = LocalTime.parse(splitFile[1]);
                String description = splitFile[2];
                String vendor = splitFile[3];
                float amount = Float.parseFloat(splitFile[4]);

                Transaction tempTransactions = new Transaction(date, time, description, vendor, amount);

                transactionsList.add(tempTransactions);
            }
            Collections.reverse(transactionsList);

        } catch (IOException e) {
            System.out.println("Error!!");
            e.printStackTrace();
        }

        System.out.println("\n    *  Welcome to your Accounts Ledger!  *  ");
        System.out.println("       -- What would you like to do? --  ");

        do {

            System.out.println("\n* Please select one of the following options:");
                System.out.println("\t~ (A) Display all entries");
                System.out.println("\t~ (D) View Deposits");
                System.out.println("\t~ (P) View Payments");
                System.out.println("\t~ (R) View Reports");
                System.out.println("\t~ (H) Return to HOME menu");

            ledgerInput = scanner.next().toUpperCase().trim();

            switch (ledgerInput){
                case "A":
                    displayAll(transactionsList);
                    break;

                case "D":
                    displayDeposits(transactionsList);
                    break;

                case "P":
                        displayPayments(transactionsList);
                    break;

                case "R":
                        Reports.loadReports(transactionsList);
                    break;

                case "H":
                    System.out.println("           --  Welcome back!  --");
                    break;

                default:
                    System.out.println("       -- Command not found --");
                    System.out.println("        * Please try again    ");
            }
        } while (!ledgerInput.equals("H"));

    }

    public static void displayAll(ArrayList<Transaction> transactionsList){

        System.out.println("                      --  Deposits and Payments  --\n");

        for (Transaction file: transactionsList) {

            System.out.printf("~ %s -- %s  --  '%s' --  Vendor: %s  --  Amount: %.2f\n",
                    file.getDate(),
                    file.getTime(),
                    file.getDescription(),
                    file.getVendor(),
                    file.getAmount());
        }
    }

    public static void displayDeposits(ArrayList<Transaction> transactionsList){

        System.out.println("                             --  Deposits  --\n");

        for (Transaction file: transactionsList) {

            if (file.getAmount() > 0) {
                System.out.printf("~ %s -- %s  --  '%s' --  Vendor: %s  --  Amount: %.2f\n",
                        file.getDate(),
                        file.getTime(),
                        file.getDescription(),
                        file.getVendor(),
                        file.getAmount());
            }
        }
    }

    public static void displayPayments(ArrayList<Transaction> transactionsList) {

        System.out.println("                            --  Payments  --\n");

        for (Transaction file: transactionsList) {

            if (file.getAmount() < 0) {
                System.out.printf("~ %s -- %s  --  '%s' --  Vendor: %s  --  Amount: %.2f\n",
                        file.getDate(),
                        file.getTime(),
                        file.getDescription(),
                        file.getVendor(),
                        file.getAmount());
            }
        }
    }
}



