package com.company;

public class MortgageCalculator {
    public static double calculateMortgage(int principal, float yearlyRate, byte periodYears) {
        int numberOfPayments = periodYears * Main.MONTHS_IN_YEAR;
        float rate = (yearlyRate / Main.PERCENTAGE) / Main.MONTHS_IN_YEAR;

        double mortgage = principal * ((rate * Math.pow((1 + rate), numberOfPayments)) / (Math.pow((1 + rate), numberOfPayments) - 1));
        return mortgage;
    }

    public static double getBalance(int principal, byte periodYears, float yearlyRate, short numberOfPaymentsMade) {
        //B = L[(1 + c)n - (1 + c)p]/[(1 + c)n - 1]
        int numberOfMonths = periodYears * Main.MONTHS_IN_YEAR;
        float rate = (yearlyRate / Main.PERCENTAGE) / Main.MONTHS_IN_YEAR;

        double balance = (principal * (Math.pow((1 + rate), numberOfMonths) - Math.pow((1 + rate), numberOfPaymentsMade))) / (Math.pow((1 + rate), numberOfMonths) - 1);
        return balance;
    }
}
