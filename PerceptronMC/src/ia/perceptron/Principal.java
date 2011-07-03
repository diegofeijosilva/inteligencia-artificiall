/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.perceptron;


/**
 *
 * @author Larissa
 */
public class Principal {




    public static void main(String args[]) {

        Perceptron perceptron = new Perceptron(true);
        perceptron.criarCamada(15, 4);
        perceptron.criarCamada(3, 15);
        perceptron.showInterface();
    }

}
