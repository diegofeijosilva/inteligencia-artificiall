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
    private double alfaCorteTemperatura;
    private double alfaCorteVolume;
    private double alfaCorte;

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
            vetorPertinencia = new double[varAtual.conjuntos.size()+1];
            fuzificar(x);
            varAtual.preencherMatrizInferencia(i, vetorPertinencia, x);
            x = x + fatorPertinencia;
        }
    }

    public void fuzificar(double x)
    {              
        for(int i = 0; i<varAtual.conjuntos.size(); i++){
            ConjuntoFuzzy conjunto = varAtual.conjuntos.get(i);
            vetorPertinencia[i+1] = conjunto.pertinencia(x);
        }      
    }

    public void mecanismoDeInferencia(double temperaturaEntrada, double volumeEntrada){//fazendo ainda...
        double[][] matrizAgregacao = operador.agregacaoMimimo(variaveisLinguisticas.get(0).matrizInferencia, variaveisLinguisticas.get(1).matrizInferencia);


        regras = new BaseDeRegras(variaveisLinguisticas.get(0).matrizInferencia, variaveisLinguisticas.get(1).matrizInferencia, temperaturaEntrada, volumeEntrada);

        //se eu tiver mais de uma regra ativada eu faço o alfa-corte de cada uma e depois faço a união dos conjuntos
        if (regras.regra1()) {
            //fazer aqui
            System.out.println("regra 1");
        }
        if (regras.regra2()) {
            //fazer aqui
            System.out.println("regra 2");
        }
        if (regras.regra3()) {
            //fazer aqui
            System.out.println("regra 3");
        }
        if (regras.regra4()) {
            //fazer aqui
            System.out.println("regra 4");
        }
        if (regras.regra5()) {
            //fazer aqui
            System.out.println("regra 5");
        }
        if (regras.regra6()) {
            //fazer aqui
            System.out.println("regra 6");
        }
        if (regras.regra7()) {
            //fazer aqui
            System.out.println("regra 7");
        }
        if (regras.regra8()) {
            //fazer aqui
            System.out.println("regra 8");
            alfaCorteTemperatura = regras.valoresRegra8[0];
            alfaCorteVolume = regras.valoresRegra8[1];
            if(alfaCorteTemperatura >= alfaCorteVolume){
                alfaCorte = alfaCorteVolume;
            }
        }
        if (regras.regra9()) {
            //fazer aqui
            System.out.println("regra 9");
        }
    }

    public void desfuzificar()
    {
        centroDeArea();
    }

    public void centroDeArea(){

    }

}
