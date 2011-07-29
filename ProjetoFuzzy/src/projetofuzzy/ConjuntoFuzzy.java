/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetofuzzy;

/**
 *
 * @author Larissa
 */
public class ConjuntoFuzzy {

    
    
    private String valorLinguistico;

    private double m;
    private double n;
    private double a;
    private double b;

    private int discretizacao;

    ConjuntoFuzzy(String var, int disc)
    {
        this.valorLinguistico = var;
        this.discretizacao = disc;
        initDefault();
    }


    public void initDefault() {
        if (valorLinguistico.equals("baixa")) {

        } else if (valorLinguistico.equals("media")) {

        } else if (valorLinguistico.equals("alta")) {
        }

    }

    private void pertinencia(double x)
    {

    }

    private void triangular(double x)
    {

    }

}


