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

    public void initTrilhaDeFeromonio(){
        trilhaDeFeromonio = new double[AntSystem.QUANTIDADE_CIDADES_DEFAULT][AntSystem.QUANTIDADE_CIDADES_DEFAULT];
        for(int i=0; i<AntSystem.QUANTIDADE_CIDADES_DEFAULT; i++){
            for(int j=0; j<AntSystem.QUANTIDADE_CIDADES_DEFAULT; j++){
                trilhaDeFeromonio[i][j] = FEROMONIO_INICIAL_DEFAULT;
            }
        }
    }

}
