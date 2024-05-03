package com.ps;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Deposit {

    public static void makeDeposit(){

        Scanner scanner = new Scanner(System.in);
        String reason;
        String reasonEntry;
        String vendorName;
        String nameEntry;
        float depositAmount;
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();

        System.out.println("       --  Make a Deposit  --       ");
            System.out.println("\n* Please enter in the reason for this deposit:");
                reason = scanner.nextLine();
                reasonEntry = reason.substring(0,1).toUpperCase()+reason.substring(1);

            System.out.println("* Please enter in the vendor name:");
                vendorName = scanner.nextLine();
                nameEntry = vendorName.substring(0,1).toUpperCase()+vendorName.substring(1);

            System.out.println("* Please enter in the amount you would like to deposit:");
                depositAmount = scanner.nextFloat();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = timeNow.format(timeFormatter);

        try {

            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("transactions.txt", true));

            String data = String.format("\n%s|%s|%s|%s|%.2f",
                    dateNow,
                    formattedTime,
                    reasonEntry,
                    nameEntry,
                    depositAmount);

            buffWriter.write(data);
            buffWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error!!");
            e.printStackTrace();
        }

        System.out.println("        ** You have successfully made a deposit! **");
    }
}
