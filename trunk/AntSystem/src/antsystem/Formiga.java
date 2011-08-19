/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package antsystem;

/**
 *
 * @author Larissa
 */
public class Formiga {

    private int[] tabuList = new int[AntSystem.QUANTIDADE_CIDADES_DEFAULT];//conjunto de cidades que a formiga ainda tem para visitar
    private int cidadeIncial;

    public Formiga(int cidade){
        this.cidadeIncial = cidade;
        initTabuList();
    }

    public int[] getTabuList() {
        return tabuList;
    }

    private void initTabuList() {
        for(int i=0; i<AntSystem.QUANTIDADE_CIDADES_DEFAULT; i++){
            this.tabuList[i] = i;
        }
    }
    public void retiraCidadeDeTabuList(int cidade){
        tabuList[cidade] = AntSystem.QUANTIDADE_CIDADES_DEFAULT + 1;//para indentificar que esta cidade já foi visitada
    }





}
