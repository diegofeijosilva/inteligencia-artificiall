package ia.perceptron;

import java.util.ArrayList;
import java.util.List;
import perceptron.Arquivo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Larissa
 */
public class Perceptron {

    public static final double TAXA_APRENDIZAGEM = 0.1;
    public static final double PRECISAO = 0.000001;


    private List<Camada> camadas = new ArrayList<Camada>();
    private double x[] = new double[4];  //camada de entrada
    private double d[] = new double[3];  //valores desejados no treino

 
    public void criarCamada(int qtdNeuronios, int qtdEntradas) {
        camadas.add(new Camada(qtdNeuronios, qtdEntradas));
    }

    private double erroQuadratico(double[] desejado, double[] saida)
    {
        double resultado = 0;

        if(desejado.length != saida.length)
            throw new IllegalArgumentException("Os vetores devem ter o mesmo tamanho!");

        for (int i = 0; i < desejado.length; i++) {
            double erro = desejado[i] - saida[i];
            resultado += Math.pow(erro, 2);
        }

        return resultado/2;
    }

//    private double EQM()
//    {
//
//    }

}
