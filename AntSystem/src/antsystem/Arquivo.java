/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Larissa
 */
public class Arquivo {

    public static final int COLUNAS_ARQUIVO_DEFAULT = 2;

    public double[][] lerArquivo( String arquivo, int linhas ) {
        int colunas = COLUNAS_ARQUIVO_DEFAULT;
        double[][] dados = new double[linhas][colunas];

        try {
            BufferedReader in = new BufferedReader(new FileReader(arquivo));
            String str;
            int count = 0;

            while (in.ready() && count < linhas) {
                str = in.readLine();
                dados[count] = montarLinha(str, colunas);

                count++;
            }
            in.close();

            return dados;

        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    private double[] montarLinha(String linhaString, int colunas) {
        String[] partes = new String[colunas];
        double[] resultado = new double[colunas];

        partes = linhaString.split(" ");

        for (int j = 0; j < colunas; j++) {
            resultado[j] = Double.parseDouble(partes[j]);
        }
        return resultado;
    }

}
