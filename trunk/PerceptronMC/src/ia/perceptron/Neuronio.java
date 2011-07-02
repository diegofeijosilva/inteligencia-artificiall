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

    public static final double BETA = 0.5;
    private double y;

    public double getSaida()
    {
        return y;
    }

    public void processar(double x)
    {
        y = sigmoide(x);
       // y = tangenteHiperbolica(x);
    }

    public static double sigmoide(double x)
    {
        double e = Math.E;
        return 1 / (1 + Math.pow(e, -(BETA)*x));
    }

     public static double tangenteHiperbolica(double x)
    {
        return Math.tanh(x);
    }

    public static double derivadaS(double x)
    {
        return BETA * sigmoide(x) * (1 - sigmoide(x));
    }

    public static double derivadaT(double x)
    {
        return 1 - Math.pow(Math.tanh(x),2);
    }

}
