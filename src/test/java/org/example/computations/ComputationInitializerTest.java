package org.example.computations;

import org.example.conditions.CustomDivisorsOutputs;
import org.example.conditions.FizzBuzzDivisorsOutputs;
import org.example.exceptions.BuzzFizzIllegalArgumentException;
import org.example.exceptions.ExceptionMessages;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ComputationInitializerTest {

    private final static Map<Integer, String> DEFAULT_CONDITIONS = new FizzBuzzDivisorsOutputs().getDivisorsOutputs();

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

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setOutputStreamToArray() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void setOutputStreamToSystemOut() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("check entire output for FizzBuzzDivisorsOutputs and HundredNumbers")
    void shouldCompute100NumbersForBuzzFizzConditions() {
        new HundredNumbers(new DivisorComputation(), DEFAULT_CONDITIONS).computationStart();

        assertEquals(OUTPUT_FOR_100_NUMBERS, outputStream.toString());
    }

    @Test
    @DisplayName("check entire output for CustomDivisorsOutputs and HundredNumbers")
    void shouldCompute100NumbersForCustomConditions() {
        CustomDivisorsOutputs customDivisorsOutputs = new CustomDivisorsOutputs();
        DEFAULT_CONDITIONS.forEach(customDivisorsOutputs::addDivisorOutput);

        new HundredNumbers(new DivisorComputation(), customDivisorsOutputs.getDivisorsOutputs()).computationStart();

        assertEquals(OUTPUT_FOR_100_NUMBERS, outputStream.toString());
    }

    @Test
    @DisplayName("check entire output for CustomDivisorsOutputs and CustomNumbers")
    void shouldComputeWithCustomNumbers() {
        CustomDivisorsOutputs customDivisorsOutputs = new CustomDivisorsOutputs();

        DEFAULT_CONDITIONS.forEach(customDivisorsOutputs::addDivisorOutput);

        CustomNumbers.getBuilder()
                .setOutputForDivisor(customDivisorsOutputs.getDivisorsOutputs())
                .setComputation(new DivisorComputation())
                .setMinValue(1)
                .setMaxValue(100)
                .setStep(1)
                .build()
                .computationStart();

        assertEquals(OUTPUT_FOR_100_NUMBERS, outputStream.toString());
    }

    @Test
    @DisplayName("check error when adding 0 as divisor to CustomDivisorsOutputs")
    void shouldCustomDivisorsOutputsThrowError() {
        CustomDivisorsOutputs customDivisorsOutput = new CustomDivisorsOutputs();
        Exception exception = assertThrows(BuzzFizzIllegalArgumentException.class,
                () -> customDivisorsOutput.addDivisorOutput(0, "")
        );

        assertEquals(ExceptionMessages.ZERO_AS_DIVISOR, exception.getMessage());
    }

}