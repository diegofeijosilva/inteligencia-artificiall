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
public class CamadaTest {

    public CamadaTest() {
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
     * Test of inicializarVetorPesos() method, of class Camada.
     */
    @Test
    public void testInicializarVetorPesos() {
        System.out.println("inicializarVetorPesos()");

        int qtdNeuronios = 15;
        int qtdEntradas = 4;
        Camada camada = new Camada(qtdNeuronios, qtdEntradas);

        for (int i = 0; i < qtdNeuronios; i++) {
            for (int j = 0; j < qtdEntradas; j++) {
                double peso = camada.getPeso(i, j);
                assertNotNull(peso);
                assertTrue("O peso inicial deve ter valor entre zero e um!", peso>0 && peso< 1 );
            }
        }
        
    }

   

}