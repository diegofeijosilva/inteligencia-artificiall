package ia.perceptron;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Larissa
 */
public class Camada {

    private List<Neuronio> neuronios;

    private double[][] W; //matriz de pesos
    private double[] I;   //vetor de entradas ponderadas
    private double[] Y;   //vetor de saídas
    private double[] S;   //gradiente local

    private double bias = -1;
    private int qtdNeuronios;
    private int qtdEntradas;

    private String funcao_ativacao = Perceptron.FUNÇÃO_ATIVACAO_SIGMOIDE;
    
    private double[][] W_anterior;
    private boolean primeiroAjustePesos = true;

    public Camada(int qtdNeuronios, int qtdEntradas) {
        this.qtdNeuronios = qtdNeuronios;
        this.qtdEntradas = qtdEntradas;
        I = new double[qtdNeuronios];
        Y = new double[qtdNeuronios];
        W_anterior = new double[qtdNeuronios][qtdEntradas+1];
        //W_anterior_aux = new double[qtdNeuronios][qtdEntradas+1];
        
        inicializarNeuronios(qtdNeuronios);
        inicializarMatrizPesos(qtdNeuronios, qtdEntradas + 1);
    }

    public Camada(int qtdNeuronios, int qtdEntradas, String funcao_ativacao) {
        this(qtdNeuronios, qtdEntradas);
        this.funcao_ativacao = funcao_ativacao;
        inicializarNeuronios(qtdNeuronios);
    }

    private void inicializarNeuronios(int qtdNeuronios) {
        neuronios = new ArrayList<Neuronio>();
        for (int i = 0; i < qtdNeuronios; i++) {
            neuronios.add(new Neuronio(this.funcao_ativacao));
        }
    }

    private void inicializarMatrizPesos(int i, int j) {

        W = new double[i][j];
        for (int k = 0; k < i; k++) {
            for (int w = 0; w < j; w++) {
                W[k][w] = 1 * (double) Math.random();

            }
        }
    }

    protected void processar(double[] entradas) {
        ponderarEntradas(concatenarBias(entradas));
        for (int i = 0; i < neuronios.size(); i++) {
            neuronios.get(i).processar(I[i]);
        }
        setSaida();
    }

    private void ponderarEntradas(double[] entradas) {
        I = new double[qtdNeuronios];
        for (int i = 0; i < qtdNeuronios; i++) {
            for (int j = 0; j < (qtdEntradas + 1); j++) {
                    I[i] += entradas[j] * W[i][j];
            }
        }
    }

    private void arredondarI() //não utilizado
    {
        for (int i = 0; i < I.length; i++) {
            I[i] = arredondar(I[i]);
        }
    }

    private void arredondarY() //não utilizado
    {
        for (int i = 0; i < Y.length; i++) {
            Y[i] = arredondar(Y[i]);
        }
    }

     private double arredondar(double num) {
        int decimalPlace = 2;
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(decimalPlace,BigDecimal.ROUND_HALF_UP);
        num = bd.doubleValue();
        return num;
    }

     private double[] concatenarBias(double[] entrada)
     {
         double[] resultado = new double[entrada.length + 1];
         resultado[0] = bias;
         for (int i = 1; i < resultado.length; i++) {
             resultado[i] = entrada[i-1];
         }
         return resultado;
     }


    protected double[] calcularGradienteLocalCamadaDeSaida(double[] saidaDesejada) {
        S = new double[qtdNeuronios];
        for (int i = 0; i < qtdNeuronios; i++) {
            S[i] = (saidaDesejada[i] - Y[i]) * Neuronio.derivadaS(I[i]);
        }
        return S;
    }

    protected double[] calcularGradienteLocalCamadaIntermediaria(Camada proxima) {
        S = new double[qtdNeuronios];
        for (int i = 0; i < qtdNeuronios; i++) {
            for (int j = 0; j < proxima.getQtdNeuronios(); j++) {
                S[i] += (proxima.S[j] * proxima.W[j][i]) * Neuronio.derivadaS(I[i]);
            }
        }
        return S;
    }

    protected void ajustarMatrizPesos(boolean momentum, double[] entradas) {

        double[] entradas_concat = concatenarBias(entradas);
        double[][] W_prox = new double[W.length][W[0].length];

        if (primeiroAjustePesos) {
            W_anterior = copiarMatriz(W);
        } 

        for (int i = 0; i < qtdNeuronios; i++) {
            for (int j = 0; j < (qtdEntradas + 1); j++) {
                if (momentum) {
                    W_prox[i][j] = W[i][j] + Perceptron.FATOR_DE_MOMENTUM * (W[i][j] - W_anterior[i][j]) + Perceptron.TAXA_APRENDIZAGEM * S[i] * entradas_concat[j];
                    W_anterior[i][j] = W[i][j];
                    W[i][j] = W_prox[i][j];
                } else {
                    W[i][j] = W[i][j] + Perceptron.TAXA_APRENDIZAGEM * S[i] * entradas_concat[j];
                }

            }
        }
        primeiroAjustePesos = false;

    }

    public static double[] copiarVetor(double[] vetor)
    {
        double[] copia = new double[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            copia[i] = vetor[i];
        }
        return copia;

    }

    public static double[][] copiarMatriz(double[][] matriz)
    {
        double[][] copia = new double[matriz.length][matriz[0].length];
        for (int i = 0; i < copia.length; i++) {
            for (int j = 0; j < copia[0].length; j++) {
                copia[i][j] = matriz[i][j];
            }
        }
        return copia;
    }

    public int getQtdNeuronios() {
        return this.qtdNeuronios;
    }

    public int getQtdEntradas() {
        return this.qtdEntradas;
    }

    public double getPeso(int i, int j) {
        return W[i][j];
    }

    public double[][] getW()
    {
        return copiarMatriz(W);
    }

    public Neuronio getNeuronio(int i) {
        return neuronios.get(i);
    }

    public double[] getSaida()
    {
        return copiarVetor(Y);
    }

    protected double[] getI()
    {
        return copiarVetor(I);
    }

    protected double[] getS()
    {
        return copiarVetor(S);
    }

    private void setSaida() {
        for (int i = 0; i < neuronios.size(); i++) {
            Y[i] = neuronios.get(i).getSaida();
        }
    }

    public void setMatrizPeso(double[][] matriz)
    {
        if(matriz.length != W.length)
            throw new IllegalArgumentException("A matriz passada tem tamanho diferente da matriz da camada! ");

        W = matriz;
    }

    protected void setBias(double bias)
    {
        this.bias = bias;
    }

    protected void setPrimeiroAjustePesos(boolean b)
    {
        this.primeiroAjustePesos = b;
    }
}
