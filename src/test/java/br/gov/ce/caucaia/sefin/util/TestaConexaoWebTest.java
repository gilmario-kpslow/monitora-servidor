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
public class TestaConexaoWebTest {

    public TestaConexaoWebTest() {
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
     * Test of testar method, of class TestaConexaoWeb.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testTestar() throws Exception {
        System.out.println("testar");
        String path = "http://localhost";
        TestaConexaoWeb instance = new TestaConexaoWeb();
        boolean expResult = true;
        boolean result = instance.testar(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
}
