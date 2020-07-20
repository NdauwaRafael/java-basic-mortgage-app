package com.company;

import java.text.NumberFormat;

public class MortgageReport {
    public static void printMortgage(int principal, float yearlyRate, byte periodYears) {
        double mortgage = Main.calculateMortgage(principal, yearlyRate, periodYears);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly Payment: " + mortgageFormatted);
    }

    public static void printPaymentSchedule(int principal, float yearlyRate, byte periodYears) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= periodYears * Main.MONTHS_IN_YEAR; month++) {
            double balance = Main.getBalance(principal, periodYears, yearlyRate, month);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormatted);
        }
    }
}
