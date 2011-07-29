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

    public static final int DISCRETIZACAO_DEFAULT = 500;
    
    private String valorLinguistico;
    private double m;
    private double n;
    private double a;
    private double b;
    private int escopoMax;
    private int escopoMin;
    private int discretizacao;
    private String tipoFuncao;

    public ConjuntoFuzzy(String valor, String tipoFuncao, int escopoMax, int escopoMin)
    {
        this.valorLinguistico = valor;
        this.discretizacao = DISCRETIZACAO_DEFAULT;
        this. escopoMax = escopoMax;
        this.escopoMin = escopoMin;
        this.tipoFuncao = tipoFuncao;
        initDefault();
    }


    public void initDefault() {
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
        //fazer a função aki
        return x;
    }
     private double trapezoidal(double x)
    {
        //fazer a função aki
        return x;
    }

}


