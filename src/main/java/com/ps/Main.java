package com.ps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to our Accounting Ledger program!");
        System.out.println("How may we help you today?");

        String homeInput;
        do {
            System.out.println("\nPlease select one of the following options: ");
            System.out.println("\t(D) Add Deposit");
            System.out.println("\t(P) Make a Payment (Debit)");
            System.out.println("\t(L) View Ledger");
            System.out.println("\t(X) Exit application");

            homeInput = scanner.next().toUpperCase().trim();

            switch (homeInput){

                case "D":
                    Deposit.addDeposit();
                    break;
                case "P":
                    Payment.makeDebitPayment();
                    break;
                case "L":
                    Ledger.checkLedger();
                    break;
                case "X":
                    System.out.println("Exiting program... Have a nice day!");
                    break;
                default:
                    System.out.println("Command not found. Please select one of the options and try again.");
                    break;
            }


        } while (!homeInput.equals("X"));

    }
}