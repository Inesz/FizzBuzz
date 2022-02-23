package org.example.computations;

import org.example.conditions.FizzBuzzDivisorsOutputs;

import java.util.Map;

public class CustomNumbers implements ComputationInitializer {
    private final Computation computation;
    private final Map<Integer, String> outputForDivisor;
    private final int step;
    private final int minValue;
    private final int maxValue;

    private CustomNumbers(Computation computation, Map<Integer, String> outputForDivisor, int minValue, int maxValue, int step) {
        this.computation = computation;
        this.outputForDivisor = outputForDivisor;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.step = step;
    }

    @Override
    @SuppressWarnings("java:S106")
    public void computationStart() {
        for (int i = minValue; i <= maxValue; i = i + step) {
            System.out.println(computation.computeForNumber(i, outputForDivisor));
        }
    }

    public static CustomNumbersBuilder getBuilder() {
        return new CustomNumbersBuilder();
    }

    public static final class CustomNumbersBuilder {
        private Computation computation = new DivisionComputation();
        private Map<Integer, String> outputForDivisor = new FizzBuzzDivisorsOutputs().getDivisorsOutputs();
        private int step = 1;
        private int minValue = 0;
        private int maxValue = 10;

        public CustomNumbers build() {
            return new CustomNumbers(computation, outputForDivisor, minValue, maxValue, step);
        }

        public CustomNumbersBuilder setComputation(Computation computation) {
            this.computation = computation;
            return this;
        }

        public CustomNumbersBuilder setOutputForDivisor(Map<Integer, String> outputForDivisor) {
            this.outputForDivisor = outputForDivisor;
            return this;
        }

        public CustomNumbersBuilder setStep(int step) {
            this.step = step;
            return this;
        }

        public CustomNumbersBuilder setMinValue(int minValue) {
            this.minValue = minValue;
            return this;
        }

        public CustomNumbersBuilder setMaxValue(int maxValue) {
            this.maxValue = maxValue;
            return this;
        }
    }
}

