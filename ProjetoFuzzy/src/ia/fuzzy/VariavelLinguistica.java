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
        if (nome.equals("Temperatura")) {
            conjuntos.add(new ConjuntoFuzzy("baixa", "trapezoidal", universoMax, universoMin));
            conjuntos.add(new ConjuntoFuzzy("media", "triangular", universoMax, universoMin));
            conjuntos.add(new ConjuntoFuzzy("alta", "trapezoidal", universoMax, universoMin));
        }
        else if(nome.equals("Volume")) {
            conjuntos.add(new ConjuntoFuzzy("pequeno","trapezoidal", universoMax, universoMin));
            conjuntos.add(new ConjuntoFuzzy("medio", "triangular", universoMax, universoMin));
            conjuntos.add(new ConjuntoFuzzy("grande","trapezoidal", universoMax, universoMin));
        }
        else if(nome.equals("Pressao")) {
            conjuntos.add(new ConjuntoFuzzy("baixa", "trapezoidal", universoMax, universoMin));
            conjuntos.add(new ConjuntoFuzzy("media","triangular", universoMax, universoMin));
            conjuntos.add(new ConjuntoFuzzy("alta", "trapezoidal", universoMax, universoMin));
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
