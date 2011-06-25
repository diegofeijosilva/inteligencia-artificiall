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
        System.out.println("\n Pesos iniciais (randomicos)");
        for (int i = 0; i < qtdNeuronios; i++) {//w[0], w[1], w[2], w[3]
            for (int j = 0; j < qtdEntradas; j++) {
                W[i][j] = 1 * (double) Math.random();
                System.out.println("W[" + i + "][" + j + "] = " + W[i][j]);
            }
        }
    }




}
