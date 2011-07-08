/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.hopfield;

import java.math.BigDecimal;

/**
 *
 * @author Neto
 */
public class Utils {

    public static double[] copiarVetor(double[] vetor)
    {
        double[] copia = new double[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            copia[i] = vetor[i];
        }
        return copia;

    }

    public static double[][] copiarMatriz(double[][] matriz)
    {
        double[][] copia = new double[matriz.length][matriz[0].length];
        for (int i = 0; i < copia.length; i++) {
            for (int j = 0; j < copia[0].length; j++) {
                copia[i][j] = matriz[i][j];
            }
        }
        return copia;
    }

    public static double[][] converterParaMatrizColuna(double[] vetor)
    {
        double[][] matriz = new double[vetor.length][1];
        for (int i = 0; i < vetor.length; i++) {
            matriz[i][0] = vetor[i];
        }
        return matriz;
    }

     public static double arredondar(double num, int casasDecimais) {
        int decimalPlace = casasDecimais;
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(decimalPlace,BigDecimal.ROUND_HALF_UP);
        num = bd.doubleValue();
        return num;
    }

}
