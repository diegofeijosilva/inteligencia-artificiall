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

     double[][] x;

     public double[][] lerArquivo(int colunas, int linhas, String arquivo){
        x = new double[linhas][colunas];  //matriz com valores de treinamento e saída desejado
        int count = 0;
        try {
        BufferedReader in = new BufferedReader(new FileReader(arquivo));
            String str;
            while (in.ready() &&  count <linhas) {
                str = in.readLine();

                    montaMatriz(str, count, colunas, linhas);

                count++;

            }
            in.close();
           // linhasDados = count;
           return x;

        } catch (IOException e) {
        }
        return null;
    }

    private void montaMatriz(String linhaString, int count, int c, int l) {

        
        String[] partes = new String[c];
        double num;
           partes = linhaString.split(" ");

           for(int j = 0; j<c; j++){
                num = Double.parseDouble(partes[j]);
                x[count][j] = num;
                System.out.println("matriz ["+count+"]["+j+"] " + x[count][j]);
            }
       
    }

   public double[][] retornaX(){
       return x;
   }



}
