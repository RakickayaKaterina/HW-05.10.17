package com.github.rakickayakaterina.mycalculator.logic;



public class Calculator implements ICalculator {

    @Override
    public Double add(Double op1, Double op2) {
        return op1+op2;
    }

    @Override
    public Double sub(Double op1, Double op2) {
        return op1-op2;
    }

    @Override
    public Double mul(Double op1, Double op2) {
        return op1*op2;
    }

    @Override
    public Double div(Double op1, Double op2) {
        return op1/op2;
    }
}
