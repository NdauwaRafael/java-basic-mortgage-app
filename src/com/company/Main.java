package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = 0;
        float yearlyRate = 0;
        byte periodYears = 0;

        principal = (int)readNumber("Enter Principal ($1k - $1m): ", 1_000, 1_000_000);
        yearlyRate = (float) readNumber("Annual Interest rate: ", 0, 30);
        periodYears = (byte) readNumber("Enter Period (Years): ", 0, 30);

        double mortgage = calculateMortgage(principal, yearlyRate, periodYears);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextInt();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter amount between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(int principal, float yearlyRate, byte periodYears) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        int numberOfPayments = periodYears * MONTHS_IN_YEAR;
        float rate = (yearlyRate / PERCENTAGE) / MONTHS_IN_YEAR;

        double mortgage = principal * ((rate * Math.pow((1 + rate), numberOfPayments)) / (Math.pow((1 + rate), numberOfPayments) - 1));
        return mortgage;
    }
}
