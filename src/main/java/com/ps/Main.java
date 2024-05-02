package com.ps;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaction> transactionsList = new ArrayList<>();

        System.out.println("\n  *  Welcome to our World Famous Accounting Ledger program!   *");
            System.out.println("              --  How may we help you?  --");

        String homeInput;
        do {
            System.out.println("\n* Please select one of the following options: ");
                System.out.println("\t~ (D) Make a Deposit (Credit)");
                System.out.println("\t~ (P) Make a Payment (Debit)");
                System.out.println("\t~ (L) View Ledger");
                System.out.println("\t~ (X) Exit application");

            homeInput = scanner.next().toUpperCase().trim();

            switch (homeInput){

                case "D":
                    Deposit.makeDeposit();
                    break;

                case "P":
                    Payment.makePayment();
                    break;

                case "L":
                    Ledger.checkLedger(transactionsList);
                    break;

                case "X":
                    System.out.println("       *  Exiting program...  *");
                    System.out.println("       --  Have a nice day!  --");
                    break;

                default:
                    System.out.println("       ** Command not found **");
                    System.out.println("        - Please try again -");
                    break;
            }

        } while (!homeInput.equals("X"));

    }
}