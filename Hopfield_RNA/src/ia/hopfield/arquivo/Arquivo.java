/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.hopfield.arquivo;

import Jama.Matrix;
import ia.hopfield.Hopfield;

/**
 *
 * @author Neto
 */
public class Arquivo {

    private double[][] matriz_dados;

    public Arquivo(double[][] matriz_dados)
    {
        this.matriz_dados = matriz_dados;
    }

    public int getTotalLinhas()
    {
        return matriz_dados.length;
    }

    public Matrix getPadrao(int index)
    {
        return new Matrix(Hopfield.converterParaMatrizColuna(matriz_dados[index]));
    }

}
