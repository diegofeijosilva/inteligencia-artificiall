package ia.perceptron;

import java.util.ArrayList;
import java.util.List;
import perceptron.Arquivo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Larissa
 */
public class Perceptron {

    private List<Camada> camadas = new ArrayList<Camada>();
    private double x[] = new double[4];
    

    public void criarCamada(int neoroniosCamadas, int entradasCamada) {
        camadas.add(new Camada(neoroniosCamadas, entradasCamada));
    }

    public void teste(){

        int neoroniosCamadas1 = 15;
        int entradasCamada1 = 5; //4 + o bias
        int neoroniosCamadas2 = 3;
        int entradasCamada2 = 4; //3 + o bias
        int colunas = 8, linhas = 130;
        String nomeArquivo = "treina.txt";

        double[][] matriz;
        double[][] matrizDeEntradas;
        

        criarCamada(neoroniosCamadas1, entradasCamada1);
        criarCamada(neoroniosCamadas2, entradasCamada2);

        
        Arquivo arquivo = new Arquivo();
        matriz = arquivo.lerArquivo(colunas, linhas, nomeArquivo);

        matrizDeEntradas = new double[linhas][entradasCamada1];
        preencheMatriz(linhas, entradasCamada1, matrizDeEntradas, matriz);


        
  }

    private void preencheMatriz(int linhas, int colunas, double[][] matrizDeEntradas, double[][] matriz){
        for(int i = 0; i<linhas; i++){
            for(int j = 0; j<colunas; j++)
                matrizDeEntradas[i][j] = matriz[i][j];
            }
    }

    
}
