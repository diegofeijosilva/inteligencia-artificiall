/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy;

/**
 *
 * @author Larissa
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SistemaFuzzy fuzzy = new SistemaFuzzy();
       fuzzy.criarVariavelLinguistica("Temperatura", 800, 1200);
       fuzzy.criarVariavelLinguistica("Volume", 2, 12);
       fuzzy.discretizar("Temperatura");
       fuzzy.discretizar("Volume");
       fuzzy.mecanismoDeInferencia();
    }

}
