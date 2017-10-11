package com.github.rakickayakaterina.mycalculator.logic;

public class Calculator implements ICalculator {

    @Override
    public Double add(final Double op1, final Double op2) {
        return op1 + op2;
    }

    @Override
    public Double sub(final Double op1, final Double op2) {
        return op1 - op2;
    }

    @Override
    public Double mul(final Double op1, final Double op2) {
        return op1 * op2;
    }

    @Override
    public Double div(final Double op1, final Double op2) {
        return op1 / op2;
    }
}
