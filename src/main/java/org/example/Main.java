package org.example;

import org.example.conditions.CustomDivisorsOutputs;
import org.example.conditions.FizzBuzzDivisorsOutputs;

public class Main {

    public static void main(String[] args) {
        fizzBuzzComputation();
        printSeparator();
        customComputation();
    }

    private static void fizzBuzzComputation() {
        Computation.computeFor100Numbers(new FizzBuzzDivisorsOutputs().getDivisorsOutputs());
    }

    private static void customComputation() {
        CustomDivisorsOutputs customDivisorsOutputs = new CustomDivisorsOutputs();
        customDivisorsOutputs.addDivisorOutput(2, "Hellozz");
        customDivisorsOutputs.addDivisorOutput(7, "Jazz");
        Computation.computeFor100Numbers(customDivisorsOutputs.getDivisorsOutputs());
    }

    private static void printSeparator() {
        System.out.println("==========================");
    }
}
