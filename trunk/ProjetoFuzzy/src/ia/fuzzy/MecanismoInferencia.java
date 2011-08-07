/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy;

import ia.fuzzy.utilitarios.BaseDeRegras;
import java.util.HashMap;
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
    private String regrasAtivadas;
    private double[][] matrizPressaoComAlfaCorte1;
    private double[][] matrizPressaoComAlfaCorte2;
    private double[][] matrizPressaoComAlfaCorte3;
    private double[][] matrizPressaoComAlfaCorte4;
    private double[][] matrizPressaoComAlfaCorte5;
    private double[][] matrizPressaoComAlfaCorte6;
    private double[][] matrizPressaoComAlfaCorte7;
    private double[][] matrizPressaoComAlfaCorte8;
    private double[][] matrizPressaoComAlfaCorte9;

    public MecanismoInferencia(Map variaveisLinguisticas){
        this.variaveisLinguisticas = variaveisLinguisticas;
    }

    public void tratarRegras(double temperaturaEntrada, double volumeEntrada){        
        regras = new BaseDeRegras(variaveisLinguisticas.get("Temperatura").matrizInferencia, variaveisLinguisticas.get("Volume").matrizInferencia, temperaturaEntrada, volumeEntrada);
        regrasAtivadas = "";
        //se eu tiver mais de uma regra ativada, eu faço o alfa-corte de cada uma e depois faço a união dos conjuntos
        if (regras.regra1()) {
            System.out.println("regra 1 - pressao baixa");
            regrasAtivadas = regrasAtivadas + "1." ;
            alfaCorteTemperatura = regras.valoresRegra1[0];
            alfaCorteVolume = regras.valoresRegra1[1];
            alfaCorte = pegarMenorValor();
            matrizPressaoComAlfaCorte1 = criarMatrizPessaoAlfaCorte(1);
        }
        if (regras.regra2()) {
            System.out.println("regra 2 - pressao baixa");
            regrasAtivadas = regrasAtivadas + "2.";
            alfaCorteTemperatura = regras.valoresRegra2[0];
            alfaCorteVolume = regras.valoresRegra2[1];
            alfaCorte = pegarMenorValor();
            matrizPressaoComAlfaCorte2 = criarMatrizPessaoAlfaCorte(1);
        }
        if (regras.regra3()) {
            System.out.println("regra 3 - pressoa media");
            regrasAtivadas = regrasAtivadas + "3.";
            alfaCorteTemperatura = regras.valoresRegra3[0];
            alfaCorteVolume = regras.valoresRegra3[1];
            alfaCorte = pegarMenorValor();
            matrizPressaoComAlfaCorte3 = criarMatrizPessaoAlfaCorte(2);
        }
        if (regras.regra4()) {
            System.out.println("regra 4 - pressao baixa");
            regrasAtivadas = regrasAtivadas + "4.";
            alfaCorteTemperatura = regras.valoresRegra4[0];
            alfaCorteVolume = regras.valoresRegra4[1];
            alfaCorte = pegarMenorValor();
            matrizPressaoComAlfaCorte4 = criarMatrizPessaoAlfaCorte(1);
        }
        if (regras.regra5()) {
            System.out.println("regra 5 - pressao media");
            regrasAtivadas = regrasAtivadas + "5.";
            alfaCorteTemperatura = regras.valoresRegra5[0];
            alfaCorteVolume = regras.valoresRegra5[1];
            alfaCorte = pegarMenorValor();
            matrizPressaoComAlfaCorte5 = criarMatrizPessaoAlfaCorte(2);
        }
        if (regras.regra6()) {
            System.out.println("regra 6 - pressao alta");
            regrasAtivadas = regrasAtivadas + "6.";
            alfaCorteTemperatura = regras.valoresRegra6[0];
            alfaCorteVolume = regras.valoresRegra6[1];
            alfaCorte = pegarMenorValor();
            matrizPressaoComAlfaCorte6 = criarMatrizPessaoAlfaCorte(3);
        }
        if (regras.regra7()) {

            System.out.println("regra 7 - pressao media");
            regrasAtivadas = regrasAtivadas + "7.";
            alfaCorteTemperatura = regras.valoresRegra7[0];
            alfaCorteVolume = regras.valoresRegra7[1];
            alfaCorte = pegarMenorValor();
            matrizPressaoComAlfaCorte7 = criarMatrizPessaoAlfaCorte(2);
        }
        if (regras.regra8()) {
            System.out.println("regra 8 - pressao alta");
            regrasAtivadas = regrasAtivadas + "8.";
            alfaCorteTemperatura = regras.valoresRegra8[0];
            alfaCorteVolume = regras.valoresRegra8[1];
            alfaCorte = pegarMenorValor();            
            matrizPressaoComAlfaCorte8 = criarMatrizPessaoAlfaCorte(3);//3 é o indic3 na matriz para o conjunto "alto"
        }
        if (regras.regra9()) {            
            System.out.println("regra 9 - pressao alta");
            regrasAtivadas = regrasAtivadas + "9.";
            alfaCorteTemperatura = regras.valoresRegra9[0];
            alfaCorteVolume = regras.valoresRegra9[1];
            alfaCorte = pegarMenorValor();
            matrizPressaoComAlfaCorte9 = criarMatrizPessaoAlfaCorte(3);
        }
    }

    private double[][] criarMatrizPessaoAlfaCorte(int indice){

        VariavelLinguistica varPressao = null;

        varPressao = variaveisLinguisticas.get("Pressao");

        double[][] matrizAlfaCorte = new double[SistemaFuzzy.DISCRETIZACAO_DEFAULT][2];
        for (int i = 0; i < SistemaFuzzy.DISCRETIZACAO_DEFAULT; i++) {
            matrizAlfaCorte[i][0] = varPressao.matrizInferencia[i][0];      
                if (varPressao.matrizInferencia[i][indice] > alfaCorte) {
                    matrizAlfaCorte[i][1] = alfaCorte;
                } else if (varPressao.matrizInferencia[i][indice] <= alfaCorte) {
                    matrizAlfaCorte[i][1] = varPressao.matrizInferencia[i][indice];
                }            
        }
        return matrizAlfaCorte;
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
