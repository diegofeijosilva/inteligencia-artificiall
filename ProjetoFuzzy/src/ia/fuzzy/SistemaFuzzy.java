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
    private MecanismoInferencia mecanismo;
    private double[][] matrizPressaoUniao;
    private int qtdVarEntradas;
    private int qtdVarSaida;
    private VariavelLinguistica varAtual;
    private int valorDiscretizacao;
    private double[] vetorPertinencia;
    private double alfaCorte;    
    private double[] regrasAtivadas = new double[9];
    private double pressaoValorEncontrado;

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
        varAtual.inicializarMatrizInferencia(valorDiscretizacao, varAtual.conjuntos.size()+1);
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

    public void executarMecanismoInferencia(double temperaturaEntrada, double volumeEntrada){
        mecanismo = new MecanismoInferencia(variaveisLinguisticas);
        mecanismo.tratarRegras(temperaturaEntrada, volumeEntrada);
        String regrasAtivadas = mecanismo.getRegrasAtivadas();
        String[] qtdDeRegras = regrasAtivadas.split("\\.");
        int tam = qtdDeRegras.length;
        int valor;

        if (qtdDeRegras.length == 1) {
            valor = Integer.parseInt(qtdDeRegras[0]);
            matrizPressaoUniao = mecanismo.getMatrizPressaoComAlfaCorte(valor);
        }
        else{
            valor = Integer.parseInt(qtdDeRegras[0]);
            matrizPressaoUniao = mecanismo.getMatrizPressaoComAlfaCorte(valor);
            for(int i = 0; i < tam-1; i++){
               valor = Integer.parseInt(qtdDeRegras[i+1]);
               unirConjuntos(mecanismo.getMatrizPressaoComAlfaCorte(valor));
            }
        }
        //pronto agora já tnho a matriz união, é só fazer o centro de area.
        pressaoValorEncontrado = centroDeArea();
        System.out.println("Valor de pressão encontrado: " + pressaoValorEncontrado);
    }

    private void unirConjuntos(double[][] matriz1){        
        for (int i = 0; i < SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++) {        
                    if(matrizPressaoUniao[i][1] < matriz1[i][1]){
                        matrizPressaoUniao[i][1] = matriz1[i][1];
                    }                                   
            }
    }
    

    public double centroDeArea(){
        double dividendo = 0;
        double divisor = 0;
        for (int i = 0; i < SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++) {
                    dividendo += matrizPressaoUniao[i][0] * matrizPressaoUniao[i][1];
                    divisor += matrizPressaoUniao[i][1];
        }
        return dividendo/divisor;
    }

//    private double maiorValor(int i){
//        if(matrizPressaoUniao[i][1] >= matrizPressaoUniao[i][2] && matrizPressaoUniao[i][1] >= matrizPressaoUniao[i][3]){
//            return matrizPressaoUniao[i][1];
//        }
//        else if(matrizPressaoUniao[i][2] >= matrizPressaoUniao[i][1] && matrizPressaoUniao[i][2] >= matrizPressaoUniao[i][3]){
//            return matrizPressaoUniao[i][2];
//        }
//        else if(matrizPressaoUniao[i][3] >= matrizPressaoUniao[i][1] && matrizPressaoUniao[i][3] >= matrizPressaoUniao[i][2]){
//            return matrizPressaoUniao[i][3];
//        }
//        return 2;
//    }

}