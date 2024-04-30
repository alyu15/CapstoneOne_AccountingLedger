package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Payment {

    public static void makeDebitPayment(){

        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTimeNow = LocalDateTime.now();
        String paymentReason;
        String payVendorName;
        float paymentAmount;

        System.out.println("\nPlease enter in the reason for this payment:");
            paymentReason = scanner.nextLine();

        System.out.println("Please enter in the vendor name:");
            payVendorName = scanner.nextLine();

        System.out.println("Please enter in the amount you would like to pay:");
            paymentAmount = scanner.nextFloat();


        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = dateTimeNow.format(dateFormatter);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = dateTimeNow.format(timeFormatter);

        try {

            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("transactions.txt", true));

            String data = "\n" + formattedDate + "|" + formattedTime + "|" + paymentReason
                    + "|" + payVendorName + "|-" + paymentAmount;

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
