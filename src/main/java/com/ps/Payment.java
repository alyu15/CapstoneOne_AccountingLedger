package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Payment {

    public static void makePayment(){

        Scanner scanner = new Scanner(System.in);
        String paymentReason;
        String payVendorName;
        String vendorEntry;
        float paymentAmount;
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();

        System.out.println("       --  Make a Payment  --       ");
            System.out.println("\nPlease enter in the reason for this payment:");
                paymentReason = scanner.nextLine();

            System.out.println("Please enter in the vendor name:");
                payVendorName = scanner.nextLine();
                vendorEntry = payVendorName.substring(0,1).toUpperCase()+payVendorName.substring(1);

            System.out.println("Please enter in the amount you would like to pay:");
                paymentAmount = scanner.nextFloat();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = timeNow.format(timeFormatter);

        try {

            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("transactions.txt", true));

            String data = "\n" + dateNow + "|" + formattedTime + "|" + paymentReason
                    + "|" + vendorEntry + "|-" + paymentAmount;

            buffWriter.write(data);
            buffWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error!!");
            e.printStackTrace();
        }

        System.out.println("You have successfully made a payment!");
    }

}
