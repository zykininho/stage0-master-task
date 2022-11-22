package com.epam.loops;

import com.epam.util.BaseIOTest;
import org.junit.jupiter.api.Test;

class MultiplicationTableTest extends BaseIOTest {

    @Test
    void printTablePrintsMultiplicationTableFor2() {
        String expectedTable = "1 x 2 = 2\n" +
                "2 x 2 = 4\n" +
                "3 x 2 = 6\n" +
                "4 x 2 = 8\n" +
                "5 x 2 = 10\n" +
                "6 x 2 = 12\n" +
                "7 x 2 = 14\n" +
                "8 x 2 = 16\n" +
                "9 x 2 = 18\n" +
                "10 x 2 = 20\n";

        MultiplicationTable multiplicationTable = new MultiplicationTable();

        multiplicationTable.printTable(2);

        assertOutEquals(expectedTable);
    }

    @Test
    void printTablePrintsMultiplicationTableFor0() {
        String expectedTable = "1 x 0 = 0\n" +
                "2 x 0 = 0\n" +
                "3 x 0 = 0\n" +
                "4 x 0 = 0\n" +
                "5 x 0 = 0\n" +
                "6 x 0 = 0\n" +
                "7 x 0 = 0\n" +
                "8 x 0 = 0\n" +
                "9 x 0 = 0\n" +
                "10 x 0 = 0\n";

        MultiplicationTable multiplicationTable = new MultiplicationTable();

        multiplicationTable.printTable(0);

        assertOutEquals(expectedTable);
    }

    @Test
    void printTablePrintsMultiplicationTableFor5() {
        String expectedTable = "1 x 5 = 5\n" +
                "2 x 5 = 10\n" +
                "3 x 5 = 15\n" +
                "4 x 5 = 20\n" +
                "5 x 5 = 25\n" +
                "6 x 5 = 30\n" +
                "7 x 5 = 35\n" +
                "8 x 5 = 40\n" +
                "9 x 5 = 45\n" +
                "10 x 5 = 50\n";

        MultiplicationTable multiplicationTable = new MultiplicationTable();

        multiplicationTable.printTable(5);

        assertOutEquals(expectedTable);
    }
}
