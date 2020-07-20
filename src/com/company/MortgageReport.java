package com.company;

import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator mortgageCalculator;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
    }

    public void printMortgage() {
        double mortgage = mortgageCalculator.calculateMortgage();

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly Payment: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (short month = 1; month <= mortgageCalculator.getYears() * MortgageCalculator.MONTHS_IN_YEAR; month++) {
            double balance = mortgageCalculator.getBalance(month);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormatted);
        }
    }
}
