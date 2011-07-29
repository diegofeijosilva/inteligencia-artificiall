/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy;

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
    private String tipoFuncao;

    public ConjuntoFuzzy(String valor, String tipoFuncao, double a, double b, double m, double n)
    {
        this.valorLinguistico = valor;
        this.tipoFuncao = tipoFuncao;
        this.a = a;
        this.b = b;
        this.m = m;
        this.n = n;
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


