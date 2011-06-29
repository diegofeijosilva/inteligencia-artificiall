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

    private List<Neuronio> neuronios = new ArrayList<Neuronio>();

    private double[][] W; //matriz de pesos
    private double[] I; //vetor de entradas ponderadas
    private double[] Y; //vetor de saídas
    private double[] S;//gradiente local
    private double deriv;
    private final double BETA = 0.5;

    private double bias;
    private int qtdNeuronios;
    private int qtdEntradas;

    public Camada(int qtdNeuronios, int qtdEntradas) {
        this.qtdNeuronios = qtdNeuronios;
        this.qtdEntradas = qtdEntradas;
        I = new double[qtdNeuronios];
        Y = new double[qtdNeuronios];
        inicializarNeuronios();
        inicializarMatrizPesos();
    }

    private void inicializarNeuronios() {
        for (int i = 0; i < qtdNeuronios; i++) {
            neuronios.add(new Neuronio());
        }
    }

    private void inicializarMatrizPesos() {

        W = new double[qtdNeuronios][qtdEntradas];
        for (int i = 0; i < qtdNeuronios; i++) {
            for (int j = 0; j < qtdEntradas; j++) {
                W[i][j] = 1 * (double) Math.random();

            }
        }
    }

    protected void processar(double[] x) {
        ponderarEntradas(concatenarBias(x));
        for (int i = 0; i < neuronios.size(); i++) {
            neuronios.get(i).processar(I[i]);
        }
        setSaida();
    }

    private void ponderarEntradas(double[] entradas) {
        for (int i = 0; i < qtdNeuronios; i++) {
            for (int j = 0; j < (qtdEntradas + 1); j++) {
                    I[i] += entradas[j] * W[i][j];
            }
        }
        arredondarI();
    }

    private void arredondarI()
    {
        for (int i = 0; i < I.length; i++) {
            I[i] = arredondar(I[i]);
        }
    }

    private void arredondarY()
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


     private double[] calcularGradienteLocalCamadaDeSaida(double[] saidaDesejada){

         //calculo da camada de saída
         S = new double[qtdNeuronios];
         for(int i=0; i<qtdNeuronios; i++){
            S[i] = (saidaDesejada[i] - Y[i]) * Neuronio.derivada(I[i]);
         }
         return S;
     }

     private double[] calcularGradienteLocalCamadaIntermediária(Camada proxima){

         //calculo da camada de saída
         S = new double[qtdNeuronios];
         for(int i=0; i<qtdNeuronios; i++){
             for (int j = 0; j < proxima.getQtdNeuronios(); j++) {
                S[i] += ( proxima.S[j] * proxima.W[j][i] ) * Neuronio.derivada(I[i]); // A formula é difente pq já envolve o resultado do gradiente anterior
            }
         }
         return S;
     }

//     private double derivada(double entrada){//entrada: entrada poderada do j-essimo neuronio da camada L
//
//         deriv = BETA*sigmoide(entrada)*(1-sigmoide(entrada));
//         return deriv;
//     }

//     private double sigmoide(double x){
//        return Math.tanh(x);
//    }

     private void ajustarMatrizPesos(double[] entradas) {//num sei se tá certo n...

        for (int i = 0; i < qtdNeuronios; i++) {
            for (int j = 0; j < qtdEntradas; j++) {
                W[i][j] = W[i][j] + Perceptron.TAXA_APRENDIZAGEM * S[i] * entradas[j];

            }
        }
    }
//metodo de ajuste de pesos do outro perceptron, só pra a gente comparar mesmo e v se segue a msm idéia
//      public void atualizarPeso(int i, double saida) {
//        w[0] = w[0] + taxaAprendizagem *(x[i][4] - saida)* x[i][0];
//        w[1] = w[1] + taxaAprendizagem *(x[i][4] - saida)* x[i][1];
//        w[2] = w[2] + taxaAprendizagem *(x[i][4] - saida)* x[i][2];
//        w[3] = w[3] + taxaAprendizagem *(x[i][4] - saida)* x[i][3];
//       // System.out.println("normalizado " + w[0] + " "+ w[1] + " " + w[2] + " "+ w[3]);
//    }





    public int getQtdNeuronios() {
        return this.qtdNeuronios;
    }

    public int getQtdEntradas() {
        return this.qtdEntradas;
    }

    public double getPeso(int i, int j) {
        return W[i][j];
    }

    public Neuronio getNeuronio(int i) {
        return neuronios.get(i);
    }

    public double[] getSaida() {
        return Y;
    }

    protected double[] getI()
    {
        return I;
    }

    protected double[] getS()
    {
        return S;
    }

    private void setSaida() {
        for (int i = 0; i < neuronios.size(); i++) {
            Y[i] = neuronios.get(i).getSaida();
        }
        arredondarY();
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
}
