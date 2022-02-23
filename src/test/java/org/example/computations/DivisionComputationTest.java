package org.example.computations;

import org.example.conditions.FizzBuzzDivisorsOutputs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DivisionComputationTest {
    private final static Map<Integer, String> BUZZFIZZ_CONDITIONS = new FizzBuzzDivisorsOutputs().getDivisorsOutputs();

    @DisplayName("check output for input data")
    @ParameterizedTest(name = "[{index}] {0} (number), {1} (output)")
    @CsvSource({"1,1", "10,Buzz", "15, Fizz Buzz", "-10,Buzz", "0,Fizz Buzz", "-8, -8"})
    void shouldComputeForNumber(int number, String expectation) {
        assertEquals(expectation, new DivisionComputation().computeForNumber(number, BUZZFIZZ_CONDITIONS));
    }

    @DisplayName("check output when number has max or min int value")
    @ParameterizedTest(name = "[{index}] number: {0} (int limit)")
    @ValueSource(ints = {Integer.MIN_VALUE, Integer.MAX_VALUE})
    void shouldComputeForIntLimitAsNumber(int number) {
        assertEquals(Integer.toString(number), new DivisionComputation().computeForNumber(number, BUZZFIZZ_CONDITIONS));
    }

    @DisplayName("check output for null or empty conditions")
    @ParameterizedTest(name = "[{index}] conditions: {0}")
    @NullAndEmptySource
    void shouldComputeForNullOrEmptyConditions(Map<Integer, String> outputForDivisor) {
        assertEquals("1", new DivisionComputation().computeForNumber(1, outputForDivisor));
    }
}