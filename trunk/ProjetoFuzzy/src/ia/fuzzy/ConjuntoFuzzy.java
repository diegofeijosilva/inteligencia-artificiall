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
public class ConjuntoFuzzy {

    private List<Elemento> elementos = new ArrayList<Elemento>();

    private String valorLinguistico;
    private double m;
    private double n;
    private double a;
    private double b;
    private String tipoFuncao;

    private VariavelLinguistica var;

    public ConjuntoFuzzy(VariavelLinguistica var, String valor, String tipoFuncao, double a, double b, double m, double n)
    {
        this.var = var;
        this.valorLinguistico = valor;
        this.tipoFuncao = tipoFuncao;
        this.a = a;
        this.b = b;
        this.m = m;
        this.n = n;
    }

    public ConjuntoFuzzy(VariavelLinguistica var, double[][] matriz)
    {
        this.var = var;
        implementarMatriz(matriz);
    }

    public double pertinencia(double x)
    {
        if(tipoFuncao.equals("triangular"))
        {
            return triangular(x);

        }else if(tipoFuncao.equals("trapezoidal"))
        {
            return trapezoidal(x);
        }
        return 2;//valor impossivel
    }

    public void discretizarUniverso(int numeroDePontos, double valorMin, double valorMax)
    {
        double delta = (valorMax - valorMin)/numeroDePontos;
        double x = valorMin;

        for (int i = 0; i < numeroDePontos; i++) {
            elementos.add(new Elemento(x, pertinencia(x)));
            x += delta;
        }
    }

    public void implementarMatriz(double[][] matriz)
    {
        elementos.clear();
       // System.out.println(matriz);
        for (int i = 0; i < matriz.length; i++) {
            elementos.add(new Elemento(matriz[i][0], matriz[i][1]));
        }
    }

    public Elemento getElemento(int idex)
    {
        return elementos.get(idex);
    }

    public int getTotalElementos()
    {
        return elementos.size();
    }

    public VariavelLinguistica getVarLinguistica()
    {
        return this.var;
    }

    public String getValorLinguistico()
    {
        return valorLinguistico;
    }

    private double triangular(double x)
    {
        if(x <= a)
            return 0;
        else if(x > a && x <= m)
            return (x-a)/(m-a);
        else if(x > m && x < b)
            return (b-x)/(b-m);
        else if(x >= b)
            return 0;

        return 2;//num sei o que colocar pra retornar, ele n aceita null; =(

    }
     private double trapezoidal(double x)
    {
        if(x < a)
            return 0;
        else if(x >= a && x < m)
            return (x-a)/(m-a);
        else if(x >= m && x <= n)
            return 1;
        else if(x > n && x <= b)
            return (b-x)/(b-n);
        else if(x > b)
            return 0;

        return 2;//num sei o que colocar pra retornar, ele n aceita null; =(
    }

}


