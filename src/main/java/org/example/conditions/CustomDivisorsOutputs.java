package org.example.conditions;

import org.example.exceptions.BuzzFizzIllegalArgumentException;
import org.example.exceptions.ExceptionMessages;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CustomDivisorsOutputs implements DivisorsOutputs {
    private final TreeMap<Integer, String> outputsForDivisors = new TreeMap<>();

    @Override
    public Map<Integer, String> getDivisorsOutputs() {
        return Collections.unmodifiableMap(outputsForDivisors);
    }

    public void addDivisorOutput(int divisor, String output) {
        if (divisor == 0) {
            throw new BuzzFizzIllegalArgumentException(ExceptionMessages.ZERO_AS_DIVISOR);
        }

        outputsForDivisors.put(divisor, output);
    }

    public void rmDivisorOutput(int divisor) {
        outputsForDivisors.remove(divisor);
    }

}
