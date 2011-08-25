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

    private Feromonio feromonio;
    private List<Formiga> listFormigas;
    private List<Cidade> listCidades = new ArrayList<Cidade>();
    private Arquivo arquivo = new Arquivo();
    private int[][] matrizDistancias;
    private double[][] matrizVisibilidade;   
    private double[][] matrizCoordenadasCidades;
    private double[][] matrizVariacaoFeromonioSoma;
    private int[] PERCUSSO_OTIMO; //T+
    private int TAMANHO_PERCURSSO_OTIMO;//L+


    public AntSystem(){
        //initListFormigas();
        //initListCidades();
        //initTrilhaDeFeromonio();
    }

    private void initListFormigas(){
        listFormigas = new ArrayList<Formiga>();
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
        feromonio = new Feromonio();
        feromonio.initTrilhaDeFeromonio();
    }

    public void menorCaminho(){
        initTrilhaDeFeromonio();
        //initListFormigas();
        initListCidades();

        PERCUSSO_OTIMO = new int[QUANTIDADE_CIDADES_DEFAULT];
        TAMANHO_PERCURSSO_OTIMO = 0;

        int tamanhoPercussoAtual = 0;
        int cidadeCorrente = QUANTIDADE_CIDADES_DEFAULT +1; //valor impossivel de cidade, só para iniciar
        int cidadeEscolhida = QUANTIDADE_CIDADES_DEFAULT +1; //valor impossivel de cidade, só para iniciar
        double[] probabilidade;

        //loop principal
        //for(int t=0; t<QUANTIDADE_ITERACOES_DEFAULT; t++){//t representa iterações
        for(int t=0; t<3000; t++){//t representa iterações
            initListFormigas();
            System.out.println("Iteração: " + t);
            for(int k=0; k<QUANTIDADE_FORMIGAS_DEFAULT; k++){//k representa a formiga               
                tamanhoPercussoAtual = 0;
                //para a formiga k na iteração t deve ser construido o percusso dela, escolhendo a proxima cidade com a roleta
                for(int i=0; i<QUANTIDADE_CIDADES_DEFAULT-1; i++){
                    cidadeCorrente = listFormigas.get(k).getCidadeCorrente();
                    probabilidade = new double[QUANTIDADE_CIDADES_DEFAULT];
                    probabilidade = calculaProbabilidade(listFormigas.get(k), cidadeCorrente);//passo a formiga atual
                    cidadeEscolhida = roleta(probabilidade);
                    while( cidadeEscolhida == 31 || cidadeJaFoiEscolhida(cidadeEscolhida, listFormigas.get(k))){
                        int[] tabu;
                        if(listFormigas.get(k).getQtdCidadesQueFaltamVisitar() == 1){
                            for(int h=0; h<QUANTIDADE_CIDADES_DEFAULT; h++){
                                tabu = listFormigas.get(k).getTabuList();
                                if(tabu[h] != 31){
                                    cidadeEscolhida = tabu[h];
                                }
                            }
                        }

                        //cidadeEscolhida = roleta(probabilidade);
                    }
                    listFormigas.get(k).setTour(cidadeEscolhida);
                    if(  (cidadeCorrente < 0 || cidadeCorrente >30)  || (cidadeEscolhida <0 || cidadeEscolhida >30) ){
                        System.out.println("erro");
                    }
                    tamanhoPercussoAtual += matrizDistancias[cidadeCorrente][cidadeEscolhida];                    
                    listFormigas.get(k).setTamanhoDoPercursso(tamanhoPercussoAtual);
                    listFormigas.get(k).setCidadeCorrente(cidadeEscolhida);
                    listFormigas.get(k).retiraCidadeDeTabuList(cidadeEscolhida);
                }
                tamanhoPercussoAtual += matrizDistancias[cidadeEscolhida][listFormigas.get(k).getCidadeIncial()];
                listFormigas.get(k).setTamanhoDoPercursso(tamanhoPercussoAtual);
                if(t==1000){
                    System.out.println("1000");
                }
            }
            //agora pegar o melhor tamanho do percursso e o melhor percursso dessa iteraçao
            int tamanhoPercussoOtimoDessaIteracao = listFormigas.get(0).getTamanhoDoPercursso();
            int percurssoAux = 0;
            int formidaDePercurssoOtimoDessaIteracao = 0;
            int[] percurssoOtimoDessaIteracao = new int[QUANTIDADE_CIDADES_DEFAULT];
            for(int k=1; k<QUANTIDADE_FORMIGAS_DEFAULT; k++){
                percurssoAux = listFormigas.get(k).getTamanhoDoPercursso();
                if(tamanhoPercussoOtimoDessaIteracao > percurssoAux ){
                    tamanhoPercussoOtimoDessaIteracao = percurssoAux;
                    formidaDePercurssoOtimoDessaIteracao = k;
                }
            }
            percurssoOtimoDessaIteracao = listFormigas.get(formidaDePercurssoOtimoDessaIteracao).getTour();

            //agora tem que comparar se o percursso otimo geral é menor que o percursso dessa iteração
            if(t==0){
                TAMANHO_PERCURSSO_OTIMO = tamanhoPercussoOtimoDessaIteracao;
                PERCUSSO_OTIMO = percurssoOtimoDessaIteracao;
            }
            else if(TAMANHO_PERCURSSO_OTIMO > tamanhoPercussoOtimoDessaIteracao){
                TAMANHO_PERCURSSO_OTIMO = tamanhoPercussoOtimoDessaIteracao;
                PERCUSSO_OTIMO = percurssoOtimoDessaIteracao;
            }

            //agora é necessário atualizar a trilha de feromonio

            //calculando a variação do feromonio
            matrizVariacaoFeromonioSoma = new double[QUANTIDADE_FORMIGAS_DEFAULT][QUANTIDADE_FORMIGAS_DEFAULT];
            double[][] matrizVariacaoFeromonio = new double[QUANTIDADE_FORMIGAS_DEFAULT][QUANTIDADE_FORMIGAS_DEFAULT];
            String cidadeOrigemDestino = "";
            for(int i=0; i<QUANTIDADE_FORMIGAS_DEFAULT; i++){
                matrizVariacaoFeromonio = feromonio.calculaVariacaoFeromonio(listFormigas.get(i));                
                int origem, destino;
                for(int j=0; j<QUANTIDADE_FORMIGAS_DEFAULT-1; j++){
                    origem = listFormigas.get(i).getTour()[j];
                    destino = listFormigas.get(i).getTour()[j+1];
                    matrizVariacaoFeromonioSoma[origem][destino] += matrizVariacaoFeromonio[origem][destino];
                    matrizVariacaoFeromonioSoma[destino][origem] += matrizVariacaoFeromonio[origem][destino];
                }
            }

            //calcular variacao do feromonio da formiga elitista
            double[][] matrizFormigasElitista = new double[QUANTIDADE_CIDADES_DEFAULT][QUANTIDADE_CIDADES_DEFAULT];
            matrizFormigasElitista = feromonio.calculaVariacaoFeromonioElitista(TAMANHO_PERCURSSO_OTIMO, PERCUSSO_OTIMO);

            //atualizar o feromonio agora
            double calc1, calc2, calc3;
            for(int i=0; i<QUANTIDADE_CIDADES_DEFAULT; i++){
                for(int j=0; j<QUANTIDADE_CIDADES_DEFAULT; j++){
                    calc1 = 1-COEFICIENTE_DECAIMENTO_DEFAULT;
                    calc2 = calc1 *feromonio.trilhaDeFeromonio[i][j];
                    calc3 = calc2 + matrizVariacaoFeromonioSoma[i][j];
                    feromonio.trilhaDeFeromonio[i][j] = calc3 + e_DEFAULT*matrizFormigasElitista[i][j];
                }
            }

        }        
    }

    private boolean cidadeJaFoiEscolhida(int cidadeEscolhida, Formiga formiga){

        int[] tabuList = formiga.getTabuList();
        if(cidadeEscolhida == tabuList[cidadeEscolhida]){
                return false;
        }
        return true;
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
        //System.out.println("soma das probabilidades: " + soma + "da formiga " + formigaAtual.getCidadeIncial());
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
        
        parte1 = Math.pow(feromonio.trilhaDeFeromonio[i][j], ALFA_DEFAULT) * Math.pow(matrizVisibilidade[i][j], BETA_DEFAULT);
        for(int l=0; l<QUANTIDADE_CIDADES_DEFAULT; l++){
            if(tabuList[l] == l && l !=i){//ou seja, a cidade l ainda não foi visitada
                aux = Math.pow(feromonio.trilhaDeFeromonio[i][l], ALFA_DEFAULT) * Math.pow(matrizVisibilidade[i][l], BETA_DEFAULT);
                parte2 += aux;
            }
        }
        if(parte2 == 0){
            return 0;
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

    public int[] getPercurssoOtimo(){
        return this.PERCUSSO_OTIMO;
    }
    public int getTamanhoPercurssoOtimo(){
        return this.TAMANHO_PERCURSSO_OTIMO;
    }

    

}
