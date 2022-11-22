package com.epam.loops;

import com.epam.util.BaseIOTest;
import org.junit.jupiter.api.Test;

class PyramidTest extends BaseIOTest {

    @Test
    void printHalfPyramidPrintNineFloor() {
        String expected = """
                    1
                   212
                  32123
                 4321234
                543212345
               65432123456
              7654321234567
             876543212345678
            98765432123456789
            """;

        Pyramid pyramid = new Pyramid();

        pyramid.printPyramid(9);

        assertOutEquals(expected);
    }

    @Test
    void printHalfPyramidPrintSixFloor() {
        String expected = """
                 1
                212
               32123
              4321234
             543212345
            65432123456
            """;

        Pyramid pyramid = new Pyramid();

        pyramid.printPyramid(6);

        assertOutEquals(expected);
    }

    @Test
    void printHalfPyramidPrintZeroFloor() {
        String expected = "" ;

        Pyramid pyramid = new Pyramid();

        pyramid.printPyramid(0);

        assertOutEquals(expected);
    }
}
