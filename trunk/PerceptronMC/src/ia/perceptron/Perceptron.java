package ia.perceptron;

import ia.perceptron.arquivo.ManipuladorArquivo;
import java.util.ArrayList;
import java.util.List;
import ia.perceptron.arquivo.Arquivo;

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
    private ManipuladorArquivo fileHandler = new ManipuladorArquivo();
    private Arquivo arquivoTeste;
    private Arquivo arquivoTreino;

    private double x[] = new double[4];  //camada de entrada
    private double d[] = new double[3];  //valores desejados no treino

    public Perceptron()
    {
        fileHandler.carregarDados();
        arquivoTeste = fileHandler.getArquivoTeste();
        arquivoTreino = fileHandler.getArquivoTreino();
    }

 

//    private double EQM()
//    {
//        int totalAmostras = ManipuladorArquivo.LINHAS_ARQUIVO_TREINO_DEFAULT;
//
//        for (int i = 0; i < totalAmostras; i++) {
//            double d = x[i];
//
//        }
//    }

    private double erroQuadratico(double[] esperado, double[] obtido)
    {
        double resultado = 0;

        if(esperado.length != obtido.length)
            throw new IllegalArgumentException("Os vetores devem ter o mesmo tamanho!");

        for (int i = 0; i < esperado.length; i++) {
            double erro = esperado[i] - obtido[i];
            resultado += Math.pow(erro, 2);
        }

        return resultado/2;
    }


    public void criarCamada(int qtdNeuronios, int qtdEntradas) {
        camadas.add(new Camada(qtdNeuronios, qtdEntradas));
    }



}
