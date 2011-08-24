/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.ag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author Gabriel
 */
public class AlgoritmoGenetico {

    public static final int TAMANHO_POPULACAO = 100;
    public static final int TOTAL_GERACOES = 100;
    public static final int TAXA_MUTACAO = 1;
    public static final int TAXA_CRUZAMENTO = 70;
    
    private List<Cromossomo> cromossomos = new ArrayList<Cromossomo>();

    public AlgoritmoGenetico()
    {
        for (int i = 0; i < TAMANHO_POPULACAO; i++) {
            cromossomos.add(new Cromossomo());
        }
    }

    private void executarMutacao()
    {
        for (Cromossomo cromossomo : cromossomos) {
            double random = Math.random() * 100;
            if(random <= TAXA_MUTACAO)
                cromossomo.mutar();
        }
    }

    private void executarCruzamento() {
        int i = 0;
        while (i < cromossomos.size()) {
            double random = Math.random() * 100;

            if (random <= TAXA_CRUZAMENTO) {
                cruzar(cromossomos.get(i), cromossomos.get(i + 1));
            }
            i += 2;
        }

    }

    private void cruzar(Cromossomo p1, Cromossomo p2)
    {
        int corte = (int) Math.random() * 21;

        int[] v1 = p1.getGenes();
        int[] v2 = p2.getGenes();

        int[] v3 = concat( Arrays.copyOfRange(v1, 0, corte), Arrays.copyOfRange(v2, corte, TAMANHO_POPULACAO));
        int[] v4 = concat( Arrays.copyOfRange(v2, 0, corte), Arrays.copyOfRange(v1, corte, TAMANHO_POPULACAO));

        cromossomos.add(new Cromossomo(v3));
        cromossomos.add(new Cromossomo(v4));

    }

    // Versão especializada para o tipo primitivo int
    public static int[] concat (int[]... arrays) {
        int length = 0;
        for (int[] array : arrays) { length += array.length; }

        int[] ret = new int[length];
        int destPos = 0;
        for (int[] array : arrays) {
            System.arraycopy (array, 0, ret, destPos, array.length);
            destPos += array.length;
        }
        return ret;
    }

    private List<Cromossomo> selecionar()
    {
        List<Cromossomo> proxGeracao = new ArrayList<Cromossomo>();
        Collections.sort(cromossomos);

        for (int i = 0; i < 100; i++) {
            int index = (int) Math.random() * 100;
            proxGeracao.add(cromossomos.get(index));
        }

        return proxGeracao;
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
