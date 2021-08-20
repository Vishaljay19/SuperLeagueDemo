package com.tcs.it.td.sldemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
        System.out.println("Inside setUp()");
    }

    @Test
    void testCreateMain() {
        Main main = new Main();
        // nothing to do...
    }

    @Test
    void testMain() {
        System.out.println("Before calling main()");
        Main.main(null);
        System.out.println("After calling main()");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside tearDown()");
    }
}