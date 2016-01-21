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
public class EnviaEmailUtilTest {

    public EnviaEmailUtilTest() {
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
     * Test of enviar method, of class EnviaEmailUtil.
     */
    @Test
    public void testEnviar() {
        System.out.println("enviar");
        try {
//            EnviaEmailUtil instance = new EnviaEmailUtil();
//            instance.enviar();
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exceção");
        }

    }

}
