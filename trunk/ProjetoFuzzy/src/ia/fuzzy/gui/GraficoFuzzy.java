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

    private double width;
    private double height;

    private float x;
    private float y;

    public GraficoFuzzy(float x, float y, double width, double height, ConjuntoFuzzy conjunto)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.conjunto = conjunto;
    }

    public void plotarGrafico(Graphics g)
    {
        desenharContainer(g);
    }

    private void desenharContainer(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.draw(new Rectangle2D.Double(x, y, width, height));
        g2d.drawString(1 + "", x - 30, y + 25);

        g2d.dispose();
    }



}
