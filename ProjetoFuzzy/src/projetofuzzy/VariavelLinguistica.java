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

    private String nome;
    private List<ConjuntoFuzzy> conjuntos = new ArrayList<ConjuntoFuzzy>();

    

    public VariavelLinguistica(String nome){
        this.setNome(nome);
        inicializarConjuntos();
    }

    public void inicializarConjuntos()
    {
        if (nome.equals("Temperatura")) {
            conjuntos = new ArrayList<ConjuntoFuzzy>();
            conjuntos.add(new ConjuntoFuzzy("baixa", 500));
            conjuntos.add(new ConjuntoFuzzy("media", 500));
            conjuntos.add(new ConjuntoFuzzy("alta", 500));
        }
        else if(nome.equals("Volume")) {
            conjuntos = new ArrayList<ConjuntoFuzzy>();
            conjuntos.add(new ConjuntoFuzzy("pequeno", 500));
            conjuntos.add(new ConjuntoFuzzy("media", 500));
            conjuntos.add(new ConjuntoFuzzy("grande", 500));
        }
        else if(nome.equals("Pressao")) {
            conjuntos = new ArrayList<ConjuntoFuzzy>();
            conjuntos.add(new ConjuntoFuzzy("baixa", 500));
            conjuntos.add(new ConjuntoFuzzy("media", 500));
            conjuntos.add(new ConjuntoFuzzy("alta", 500));
        }
    }



     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
