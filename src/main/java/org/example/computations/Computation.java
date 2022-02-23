package org.example.computations;

import java.util.Map;

public interface Computation {
    String computeForNumber(int number, Map<Integer, String> outputForDivisor);
}
