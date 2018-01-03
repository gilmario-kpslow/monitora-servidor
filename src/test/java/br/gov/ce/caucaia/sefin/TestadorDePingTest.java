/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin;

import br.gov.ce.caucaia.sefin.util.TestadorDePing;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
//    @org.junit.Test
    public void testTestaPing() throws Exception {
        System.out.println("testaPing");
        String ip = "10.100.0.254";
        TestadorDePing instance = new TestadorDePing();
        assertTrue(instance.testaPing(ip));
    }

//    @org.junit.Test
    public void testTestaPing2() throws Exception {
        System.out.println("testaPing");
        String ip = "10.100.0.2";
        TestadorDePing instance = new TestadorDePing();
        assertTrue(instance.testaPing(ip));
    }

    @org.junit.Test
    public void testTestaIP() throws Exception {
        String ip = "2.255.255.8";
        //Pattern p = Pattern.compile("\\d[0-2]|\\d{3}.\\d{3}.\\d{3}.\\d{3}");;
        //Pattern p = Pattern.compile("\\d[0-2]\\d[0-5]\\\\d[0-5]|\\d{1,3}");
        //Pattern p = Pattern.compile("[[\\d{1,2}]|[\\d[0-2]\\d[0-5]\\d[0-5]]]\\.[[\\d{1,2}|\\d[0-2]\\d[0-5]\\d[0-5]]]");
        Pattern p = Pattern.compile("\\b(([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\b");
        Matcher matcher = p.matcher(ip);


        assertTrue(matcher.find());
    }
}
