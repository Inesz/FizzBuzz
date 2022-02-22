package org.example;

import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Computation {

    private Computation() {
    }

    public static void computeFor100Numbers(Map<Integer, String> outputForDivisor) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(computeForNumber(i, outputForDivisor));
        }
    }

    public static String computeForNumber(int number, @Nullable Map<Integer, String> outputForDivisor) {
        if (outputForDivisor == null || outputForDivisor.isEmpty()) {
            return Integer.toString(number);
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

    private static boolean isDivisible(int dividend, Integer divisor) {
        return dividend % divisor == 0;
    }

}
