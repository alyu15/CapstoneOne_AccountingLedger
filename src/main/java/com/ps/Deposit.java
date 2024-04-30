package com.ps;

import java.io.*;
import java.util.Scanner;

public class Deposit {

    public static void addDeposit(){

        // Prompt user for deposit information
        Scanner scanner = new Scanner(System.in);
        String reason;
        String vendorName;
        float depositAmount;

        System.out.println("\nPlease enter in the reason for this deposit:");
            reason = scanner.nextLine();

        System.out.println("Please enter in the vendor name:");
            vendorName = scanner.nextLine();

        System.out.println("Please enter in the amount you would like to deposit:");
            depositAmount = scanner.nextFloat();

        // Save info to csv file

        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("transactions.txt"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("You have successfully made a deposit!");
    }
}
