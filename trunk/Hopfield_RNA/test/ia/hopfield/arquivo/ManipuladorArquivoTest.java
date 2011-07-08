/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.hopfield.arquivo;

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
    public void testCarregarDadosPadroes() {
//       System.out.println("testeCarregarDadosPadroes()");
//        ManipuladorArquivo instance = new ManipuladorArquivo();
//        instance.carregarDados();
//
//        double[] obtido1 = instance.getArquivoPadroes().getPadrao(0).;
//        double[] esperado1 = new double[]{-1, -1, 1, 1, -1, -1, 1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1};
//
//        double[] obtido2 = instance.getArquivoPadroes().getPadrao(1);
//        double[] esperado2 = new double[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//
//
//        //Checando primeira linha do arquivo de padrões
//        assertEquals(esperado1.length,obtido1.length);
//
//        assertEquals(esperado1[0],obtido1[0],0);
//        assertEquals(esperado1[1],obtido1[1],0);
//        assertEquals(esperado1[2],obtido1[2],0);
//        assertEquals(esperado1[3],obtido1[3],0);
//        assertEquals(esperado1[4],obtido1[4],0);
//        assertEquals(esperado1[5],obtido1[5],0);
//        assertEquals(esperado1[6],obtido1[6],0);
//        assertEquals(esperado1[7],obtido1[7],0);
//        assertEquals(esperado1[8],obtido1[8],0);
//        assertEquals(esperado1[9],obtido1[9],0);
//        assertEquals(esperado1[10],obtido1[10],0);
//        assertEquals(esperado1[11],obtido1[11],0);
//        assertEquals(esperado1[12],obtido1[12],0);
//        assertEquals(esperado1[13],obtido1[13],0);
//        assertEquals(esperado1[14],obtido1[14],0);
//        assertEquals(esperado1[15],obtido1[15],0);
//        assertEquals(esperado1[16],obtido1[16],0);
//        assertEquals(esperado1[17],obtido1[17],0);
//        assertEquals(esperado1[18],obtido1[18],0);
//        assertEquals(esperado1[19],obtido1[19],0);
//        assertEquals(esperado1[20],obtido1[20],0);
//        assertEquals(esperado1[21],obtido1[21],0);
//        assertEquals(esperado1[22],obtido1[22],0);
//        assertEquals(esperado1[23],obtido1[23],0);
//        assertEquals(esperado1[24],obtido1[24],0);
//        assertEquals(esperado1[25],obtido1[25],0);
//        assertEquals(esperado1[26],obtido1[26],0);
//        assertEquals(esperado1[27],obtido1[27],0);
//        assertEquals(esperado1[28],obtido1[28],0);
//        assertEquals(esperado1[29],obtido1[29],0);
//        assertEquals(esperado1[30],obtido1[30],0);
//        assertEquals(esperado1[31],obtido1[31],0);
//        assertEquals(esperado1[32],obtido1[32],0);
//        assertEquals(esperado1[33],obtido1[33],0);
//        assertEquals(esperado1[34],obtido1[34],0);
//        assertEquals(esperado1[35],obtido1[35],0);
//        assertEquals(esperado1[36],obtido1[36],0);
//        assertEquals(esperado1[37],obtido1[37],0);
//        assertEquals(esperado1[38],obtido1[38],0);
//        assertEquals(esperado1[39],obtido1[39],0);
//        assertEquals(esperado1[40],obtido1[40],0);
//        assertEquals(esperado1[41],obtido1[41],0);
//        assertEquals(esperado1[42],obtido1[42],0);
//        assertEquals(esperado1[43],obtido1[43],0);
//        assertEquals(esperado1[44],obtido1[44],0);
//
//
//        //Checando segunda linha do arquivo de padrões
//        assertEquals(esperado2.length,obtido2.length);
//
//        assertEquals(esperado2[0],obtido2[0],0);
//        assertEquals(esperado2[1],obtido2[1],0);
//        assertEquals(esperado2[2],obtido2[2],0);
//        assertEquals(esperado2[3],obtido2[3],0);
//        assertEquals(esperado2[4],obtido2[4],0);
//        assertEquals(esperado2[5],obtido2[5],0);
//        assertEquals(esperado2[6],obtido2[6],0);
//        assertEquals(esperado2[7],obtido2[7],0);
//        assertEquals(esperado2[8],obtido2[8],0);
//        assertEquals(esperado2[9],obtido2[9],0);
//        assertEquals(esperado2[10],obtido2[10],0);
//        assertEquals(esperado2[11],obtido2[11],0);
//        assertEquals(esperado2[12],obtido2[12],0);
//        assertEquals(esperado2[13],obtido2[13],0);
//        assertEquals(esperado2[14],obtido2[14],0);
//        assertEquals(esperado2[15],obtido2[15],0);
//        assertEquals(esperado2[16],obtido2[16],0);
//        assertEquals(esperado2[17],obtido2[17],0);
//        assertEquals(esperado2[18],obtido2[18],0);
//        assertEquals(esperado2[19],obtido2[19],0);
//        assertEquals(esperado2[20],obtido2[20],0);
//        assertEquals(esperado2[21],obtido2[21],0);
//        assertEquals(esperado2[22],obtido2[22],0);
//        assertEquals(esperado2[23],obtido2[23],0);
//        assertEquals(esperado2[24],obtido2[24],0);
//        assertEquals(esperado2[25],obtido2[25],0);
//        assertEquals(esperado2[26],obtido2[26],0);
//        assertEquals(esperado2[27],obtido2[27],0);
//        assertEquals(esperado2[28],obtido2[28],0);
//        assertEquals(esperado2[29],obtido2[29],0);
//        assertEquals(esperado2[30],obtido2[30],0);
//        assertEquals(esperado2[31],obtido2[31],0);
//        assertEquals(esperado2[32],obtido2[32],0);
//        assertEquals(esperado2[33],obtido2[33],0);
//        assertEquals(esperado2[34],obtido2[34],0);
//        assertEquals(esperado2[35],obtido2[35],0);
//        assertEquals(esperado2[36],obtido2[36],0);
//        assertEquals(esperado2[37],obtido2[37],0);
//        assertEquals(esperado2[38],obtido2[38],0);
//        assertEquals(esperado2[39],obtido2[39],0);
//        assertEquals(esperado2[40],obtido2[40],0);
//        assertEquals(esperado2[41],obtido2[41],0);
//        assertEquals(esperado2[42],obtido2[42],0);
//        assertEquals(esperado2[43],obtido2[43],0);
//        assertEquals(esperado2[44],obtido2[44],0);

    }

}