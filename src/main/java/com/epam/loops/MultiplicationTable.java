package com.epam.loops;

public class MultiplicationTable {

    public void printTable(int numberTableToPrint) {
        String record = "%d x %d = %d\n";
        for (int i = 1; i <= 10; i++) {
            System.out.printf(record, i, numberTableToPrint, i * numberTableToPrint);
        }
    }
}
