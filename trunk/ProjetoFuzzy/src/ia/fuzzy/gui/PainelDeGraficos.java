/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy.gui;

import ia.fuzzy.ConjuntoFuzzy;
import ia.fuzzy.VariavelLinguistica;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
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

        for (ConjuntoFuzzy conjuntoFuzzy : conjuntos) {
            graficos.add(new GraficoFuzzy(x,y,width,height,conjuntoFuzzy));
            y += 50;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        //desenharContainers(g);
        for (GraficoFuzzy graficoFuzzy : graficos) {
            graficoFuzzy.plotarGrafico(g);
        }
    }

    private void desenharContainers(Graphics g)
    {
        double width = 210;
        double height = 40;

        float x = 50;
        float y = 80;

        Graphics2D g2d = (Graphics2D) g.create();

        for (int i = 0; i < 9; i++) {
            g2d.draw(new Rectangle2D.Double(x, y, width, height));
            g2d.drawString((i+1)+"", x-30, y+25);
            y += 50;
        }
        g2d.dispose();
    }


}
