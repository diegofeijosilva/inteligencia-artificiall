/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetofuzzy;

import Jama.Matrix;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Larissa
 */
public class SistemaFuzzy {

    public static final int QTD_VARIAVEIS_ENTRADA_DEFAULT = 2;
    public static final int QTD_VARIAVEIS_SAIDA_DEFAULT = 1;
    public static final int DISCRETIZACAO_DEFAULT = 500;

    private List<VariavelLinguistica> variaveisLinguisticas = new ArrayList<VariavelLinguistica>();
    private int qtdVarEntradas;
    private int qtdVarSaida;
    public double[][] matrizInferencia;
    private VariavelLinguistica varAtual;

    public SistemaFuzzy(int varEntradas, int varSaida)
    {
        qtdVarEntradas = varEntradas;
        qtdVarSaida = varSaida;
    }

    public SistemaFuzzy()
    {
        qtdVarEntradas = QTD_VARIAVEIS_ENTRADA_DEFAULT;
        qtdVarSaida = QTD_VARIAVEIS_SAIDA_DEFAULT;

        
    }

    public void criarVariavelLinguistica(String nome, int universoMin, int universoMax, int qtdValoresLinguisticos)
    {
        variaveisLinguisticas.add(new VariavelLinguistica(nome, universoMin, universoMax, qtdValoresLinguisticos));
    }

    public void preFuzificar(String nomeVarLinguistica){

        varAtual = null;
        for(int i = 0; i<variaveisLinguisticas.size(); i++){
            if(variaveisLinguisticas.get(i).getNome().equals(nomeVarLinguistica)){
                varAtual = variaveisLinguisticas.get(i);
            }
        }

        matrizInferencia = new double[DISCRETIZACAO_DEFAULT][varAtual.conjuntos.size()];

    }

    public void fuzificar(String nomeVarLinguistica, double x) //tá incompleto, esse método...sóz fiz começar a idéia.
    {
        preFuzificar(nomeVarLinguistica);

        for(int i = 0; i<varAtual.conjuntos.size(); i++){
            ConjuntoFuzzy conjunto = varAtual.conjuntos.get(i);
            inserirPertinenciaNaMatriz(conjunto.pertinencia(x));
        }
            

    }

    public void inserirPertinenciaNaMatriz(double pert){ //tá incompleto, esse método...sóz fiz começar a idéia.

            for(int j=0; j<DISCRETIZACAO_DEFAULT; j++){
                for(int k=0; k<varAtual.conjuntos.size(); k++){
                    matrizInferencia[j][k] = pert;
                }
            }

    }

    public void desfuzificar()
    {
        centroDeArea();
    }

    public void centroDeArea(){

    }

}
