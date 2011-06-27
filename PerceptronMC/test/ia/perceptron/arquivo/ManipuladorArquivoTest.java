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
    public void testCarregarDadosEntradaTreino() {
        System.out.println("carregarDadosEntradaTreino()");
        ManipuladorArquivo instance = new ManipuladorArquivo();
        instance.carregarDados();

        double[] obtido1 = instance.getArquivoTreino().x(0);
        double[] esperado1 = new double[]{0.3841, 0.2021, 0.0, 0.2438};

        double[] obtido2 = instance.getArquivoTreino().x(129);
        double[] esperado2 = new double[]{0.3832, 0.2321, 0.0341, 0.2450};

        double[] obtido3 = instance.getArquivoTreino().x(99);
        double[] esperado3 = new double[]{0.3858, 0.7585, 0.3239, 0.3565};

        double[] obtido4 = instance.getArquivoTreino().x(62);
        double[] esperado4 = new double[]{0.6880, 0.6004, 0.6602, 0.4320};
        

        assertEquals(esperado1.length,obtido1.length);
        
        assertEquals(esperado1[0],obtido1[0],0);
        assertEquals(esperado1[1],obtido1[1],0);
        assertEquals(esperado1[2],obtido1[2],0);
        assertEquals(esperado1[3],obtido1[3],0);

        assertEquals(esperado2.length,obtido2.length);

        assertEquals(esperado2[0],obtido2[0],0);
        assertEquals(esperado2[1],obtido2[1],0);
        assertEquals(esperado2[2],obtido2[2],0);
        assertEquals(esperado2[3],obtido2[3],0);

        assertEquals(esperado3.length,obtido3.length);

        assertEquals(esperado3[0],obtido3[0],0);
        assertEquals(esperado3[1],obtido3[1],0);
        assertEquals(esperado3[2],obtido3[2],0);
        assertEquals(esperado3[3],obtido3[3],0);

        assertEquals(esperado4.length,obtido4.length);

        assertEquals(esperado4[0],obtido4[0],0);
        assertEquals(esperado4[1],obtido4[1],0);
        assertEquals(esperado4[2],obtido4[2],0);
        assertEquals(esperado4[3],obtido4[3],0);
        
    }

    @Test
    public void testCarregarDadosSaidaTreino() {
        System.out.println("carregarDadosSaidaTreino()");
        ManipuladorArquivo instance = new ManipuladorArquivo();
        instance.carregarDados();

        double[] obtido1 = instance.getArquivoTreino().d(0);
        double[] esperado1 = new double[]{1, 0, 0};

        double[] obtido2 = instance.getArquivoTreino().d(129);
        double[] esperado2 = new double[]{1, 0, 0};

        double[] obtido3 = instance.getArquivoTreino().d(99);
        double[] esperado3 = new double[]{0, 1, 0};

        double[] obtido4 = instance.getArquivoTreino().d(62);
        double[] esperado4 = new double[]{0, 1, 0};


        assertEquals(esperado1.length,obtido1.length);

        assertEquals(esperado1[0],obtido1[0],0);
        assertEquals(esperado1[1],obtido1[1],0);
        assertEquals(esperado1[2],obtido1[2],0);

        assertEquals(esperado2.length,obtido2.length);

        assertEquals(esperado2[0],obtido2[0],0);
        assertEquals(esperado2[1],obtido2[1],0);
        assertEquals(esperado2[2],obtido2[2],0);

        assertEquals(esperado3.length,obtido3.length);

        assertEquals(esperado3[0],obtido3[0],0);
        assertEquals(esperado3[1],obtido3[1],0);
        assertEquals(esperado3[2],obtido3[2],0);

        assertEquals(esperado4.length,obtido4.length);

        assertEquals(esperado4[0],obtido4[0],0);
        assertEquals(esperado4[1],obtido4[1],0);
        assertEquals(esperado4[2],obtido4[2],0);

    }

    @Test
    public void testCarregarDadosEntradaTeste() {
        System.out.println("carregarDadosEntradaTeste()");
        ManipuladorArquivo instance = new ManipuladorArquivo();
        instance.carregarDados();

        double[] obtido1 = instance.getArquivoTeste().x(0);
        double[] esperado1 = new double[]{0.8622, 0.7101, 0.6236, 0.7894};

        double[] obtido2 = instance.getArquivoTeste().x(17);
        double[] esperado2 = new double[]{0.7325, 0.4761, 0.3888, 0.5683};

        double[] obtido3 = instance.getArquivoTeste().x(13);
        double[] esperado3 = new double[]{0.9633, 0.7850, 0.6777, 0.6059};

        double[] obtido4 = instance.getArquivoTeste().x(8);
        double[] esperado4 = new double[]{0.0705, 0.4717, 0.2921, 0.2954};


        assertEquals(esperado1.length,obtido1.length);

        assertEquals(esperado1[0],obtido1[0],0);
        assertEquals(esperado1[1],obtido1[1],0);
        assertEquals(esperado1[2],obtido1[2],0);
        assertEquals(esperado1[3],obtido1[3],0);

        assertEquals(esperado2.length,obtido2.length);

        assertEquals(esperado2[0],obtido2[0],0);
        assertEquals(esperado2[1],obtido2[1],0);
        assertEquals(esperado2[2],obtido2[2],0);
        assertEquals(esperado2[3],obtido2[3],0);

        assertEquals(esperado3.length,obtido3.length);

        assertEquals(esperado3[0],obtido3[0],0);
        assertEquals(esperado3[1],obtido3[1],0);
        assertEquals(esperado3[2],obtido3[2],0);
        assertEquals(esperado3[3],obtido3[3],0);

        assertEquals(esperado4.length,obtido4.length);

        assertEquals(esperado4[0],obtido4[0],0);
        assertEquals(esperado4[1],obtido4[1],0);
        assertEquals(esperado4[2],obtido4[2],0);
        assertEquals(esperado4[3],obtido4[3],0);

    }

    @Test
    public void testCarregarDadosSaidaTeste() {
        System.out.println("carregarDadosSaidaTeste()");
        ManipuladorArquivo instance = new ManipuladorArquivo();
        instance.carregarDados();

        double[] obtido1 = instance.getArquivoTeste().d(0);
        double[] esperado1 = new double[]{0, 0, 1};

        double[] obtido2 = instance.getArquivoTeste().d(17);
        double[] esperado2 = new double[]{0, 1, 0};

        double[] obtido3 = instance.getArquivoTeste().d(13);
        double[] esperado3 = new double[]{0, 0, 1};

        double[] obtido4 = instance.getArquivoTeste().d(8);
        double[] esperado4 = new double[]{1, 0, 0};


        assertEquals(esperado1.length,obtido1.length);

        assertEquals(esperado1[0],obtido1[0],0);
        assertEquals(esperado1[1],obtido1[1],0);
        assertEquals(esperado1[2],obtido1[2],0);

        assertEquals(esperado2.length,obtido2.length);

        assertEquals(esperado2[0],obtido2[0],0);
        assertEquals(esperado2[1],obtido2[1],0);
        assertEquals(esperado2[2],obtido2[2],0);

        assertEquals(esperado3.length,obtido3.length);

        assertEquals(esperado3[0],obtido3[0],0);
        assertEquals(esperado3[1],obtido3[1],0);
        assertEquals(esperado3[2],obtido3[2],0);

        assertEquals(esperado4.length,obtido4.length);

        assertEquals(esperado4[0],obtido4[0],0);
        assertEquals(esperado4[1],obtido4[1],0);
        assertEquals(esperado4[2],obtido4[2],0);

    }



}