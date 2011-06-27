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
        inicializarVetorPesos();
    }

    private void inicializarNeuronios() {
        for (int i = 0; i < qtdNeuronios; i++) {
            neuronios.add(new Neuronio(qtdEntradas));
        }
    }

    private void inicializarVetorPesos() {
       
        W = new double[qtdNeuronios][qtdEntradas];
        for (int i = 0; i < qtdNeuronios; i++) {
            for (int j = 0; j < qtdEntradas; j++) {
                W[i][j] = 1 * (double) Math.random();
                
            }
        }
    }

    public int getQtdNeuronios()
    {
        return this.qtdNeuronios;
    }

    public int getQtdEntradas()
    {
        return this.qtdEntradas;
    }

    public double getPeso(int i, int j)
    {
        return W[i][j];
    }




}
