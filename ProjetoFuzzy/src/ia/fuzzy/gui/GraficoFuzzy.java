/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy.gui;

import ia.fuzzy.ConjuntoFuzzy;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Gabriel
 */
public class GraficoFuzzy {

    ConjuntoFuzzy conjunto;

    private float width;
    private float height;

    private float x;
    private float y;

    public GraficoFuzzy(float x, float y, float width, float height, ConjuntoFuzzy conjunto)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.conjunto = conjunto;
    }

    public void plotarGrafico(Graphics g, int index)
    {
        desenharContainer(g, index);
    }

    private void desenharContainer(Graphics g, int index)
    {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.draw(new Rectangle2D.Double(x, y, width, height));
        g2d.drawString(index + "", x - 30, y + 25);

        if(index==9)
        {
            g2d.drawString(String.valueOf(conjunto.getVarLinguistica().getUniversoMin()), x - 5 , y + 53);
            g2d.drawString(String.valueOf(conjunto.getVarLinguistica().getUniversoMax()), x + width - 10, y + 53);
        }

        g2d.dispose();
    }

    private void plotar()
    {

    }



}
