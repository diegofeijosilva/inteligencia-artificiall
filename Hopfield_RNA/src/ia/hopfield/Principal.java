/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.hopfield;

/**
 *
 * @author Neto
 */
public class Principal {

    public static void main(String[] args) {
        Hopfield hopfield = new Hopfield(45,true);
        hopfield.showInterface();
    }
}
