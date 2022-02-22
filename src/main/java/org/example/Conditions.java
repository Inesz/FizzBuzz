package org.example;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Conditions {
    private final TreeMap<Integer, String> outputForDivisor = new TreeMap<>();

    public Conditions() {
        defaultValues();
    }

    private void defaultValues() {
        outputForDivisor.put(3, "Fizz");
        outputForDivisor.put(5, "Buzz");
    }

    public Map<Integer, String> getOutputForDivisor() {
        return Collections.unmodifiableMap(outputForDivisor);
    }
}
