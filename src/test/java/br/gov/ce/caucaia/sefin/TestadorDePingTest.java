/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin;

import br.gov.ce.caucaia.sefin.util.TestadorDePing;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author gilmario
 */
public class TestadorDePingTest {

    public TestadorDePingTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of testaPing method, of class TestadorDePing.
     *
     * @throws java.lang.Exception
     */
    @org.junit.Test
    public void testTestaPing() throws Exception {
        System.out.println("testaPing");
        String ip = "10.100.0.48";
        TestadorDePing instance = new TestadorDePing();
        assertTrue(instance.testaPing(ip));
    }

//    @org.junit.Test
//    public void testTestaPing2() throws Exception {
//        System.out.println("testaPing");
//        String ip = "10.100.1.11";
//        TestadorDePing instance = new TestadorDePing();
//        assertFalse(instance.testaPing(ip));
//    }
}
