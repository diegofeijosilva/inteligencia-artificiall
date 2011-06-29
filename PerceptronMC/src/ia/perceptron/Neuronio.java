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

    public static double sigmoide(double x)
    {
        return Math.tanh(x);
    }

    public static double derivadaSigmoide(double x)
    {
        return 1 - Math.pow(Math.tanh(x),2);
    }

    public static double derivada(double entrada){//entrada: entrada poderada do j-essimo neuronio da camada L

         return 0.5*sigmoide(entrada)*(1-sigmoide(entrada));
     }

}