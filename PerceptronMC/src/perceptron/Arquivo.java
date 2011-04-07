/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package perceptron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Larissa
 */
public class Arquivo {



     public void lerArquivo(int colunas, int linhas, String arquivo){

        int count = 0;
        try {
        BufferedReader in = new BufferedReader(new FileReader(arquivo));
            String str;
            while (in.ready()) {
                str = in.readLine();

                    montaMatriz(str, count, colunas, linhas);

                count++;

            }
            in.close();
           // linhasDados = count;

        } catch (IOException e) {
        }
    }

    private double[][] montaMatriz(String linhaString, int count, int c, int l) {

        double[][] x = new double[l][c];  //matriz com valores de treinamento e saída desejado
        String[] partes = new String[c];
        double num;
           partes = linhaString.split(" ");

           for(int j = 0; j<c; j++){
                num = Double.parseDouble(partes[j]);
                x[count][j] = num;
                System.out.println("matriz ["+count+"]["+j+"] " + x[count][j]);
            }
       return x;
    }



}
