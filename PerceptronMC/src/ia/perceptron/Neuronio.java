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
    private String funcao_ativacao =  Perceptron.FUNÇÃO_ATIVACAO_SIGMOIDE;;
    private double y;


    public Neuronio()
    {
        this.funcao_ativacao = Perceptron.FUNÇÃO_ATIVACAO_SIGMOIDE;
    }

    public Neuronio(String funcao_ativacao)
    {
        this.funcao_ativacao = funcao_ativacao;
    }

    public double getSaida()
    {
        return y;
    }

    public void processar(double x) {
        if (funcao_ativacao.equals(Perceptron.FUNÇÃO_ATIVACAO_TANGENTE_HEPERBOLICA)) {
            y = tangenteHiperbolica(x);
        } else if(funcao_ativacao.equals(Perceptron.FUNÇÃO_ATIVACAO_SIGMOIDE)) {
            y = sigmoide(x);
        } else
            throw new RuntimeException("Função de ativação não suportada!");
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
