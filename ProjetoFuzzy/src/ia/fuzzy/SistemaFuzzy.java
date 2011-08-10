/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Larissa
 */
public class SistemaFuzzy {

    public static final int DISCRETIZACAO_DEFAULT = 500;
    public static final int QTD_VALORES_LINGUISTICOS_DEFAULT = 3;

    private Map<String, VariavelLinguistica> variaveisLinguisticas = new HashMap<String, VariavelLinguistica>();
    private MecanismoInferencia mecanismo;
    private int valorDiscretizacao;

    public SistemaFuzzy()
    {
        valorDiscretizacao = DISCRETIZACAO_DEFAULT;   
    }

    public void criarVariavelLinguistica(String nome, int universoMin, int universoMax)
    {
        variaveisLinguisticas.put(nome, new VariavelLinguistica(nome, universoMin, universoMax));
        fuzificar(nome);
    }

    public double executarMecanismoInferencia(double temperaturaEntrada, double volumeEntrada){
        double resultadoPressao = 0;
        double [][] regiaoNebulosaDeSaida;
        mecanismo = new MecanismoInferencia(variaveisLinguisticas);

        regiaoNebulosaDeSaida = mecanismo.processar(temperaturaEntrada, volumeEntrada);

        resultadoPressao = desfuzificar(regiaoNebulosaDeSaida);
        System.out.println("Valor de pressão encontrado: " + resultadoPressao);

        return resultadoPressao;
    }

    private void fuzificar(String nomeVarLinguistica)
    {
        VariavelLinguistica var = variaveisLinguisticas.get(nomeVarLinguistica);
        var.discretizarUniverso(valorDiscretizacao);
        var.fuzificar();
    }
   
    private double desfuzificar (double[][] regiaoNebulosa)
    {
        return centroDeArea(regiaoNebulosa);
    }

    private double centroDeArea(double[][] regiaoNebulosa){
        double dividendo = 0;
        double divisor = 0;
        for (int i = 0; i < SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++) {
                    dividendo += regiaoNebulosa[i][0] * regiaoNebulosa[i][1];
                    divisor += regiaoNebulosa[i][1];
        }
        return dividendo/divisor;
    }

    public Map<String, VariavelLinguistica> getVariaveisLinguisticas()
    {
        return this.variaveisLinguisticas;
    }

}