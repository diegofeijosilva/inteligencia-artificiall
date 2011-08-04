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

       double temperaturaEntrada = 965;
       double volumeEntrada = 11;
//       double temperaturaEntrada = 920;
//       double volumeEntrada = 7.6;
//       double temperaturaEntrada = 1050;
//       double volumeEntrada = 6.3;
//       double temperaturaEntrada = 843;
//       double volumeEntrada = 8.6;
//       double temperaturaEntrada = 1122;
//       double volumeEntrada = 5.2;

       SistemaFuzzy fuzzy = new SistemaFuzzy();
       fuzzy.criarVariavelLinguistica("Temperatura", 800, 1200);
       fuzzy.criarVariavelLinguistica("Volume", 2, 12);
       fuzzy.criarVariavelLinguistica("Pressao", 4, 12);
       fuzzy.discretizar("Temperatura");
       fuzzy.discretizar("Volume");
       fuzzy.discretizar("Pressao");
       fuzzy.executarMecanismoInferencia(temperaturaEntrada, volumeEntrada);
    }

}
