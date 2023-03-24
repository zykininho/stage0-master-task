package com.epam.loops;

public class Power {

    public void printPower(int numberToPrint, int power) {
        if (power == 0) {
            System.out.println(1);
        }
        final int origin = numberToPrint;
        for (int i = 2; i <= power; i++) {
            numberToPrint = numberToPrint * origin;
        }
        System.out.println(numberToPrint);
    }

    public static void main(String[] args) {
        new Power().printPower(10, 3);
    }
}
