package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int principal = (int)readNumber("Enter Principal ($1k - $1m): ", 1_000, 1_000_000);
        float yearlyRate = (float) readNumber("Annual Interest rate: ", 0, 30);
        byte periodYears = (byte) readNumber("Enter Period (Years): ", 0, 30);

        double mortgage = calculateMortgage(principal, yearlyRate, periodYears);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("MORTGAGE");
        System.out.println("---------");

        System.out.println("Monthly Payment: " + mortgageFormatted);

        //B = L[(1 + c)n - (1 + c)p]/[(1 + c)n - 1]
        calculateLoanBalance(principal, periodYears, yearlyRate);
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

    public static void calculateLoanBalance(int principal, byte periodYears, float yearlyRate){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        int numberOfMonths = periodYears * MONTHS_IN_YEAR;
        float rate = (yearlyRate / PERCENTAGE) / MONTHS_IN_YEAR;

        int count = 0;

        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        while (true){
            count++;
            double balance = (principal*(Math.pow((1+rate), numberOfMonths) - Math.pow((1+rate), count))) / (Math.pow((1+rate), numberOfMonths) - 1);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormatted);
            if (count == numberOfMonths)
                break;
        }

    }
}
