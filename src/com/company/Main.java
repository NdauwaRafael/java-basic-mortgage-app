package com.company;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENTAGE = 100;

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Enter Principal ($1k - $1m): ", 1_000, 1_000_000);
        float yearlyRate = (float) Console.readNumber("Annual Interest rate: ", 0, 30);
        byte periodYears = (byte) Console.readNumber("Enter Period (Years): ", 0, 30);

        MortgageReport.printMortgage(principal, yearlyRate, periodYears);

        MortgageReport.printPaymentSchedule(principal, yearlyRate, periodYears);
    }

    public static double calculateMortgage(int principal, float yearlyRate, byte periodYears) {
        int numberOfPayments = periodYears * MONTHS_IN_YEAR;
        float rate = (yearlyRate / PERCENTAGE) / MONTHS_IN_YEAR;

        double mortgage = principal * ((rate * Math.pow((1 + rate), numberOfPayments)) / (Math.pow((1 + rate), numberOfPayments) - 1));
        return mortgage;
    }

    public static double getBalance(int principal, byte periodYears, float yearlyRate, short numberOfPaymentsMade) {
        //B = L[(1 + c)n - (1 + c)p]/[(1 + c)n - 1]
        int numberOfMonths = periodYears * MONTHS_IN_YEAR;
        float rate = (yearlyRate / PERCENTAGE) / MONTHS_IN_YEAR;

        double balance = (principal * (Math.pow((1 + rate), numberOfMonths) - Math.pow((1 + rate), numberOfPaymentsMade))) / (Math.pow((1 + rate), numberOfMonths) - 1);
        return balance;
    }
}
