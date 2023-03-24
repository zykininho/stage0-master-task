package com.epam.langSyntax;

public class DigitsSumCalculator {

    public void calculateSum(int number) {
        int sum = 0;
        while (number != 0) {
            int remainder = number % 10;
            sum += remainder;
            number = number / 10;
        }
        System.out.println(sum);
    }
}