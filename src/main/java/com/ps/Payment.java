package com.ps;

import java.util.Scanner;

public class Payment {

    public static void makeDebitPayment(){

        // Prompt user for debit information
        Scanner scanner = new Scanner(System.in);
        String paymentReason;
        String payVendorName;
        float paymentAmount;

        System.out.println("\nPlease enter in the reason for this payment:");
        paymentReason = scanner.nextLine();

        System.out.println("Please enter in the vendor name:");
        payVendorName = scanner.nextLine();

        System.out.println("Please enter in the amount you would like to pay:");
        paymentAmount = scanner.nextFloat();

        // Save info to csv file

        System.out.println("You have successfully made a payment!");
    }

}
