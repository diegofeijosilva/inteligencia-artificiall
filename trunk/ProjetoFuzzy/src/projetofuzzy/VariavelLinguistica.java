/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetofuzzy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Larissa
 */
class VariavelLinguistica {
    
    public static final int QTD_CONJUNTOS_FUZZY_DEFAULT = 3;

    private int qtdConjuntos;
    List<ConjuntoFuzzy> conjuntos = new ArrayList<ConjuntoFuzzy>();

    

    public VariavelLinguistica(int Conj){
        qtdConjuntos = Conj;
    }

    public VariavelLinguistica(){
        qtdConjuntos = QTD_CONJUNTOS_FUZZY_DEFAULT;
    }

}
