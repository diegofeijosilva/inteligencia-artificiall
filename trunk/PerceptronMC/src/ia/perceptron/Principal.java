/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.perceptron;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Larissa
 */
public class Principal {




    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

         try {
           UIManager.setLookAndFeel(new com.jgoodies.looks.windows.WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }


        Perceptron perceptron = new Perceptron(true);
        perceptron.criarCamada(15, 4);
        perceptron.criarCamada(3, 15);
        perceptron.showInterface();
    }

}
