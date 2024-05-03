package com.ps;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GoalManager {
    static Scanner scanner = new Scanner(System.in);

    public static void goalManager() {

        String goalInput;

        System.out.println("       * Welcome to your Financial Goal Manager! *");
        System.out.println("           -- What would you like to do? --");

        do {
            System.out.println("\n* Please select one of the following options:");
            System.out.println("\t~ (1) Create a new Financial Goal");
            System.out.println("\t~ (2) View Current Goals");
            System.out.println("\t~ (3) Return to HOME menu");

            goalInput = scanner.nextLine();

            switch (goalInput) {
                case "1":
                    createGoal();
                    break;

                case "2":
                    progressTracker();
                    break;

                case "3":
                    System.out.println("         --  Welcome back!  --");
                    break;

                default:
                    System.out.println("       -- Command not found --");
                    System.out.println("        * Please try again    ");
                    break;
            }

        } while (!goalInput.equals("3"));

    }

    private static Date parseDate(String targetDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(targetDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
            return null;
        }
    }

    public static void createGoal() {
        String inputReason;
        String reasonEntry;
        double currentAmount;
        double inputAmount;
        String targetDate;

        System.out.println("         -- Create a new Financial Goal -- ");
        System.out.println("\n* Please enter in a reason behind your Financial Goal:");
        inputReason = scanner.nextLine();
        reasonEntry = inputReason.substring(0, 1).toUpperCase() + inputReason.substring(1);

        System.out.println("* Please enter in the amount you would like to contribute now");
        currentAmount = scanner.nextDouble();

        System.out.println("* Please enter in the target goal amount:");
        inputAmount = scanner.nextDouble();

        System.out.println("* Please enter in the target date of completion using (YYYY-MM-DD):");
        targetDate = scanner.next();
        scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateEntry = parseDate(targetDate);

        String formattedDate = dateFormat.format(dateEntry);

        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("financialgoals.txt", true));

            String data = String.format("\n%s|%.2f|%.2f|%s",
                    reasonEntry,
                    currentAmount,
                    inputAmount,
                    formattedDate);
            buffWriter.write(data);
            buffWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n      ** You have successfully created a new goal! **");
    }

    public static void progressTracker() {
        ArrayList<FinancialGoal> goalsList = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("financialgoals.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                String reason = parts[0];
                double currentAmount = Double.parseDouble(parts[1]);
                double targetAmount = Double.parseDouble(parts[2]);
                Date targetDate = parseDate(parts[3]);

                FinancialGoal finGoal = new FinancialGoal(reason, currentAmount, targetAmount, targetDate);
                goalsList.add(finGoal);
            }
        } catch (IOException e) {
            System.err.println("Error!!");
            throw new RuntimeException(e);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("                                                 --  Financial Goals  --\n");

        for (FinancialGoal trackGoal : goalsList) {

            double remaining = trackGoal.getTargetAmount() - trackGoal.getCurrentAmount();
            String formattedDate = dateFormat.format(trackGoal.getTargetDate());

            System.out.printf("~ '%s' -- Current Amount: $%.2f -- Target Amount: $%.2f -- Remaining Amount: $%.2f -- Target Date: %s\n",
                    trackGoal.getReason(),
                    trackGoal.getCurrentAmount(),
                    trackGoal.getTargetAmount(),
                    remaining,
                    formattedDate);
        }
    }
}