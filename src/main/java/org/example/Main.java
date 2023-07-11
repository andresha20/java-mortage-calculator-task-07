package org.example;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    private static final int MONTHS_IN_A_YEAR = 12;
    public static void main(String[] args) {
        try(Scanner parser = new Scanner(System.in)) {
            double loan = 10;
            float annualInterestRate = 0.04f;
            int years = 2;
            String outputChatbox;
            try {
                outputChatbox = "What's the loan amount?";
                System.out.println(outputChatbox);
                loan = parser.nextDouble();
                outputChatbox = "What's the annual interest rate?";
                System.out.println(outputChatbox);
                annualInterestRate = parser.nextFloat();
                outputChatbox = "Term in years?";
                System.out.println(outputChatbox);
                years = parser.nextInt();
            } catch(Exception e) {
                outputChatbox = "Something went wrong. Insert a valid value.";
                System.out.println(outputChatbox);
                System.exit(-1);
            }
            if (loan == 0 || annualInterestRate == 0 || years == 0) {
                outputChatbox = "You cannot insert empty or 0 values.";
                System.out.println(outputChatbox);
                System.exit(-1);
            }
            parser.close();
            float monthlyInterestRate = annualInterestRate / MONTHS_IN_A_YEAR;
            int numberOfMonthlyPayments = years * MONTHS_IN_A_YEAR;
            double discountRate = Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments);
            double mortgage = loan * ((monthlyInterestRate * discountRate) / (discountRate - 1));
            outputChatbox = "Your mortgage value is: " + String.valueOf(NumberFormat.getCurrencyInstance().format(mortgage));
            System.out.println(outputChatbox);
            outputChatbox = "Payback: " + String.valueOf(NumberFormat.getCurrencyInstance().format(numberOfMonthlyPayments * mortgage));
            System.out.println(outputChatbox);
            outputChatbox = "Success! Closing...";
            System.out.println(outputChatbox);
            System.exit(1);
        }
    }
}