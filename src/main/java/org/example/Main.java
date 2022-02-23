package org.example;

import org.example.computations.CustomNumbers;
import org.example.computations.DivisionComputation;
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
        new HundredNumbers(new DivisionComputation(), new FizzBuzzDivisorsOutputs().getDivisorsOutputs()).computationStart();
    }

    private static void customComputation() {
        CustomDivisorsOutputs customDivisorsOutputs = new CustomDivisorsOutputs();
        customDivisorsOutputs.addDivisorOutput(2, "Hellozz");
        customDivisorsOutputs.addDivisorOutput(7, "Jazz");
        new HundredNumbers(new DivisionComputation(), customDivisorsOutputs.getDivisorsOutputs()).computationStart();
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

    private static void printSeparator() {
        System.out.println("==========================");
    }
}
