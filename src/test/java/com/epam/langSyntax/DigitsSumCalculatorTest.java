package com.epam.langSyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.epam.util.BaseIOTest;
import org.junit.jupiter.api.Test;

class DigitsSumCalculatorTest extends BaseIOTest {

    @Test
    void calculateSumCalculatesSumFor1111() {
        DigitsSumCalculator calculator = new DigitsSumCalculator();

        calculator.calculateSum(1111);

        assertEquals("4\n", updateLineSpliterators(outContent.toString()));
    }

    @Test
    void calculateSumCalculatesSumFor4567() {
        DigitsSumCalculator calculator = new DigitsSumCalculator();

        calculator.calculateSum(4567);

        assertEquals("22\n", updateLineSpliterators(outContent.toString()));
    }


    @Test
    void containsNoLibsOrStringMethods() throws IOException {
        Path path = Paths.get("src/main/java/com/epam/langSyntax/DigitsSumCalculator.java");
        List<String> strings = Files.readAllLines(path);
        List<String> declarationResult = strings.stream()
                .filter(line ->
                        line.contains("import") || line.contains(".sum") || line.contains("if"))
                .collect(Collectors.toList());

        assertEquals(0, declarationResult.size());
    }
}
