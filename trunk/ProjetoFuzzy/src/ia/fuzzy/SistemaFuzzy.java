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
        int valor, valor2;

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
        centroDeArea();
    }

    private void unirConjuntos(double[][] matriz1){

        double[][] matrizAux = new double[DISCRETIZACAO_DEFAULT][QTD_VALORES_LINGUISTICOS_DEFAULT];

        for (int i = 0; i < SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++) {
                for (int j = 1; j < QTD_VALORES_LINGUISTICOS_DEFAULT + 1; j++) {
                    if(matrizPressaoUniao[i][j] < matriz1[i][j]){
                        matrizPressaoUniao[i][j] = matriz1[i][j];
                    }                    
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
