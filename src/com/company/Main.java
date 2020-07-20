package com.company;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Enter Principal ($1k - $1m): ", 1_000, 1_000_000);
        float yearlyRate = (float) Console.readNumber("Annual Interest rate: ", 0, 30);
        byte periodYears = (byte) Console.readNumber("Enter Period (Years): ", 0, 30);

        MortgageCalculator mortgageCalculator = new MortgageCalculator(principal, yearlyRate, periodYears);
        MortgageReport mortgageReport = new MortgageReport(mortgageCalculator);

        mortgageReport.printMortgage();

        mortgageReport.printPaymentSchedule();
    }

}
