/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetofuzzy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Larissa
 */
public class SistemaFuzzy {

    public static final int QTD_VARIAVEIS_ENTRADA_DEFAULT = 2;
    public static final int QTD_VARIAVEIS_SAIDA_DEFAULT = 1;

    List<VariavelLinguistica> variaveisLinguisticas = new ArrayList<VariavelLinguistica>();
    private int qtdVarEntradas;
    private int qtdVarSaida;

    public void fuzificar(int varEntradas, int varSaida)
    {
        qtdVarEntradas = varEntradas;
        qtdVarSaida = varSaida;
    }

      public void fuzificar()
    {
        qtdVarEntradas = QTD_VARIAVEIS_ENTRADA_DEFAULT;
        qtdVarSaida = QTD_VARIAVEIS_SAIDA_DEFAULT;
    }

    public void desfuzificar()
    {
        centroDeArea();
    }

    public void centroDeArea(){

    }

}
