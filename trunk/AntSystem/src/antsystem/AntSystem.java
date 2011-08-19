/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Larissa
 */
public class AntSystem {

    public static final int QUANTIDADE_CIDADES_DEFAULT = 30;
    public static final int QUANTIDADE_ITERACOES_DEFAULT = 3000;
    public static final String NOME_ARQUIVO_DEFAULT = "Oliver30.txt";

    private List<Formiga> listFormigas = new ArrayList<Formiga>();
    private List<Cidade> listCidades = new ArrayList<Cidade>();
    private int[][] matrizDistancias;
    private Arquivo arquivo = new Arquivo();
    private double[][] matrizCoordenadasCidades;


    public AntSystem(){
        initListFormigas();
        initListCidades();
        calcularDistanciaEntreCidades();
    }

    private void initListFormigas(){
        for(int i=0; i<QUANTIDADE_CIDADES_DEFAULT; i++){
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
    }

    private void calcularDistanciaEntreCidades(){
        matrizDistancias = new int[QUANTIDADE_CIDADES_DEFAULT][QUANTIDADE_CIDADES_DEFAULT];

        for(int i=0; i<QUANTIDADE_CIDADES_DEFAULT; i++){
            matrizDistancias[i][i] = 0;
            for(int j=1; j<QUANTIDADE_CIDADES_DEFAULT; j++){
                matrizDistancias[i][j] = calcular(listCidades.get(i), listCidades.get(j));
            }
        }
    }
    private int calcular(Cidade cidadePartida, Cidade cidadeChegada){
        int x1 = cidadePartida.getX();
        int y1 = cidadePartida.getY();
        int x2 = cidadeChegada.getX();
        int y2 = cidadeChegada.getY();

        int d = 0;
        //fazer calculo
        return d;
    }



}
