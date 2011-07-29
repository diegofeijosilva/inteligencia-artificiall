/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Larissa
 */
class VariavelLinguistica {
    
   // public static final int QTD_CONJUNTOS_FUZZY_DEFAULT = 3;

    private String nome;
    private int universoMin; //min e max do gráfico (universo de discurso)
    private int universoMax;
    public List<ConjuntoFuzzy> conjuntos = new ArrayList<ConjuntoFuzzy>();

    

    public VariavelLinguistica(String nome, int min, int max, int qtdValoresLinguisticos){
        this.nome = nome;
        this.universoMin = min;
        this.universoMax = max;
        inicializarConjuntos();
    }

    private void inicializarConjuntos()
    {
        if (nome.equals("Temperatura")) {//estou colocando zero onde não tem valor
            conjuntos.add(new ConjuntoFuzzy("baixa", "trapezoidal", 0, 1000, 800, 900));
            conjuntos.add(new ConjuntoFuzzy("media", "triangular", 900, 1100, 1000, 0));
            conjuntos.add(new ConjuntoFuzzy("alta", "trapezoidal", 1000, 0, 1100, 1200));
        }
        else if(nome.equals("Volume")) {
            conjuntos.add(new ConjuntoFuzzy("pequeno","trapezoidal", 0, 7, 2, 4.5));
            conjuntos.add(new ConjuntoFuzzy("medio", "triangular", 4.5, 9.5, 7, 0));
            conjuntos.add(new ConjuntoFuzzy("grande","trapezoidal", 7, 0, 9.5, 12));
        }
        else if(nome.equals("Pressao")) {
            conjuntos.add(new ConjuntoFuzzy("baixa", "trapezoidal", 0, 8, 4, 5));
            conjuntos.add(new ConjuntoFuzzy("media","triangular", 6, 10, 8, 0));
            conjuntos.add(new ConjuntoFuzzy("alta", "trapezoidal", 8, 0, 11, 12));
        }
    }



    public String getNome() {
        return nome;
    }

    public int getUniversoMax() {
        return universoMax;
    }

    public int getUniversoMin() {
        return universoMin;
    }
}
