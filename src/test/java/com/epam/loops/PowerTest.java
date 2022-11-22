package com.epam.loops;

import com.epam.util.BaseIOTest;
import org.junit.jupiter.api.Test;

class PowerTest extends BaseIOTest {

    @Test
    void printPowerPrints10Times4() {
        Power power = new Power();

        power.printPower(10, 4);

        assertOutEquals("10000\n");
    }

    @Test
    void printPowerPrints0Times4() {
        Power power = new Power();

        power.printPower(0, 4);

        assertOutEquals("0\n");
    }

    @Test
    void printPowerPrintsNegative10Times4() {
        Power power = new Power();

        power.printPower(-10, 4);

        assertOutEquals("10000\n");
    }

    @Test
    void printPowerPrintsNegative10Times3() {
        Power power = new Power();

        power.printPower(-10, 3);

        assertOutEquals("-1000\n");
    }
}
