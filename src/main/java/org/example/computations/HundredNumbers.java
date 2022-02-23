package org.example.computations;

import java.util.Map;

public class HundredNumbers implements ComputationInitializer {
    private final Computation computation;
    private final Map<Integer, String> outputForDivisor;

    public HundredNumbers(Computation computation, Map<Integer, String> outputForDivisor) {
        this.computation = computation;
        this.outputForDivisor = outputForDivisor;
    }

    @Override
    public void computationStart() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(computation.computeForNumber(i, outputForDivisor));
        }
    }
}
