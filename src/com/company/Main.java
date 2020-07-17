package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        int principal = 0;
        float yearlyRate = 0;
        float rate = 0;
        int numberOfPayments = 0;
        byte periodYears = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Principal ($1k - $1m): ");
            principal = scanner.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000)
                break;
            System.out.println("Enter amount between 1,000 and 1,000, 000");
        }

        while (true){
            System.out.print("Annual Interest rate: ");
            yearlyRate = scanner.nextFloat();

            if (yearlyRate > 0 && yearlyRate <= 30) {
                rate = (yearlyRate / PERCENTAGE) / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter value between 0 and 30.");
        }

        while (true){
            System.out.print("Enter Period (Years): ");
            periodYears = scanner.nextByte();

            if (periodYears > 0 && periodYears <= 30){
                numberOfPayments = periodYears * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter value between 0 and 30.");

        }

        double mortgage = principal * ((rate * Math.pow((1 + rate), numberOfPayments)) / (Math.pow((1 + rate), numberOfPayments) - 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);


    }
}
