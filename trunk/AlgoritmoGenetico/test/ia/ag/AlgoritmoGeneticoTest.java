/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.ag;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class AlgoritmoGeneticoTest {

    public AlgoritmoGeneticoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of eval method, of class AlgoritmoGenetico.
     */
    @Test
    public void testEval() {
        AlgoritmoGenetico ag = new AlgoritmoGenetico();

        Cromossomo cromossomo1 = new Cromossomo(new int[]{1,1,1,0,0,0,1,0,1,0,1,1,0,1,1,1,0,1,0,0,0,1});
        Cromossomo cromossomo2 = new Cromossomo(new int[]{0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0});
        Cromossomo cromossomo3 = new Cromossomo(new int[]{1,0,1,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1});

        ag.eval(cromossomo3);

        assertEquals(1.586345,ag.eval(cromossomo1),0.0);
        assertEquals(0.078878,ag.eval(cromossomo2),0.0);
        assertEquals(2.250650,ag.eval(cromossomo3),0.0);

    }

}