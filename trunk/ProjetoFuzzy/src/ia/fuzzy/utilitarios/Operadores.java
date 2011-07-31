/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy.utilitarios;

import Jama.Matrix;
import ia.fuzzy.SistemaFuzzy;

/**
 *
 * @author Larissa
 */
public class Operadores {


    //metodo constrói uma matriz resultante de 500X500
    public void composicaoMaxMin(double[][] matrizTemperatura, double[][] matrizVolume){

        double[][] matrizMaxMin = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][SistemaFuzzy.DISCRETIZACAO_DEFAULT];
        double min[] = new double[SistemaFuzzy.QTD_VALORES_LINGUISTICOS_DEFAULT];
        double max;
        int linhaMatrizMaxMin = 0;

        for(int i=0; i<SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++){
            for(int j=0; j<SistemaFuzzy.QTD_VALORES_LINGUISTICOS_DEFAULT; j++){
                min[j] = minimo(matrizTemperatura[linhaMatrizMaxMin][j], matrizVolume[i][j]);
            }            
            max = maximo(min);          
            matrizMaxMin[linhaMatrizMaxMin][i] = max;

            if(i == 499){
                i = 0;
                linhaMatrizMaxMin++;
            }
            if(linhaMatrizMaxMin==499){
                break;
            }
        }
    }

    public double minimo(double x1, double x2){
        if(x1<=x2)
            return x1;
        else if(x1>x2)
            return x2;
        return 2;
    }
     public double maximo(double[] min){
        double aux = min[0];
        for(int i = 1; i <min.length; i++){
            if(min[i] > aux){
                aux = min[i];
            }
        }
        return aux;

    }

    public void implicacaoMandami(){

    }

    public void agregacaoMaximo(){

    }
}
