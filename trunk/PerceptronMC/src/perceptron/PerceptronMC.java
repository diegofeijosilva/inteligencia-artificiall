/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perceptron;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFileChooser;
/**
 *
 * @author Larissa
 */
public class PerceptronMC {


        double taxaAprendizagem;
        double[] w; //vetor de pesos
        double[][] x;  //matriz com valores de treinamento e saída desejado
        double[][] x2; //matriz com valores de teste
        double y = 0; //saída do Perceptron
        Random rand = new Random();
        double bias = -1.0;
        String file;
        int linhasDados = 0;

    public PerceptronMC(double taxa, int tamW, int treinoC, int treinoL, int testeC, int testeL) {

        taxaAprendizagem = taxa;
        w = new double[tamW]; //vetor de pesos
        x = new double[treinoL][treinoC];  //matriz com valores de treinamento e saída desejado
        x2 = new double[testeL][testeC]; //matriz com valores de teste
        linhasDados = treinoL;

    }
    String pesosFinais  ="";
    String pesosIniciais = "";
    String teste="";

    public void inicializarVetorPesos(int tamW){
        System.out.println("\n Pesos iniciais (randomicos)");
        for (int i = 0; i < tamW; i++) {//w[0], w[1], w[2], w[3]
            w[i] = 1*(double)Math.random();

	}
         System.out.println(w[0] + "\n" + w[1] + "\n" + w[2] + "\n" + w[3]);
         pesosIniciais = "Pesos iniciais (randomicos)\n" + w[0] + "\n" + w[1] + "\n" + w[2] + "\n" + w[3];
    }

    public void treinamento(){

        //obterConjTreino();
        int epoca = 0;
        boolean erro;
        //linhasDados = 30;
        do{
             erro = false;
             for (int i = 0; i < linhasDados; i++) {
                // A saída recebe o resultado da rede que no caso é -1 ou 1
		y = executar(x[i][0], x[i][1], x[i][2], x[i][3]);

                // System.out.println("valor do i " + i);
                if (y != x[i][4]) {
                   atualizarPeso(i, y);
                   erro = true;
                }
            }
            epoca++;
        }while (erro == true);
        System.out.println("\n Epocas: " + epoca);

        System.out.println("\n Vetor de pesos final: \n w[0] = " + w[0] + "\n w[1] = " + w[1]+ "\n w[2] = " + w[2]+ "\n w[3] = " + w[3]+"\n\n");
        pesosFinais = "\n\nPesos Finais \nw[0] = " + w[0] + "\nw[1] = " + w[1]+ "\nw[2] = " + w[2]+ "\nw[3] = " + w[3] ;
    }

    public double executar(double x0, double x1, double x2, double x3) {
		y = (x0 * w[0]) + (x1 * w[1]) + (x2 * w[2]) + (x3 * w[3]);
               // System.out.println("valor do y "+ y);
        // Funcao de Ativação: função sinal
        if (y >= 0) {
            return 1;
        }
        return -1;
    }

    public void testar(){

        teste ="\n\nResultado";
        for (int i = 0; i < 10; i++) {

            y = executar(x2[i][0], x2[i][1], x2[i][2], x2[i][3]);
            
            if (y==(-1)) {
                System.out.println("Padrão "+(i+1)+" Pertence à classe C1! -> y = -1");
                teste = teste.concat("\nPadrão "+(i+1)+" Pertence à classe C1! -> y = -1");
            } else {
                System.out.println("Padrão "+(i+1)+" Pertence à classe C2! -> y = 1");
                teste = teste.concat("\nPadrão "+(i+1)+" Pertence à classe C2! -> y = 1");
            }

        }
    }

    public void atualizarPeso(int i, double saida) {

        w[0] = w[0] + taxaAprendizagem *(x[i][4] - saida)* x[i][0];
        w[1] = w[1] + taxaAprendizagem *(x[i][4] - saida)* x[i][1];
        w[2] = w[2] + taxaAprendizagem *(x[i][4] - saida)* x[i][2];
        w[3] = w[3] + taxaAprendizagem *(x[i][4] - saida)* x[i][3];
       // System.out.println("normalizado " + w[0] + " "+ w[1] + " " + w[2] + " "+ w[3]);
    }

    double[][] matriz;
    public void executarTreino(PerceptronMC p, Arquivo a, int treinocolunas, int treinolinhas, int tampesos){
     matriz = a.lerArquivo(treinocolunas, treinolinhas, "dados.txt");
     p.x = matriz;
     p.inicializarVetorPesos(tampesos);
     p.treinamento();
    }

    public void executarTeste(PerceptronMC p, Arquivo a, int testecolunas, int testelinhas, int tampesos){
     matriz = a.lerArquivo(testecolunas, testelinhas, "teste.txt");
     p.x2 = matriz;
    // p.lerArquivoTeste();
    // p.normalizarMatrizTeste();
     p.testar();
    }
}
