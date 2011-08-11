/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.fuzzy.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

/**
 *
 * @author Gabriel
 */
public class MouseHandler implements MouseListener, MouseMotionListener{

    PainelDeGraficos painel;

    MouseHandler(PainelDeGraficos painel)
    {
        this.painel = painel;
    }

    public void mouseClicked(MouseEvent e) {

        double x = painel.getGraficos().get(0).getX();
        double width = painel.getGraficos().get(0).getWidth();
        Line2D linha = painel.getLinha();

        if ((e.getX() > x && e.getX() < (x + width)) && ((e.getY() > linha.getY1()) && (e.getY() < linha.getY2()))) {
            Line2D novaLinha = new Line2D.Double(e.getX(), linha.getY1(), e.getX(), linha.getY2());
            painel.setLinha(novaLinha);
        }
        painel.repaint();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        
    }

}
