/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gilmario
 */
public class TestaPortaTest {

    public TestaPortaTest() {
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
     * Test of testar method, of class TestaPorta.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testTestar() throws Exception {
        System.out.println("testar");
        String host = "10.100.0.4";
        int porta = 3306;
        TestaPorta instance = new TestaPorta();
        boolean expResult = true;
        boolean result = instance.testar(host, porta);
        assertEquals(expResult, result);
    }
}
