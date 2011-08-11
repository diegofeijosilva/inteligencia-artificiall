/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy;

import ia.fuzzy.utilitarios.BaseDeRegras;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Larissa
 */
public class MecanismoInferencia {

    private BaseDeRegras regras;
    private Map<String, VariavelLinguistica> variaveisLinguisticas = new HashMap<String, VariavelLinguistica>();
    private double alfaCorteTemperatura;
    private double alfaCorteVolume;
    private double alfaCorte;
    private double[] alfaCortes = new double[9];
    private String regrasAtivadas;
    private double[][] matrizPressaoComAlfaCorte1 = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][2];
    private double[][] matrizPressaoComAlfaCorte2 = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][2];
    private double[][] matrizPressaoComAlfaCorte3 = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][2];
    private double[][] matrizPressaoComAlfaCorte4 = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][2];
    private double[][] matrizPressaoComAlfaCorte5 = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][2];
    private double[][] matrizPressaoComAlfaCorte6 = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][2];
    private double[][] matrizPressaoComAlfaCorte7 = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][2];
    private double[][] matrizPressaoComAlfaCorte8 = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][2];
    private double[][] matrizPressaoComAlfaCorte9 = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][2];

    public MecanismoInferencia(Map variaveisLinguisticas){
        this.variaveisLinguisticas = variaveisLinguisticas;
    }

    public double[][] processar(double temperaturaEntrada, double volumeEntrada)
    {
        tratarRegras(temperaturaEntrada, volumeEntrada);
        return combinarRegioesNebulosasDeSaida();
    }

    private double[][] combinarRegioesNebulosasDeSaida()
    {
        String[] regrasAtiv = getRegrasAtivadas().split("\\.");
        int regra;

        regra = Integer.parseInt(regrasAtiv[0]);
        double[][] matrizPressaoUniao = getMatrizPressaoComAlfaCorte(regra);

        if (regrasAtiv.length > 1){
            for(int i = 0; i < regrasAtiv.length-1; i++){
               regra = Integer.parseInt(regrasAtiv[i+1]);
               matrizPressaoUniao = unirConjuntos(getMatrizPressaoComAlfaCorte(regra), matrizPressaoUniao);
            }
        }
        return matrizPressaoUniao;
    }

    private double[][] unirConjuntos(double[][] matriz1, double[][] matriz2){
        for (int i = 0; i < SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++) {
                    if(matriz2[i][1] < matriz1[i][1]){
                        matriz2[i][1] = matriz1[i][1];
                    }
            }
        return matriz2;
    }

    private void tratarRegras(double temperaturaEntrada, double volumeEntrada){
        regras = new BaseDeRegras(variaveisLinguisticas.get("Temperatura").matrizPertinencia, variaveisLinguisticas.get("Volume").matrizPertinencia, temperaturaEntrada, volumeEntrada);
        regrasAtivadas = "";
        //se eu tiver mais de uma regra ativada, eu faço o alfa-corte de cada uma e depois faço a união dos conjuntos
        if (regras.regra1()) {
            System.out.println("regra 1 - pressao baixa");
            regrasAtivadas = regrasAtivadas + "1." ;
            alfaCorteTemperatura = regras.valoresRegra1[0];
            alfaCorteVolume = regras.valoresRegra1[1];
            alfaCortes[0] = pegarMenorValor();
            matrizPressaoComAlfaCorte1 = criarMatrizPessaoAlfaCorte(1,0);
        }
        if (regras.regra2()) {
            System.out.println("regra 2 - pressao baixa");
            regrasAtivadas = regrasAtivadas + "2.";
            alfaCorteTemperatura = regras.valoresRegra2[0];
            alfaCorteVolume = regras.valoresRegra2[1];
            alfaCortes[1] = pegarMenorValor();
            matrizPressaoComAlfaCorte2 = criarMatrizPessaoAlfaCorte(1,1);
        }
        if (regras.regra3()) {
            System.out.println("regra 3 - pressoa media");
            regrasAtivadas = regrasAtivadas + "3.";
            alfaCorteTemperatura = regras.valoresRegra3[0];
            alfaCorteVolume = regras.valoresRegra3[1];
            alfaCortes[2] = pegarMenorValor();
            matrizPressaoComAlfaCorte3 = criarMatrizPessaoAlfaCorte(2,2);
        }
        if (regras.regra4()) {
            System.out.println("regra 4 - pressao baixa");
            regrasAtivadas = regrasAtivadas + "4.";
            alfaCorteTemperatura = regras.valoresRegra4[0];
            alfaCorteVolume = regras.valoresRegra4[1];
            alfaCortes[3] = pegarMenorValor();
            matrizPressaoComAlfaCorte4 = criarMatrizPessaoAlfaCorte(1,3);
        }
        if (regras.regra5()) {
            System.out.println("regra 5 - pressao media");
            regrasAtivadas = regrasAtivadas + "5.";
            alfaCorteTemperatura = regras.valoresRegra5[0];
            alfaCorteVolume = regras.valoresRegra5[1];
            alfaCortes[4] = pegarMenorValor();
            matrizPressaoComAlfaCorte5 = criarMatrizPessaoAlfaCorte(2,4);
        }
        if (regras.regra6()) {
            System.out.println("regra 6 - pressao alta");
            regrasAtivadas = regrasAtivadas + "6.";
            alfaCorteTemperatura = regras.valoresRegra6[0];
            alfaCorteVolume = regras.valoresRegra6[1];
            alfaCortes[5] = pegarMenorValor();
            matrizPressaoComAlfaCorte6 = criarMatrizPessaoAlfaCorte(3,5);
        }
        if (regras.regra7()) {

            System.out.println("regra 7 - pressao media");
            regrasAtivadas = regrasAtivadas + "7.";
            alfaCorteTemperatura = regras.valoresRegra7[0];
            alfaCorteVolume = regras.valoresRegra7[1];
            alfaCortes[6] = pegarMenorValor();
            matrizPressaoComAlfaCorte7 = criarMatrizPessaoAlfaCorte(2,6);
        }
        if (regras.regra8()) {
            System.out.println("regra 8 - pressao alta");
            regrasAtivadas = regrasAtivadas + "8.";
            alfaCorteTemperatura = regras.valoresRegra8[0];
            alfaCorteVolume = regras.valoresRegra8[1];
            alfaCortes[7] = pegarMenorValor();
            matrizPressaoComAlfaCorte8 = criarMatrizPessaoAlfaCorte(3,7);//3 é o indic3 na matriz para o conjunto "alto"
        }
        if (regras.regra9()) {            
            System.out.println("regra 9 - pressao alta");
            regrasAtivadas = regrasAtivadas + "9.";
            alfaCorteTemperatura = regras.valoresRegra9[0];
            alfaCorteVolume = regras.valoresRegra9[1];
            alfaCortes[8] = pegarMenorValor();
            matrizPressaoComAlfaCorte9 = criarMatrizPessaoAlfaCorte(3,8);
        }
    }

    private double[][] criarMatrizPessaoAlfaCorte(int indice, int alfaCorteIndex){

        VariavelLinguistica varPressao = null;

        varPressao = variaveisLinguisticas.get("Pressao");

        double[][] matrizAlfaCorte = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][2];
        for (int i = 0; i < SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++) {
            matrizAlfaCorte[i][0] = varPressao.matrizPertinencia[i][0];
                if (varPressao.matrizPertinencia[i][indice] > alfaCortes[alfaCorteIndex]) {
                    matrizAlfaCorte[i][1] = alfaCortes[alfaCorteIndex];
                } else if (varPressao.matrizPertinencia[i][indice] <= alfaCortes[alfaCorteIndex]) {
                    matrizAlfaCorte[i][1] = varPressao.matrizPertinencia[i][indice];
                }            
        }
        return matrizAlfaCorte;
    }

    public double getAlfaCorte(int index)
    {
        return alfaCortes[index-1];
    }

    private double pegarMenorValor() {
        if (alfaCorteTemperatura >= alfaCorteVolume) {
            return alfaCorteVolume;
        } else {
            return alfaCorteTemperatura;
        }
    }
    public String getRegrasAtivadas(){
        return regrasAtivadas;
    }
    public double[][] getMatrizPressaoComAlfaCorte(int matriz) {
        if(matriz==1)
            return matrizPressaoComAlfaCorte1;
        else if(matriz==2)
            return matrizPressaoComAlfaCorte2;
        else if(matriz==3)
            return matrizPressaoComAlfaCorte3;
        else if(matriz==4)
            return matrizPressaoComAlfaCorte4;
        else if(matriz==5)
            return matrizPressaoComAlfaCorte5;
        else if(matriz==6)
            return matrizPressaoComAlfaCorte6;
        else if(matriz==7)
            return matrizPressaoComAlfaCorte7;
        else if(matriz==8)
            return matrizPressaoComAlfaCorte8;
        else if(matriz==9)
            return matrizPressaoComAlfaCorte9;

        return null;
    }
}
