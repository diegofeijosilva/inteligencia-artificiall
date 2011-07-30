/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy;

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
    private VariavelLinguistica varAtual;
    private int valorDiscretizacao;
    private double[] vetorPertinencia;

    public SistemaFuzzy(int varEntradas, int varSaida, int valorDis)
    {
        qtdVarEntradas = varEntradas;
        qtdVarSaida = varSaida;
        valorDiscretizacao = valorDis;
    }

    public SistemaFuzzy()
    {
        qtdVarEntradas = QTD_VARIAVEIS_ENTRADA_DEFAULT;
        qtdVarSaida = QTD_VARIAVEIS_SAIDA_DEFAULT;
        valorDiscretizacao = DISCRETIZACAO_DEFAULT;
        
    }

    public void criarVariavelLinguistica(String nome, int universoMin, int universoMax, int qtdValoresLinguisticos)
    {
        variaveisLinguisticas.add(new VariavelLinguistica(nome, universoMin, universoMax, qtdValoresLinguisticos));
    }

    public void getVarLinguistica(String nomeVarLinguistica){

        varAtual = null;
        for(int i = 0; i<variaveisLinguisticas.size(); i++){
            if(variaveisLinguisticas.get(i).getNome().equals(nomeVarLinguistica)){
                varAtual = variaveisLinguisticas.get(i);
            }
        }
        varAtual.inicializarMatrizInferencia(valorDiscretizacao, varAtual.conjuntos.size());
    }

    public void discretizar(String nomeVarLinguistica)
    {
        getVarLinguistica(nomeVarLinguistica);
        double fatorPertinencia = 0;
        double x = varAtual.getUniversoMin() + fatorPertinencia;
        double max = varAtual.getUniversoMax();
        double min = varAtual.getUniversoMin();
        fatorPertinencia = (max - min)/500;

        for(int i=0; i<valorDiscretizacao; i++){
            fuzificar(x);
            x = x + fatorPertinencia;
            varAtual.preencherMatrizInferencia(i, vetorPertinencia);
        }
    }

    public void fuzificar(double x)
    {        
        vetorPertinencia = new double[varAtual.conjuntos.size()];     
        for(int i = 0; i<varAtual.conjuntos.size(); i++){
            ConjuntoFuzzy conjunto = varAtual.conjuntos.get(i);
            vetorPertinencia[i] = conjunto.pertinencia(x);
        }      
    }

    public void mecanismoDeInferencia(){

    }

    public void desfuzificar()
    {
        centroDeArea();
    }

    public void centroDeArea(){

    }

}
