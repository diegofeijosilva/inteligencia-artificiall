/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.perceptron;

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
public class PerceptronTest {

    public PerceptronTest() {
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
     * Test of propagarEntradas method, of class Perceptron.
     */
    @Test
    public void testProcessarEntradas() {
        System.out.println("processarEntradas()");
       
        Perceptron instance = new Perceptron(2);

        instance.setBias(-1);
        instance.criarCamada(3, 2);
        instance.criarCamada(2, 3);
        instance.criarCamada(1, 2);

        instance.getCamada(0).setMatrizPeso(new double[][] {{0.2,0.4,0.5},{0.3,0.6,0.7},{0.4,0.8,0.3}});
        instance.getCamada(1).setMatrizPeso(new double[][] {{-0.7,0.6,0.2,0.7},{-0.3,0.7,0.2,0.8}});
        instance.getCamada(2).setMatrizPeso(new double[][] {{0.1,0.8,0.5}});

        instance.getCamada(0).setBias(-1);
        instance.getCamada(1).setBias(-1);
        instance.getCamada(2).setBias(-1);

        instance.setEntrada(new double[] {0.3,0.7});

        instance.propagarEntradas();

        //Primeira camada neural
        assertEquals(0.27,instance.getCamada(0).getI()[0],0.0);
        assertEquals(0.37,instance.getCamada(0).getI()[1],0.0);
        assertEquals(0.05,instance.getCamada(0).getI()[2],0.0);

        assertEquals(0.26,instance.getCamada(0).getSaida()[0],0.0);
        assertEquals(0.35,instance.getCamada(0).getSaida()[1],0.0);
        assertEquals(0.05,instance.getCamada(0).getSaida()[2],0.0);
        
        //Segunda camada neural
        assertEquals(0.96,instance.getCamada(1).getI()[0],0.0);
        assertEquals(0.59,instance.getCamada(1).getI()[1],0.0);

        assertEquals(0.74,instance.getCamada(1).getSaida()[0],0.0);
        assertEquals(0.53,instance.getCamada(1).getSaida()[1],0.0);

        //Terceira camada neural
        assertEquals(0.76,instance.getCamada(2).getI()[0],0.0);

        assertEquals(0.64,instance.getCamada(2).getSaida()[0],0.0);



    }

}