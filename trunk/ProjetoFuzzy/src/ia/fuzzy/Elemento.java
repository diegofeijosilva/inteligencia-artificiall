/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy;

/**
 *
 * @author Gabriel
 */
public class Elemento {

    private double valor;
    private double pertinencia;

    public Elemento(double valor, double pertinencia)
    {
        this.valor = valor;
        this.pertinencia = pertinencia;
    }

    public double getPertinencia() {
        return pertinencia;
    }

    public double getValor() {
        return valor;
    }

}
