package org.example.computations;

import org.example.exceptions.BuzzFizzIllegalArgumentException;
import org.example.exceptions.ExceptionMessages;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class DivisionComputation implements Computation {

    /**
     * Check if a provided Integer (entry in Map) is a divisor of a provided number (dividend). Return String (entry in Map) if true or number if false.
     * If more than one divisor found, Strings are concatenates., eg. "Fizz Buzz" where number is 2 and outputForDivisor contains two entries: {1, Fizz},{2, Buzz}.
     * The separator between two Strings is one space.
     * Example 1
     * <pre> {@code outputForDivisor : {[1, Fizz], [2, Buzz]}, number : 2, output: "Fizz Buzz"}</pre>
     * Example 2
     * <pre> {@code outputForDivisor : {[2, Buzz]}, number : 3, output: "3"}</pre>
     * Example 3
     * <pre> {@code outputForDivisor : {}, number : 3, output: "3"}</pre>
     * Example 4
     * <pre> {@code outputForDivisor : {[2, Fizz], [3, Buzz]}, number : 2, output: "Fizz"}</pre>
     *
     * @param number           dividend
     * @param outputForDivisor collection of entries where Integer is divisor and String is output. Divisor can not be 0.
     * @return combined outputs
     */
    @Override
    public String computeForNumber(int number, @Nullable Map<Integer, String> outputForDivisor) {
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
