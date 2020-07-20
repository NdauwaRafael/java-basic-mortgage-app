package com.company;

public class MortgageCalculator {

    private int principal;
    private float yearlyRate;
    private byte periodYears;

    public MortgageCalculator(int principal, float yearlyRate, byte periodYears) {
        this.principal = principal;
        this.yearlyRate = yearlyRate;
        this.periodYears = periodYears;
    }

    public double calculateMortgage() {
        int numberOfPayments = periodYears * Main.MONTHS_IN_YEAR;
        float rate = (yearlyRate / Main.PERCENTAGE) / Main.MONTHS_IN_YEAR;

        double mortgage = principal * ((rate * Math.pow((1 + rate), numberOfPayments)) / (Math.pow((1 + rate), numberOfPayments) - 1));
        return mortgage;
    }

    public double getBalance(short numberOfPaymentsMade) {
        //B = L[(1 + c)n - (1 + c)p]/[(1 + c)n - 1]
        int numberOfMonths = periodYears * Main.MONTHS_IN_YEAR;
        float rate = (yearlyRate / Main.PERCENTAGE) / Main.MONTHS_IN_YEAR;

        double balance = (principal * (Math.pow((1 + rate), numberOfMonths) - Math.pow((1 + rate), numberOfPaymentsMade))) / (Math.pow((1 + rate), numberOfMonths) - 1);
        return balance;
    }

    public byte getYears() {
        return periodYears;
    }
}
