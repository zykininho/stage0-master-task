package com.epam.conditions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.util.BaseIOTest;
import org.junit.jupiter.api.Test;

class BitwiseValuesSwapTest extends BaseIOTest {

    private static final String FIRST_SECOND_VARS_ORDER = "^.+(System\\.out\\.println\\((first)\\W+).+((System\\.out\\.println\\((second)\\))).+$";

    @Test
    void swapTestSwapsValues() {
        BitwiseValuesSwap valuesSwap = new BitwiseValuesSwap();

        valuesSwap.swap(6,7);

        assertOutEquals("7\n6\n");
    }

    @Test
    void notContainsIfOrRawPrint() throws IOException {
        Path path = Paths.get("src/main/java/com/epam/conditions/BitwiseValuesSwap.java");
        List<String> strings = Files.readAllLines(path);
        String joined = String.join(" ", strings);
        List<String> ifLines = strings.stream()
                .filter(line -> line.contains("if"))
                .collect(Collectors.toList());

        List<String> xorLines = strings.stream()
                .filter(line -> line.contains("^"))
                .collect(Collectors.toList());

        boolean matches = joined.matches(FIRST_SECOND_VARS_ORDER);

        assertEquals(0, ifLines.size());
        assertEquals(3, xorLines.size());
        assertTrue(matches);
    }
}
