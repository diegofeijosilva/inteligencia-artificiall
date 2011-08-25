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
            //System.out.println("CROMOSSOMO: "+(i+1));
            cromossomos.add(new Cromossomo());
            //System.out.println("\n\n");
        }
    }

    public void executar()
    {
        System.out.println("\n\n Valor máximo: "+Collections.max(cromossomos).getValor());
        int t = 0; //geração
        while(t<100)
        {
            System.out.println("VALOR DE T: "+t);
            t++;
            cromossomos = selecionar();
            //alterarPopulacao();
            System.out.println("\n\n Valor máximo: "+Collections.max(cromossomos).getValor());
        }
    }

    private void alterarPopulacao()
    {
        executarCruzamento();
        executarMutacao();
    }

    private void executarMutacao()
    {
        for (Cromossomo cromossomo : cromossomos) {
            double random = Math.random() * 100;
            if (random <= TAXA_MUTACAO) {
                cromossomo.mutar();
            }
        }
    }

    private void executarCruzamento() {
        int i = 0;
        while (i < TAMANHO_POPULACAO-1) {
            double random = Math.random() * 100;

            if (random <= TAXA_CRUZAMENTO) {
                cruzar(cromossomos.get(i), cromossomos.get(i + 1));
            }
            i = i + 1;
        }
        //retirarExcessoPopulacao();
    }

    private void cruzar(Cromossomo p1, Cromossomo p2)
    {
        int corte = (int) Math.random() * 21;

        int[] v1 = p1.getGenes();
        int[] v2 = p2.getGenes();

        int[] v3 = concat( Arrays.copyOfRange(v1, 0, corte), Arrays.copyOfRange(v2, corte, TAMANHO_POPULACAO));
        int[] v4 = concat( Arrays.copyOfRange(v2, 0, corte), Arrays.copyOfRange(v1, corte, TAMANHO_POPULACAO));

        //retirando pais
        cromossomos.remove(p1);
        cromossomos.remove(p2);

        //adicionando filhos
        cromossomos.add(new Cromossomo(v3));
        cromossomos.add(new Cromossomo(v4));

    }

    private void retirarExcessoPopulacao()
    {
        int qtdExcesso = cromossomos.size() - TAMANHO_POPULACAO;

        for (int i = 0; i < qtdExcesso; i++) {
            cromossomos.remove(Collections.min(cromossomos));
        }
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
        //return roleta();
        return torneio();
    }

    private List<Cromossomo> torneio()
    {
        List<Cromossomo> proxGeracao = new ArrayList<Cromossomo>();
        List<Cromossomo> torneio = new ArrayList<Cromossomo>();
        int i1 = (int) (Math.random() * 100);
        int i2 = (int) (Math.random() * 100);
        int i3 = (int) (Math.random() * 100);

        for (int i = 0; i < TAMANHO_POPULACAO; i++) {
            i1 = (int) (Math.random() * 100);
            i2 = (int) (Math.random() * 100);
            i3 = (int) (Math.random() * 100);

            torneio.add(new Cromossomo(cromossomos.get(i1).getGenes()));
            torneio.add(new Cromossomo(cromossomos.get(i2).getGenes()));
            torneio.add(new Cromossomo(cromossomos.get(i3).getGenes()));

            proxGeracao.add(Collections.max(torneio));
        }
        return proxGeracao;
    }

    private List<Cromossomo> roleta()
    {
        List<Cromossomo> proxGeracao = new ArrayList<Cromossomo>();
        double aptidaoTotal = 0; //somatório das aptidões,ou seja, 100%
        int porcaoRoleta = 1; //porção (número de casas) de um cromossomo na roleta
        Cromossomo[] roleta = new Cromossomo[TAMANHO_POPULACAO];
        int i = 0; //indice da roleta

        //calcula total das aptidoes
        for (Cromossomo cromossomo : cromossomos) {
            aptidaoTotal += eval(cromossomo);
        }

        //calcula numero de casas de cada cromossomo na roleta, proporcionalmente a sua aptidão,e preenche a roleta
        for (Cromossomo cromossomo : cromossomos) {
            porcaoRoleta = (int) Cromossomo.arredondar( (( TAMANHO_POPULACAO * eval(cromossomo) ) / aptidaoTotal),0);
            for (int j = 0; j < porcaoRoleta; j++) {
                if (i < TAMANHO_POPULACAO) {
                    roleta[i] = cromossomo;
                    i++;
                }
            }
        }
        System.out.println("valor de i: "+i);

        for (int k = 0; k < 100; k++) {
            int index = (int) (Math.random() * 100);
            proxGeracao.add(new Cromossomo(roleta[index].getGenes()));
        }

        return proxGeracao;
    }

    public double eval(Cromossomo c)
    {
        return Cromossomo.arredondar(f(c.getValor()),6);
    }

    //função de avaliação
    private double f(double x)
    {
        return x * Math.sin(10*Math.PI*x) + 1;
    }

    public static void main(String[] args) {
        AlgoritmoGenetico ag = new AlgoritmoGenetico();
        ag.executar();
    }

    
}
