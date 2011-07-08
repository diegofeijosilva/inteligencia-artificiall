/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.hopfield.arquivo;

import Jama.Matrix;
import ia.hopfield.Utils;

/**
 *
 * @author Neto
 */
public class Arquivo {

    private double[][] matriz_dados;

    private int linhas;

    public Arquivo(double[][] matriz_dados)
    {
        this.matriz_dados = matriz_dados;
    }

    protected void setLinhas(int linhas)
    {
        this.linhas = linhas;
    }

    public int getTotalLinhas()
    {
        return matriz_dados.length;
    }

    public Matrix getPadrao(int index)
    {
        //return Utils.copiarVetor(matriz_dados[index]);
        return new Matrix(Utils.converterParaMatrizColuna(matriz_dados[index]));
    }

}
