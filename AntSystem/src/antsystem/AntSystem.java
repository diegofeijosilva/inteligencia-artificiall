/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Larissa
 */
public class AntSystem {

    public static final int QUANTIDADE_CIDADES_DEFAULT = 30;
    public static final int QUANTIDADE_FORMIGAS_DEFAULT = QUANTIDADE_CIDADES_DEFAULT;
    public static final int QUANTIDADE_ITERACOES_DEFAULT = 3000;
    public static final String NOME_ARQUIVO_DEFAULT = "Oliver30.txt";
    public static final double COEFICIENTE_DECAIMENTO_DEFAULT = 0.5;
    public static final int ALFA_DEFAULT = 1;
    public static final int BETA_DEFAULT = 5;
    public static final int Q_DEFAULT = 100;//ordem de magnitude do caminho otimo, que é 420
    public static final int e_DEFAULT = 5;//formigas elitistas
    public static final double FEROMONIO_INICIAL_DEFAULT = 0.000001;

    private List<Formiga> listFormigas = new ArrayList<Formiga>();
    private List<Cidade> listCidades = new ArrayList<Cidade>();
    private int[][] matrizDistancias;
    private double[][] matrizVisibilidade;
    private Arquivo arquivo = new Arquivo();
    private double[][] matrizCoordenadasCidades;
    private double[][] trilhaDeFeromonio;
    private int[] percussoOtimo; //T+
    private int tamanhoPercussoOtimo;//L+


    public AntSystem(){
        //initListFormigas();
        //initListCidades();
        //initTrilhaDeFeromonio();
    }

    private void initListFormigas(){
        for(int i=0; i<QUANTIDADE_FORMIGAS_DEFAULT; i++){
            listFormigas.add(new Formiga(i));
        }
    }

    private void initListCidades(){
        int x=0;//pegar x e y do arquivo
        int y=0;
        matrizCoordenadasCidades = arquivo.lerArquivo(NOME_ARQUIVO_DEFAULT, QUANTIDADE_CIDADES_DEFAULT);
        for(int i=0; i<QUANTIDADE_CIDADES_DEFAULT; i++){
            x = (int) matrizCoordenadasCidades[i][0];
            y = (int) matrizCoordenadasCidades[i][1];
            listCidades.add(new Cidade(x, y));
        }
        calcularDistanciaEntreCidadesEVisibilidade();
    }

    private void calcularDistanciaEntreCidadesEVisibilidade(){
        matrizDistancias = new int[QUANTIDADE_CIDADES_DEFAULT][QUANTIDADE_CIDADES_DEFAULT];
        matrizVisibilidade = new double[QUANTIDADE_CIDADES_DEFAULT][QUANTIDADE_CIDADES_DEFAULT];
        double aux = 0;
        int resultado = 0;
        for(int i=0; i<QUANTIDADE_CIDADES_DEFAULT; i++){         
            for(int j=0; j<QUANTIDADE_CIDADES_DEFAULT; j++){
                if(i==j){
                    matrizDistancias[i][i] = 0;
                    matrizVisibilidade[i][i] = 0;
                }
                else if(matrizDistancias[i][j] == 0){
                    resultado = calcular(listCidades.get(i), listCidades.get(j));
                    matrizDistancias[i][j] = resultado;
                    matrizDistancias[j][i] = resultado;
                    aux = matrizDistancias[i][j];
                    matrizVisibilidade[i][j] = 1/aux;
                    matrizVisibilidade[j][i] = 1/aux;
                }                
            }
        }
    }
    private int calcular(Cidade cidadePartida, Cidade cidadeChegada){
        int x1 = cidadePartida.getX();
        int y1 = cidadePartida.getY();
        int x2 = cidadeChegada.getX();
        int y2 = cidadeChegada.getY();

        double parte1 = Math.pow(x1 - x2, 2);
        double parte2 = Math.pow(y1 - y2, 2);
        int d = (int) Math.sqrt(parte1 + parte2);
        return d;
    }

    private void initTrilhaDeFeromonio(){
        trilhaDeFeromonio = new double[QUANTIDADE_CIDADES_DEFAULT][QUANTIDADE_CIDADES_DEFAULT];
        for(int i=0; i<QUANTIDADE_CIDADES_DEFAULT; i++){
            for(int j=0; j<QUANTIDADE_CIDADES_DEFAULT; j++){
                trilhaDeFeromonio[i][j] = FEROMONIO_INICIAL_DEFAULT;
            }
        }
    }

    public void menorCaminho(){
        initTrilhaDeFeromonio();
        initListFormigas();
        initListCidades();

        percussoOtimo = new int[QUANTIDADE_CIDADES_DEFAULT];
        tamanhoPercussoOtimo = 0;
        int tamanhoPercussoAtual = 0;
        int cidadeCorrente = QUANTIDADE_CIDADES_DEFAULT +1; //valor impossivel de cidade, só para iniciar
        int cidadeEscolhida = QUANTIDADE_CIDADES_DEFAULT +1; //valor impossivel de cidade, só para iniciar
        double[] probabilidade;

        //loop principal
        for(int t=0; t<QUANTIDADE_ITERACOES_DEFAULT; t++){//t representa iterações
            for(int k=0; k<QUANTIDADE_FORMIGAS_DEFAULT; k++){//k representa a formiga
                
                //para a formiga k na iteração t deve ser construido o percusso dela, escolhendo a proxima cidade com a roleta
                for(int i=0; i<QUANTIDADE_CIDADES_DEFAULT-1; i++){
                    cidadeCorrente = listFormigas.get(k).getCidadeCorrente();
                    probabilidade = new double[QUANTIDADE_CIDADES_DEFAULT];
                    probabilidade = calculaProbabilidade(listFormigas.get(k), cidadeCorrente);//passo a formiga atual
                    cidadeEscolhida = roleta(probabilidade);
                    listFormigas.get(k).setTour(cidadeEscolhida);
                    tamanhoPercussoAtual += matrizDistancias[cidadeCorrente][cidadeEscolhida];
                    listFormigas.get(k).setTamanhoDoPercursso(tamanhoPercussoAtual);
                    listFormigas.get(k).setCidadeCorrente(cidadeEscolhida);
                    listFormigas.get(k).retiraCidadeDeTabuList(cidadeEscolhida);
                }
            }
        }

    }
    
    private double[] calculaProbabilidade(Formiga formigaAtual, int cidadeCorrente){

        double[] vetorProbabilidade = new double[QUANTIDADE_CIDADES_DEFAULT];
        int cidadeProvavel = QUANTIDADE_CIDADES_DEFAULT +1; //valor impossivel de cidade, só para iniciar

        for (int i = 0; i < QUANTIDADE_CIDADES_DEFAULT; i++) {
            if (cidadeCorrente != i) {
                cidadeProvavel = i;
                vetorProbabilidade[cidadeProvavel] = funcaoProbabilidade(formigaAtual, cidadeCorrente, cidadeProvavel);
            }
            else
                vetorProbabilidade[i] = 0;
        }
        //somando, para verificar se a probabilidade está correta
        double soma=0;
        for(int i=0; i<QUANTIDADE_CIDADES_DEFAULT; i++){
            soma += vetorProbabilidade[i];
        }
        System.out.println("soma das probabilidades: " + soma + "da formiga " + formigaAtual.getCidadeIncial());
        return vetorProbabilidade;
    }

    private double funcaoProbabilidade(Formiga formigaAtual, int i, int j){
        double resultado = 0;
        double parte1 = 0;
        double parte2 = 0;
        int[] tabuList;
        double aux=0;
        
        tabuList = formigaAtual.getTabuList();
        if(tabuList[j] == QUANTIDADE_CIDADES_DEFAULT+1){//a cidade j já foi visitada
            return 0;
        }
        
        parte1 = Math.pow(trilhaDeFeromonio[i][j], ALFA_DEFAULT) * Math.pow(matrizVisibilidade[i][j], BETA_DEFAULT);
        for(int l=0; l<QUANTIDADE_CIDADES_DEFAULT; l++){

            if(tabuList[l] == l){//ou seja, a cidade l ainda não foi visitada
                aux = Math.pow(trilhaDeFeromonio[i][l], ALFA_DEFAULT) * Math.pow(matrizVisibilidade[i][l], BETA_DEFAULT);
                parte2 += aux;
            }
        }
        resultado = parte1/parte2;
        return resultado;
    }

    private int roleta(double[] probabilidade){
        double[] probabilidadeCopia = new double[QUANTIDADE_CIDADES_DEFAULT];
        probabilidadeCopia = probabilidade.clone();
        Arrays.sort(probabilidade);
        double numeroSorteado;
        double aux = 0;
        numeroSorteado = Math.random()*1;        
        for(int j=0; j<QUANTIDADE_CIDADES_DEFAULT; j++){
            aux +=probabilidade[j];
            if(aux >= numeroSorteado){
                for(int z=0; z<QUANTIDADE_CIDADES_DEFAULT; z++){
                    if(probabilidadeCopia[z]==probabilidade[j])
                        return z;
                }
            }
        }
        return 31;//cidade inexistente
    }


    

}
