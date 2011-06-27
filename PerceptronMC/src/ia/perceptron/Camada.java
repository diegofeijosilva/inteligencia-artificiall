package ia.perceptron;

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
    private int qtdNeuronios;
    private int qtdEntradas;

    public Camada(int qtdNeuronios, int qtdEntradas) {
        this.qtdNeuronios = qtdNeuronios;
        this.qtdEntradas = qtdEntradas;
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
            for (int j = 0; j < qtdEntradas; j++) {
                I[i] += entradas[j] * W[i][j];
            }
        }
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
    }
}
