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
public class CromossomoTest {

    public CromossomoTest() {
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
     * Test of getRealValue method, of class Cromossomo.
     */
    @Test
    public void testGetRealValue() {
        Cromossomo cromossomoEsquerdo = new Cromossomo(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        Cromossomo cromossomo = new Cromossomo(new int[]{1,1,1,0,0,0,1,0,1,0,1,1,0,1,1,1,0,1,0,0,0,1});

        Cromossomo cromossomo1 = new Cromossomo(new int[]{1,1,1,0,0,0,1,0,1,0,1,1,0,1,1,1,0,1,0,0,0,1});
        Cromossomo cromossomo2 = new Cromossomo(new int[]{0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0});
        Cromossomo cromossomo3 = new Cromossomo(new int[]{1,0,1,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1});

        assertEquals(0.637197,cromossomo1.getRealValue(),0.0);
        assertEquals(-0.958973,cromossomo2.getRealValue(),0.0);
        assertEquals(1.627888,cromossomo3.getRealValue(),0.0);

        assertEquals((-1),cromossomoEsquerdo.getRealValue(),0.0);
        assertEquals((0.637197),cromossomo.getRealValue(),0.0);       
    }

    /**
     * Test of setGenes method, of class Cromossomo.
     */
  
}