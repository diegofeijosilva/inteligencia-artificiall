/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy;

import ia.fuzzy.utilitarios.BaseDeRegras;
import ia.fuzzy.utilitarios.Operadores;
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
    public static final int QTD_VALORES_LINGUISTICOS_DEFAULT = 3;

    private List<VariavelLinguistica> variaveisLinguisticas = new ArrayList<VariavelLinguistica>();
    private Operadores operador = new Operadores();
    private BaseDeRegras regras;

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
    public void criarVariavelLinguistica(String nome, int universoMin, int universoMax)
    {
        variaveisLinguisticas.add(new VariavelLinguistica(nome, universoMin, universoMax, QTD_VALORES_LINGUISTICOS_DEFAULT));
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

    public void mecanismoDeInferencia(double temperaturaEntrada, double volumeEntrada){//fazendo ainda...
        double[][] matrizAgregacao = operador.agregacaoMimimo(variaveisLinguisticas.get(0).matrizInferencia, variaveisLinguisticas.get(1).matrizInferencia);
        regras = new BaseDeRegras(variaveisLinguisticas.get(0).matrizInferencia, variaveisLinguisticas.get(1).matrizInferencia, temperaturaEntrada, volumeEntrada);

       if(regras.regra1()){
           //fazer aqui
       }
       if(regras.regra2()){
           //fazer aqui
       }
       if(regras.regra3()){
           //fazer aqui
       }
       if(regras.regra4()){
           //fazer aqui
       }
       if(regras.regra5()){
           //fazer aqui
       }
       if(regras.regra6()){
           //fazer aqui
       }
       if(regras.regra7()){
           //fazer aqui
       }
       if(regras.regra8()){
           //fazer aqui
       }
       if(regras.regra9()){
           //fazer aqui
       }
    }

    public void desfuzificar()
    {
        centroDeArea();
    }

    public void centroDeArea(){

    }

}
