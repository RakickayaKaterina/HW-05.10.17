package com.github.rakickayakaterina.mycalculator.logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

public class CalculatorTest {

    private ICalculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = spy(Calculator.class);

    }

    @Test
    public void calculatorTest() {
        assertEquals(mCalculator.add(2.4, 8.6), 11, 0);
        assertEquals(mCalculator.sub(2.4, 2.4), 0, 0);
        assertEquals(mCalculator.mul(2.4, 2.0), 4.8, 0);
        assertEquals(mCalculator.div(2.4, 1.2), 2, 0);
    }

}