/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.perceptron.arquivo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Neto
 */
public class ManipuladorArquivoTest {

    public ManipuladorArquivoTest() {
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
     * Test of carregarDados method, of class ManipuladorArquivo.
     */
    @Test
    public void testCarregarDados() {
        System.out.println("carregarDados");
        ManipuladorArquivo instance = new ManipuladorArquivo();
        instance.carregarDados();

        double[] d = instance.getArquivoTreino().x(0);
        System.out.println("dados: "+d[0]+" "+d[1]+" "+d[2]+" "+d[3]+" ");

        assertEquals(0.3841,d[0],0);
        assertEquals(0.2021,d[1],0);
        assertEquals(0.0,d[2],0);
        assertEquals(0.2438,d[3],0);
        
    }

}