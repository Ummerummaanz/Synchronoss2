package com.example.synchronoss2;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
        Calculator mCalculator;
    public void setUp() throws Exception {
        super.setUp();
           mCalculator= new Calculator();
    }

    public void tearDown() throws Exception {
    }

    public void testAdd() {
           int expected = 30;
            int actual = mCalculator.add(10,20);
            assertEquals(expected,actual);

    }

    public void testMult() {
        int expected  =12;
        int actual = mCalculator.multiply(3,4);
        assertEquals(expected,actual);
    }

}