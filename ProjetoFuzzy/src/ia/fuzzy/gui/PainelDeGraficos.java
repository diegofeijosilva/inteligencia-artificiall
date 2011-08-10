/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy.gui;

import ia.fuzzy.ConjuntoFuzzy;
import ia.fuzzy.VariavelLinguistica;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
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
    Line2D linha;
    

    public PainelDeGraficos(VariavelLinguistica varLinguistica)
    {
        this.var = varLinguistica;
        initGraficosFuzzy();
    }

    private void initGraficosFuzzy()
    {
        List<ConjuntoFuzzy> conjuntos = var.getConjuntosFuzzy();

        float width = 210;
        float height = 40;

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
        desenharLinhaVertical(g);     
        plotarGraficos(g);
        desenharLinhaVertical(g); // armengue pra linha ficar por cima
    }

    private void plotarGraficos(Graphics g)
    {
        for (int i = 0; i < graficos.size(); i++) {
            graficos.get(i).plotarGrafico(g, i+1, (int) linha.getX1());
        }
    }

    private void desenharLinhaVertical(Graphics g)
    {
        double linhaX = graficos.get(0).getX() + (graficos.get(0).getWidth()*2/3);
        double linhaY1 = graficos.get(0).getY() - 10;
        double linhaY2 = graficos.get(graficos.size()-1).getY() + graficos.get(0).getHeight() + 30;

        Graphics2D g2d = (Graphics2D) g.create();
        linha = new Line2D.Double(linhaX, linhaY1, linhaX, linhaY2);
        g2d.setColor(Color.red);
        g2d.draw(linha);
    }

}
