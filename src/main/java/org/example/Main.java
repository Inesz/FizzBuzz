package org.example;

import org.example.computations.CustomNumbers;
import org.example.computations.DivisorComputation;
import org.example.computations.HundredNumbers;
import org.example.conditions.CustomDivisorsOutputs;
import org.example.conditions.FizzBuzzDivisorsOutputs;

public class Main {

    public static void main(String[] args) {
        fizzBuzzComputation();
        printSeparator();
        customComputation();
        printSeparator();
        customComputationCustomScope();
    }

    private static void fizzBuzzComputation() {
        new HundredNumbers(new DivisorComputation(), new FizzBuzzDivisorsOutputs().getDivisorsOutputs()).computationStart();
    }

    private static void customComputation() {
        CustomDivisorsOutputs customDivisorsOutputs = new CustomDivisorsOutputs();
        customDivisorsOutputs.addDivisorOutput(2, "Hellozz");
        customDivisorsOutputs.addDivisorOutput(7, "Jazz");
        new HundredNumbers(new DivisorComputation(), customDivisorsOutputs.getDivisorsOutputs()).computationStart();
    }

    private static void customComputationCustomScope() {
        CustomDivisorsOutputs customDivisorsOutputs = new CustomDivisorsOutputs();
        customDivisorsOutputs.addDivisorOutput(3, "Customzz");

        CustomNumbers.getBuilder()
                .setOutputForDivisor(customDivisorsOutputs.getDivisorsOutputs())
                .setMinValue(3)
                .setMaxValue(20)
                .setStep(2)
                .build()
                .computationStart();
    }

    @SuppressWarnings("java:S106")
    private static void printSeparator() {
        System.out.println("==========================");
    }
}
