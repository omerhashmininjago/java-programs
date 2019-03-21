package com.demonstrate.concepts.junit.example1;

import org.junit.jupiter.api.*;

public class DemoTest {

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        System.out.println("In @BeforeAll");
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("\n" + "In @BeforeEach");
    }

    @Test
    public void testDummy() {
        System.out.println("\n" + "In testDummy()");
    }

    @Test
    public void testData() {
        System.out.println("\n" + "In testData()");
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("\n" + "In @AfterEach");
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        System.out.println("\n" + "In @AfterAll");
    }
}