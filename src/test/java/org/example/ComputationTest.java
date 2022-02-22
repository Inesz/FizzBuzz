package org.example;

import org.example.conditions.CustomDivisorsOutputs;
import org.example.conditions.FizzBuzzDivisorsOutputs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ComputationTest {
    private final Map<Integer, String> DEFAULT_CONDITIONS = new FizzBuzzDivisorsOutputs().getDivisorsOutputs();

    private final static String OUTPUT_FOR_100_NUMBERS = "1\r\n" +
            "2\r\n" +
            "Fizz\r\n" +
            "4\r\n" +
            "Buzz\r\n" +
            "Fizz\r\n" +
            "7\r\n" +
            "8\r\n" +
            "Fizz\r\n" +
            "Buzz\r\n" +
            "11\r\n" +
            "Fizz\r\n" +
            "13\r\n" +
            "14\r\n" +
            "Fizz Buzz\r\n" +
            "16\r\n" +
            "17\r\n" +
            "Fizz\r\n" +
            "19\r\n" +
            "Buzz\r\n" +
            "Fizz\r\n" +
            "22\r\n" +
            "23\r\n" +
            "Fizz\r\n" +
            "Buzz\r\n" +
            "26\r\n" +
            "Fizz\r\n" +
            "28\r\n" +
            "29\r\n" +
            "Fizz Buzz\r\n" +
            "31\r\n" +
            "32\r\n" +
            "Fizz\r\n" +
            "34\r\n" +
            "Buzz\r\n" +
            "Fizz\r\n" +
            "37\r\n" +
            "38\r\n" +
            "Fizz\r\n" +
            "Buzz\r\n" +
            "41\r\n" +
            "Fizz\r\n" +
            "43\r\n" +
            "44\r\n" +
            "Fizz Buzz\r\n" +
            "46\r\n" +
            "47\r\n" +
            "Fizz\r\n" +
            "49\r\n" +
            "Buzz\r\n" +
            "Fizz\r\n" +
            "52\r\n" +
            "53\r\n" +
            "Fizz\r\n" +
            "Buzz\r\n" +
            "56\r\n" +
            "Fizz\r\n" +
            "58\r\n" +
            "59\r\n" +
            "Fizz Buzz\r\n" +
            "61\r\n" +
            "62\r\n" +
            "Fizz\r\n" +
            "64\r\n" +
            "Buzz\r\n" +
            "Fizz\r\n" +
            "67\r\n" +
            "68\r\n" +
            "Fizz\r\n" +
            "Buzz\r\n" +
            "71\r\n" +
            "Fizz\r\n" +
            "73\r\n" +
            "74\r\n" +
            "Fizz Buzz\r\n" +
            "76\r\n" +
            "77\r\n" +
            "Fizz\r\n" +
            "79\r\n" +
            "Buzz\r\n" +
            "Fizz\r\n" +
            "82\r\n" +
            "83\r\n" +
            "Fizz\r\n" +
            "Buzz\r\n" +
            "86\r\n" +
            "Fizz\r\n" +
            "88\r\n" +
            "89\r\n" +
            "Fizz Buzz\r\n" +
            "91\r\n" +
            "92\r\n" +
            "Fizz\r\n" +
            "94\r\n" +
            "Buzz\r\n" +
            "Fizz\r\n" +
            "97\r\n" +
            "98\r\n" +
            "Fizz\r\n" +
            "Buzz\r\n";

    @Test
    @DisplayName("check computeFor100Numbers (entire output) for FizzBuzzDivisorsOutputs")
    void shouldCompute100NumbersForBuzzFizzConditions() {
        try {
            final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            Computation.computeFor100Numbers(DEFAULT_CONDITIONS);
            assertEquals(OUTPUT_FOR_100_NUMBERS, outputStream.toString());
        } finally {
            System.setOut(System.out);
        }
    }

    @Test
    @DisplayName("check computeFor100Numbers (entire output) for CustomDivisorsOutputs")
    void shouldCompute100NumbersForCustomConditions() {
        try {
            final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            CustomDivisorsOutputs customDivisorsOutputs = new CustomDivisorsOutputs();
            DEFAULT_CONDITIONS.entrySet()
                    .forEach(entry -> customDivisorsOutputs.addDivisorOutput(
                            entry.getKey(), entry.getValue()));

            Computation.computeFor100Numbers(customDivisorsOutputs.getDivisorsOutputs());

            assertEquals(OUTPUT_FOR_100_NUMBERS, outputStream.toString());
        } finally {
            System.setOut(System.out);
        }
    }

    @DisplayName("check output for input data")
    @ParameterizedTest(name = "[{index}] {0} (number), {1} (output)")
    @CsvSource({"1,1", "10,Buzz", "15, Fizz Buzz", "-10,Buzz", "0,Fizz Buzz", "-8, -8"})
    void shouldComputeForNumber(int number, String expectation) {
        assertEquals(expectation, Computation.computeForNumber(number, DEFAULT_CONDITIONS));
    }

    @DisplayName("check output when number has max or min int value")
    @ParameterizedTest(name = "[{index}] number: {0} (int limit)")
    @ValueSource(ints = {Integer.MIN_VALUE, Integer.MAX_VALUE})
    void shouldComputeForIntLimitAsNumber(int number) {
        assertEquals(Integer.toString(number), Computation.computeForNumber(number, DEFAULT_CONDITIONS));
    }

    @DisplayName("check output for null or empty conditions")
    @ParameterizedTest(name = "[{index}] conditions: {0}")
    @NullAndEmptySource
    void shouldComputeForNullOrEmptyConditions(Map<Integer, String> outputForDivisor) {
        assertEquals("1", Computation.computeForNumber(1, outputForDivisor));
    }
}