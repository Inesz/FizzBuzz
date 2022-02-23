package org.example.computations;

import java.util.Map;

/**
 * Computation interface
 */
interface Computation {
    /**
     * Make a computation for given input.
     *
     * @param number           number for computation
     * @param outputForDivisor parameters for computation
     * @return computation result
     */
    String computeForNumber(int number, Map<Integer, String> outputForDivisor);
}
