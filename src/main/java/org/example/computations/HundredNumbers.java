package org.example.computations;

import java.util.Map;

/**
 * Run computation for numbers from 1 to 100.
 */
public class HundredNumbers implements ComputationInitializer {
    private final Computation computation;
    private final Map<Integer, String> outputForDivisor;

    public HundredNumbers(Computation computation, Map<Integer, String> outputForDivisor) {
        this.computation = computation;
        this.outputForDivisor = outputForDivisor;
    }

    @Override
    @SuppressWarnings("java:S106")
    /**
     * {@inheritdoc}
     */
    public void computationStart() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(computation.computeForNumber(i, outputForDivisor));
        }
    }
}
