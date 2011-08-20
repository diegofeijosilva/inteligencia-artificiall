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

    private int[] tabuList;//conjunto de cidades que a formiga ainda tem para visitar
    private int qtdCidadesQueFaltamVisitar;
    private int cidadeIncial;
    private int cidadeCorrente;
    private int[] tour;
    private int posicaoTour;
    private int tamanhoDoPercursso;

    public Formiga(int cidade){
        this.cidadeIncial = cidade;        
        this.tamanhoDoPercursso = 0;
        this.cidadeCorrente = cidadeIncial;
        this.posicaoTour = 0;
        this.qtdCidadesQueFaltamVisitar = 29;
        initTabuList();
        initTour();
    }

    private void initTour(){
        this.tour = new int[AntSystem.QUANTIDADE_CIDADES_DEFAULT];
        tour[posicaoTour] = cidadeIncial;
        posicaoTour++;
    }
    
    public int[] getTabuList() {
        return tabuList;
    }

    private void initTabuList() {
        tabuList = new int[AntSystem.QUANTIDADE_CIDADES_DEFAULT];
        for(int i=0; i<AntSystem.QUANTIDADE_CIDADES_DEFAULT; i++){
            this.tabuList[i] = i;
        }
        retiraCidadeDeTabuList(cidadeIncial);//isso pq no inicio tabulist tem todas as cidades menos a cidade que a formiga está.
    }

    public void retiraCidadeDeTabuList(int cidade){
        tabuList[cidade] = AntSystem.QUANTIDADE_CIDADES_DEFAULT + 1;//para indentificar que esta cidade já foi visitada
        qtdCidadesQueFaltamVisitar--;
    }


    public int getTamanhoDoPercursso() {
        return tamanhoDoPercursso;
    }

    public void setTamanhoDoPercursso(int tamanhoDoPercursso) {
        this.tamanhoDoPercursso = tamanhoDoPercursso;
    }

    public int[] getTour() {
        return tour;
    }

    public void setTour(int cidadeVisitada) {
        this.tour[posicaoTour] = cidadeVisitada;
        posicaoTour++;
    }

    public int getCidadeIncial() {
        return cidadeIncial;
    }
    
    public int getCidadeCorrente() {
        return cidadeCorrente;
    }

    public void setCidadeCorrente(int cidadeCorrente) {
        this.cidadeCorrente = cidadeCorrente;
    }

    public int getQtdCidadesQueFaltamVisitar() {
        return qtdCidadesQueFaltamVisitar;
    }


}
