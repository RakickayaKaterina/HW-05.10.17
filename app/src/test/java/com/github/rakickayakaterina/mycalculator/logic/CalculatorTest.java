package com.github.rakickayakaterina.mycalculator.logic;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


public class CalculatorTest {
    ICalculator mCalculator;

    @Before
    public void  setUp(){
     //   mCalculator = spy(Calculator.class);
        mCalculator =  mock(Calculator.class);
    }



    @Test
    public void evaluate() throws Exception {
        assertEquals(mCalculator.evaluate("5"),null);
    }

}