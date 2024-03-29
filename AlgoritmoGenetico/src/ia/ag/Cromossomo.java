/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.ag;

import ia.ag.AlgoritmoGenetico.*;
import java.math.BigDecimal;
/**
 *
 * @author Gabriel
 */
public class Cromossomo implements Comparable<Cromossomo>{

    private int[] genes = new int[22];
    private double valor = 0;

    public Cromossomo()
    {
        gerarValorAleatorio();
        valor = getRealValue();
    }

    public Cromossomo(int genes[])
    {
        this.genes = genes;
        valor = getRealValue();
    }

    public void mutar()
    {
        mutacaoSimples();
    }

    private void mutacaoSimples()
    {
        int index = (int) Math.random() * 21;
        genes[index] = alternarBit(genes[index]);
    }

    private int alternarBit(int bit)
    {
        if(bit==0) return 1;
        if(bit==1) return 0;
        throw new IllegalArgumentException("Valor inválido! Deve ser sero ou um!");       
    }

    private void gerarValorAleatorio() {
        double temp = 0;
        for (int i = 0; i < genes.length; i++) {
            temp = (double) Math.random();
            genes[i] = arredondarBit(temp);
            //System.out.print(genes[i]);
        }
    }

    private int arredondarBit(double x)
    {
         int bit;
         if (x >= 0.5) {
                bit = 1;
            } else {
                bit = 0;
            }
         return bit;
    }

    public double getRealValue()
    {
        double x_ = 0;
        double x = 0;

        for (int i = 0; i < genes.length; i++) {
            x_ += genes[i] * Math.pow(2, i);
        }

        x = -1.0 + x_*(3/(Math.pow(2, 22)-1));

        return arredondar(x,6);
    }

    public int[] getGenes()
    {
        return this.genes;
    }

    public void setGenes(int[] genes)
    {
        this.genes = genes;
        valor = getRealValue();
    }

    public double getValor()
    {
        return this.valor;
    }

    public static double arredondar(double num, int casas) {
        int decimalPlace = casas;
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(decimalPlace,BigDecimal.ROUND_HALF_UP);
        num = bd.doubleValue();
        return num;
    }

    public int compareTo(Cromossomo outro) {
        AlgoritmoGenetico ag = new AlgoritmoGenetico();

        if (ag.eval(this) < ag.eval(outro)) {
            return -1;
        }

        if (ag.eval(this) > ag.eval(outro)) {
            return 1;
        }
        return 0;

    }

//    public static void main(String[] args) {
//        Cromossomo cromossomo = new Cromossomo();
//    }
}
