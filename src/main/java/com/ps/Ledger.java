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
    public static ArrayList <String> transactions;

    public static void checkLedger(){
        Scanner scanner = new Scanner(System.in);
        String ledgerInput;
        readTransactions();

        System.out.println("\nWelcome to your Accounts Ledger!");
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

                    System.out.println("Displaying all deposits and payments:");
                        displayAll();

                    break;
                case "D":
                    System.out.println("Displaying all deposits:");
                        displayDeposits();
                    break;

                case "P":
                    System.out.println("Displaying all payments:");
                        displayPayments();
                    break;

                case "R":
                    System.out.println("You have selected 'View Reports'.");
                        Reports.loadReports();
                    break;

                case "H":
                    System.out.println("Returning to HOME menu...");
                    break;

                default:
                    System.out.println("Command not found. Please select one of the options and try again.");
            }
        } while (!ledgerInput.equals("H"));

    }

    public static ArrayList<String> readTransactions() {

        transactions = new ArrayList<>();

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("transactions.txt"));
            String file;
            while ((file = buffReader.readLine()) != null) {
                transactions.add(file);
            }
            Collections.reverse(transactions);

        } catch (IOException e) {
            System.out.println("Error!!");
            e.printStackTrace();
        }
        return transactions;

    }

    public static void displayAll(){

        for (String file: transactions) {

            String[] splitFile = file.split("\\|");
                LocalDate date = LocalDate.parse(splitFile[0]);
                LocalTime time = LocalTime.parse(splitFile[1]);
                String description = splitFile[2];
                String vendor = splitFile[3];
                float amount = Float.parseFloat(splitFile[4]);

            Transaction tempTransactions = new Transaction(date, time, description, vendor, amount);

            System.out.printf("%s -- %s  --  '%s' --  Vendor: %s  --  Amount: %.2f\n",
                    tempTransactions.getDate(),
                    tempTransactions.getTime(),
                    tempTransactions.getDescription(),
                    tempTransactions.getVendor(),
                    tempTransactions.getAmount());
        }
    }

    public static void displayDeposits(){
        for (String file: transactions) {

            String[] splitFile = file.split("\\|");
                LocalDate date = LocalDate.parse(splitFile[0]);
                LocalTime time = LocalTime.parse(splitFile[1]);
                String description = splitFile[2];
                String vendor = splitFile[3];
                float amount = Float.parseFloat(splitFile[4]);

            Transaction tempTransactions = new Transaction(date, time, description, vendor, amount);

            if (tempTransactions.getAmount() > 0) {
                System.out.printf("%s  %s    '%s',  Vendor: %s,  Amount: %.2f\n",
                        tempTransactions.getDate(),
                        tempTransactions.getTime(),
                        tempTransactions.getDescription(),
                        tempTransactions.getVendor(),
                        tempTransactions.getAmount());
            }

        }

    }

    public static void displayPayments(){
        for (String file: transactions) {

            String[] splitFile = file.split("\\|");
                LocalDate date = LocalDate.parse(splitFile[0]);
                LocalTime time = LocalTime.parse(splitFile[1]);
                String description = splitFile[2];
                String vendor = splitFile[3];
                float amount = Float.parseFloat(splitFile[4]);

            Transaction tempTransactions = new Transaction(date, time, description, vendor, amount);

            if (tempTransactions.getAmount() < 0) {
                System.out.printf("%s  %s    '%s',  Vendor: %s,  Amount: %.2f\n",
                        tempTransactions.getDate(),
                        tempTransactions.getTime(),
                        tempTransactions.getDescription(),
                        tempTransactions.getVendor(),
                        tempTransactions.getAmount());
            }


        }

    }
}



