package org.example.conditions;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class FizzBuzzDivisorsOutputs implements DivisorsOutputs {
    private static final TreeMap<Integer, String> OUTPUT_FOR_DIVISOR = new TreeMap<>();

    static {
        OUTPUT_FOR_DIVISOR.put(3, "Fizz");
        OUTPUT_FOR_DIVISOR.put(5, "Buzz");
    }

    @Override
    public Map<Integer, String> getDivisorsOutputs() {
        return Collections.unmodifiableMap(OUTPUT_FOR_DIVISOR);
    }
}
