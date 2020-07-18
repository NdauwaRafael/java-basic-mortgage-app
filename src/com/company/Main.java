package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENTAGE = 100;

    public static void main(String[] args) {

        int principal = (int) readNumber("Enter Principal ($1k - $1m): ", 1_000, 1_000_000);
        float yearlyRate = (float) readNumber("Annual Interest rate: ", 0, 30);
        byte periodYears = (byte) readNumber("Enter Period (Years): ", 0, 30);

        double mortgage = calculateMortgage(principal, yearlyRate, periodYears);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly Payment: " + mortgageFormatted);

        //B = L[(1 + c)n - (1 + c)p]/[(1 + c)n - 1]
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= periodYears * MONTHS_IN_YEAR; month++) {
            double balance = getBalance(principal, periodYears, yearlyRate, month);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance)
            System.out.println(balanceFormatted);
        }
    }

    public static double readNumber(String prompt, double min, double max) {
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

        int numberOfPayments = periodYears * MONTHS_IN_YEAR;
        float rate = (yearlyRate / PERCENTAGE) / MONTHS_IN_YEAR;

        double mortgage = principal * ((rate * Math.pow((1 + rate), numberOfPayments)) / (Math.pow((1 + rate), numberOfPayments) - 1));
        return mortgage;
    }

    public static double getBalance(int principal, byte periodYears, float yearlyRate, short numberOfPaymentsMade) {
        int numberOfMonths = periodYears * MONTHS_IN_YEAR;
        float rate = (yearlyRate / PERCENTAGE) / MONTHS_IN_YEAR;

        double balance = (principal * (Math.pow((1 + rate), numberOfMonths) - Math.pow((1 + rate), numberOfPaymentsMade))) / (Math.pow((1 + rate), numberOfMonths) - 1);

        return balance;

    }
}
