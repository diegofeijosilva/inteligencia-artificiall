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

    
    
    private String variavelLinguistica;

    private double m;
    private double n;
    private double a;
    private double b;

    private int discretizacao;

    ConjuntoFuzzy(String var, int disc)
    {
        this.variavelLinguistica = var;
        this.discretizacao = disc;
    }


    public void initDefault() {
        if (variavelLinguistica.equals("Temperatura")) {

        } else if (variavelLinguistica.equals("Volume")) {

        } else if (variavelLinguistica.equals("Pressao")) {
        }

    }

    private void pertinencia(double x)
    {

    }

    private void triangular(double x)
    {

    }

}


