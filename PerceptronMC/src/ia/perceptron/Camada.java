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
    private double[][] W;
    private double[] I;
    private double[] Y;
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
        ponderarEntradas(x);

        for (int i = 0; i < neuronios.size(); i++) {
            neuronios.get(i).processar(I[i]);
        }
        setSaida();
    }

    private void ponderarEntradas(double[] entradas) {
        for (int i = 0; i < qtdNeuronios; i++) {
            for (int j = 0; j < (qtdEntradas + 1); j++) {
                if(j==0) {
                    I[i] += bias * W[i][j];
                }
                else {
                    I[i] += entradas[j-1] * W[i][j];
                }
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

    protected double[] getI()
    {
        return I;
    }

    protected void setBias(double bias)
    {
        this.bias = bias;
    }
}
