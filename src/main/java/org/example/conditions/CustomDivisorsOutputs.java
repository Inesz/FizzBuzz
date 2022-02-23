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

    /**
     * Add Entry to outputsForDivisors Map.
     *
     * @param divisor can not be 0
     * @param output  value to output for divisor
     * @throws BuzzFizzIllegalArgumentException 0 as divisor
     */
    public void addDivisorOutput(int divisor, String output) throws BuzzFizzIllegalArgumentException {
        if (divisor == 0) {
            throw new BuzzFizzIllegalArgumentException(ExceptionMessages.ZERO_AS_DIVISOR);
        }

        outputsForDivisors.put(divisor, output);
    }

    public void rmDivisorOutput(int divisor) {
        outputsForDivisors.remove(divisor);
    }

}
