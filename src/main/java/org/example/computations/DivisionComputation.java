package org.example.computations;

import org.example.exceptions.BuzzFizzIllegalArgumentException;
import org.example.exceptions.ExceptionMessages;

import java.util.Map;

public class DivisionComputation implements Computation {

    @Override
    public String computeForNumber(int number, Map<Integer, String> outputForDivisor) {
        if (outputForDivisor == null || outputForDivisor.isEmpty()) {
            return Integer.toString(number);
        }

        if (outputForDivisor.containsKey(0)) {
            throw new BuzzFizzIllegalArgumentException(ExceptionMessages.ZERO_AS_DIVISOR);
        }

        StringBuilder out = new StringBuilder();
        for (Map.Entry<Integer, String> condition : outputForDivisor.entrySet()) {
            if (isDivisible(number, condition.getKey())) {

                if (out.length() > 0) {
                    out.append(" ");
                }
                out.append(condition.getValue());
            }
        }

        return (out.length() > 0) ? out.toString() : Integer.toString(number);
    }

    private boolean isDivisible(int dividend, Integer divisor) {
        return dividend % divisor == 0;
    }

}
