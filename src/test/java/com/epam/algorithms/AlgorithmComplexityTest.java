package com.epam.algorithms;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.epam.algorithms.utils.Complexity;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

class AlgorithmComplexityTest {

    private final List<String> encodedComplexities = List.of(
            "9cc80a98d4710d85fad1faf9a39df9fe", //O_N_2
            "48aaa3d74e0baf7767898171107e6749", //O_N
            "689d093372f12bb7002c7ece2f4f9485", //O_LOG_N
            "31b6eb924de49df799c3016cfea5a36b"  //O_1
    );

    private final AlgorithmComplexity algorithmComplexity = new AlgorithmComplexity();

    @Test
    public void badLinerSearch() {
        assertEquals(1, encodedComplexities.indexOf(encodeAnswer(algorithmComplexity.badLinerSearch())));
    }

    @Test
    public void twoCycleSorting() {
       assertEquals(0, encodedComplexities.indexOf(encodeAnswer(algorithmComplexity.twoCycleSorting())));
    }

    @Test
    public void binarySorting() {
        assertEquals(2, encodedComplexities.indexOf(encodeAnswer(algorithmComplexity.binarySorting())));
    }

    @Test
    public void arrayItemAccess() {
        assertEquals(3, encodedComplexities.indexOf(encodeAnswer(algorithmComplexity.arrayIndexItemAccess())));
    }

    private String encodeAnswer(Complexity complexity) {
        return DigestUtils.md5Hex(complexity.name());
    }
}
