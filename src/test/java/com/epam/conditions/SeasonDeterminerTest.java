package com.epam.conditions;

import com.epam.util.BaseIOTest;
import org.junit.jupiter.api.Test;

class SeasonDeterminerTest extends BaseIOTest {

    @Test
    void tellTheSeasonPrintsWinterWhenFebruary() {
        SeasonDeterminer determiner = new SeasonDeterminer();

        determiner.tellTheSeason(2);

        assertOutEquals("Winter\n");
    }

    @Test
    void tellTheSeasonPrintsWinterWhenDecember() {
        SeasonDeterminer determiner = new SeasonDeterminer();

        determiner.tellTheSeason(12);

        assertOutEquals("Winter\n");
    }

    @Test
    void tellTheSeasonPrintsSummerWhenJune() {
        SeasonDeterminer determiner = new SeasonDeterminer();

        determiner.tellTheSeason(6);

        assertOutEquals("Summer\n");
    }

    @Test
    void tellTheSeasonPrintsWrongSeasonWhenZero() {
        SeasonDeterminer determiner = new SeasonDeterminer();

        determiner.tellTheSeason(0);

        assertOutEquals("Wrong month number\n");
    }

}
