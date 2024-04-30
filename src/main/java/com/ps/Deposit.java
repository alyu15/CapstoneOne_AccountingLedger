package com.ps;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Deposit {

    public static void addDeposit(){

        Scanner scanner = new Scanner(System.in);
        LocalDateTime currentDateTime = LocalDateTime.now();
        String reason;
        String vendorName;
        float depositAmount;

        System.out.println("\nPlease enter in the reason for this deposit:");
            reason = scanner.nextLine();

        System.out.println("Please enter in the vendor name:");
            vendorName = scanner.nextLine();

        System.out.println("Please enter in the amount you would like to deposit:");
            depositAmount = scanner.nextFloat();


        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDateTime.format(dateFormatter);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = currentDateTime.format(timeFormatter);

        try {

            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("transactions.txt", true));

            String data = "\n" + formattedDate + "|" + formattedTime + "|" + reason
                    + "|" + vendorName + "|" + depositAmount;

            buffWriter.write(data);
            buffWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error!!");
            e.printStackTrace();
        }

        System.out.println("You have successfully made a deposit!");
    }
}
