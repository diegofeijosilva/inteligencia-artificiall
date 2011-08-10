/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy.gui;

import ia.fuzzy.ConjuntoFuzzy;
import ia.fuzzy.VariavelLinguistica;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
/**
 *
 * @author Gabriel
 */
public class PainelDeGraficos extends JPanel {

    VariavelLinguistica var;
    List<GraficoFuzzy> graficos = new ArrayList<GraficoFuzzy>();
    

    public PainelDeGraficos(VariavelLinguistica varLinguistica)
    {
        this.var = varLinguistica;
        initGraficosFuzzy();
    }

    private void initGraficosFuzzy()
    {
        List<ConjuntoFuzzy> conjuntos = var.getConjuntosFuzzy();

        double width = 210;
        double height = 40;

        float x = 50;
        float y = 80;

        if (var.getNome().equals("Temperatura")){
            for (int i = 0; i < 3; i++) {
                for (ConjuntoFuzzy conjuntoFuzzy : conjuntos) {
                    graficos.add(new GraficoFuzzy(x, y, width, height, conjuntoFuzzy));
                    y += 50;
                }
            }
        }
        if(var.getNome().equals("Volume")){
            for (ConjuntoFuzzy conjuntoFuzzy : conjuntos) {
                for (int i = 0; i < 3; i++) {
                   graficos.add(new GraficoFuzzy(x, y, width, height, conjuntoFuzzy));
                    y += 50;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
 
        for (int i = 0; i < graficos.size(); i++) {
            graficos.get(i).plotarGrafico(g, i+1);
        }
    }

}
