/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antsystem;

/**
 *
 * @author Larissa
 */
public class Feromonio {
    
    public static final double FEROMONIO_INICIAL_DEFAULT = 0.000001;
    public double[][] trilhaDeFeromonio;
    private double[][] matrizVariacaoFeromonio;
    private String dePara;

    public void initTrilhaDeFeromonio(){
        trilhaDeFeromonio = new double[AntSystem.QUANTIDADE_CIDADES_DEFAULT][AntSystem.QUANTIDADE_CIDADES_DEFAULT];
        for(int i=0; i<AntSystem.QUANTIDADE_CIDADES_DEFAULT; i++){
            for(int j=0; j<AntSystem.QUANTIDADE_CIDADES_DEFAULT; j++){
                trilhaDeFeromonio[i][j] = FEROMONIO_INICIAL_DEFAULT;
            }
        }
    }

    public double[][] calculaVariacaoFeromonio(Formiga formiga){
        matrizVariacaoFeromonio = new double[AntSystem.QUANTIDADE_FORMIGAS_DEFAULT][AntSystem.QUANTIDADE_FORMIGAS_DEFAULT];
        int[] tourDaFormiga = new int[AntSystem.QUANTIDADE_FORMIGAS_DEFAULT];
        tourDaFormiga = formiga.getTour();
        int i;//cidade origem
        int j;//cidade destino
        //dePara = "";
        double resultado = 0;
        double Q = AntSystem.Q_DEFAULT;
        double tamPercusso = formiga.getTamanhoDoPercursso();
        for(int k=0; k<AntSystem.QUANTIDADE_FORMIGAS_DEFAULT-1; k++){
            i = tourDaFormiga[k];
            j = tourDaFormiga[k+1];
            resultado =  Q/tamPercusso;
            matrizVariacaoFeromonio[i][j] = resultado;
            matrizVariacaoFeromonio[j][i] = resultado;
           // dePara = dePara + Integer.toString(i) + "." + Integer.toString(j) + ".";
        }
        return matrizVariacaoFeromonio;
    }

    public double[][] calculaVariacaoFeromonioElitista(int tamPercurssoOtimo, int[] percussoOtimo){
        double[][] matrizVariacaoFeromonioElitista = new double[AntSystem.QUANTIDADE_FORMIGAS_DEFAULT][AntSystem.QUANTIDADE_FORMIGAS_DEFAULT];
        int i;//cidade origem
        int j;//cidade destino
        double resultado = 0;
        double Q = AntSystem.Q_DEFAULT;
        for(int k=0; k<AntSystem.QUANTIDADE_FORMIGAS_DEFAULT-1; k++){
            i = percussoOtimo[k];
            j = percussoOtimo[k+1];
            resultado =  Q/tamPercurssoOtimo;
            matrizVariacaoFeromonioElitista[i][j] = resultado;
            matrizVariacaoFeromonioElitista[i][j] = resultado;  
        }
        return matrizVariacaoFeromonioElitista;
    }


    public String getDePara() {
        return dePara;
    }








}

