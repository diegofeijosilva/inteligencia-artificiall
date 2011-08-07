/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy;

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
public class SistemaFuzzyTest {

    SistemaFuzzy fuzzy;

    public SistemaFuzzyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        initFuzzy();
    }

    @After
    public void tearDown() {
    }

    private void initFuzzy()
    {
       fuzzy = new SistemaFuzzy();
       fuzzy.criarVariavelLinguistica("Temperatura", 800, 1200);
       fuzzy.criarVariavelLinguistica("Volume", 2, 12);
       fuzzy.criarVariavelLinguistica("Pressao", 4, 12);
    }

    /**
     * Test of executarMecanismoInferencia method, of class SistemaFuzzy.
     */
    @Test
    public void testExecutarMecanismoInferencia() {

        double temperaturaEntrada1 = 965;
        double temperaturaEntrada2 = 920;
        double temperaturaEntrada3 = 1050;
        double temperaturaEntrada4 = 843;
        double temperaturaEntrada5 = 1122;

        double volumeEntrada1 = 11;
        double volumeEntrada2 = 7.6;
        double volumeEntrada3 = 6.3;
        double volumeEntrada4 = 8.6;
        double volumeEntrada5 = 5.2;

        double pressaoEncontrada1 = fuzzy.executarMecanismoInferencia(temperaturaEntrada1, volumeEntrada1);
        double pressaoEncontrada2 = fuzzy.executarMecanismoInferencia(temperaturaEntrada2, volumeEntrada2);
        double pressaoEncontrada3 = fuzzy.executarMecanismoInferencia(temperaturaEntrada3, volumeEntrada3);
        double pressaoEncontrada4 = fuzzy.executarMecanismoInferencia(temperaturaEntrada4, volumeEntrada4);
        double pressaoEncontrada5 = fuzzy.executarMecanismoInferencia(temperaturaEntrada5, volumeEntrada5);

        assertEquals(9.592153687047269, pressaoEncontrada1, 0);
        assertEquals(6.776952760417753, pressaoEncontrada2, 0);
        assertEquals(8.465591820683994, pressaoEncontrada3, 0);
        assertEquals(7.074673247778785, pressaoEncontrada4, 0);
        assertEquals(8.731324728962232, pressaoEncontrada5, 0);

    }

   
}