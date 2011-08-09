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

    public static final int QTD_VARIAVEIS_ENTRADA_DEFAULT = 2;
    public static final int QTD_VARIAVEIS_SAIDA_DEFAULT = 1;
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

    private void fuzificar(String nomeVarLinguistica)
    {
        VariavelLinguistica var = variaveisLinguisticas.get(nomeVarLinguistica);
        var.discretizarUniverso(valorDiscretizacao);
        var.fuzificar();
    }

    public double executarMecanismoInferencia(double temperaturaEntrada, double volumeEntrada){
        double resultado;
        mecanismo = new MecanismoInferencia(variaveisLinguisticas);
        mecanismo.tratarRegras(temperaturaEntrada, volumeEntrada);
        String regrasAtivadas = mecanismo.getRegrasAtivadas();
        String[] qtdDeRegras = regrasAtivadas.split("\\.");
        int tam = qtdDeRegras.length;
        int valor;

        valor = Integer.parseInt(qtdDeRegras[0]);
        double[][] matrizPressaoUniao = mecanismo.getMatrizPressaoComAlfaCorte(valor);
  
        if (qtdDeRegras.length != 1){
            for(int i = 0; i < tam-1; i++){
               valor = Integer.parseInt(qtdDeRegras[i+1]);
               matrizPressaoUniao = unirConjuntos(mecanismo.getMatrizPressaoComAlfaCorte(valor), matrizPressaoUniao);
            }
        }
        //pronto agora já tnho a matriz união, é só fazer o centro de area.
        resultado = desfuzificar(matrizPressaoUniao);
        System.out.println("Valor de pressão encontrado: " + resultado);

        return resultado;
    }

    private double desfuzificar (double[][] regiaoNebulosa)
    {
        return centroDeArea(regiaoNebulosa);
    }

    private double[][] unirConjuntos(double[][] matriz1, double[][] matriz2){
        for (int i = 0; i < SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++) {        
                    if(matriz2[i][1] < matriz1[i][1]){
                        matriz2[i][1] = matriz1[i][1];
                    }                                   
            }
        return matriz2;
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

}
