package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest rate: ");
        float yearlyRate = scanner.nextFloat();
        float rate = (yearlyRate/PERCENTAGE)/MONTHS_IN_YEAR;

        System.out.print("Enter Period (Years): ");
        byte periodYears = scanner.nextByte();
        int numberOfPayments = periodYears * MONTHS_IN_YEAR;

        double mortgage = principal * ((rate *  Math.pow((1 + rate), numberOfPayments)) / (Math.pow((1+rate), numberOfPayments) - 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);


    }
}
