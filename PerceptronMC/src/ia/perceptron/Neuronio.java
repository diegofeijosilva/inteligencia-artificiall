/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.perceptron;

/**
 *
 * @author Larissa
 */
public class Neuronio {

    private double y;

    public double getSaida()
    {
        return y;
    }

    public void processar(double x)
    {
        y = sigmoide(x);
    }

    private double sigmoide(double x)
    {
        return Math.tanh(x);
    }

    private double arredondar(double n) {
        int x = 2; //numeros depois da virgula.
        x = (int) Math.pow(10, x);
        double N = (int) (n * x);
        N = (double) (N / x);
        return N;
    }
}