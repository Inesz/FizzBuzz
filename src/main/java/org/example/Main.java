package org.example;

import org.example.conditions.FizzBuzzDivisorsOutputs;

public class Main {

    public static void main(String[] args) {
        Computation.computeFor100Numbers(new FizzBuzzDivisorsOutputs().getDivisorsOutputs());
    }
}
