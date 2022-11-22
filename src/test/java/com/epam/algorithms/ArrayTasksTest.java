package com.epam.algorithms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ArrayTasksTest {

    private static final Random RANDOM = new Random();

    private final ArrayTasks arrayTasks = new ArrayTasks();

    private static List<String> notAllowedStrings;

    @BeforeAll
    public static void findImports() throws IOException {
        notAllowedStrings = Files.readAllLines(
                        Path.of("src/main/java/com/epam/algorithms/ArrayTasks.java")
                ).stream()
                .filter(line -> line.contains("import"))
                .collect(Collectors.toList());
    }

    @BeforeEach
    public void shouldNotUserUtils(){
        assertTrue(notAllowedStrings.isEmpty(), "You use some not allowed utils, such as java.util.Arrays");
    }

    @Test
    public void seasonsArrayTest() {
        assertArrayEquals(Stream.of("winter", "spring", "summer", "autumn").toArray(),
                Arrays.stream(arrayTasks.seasonsArray()).map(String::toLowerCase).toArray(),
                "I think, you have mistake in order or name of season");
    }

    @ParameterizedTest
    @MethodSource("generatedNumbersTestProvider")
    public void generateNumbersTests(int length, int[] expectedArr) {
        assertArrayEquals(expectedArr, arrayTasks.generateNumbers(length),
                "I think, something went wrong with number generation implementation");
    }

    @ParameterizedTest
    @MethodSource("reverseArrayTestProvider")
    public void reverseArrayTest(String[] arr, String[] expectedRevertedArray) {
        assertArrayEquals(expectedRevertedArray, arrayTasks.reverseArray(arr),
                "I think, something went wrong with reverse implementation");
    }

    @ParameterizedTest
    @MethodSource("totalSumTestProvider")
    public void totalSumTest(int[] arr, int expectedSum) {
        assertEquals(expectedSum, arrayTasks.totalSum(arr),
                "I think, something went wrong with total sum implementation");
    }

    @ParameterizedTest
    @MethodSource("findIndexOfNumberTestProvider")
    public void findIndexOfNumberTest(int[] arr, int number, int expectedIndex) {
        assertEquals(expectedIndex, arrayTasks.findIndexOfNumber(arr, number),
                "I think, something went wrong with finding index implementation");
    }

    @ParameterizedTest
    @MethodSource("getOnlyPositiveNumbersTestProvider")
    public void getOnlyPositiveNumbersTest(int[] arr, int[] expectedArr) {
        assertArrayEquals(expectedArr, arrayTasks.getOnlyPositiveNumbers(arr));
    }

    @ParameterizedTest
    @MethodSource("sortRaggedArrayProvider")
    public void sortRaggedArrayTest(RaggedArray arr, RaggedArray expectedArr) {

        assertArrayEquals(expectedArr.getArr(), arrayTasks.sortRaggedArray(arr.getArr()),
                "I think, something went wrong with sorting ragged array implementation");
    }


    private static Stream<Arguments> totalSumTestProvider() {
        return getIntArraysStream(4, 100, 1000)
                .map(arr -> Arguments.of(arr, Arrays.stream(arr).sum()));
    }

    private static Stream<Arguments> sortRaggedArrayProvider() {

        return RANDOM.ints(20, 1, 5)
                .mapToObj(i -> getIntArraysStream(5, 1, 5)
                        .collect(Collectors.toList()))
                .map(arrList -> {
                    int[][] arr = new int[arrList.size()][];
                    for (int i = 0; i < arrList.size(); i++) {
                        arr[i] = arrList.get(i);
                    }
                    return arr;
                })
                .map(RaggedArray::new)
                .map(raggedArray ->
                        Arguments.of(raggedArray, RaggedArray.of(Arrays.stream(raggedArray.getArr())
                                .sorted(Comparator.comparingInt(array -> array.length))
                                .peek(Arrays::sort)
                                .toArray(int[][]::new))
                        ));
    }


    private static Stream<Arguments> reverseArrayTestProvider() {

        return RANDOM.ints(5, 4, 10)
                .mapToObj(i -> IntStream.rangeClosed(1, i)
                        .mapToObj(num -> UUID.randomUUID().toString())
                        .toArray(String[]::new))
                .map(arr ->
                        Arguments.of(arr, IntStream.rangeClosed(1, arr.length)
                                .mapToObj(i -> arr[arr.length - i])
                                .toArray(String[]::new)));
    }

    private static Stream<Arguments> generatedNumbersTestProvider() {
        return RANDOM.ints(4, 3, 10000)
                .mapToObj(length -> IntStream.range(1, length + 1)
                        .toArray())
                .map(arr -> Arguments.of(arr.length, arr));
    }

    private static Stream<Arguments> findIndexOfNumberTestProvider() {
        return getIntArraysStream(5, 1000, 5000)
                .map(arr -> {
                    int number = RANDOM.nextBoolean() ? arr[RANDOM.nextInt(arr.length)]
                            : RANDOM.nextInt(2000);
                    return Arguments.of(arr,
                            number,
                            IntStream.range(0, arr.length)
                                    .filter(i -> arr[i] == number)
                                    .findFirst().orElse(-1)
                    );
                });
    }

    private static Stream<Arguments> getOnlyPositiveNumbersTestProvider() {
        return getIntArraysStream(6, 1000, 5000)
                .map(arr -> Arguments.of(arr, Arrays.stream(arr).filter(i -> i > 0).toArray()));
    }

    private static Stream<int[]> getIntArraysStream(int arrAmount, int leftBoundLength, int rightBoundLength) {
        return RANDOM.ints(arrAmount, leftBoundLength, rightBoundLength)
                .mapToObj(length -> IntStream.generate(() -> RANDOM.nextInt(2000) - 1000)
                        .limit(length)
                        .toArray());
    }

    private static class RaggedArray {
        public int[][] arr;

        public static RaggedArray of(int[][] arr) {
            return new RaggedArray(arr);
        }

        public RaggedArray(int[][] arr) {
            this.arr = arr;
        }

        public int[][] getArr() {
            return arr;
        }
    }

}
