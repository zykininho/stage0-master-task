package com.epam.conditions;

import com.epam.util.BaseIOTest;
import org.junit.jupiter.api.Test;

class TriangleSidesValidatorTest extends BaseIOTest {

    @Test
    void validate3PointsBuildUpValidTriangle() {
        TriangleSidesValidator triangleSidesValidator = new TriangleSidesValidator();

        triangleSidesValidator.validate(1, 4, 4);

        assertOutEquals("this is a valid triangle\n");
    }

    @Test
    void validate3PointsBuildUpInvalidTriangleZeroLength() {
        TriangleSidesValidator triangleSidesValidator = new TriangleSidesValidator();

        triangleSidesValidator.validate(1, 0, 4);

        assertOutEquals("it's not a triangle\n");
    }

    @Test
    void validate3PointsBuildUpInvalidTriangleNegativeLength() {
        TriangleSidesValidator triangleSidesValidator = new TriangleSidesValidator();

        triangleSidesValidator.validate(1, -1, 4);

        assertOutEquals("it's not a triangle\n");
    }

    @Test
    void validate3PointsBuildUpInvalidTriangleTooLongSide() {
        TriangleSidesValidator triangleSidesValidator = new TriangleSidesValidator();

        triangleSidesValidator.validate(1, 7, 4);

        assertOutEquals("it's not a triangle\n");
    }
}
