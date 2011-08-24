/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.ag;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class AlgoritmoGenetico {

    public static final int TAMANHO_POPULACAO = 100;
    public static final int TOTAL_GERACOES = 100;
    
    private List<Cromossomo> cromossomos = new ArrayList<Cromossomo>();

    public AlgoritmoGenetico()
    {
        for (int i = 0; i < TAMANHO_POPULACAO; i++) {
            cromossomos.add(new Cromossomo());
        }
    }

    private void executarMutacao()
    {
        int index = (int) Math.random()*100; // gera um indice aleatório para escolher o cromossomo a ser mutado
        cromossomos.get(index).mutar();
    }

    public double eval(Cromossomo c)
    {
        return Cromossomo.arredondar(f(c.getRealValue()),6);
    }

    //função de avaliação
    private double f(double x)
    {
        return x * Math.sin(10*Math.PI*x) + 1;
    }

    
}
