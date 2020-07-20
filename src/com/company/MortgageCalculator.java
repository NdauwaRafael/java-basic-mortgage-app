package com.company;

public class MortgageCalculator {

    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENTAGE = 100;

    private int principal;
    private float yearlyRate;
    private byte periodYears;

    public MortgageCalculator(int principal, float yearlyRate, byte periodYears) {
        this.principal = principal;
        this.yearlyRate = yearlyRate;
        this.periodYears = periodYears;
    }

    public double calculateMortgage() {
        int numberOfPayments = getNumberOfPayments();
        float rate = getMonthlyInterest();

        double mortgage = principal * ((rate * Math.pow((1 + rate), numberOfPayments)) / (Math.pow((1 + rate), numberOfPayments) - 1));
        return mortgage;
    }

    public double getBalance(short numberOfPaymentsMade) {
        //B = L[(1 + c)n - (1 + c)p]/[(1 + c)n - 1]
        int numberOfMonths = getNumberOfPayments();
        float rate = getMonthlyInterest();

        double balance = (principal * (Math.pow((1 + rate), numberOfMonths) - Math.pow((1 + rate), numberOfPaymentsMade))) / (Math.pow((1 + rate), numberOfMonths) - 1);
        return balance;
    }

    public double[] getRemainingBalances() {
        double[] balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = getBalance(month);
        return balances;
    }

    private int getNumberOfPayments() {
        return periodYears * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return (yearlyRate / PERCENTAGE) / MONTHS_IN_YEAR;
    }
}
