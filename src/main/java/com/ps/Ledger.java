package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {

    public static void checkLedger(){
        Scanner scanner = new Scanner(System.in);
        String ledgerInput;

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
                    // Display all entries, showing only the newest entries first
                    System.out.println("Displaying all deposits and payments:");
                        displayAll();

                    break;
                case "D":
                    // Deposits - Display only deposits into account
                    System.out.println("Displaying all deposits:");
                        displayDeposits();

                    break;
                case "P":
                    // Displays only the negative entries/Payments from account
                    System.out.println("Displaying all payments:");
                        displayPayments();
                    break;
                case "R":
                    // Reports
                    System.out.println("You have selected 'View Reports'.");
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

    public static void displayAll(){
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("transactions.txt"));

            String file;
            ArrayList<Transaction> allTransactions = new ArrayList<>();

            while((file = buffReader.readLine()) != null){
                String[] splitFile = file.split("\\|");

                String date = splitFile[0];
                String time = splitFile[1];
                String description = splitFile[2];
                String vendor = splitFile[3];
                float amount = Float.parseFloat(splitFile[4]);

                Transaction transactions = new Transaction(date, time, description, vendor, amount);

                System.out.printf("%s  %s    '%s',  Vendor: %s,  Amount: %.2f\n",
                        transactions.getDate(),
                        transactions.getTime(),
                        transactions.getDescription(),
                        transactions.getVendor(),
                        transactions.getAmount());
            }
            buffReader.close();
        } catch (IOException e) {
            System.out.println("Error, please try again.");
            throw new RuntimeException(e);
        }

    }
    public static void displayDeposits(){
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("transactions.txt"));

            String file;

            while((file = buffReader.readLine()) != null){
                String[] splitFile = file.split("\\|");

                String date = splitFile[0];
                String time = splitFile[1];
                String description = splitFile[2];
                String vendor = splitFile[3];
                float amount = Float.parseFloat(splitFile[4]);

                Transaction transactions = new Transaction(date, time, description, vendor, amount);

                boolean depositFound = false;

                for (int i = 0; i < transactions.getAmount(); i++){
                        depositFound = true;
                        System.out.printf("%s  %s    '%s',  Vendor: %s,  Amount: %.2f\n",
                                transactions.getDate(),
                                transactions.getTime(),
                                transactions.getDescription(),
                                transactions.getVendor(),
                                transactions.getAmount());
                        break;

                }
            }
            buffReader.close();
        } catch (IOException e) {
            System.out.println("Error, please try again.");
            throw new RuntimeException(e);
        }
    }
    public static void displayPayments(){
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("transactions.txt"));

            String file;

            while((file = buffReader.readLine()) != null){
                String[] splitFile = file.split("\\|");

                String date = splitFile[0];
                String time = splitFile[1];
                String description = splitFile[2];
                String vendor = splitFile[3];
                float amount = Float.parseFloat(splitFile[4]);

                Transaction transactions = new Transaction(date, time, description, vendor, amount);

                boolean paymentFound = false;

                for (int i = 0; i > transactions.getAmount(); i++){
                    paymentFound = true;
                    System.out.printf("%s  %s    '%s',  Vendor: %s,  Amount: %.2f\n",
                            transactions.getDate(),
                            transactions.getTime(),
                            transactions.getDescription(),
                            transactions.getVendor(),
                            transactions.getAmount());
                    break;

                }
            }
            buffReader.close();
        } catch (IOException e) {
            System.out.println("Error, please try again.");
            throw new RuntimeException(e);
        }


    }
}