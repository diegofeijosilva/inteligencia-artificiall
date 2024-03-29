/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.fuzzy.gui;

import ia.fuzzy.ConjuntoFuzzy;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class GraficoFuzzy {

    ConjuntoFuzzy conjunto;
    List<Ponto> pontos = new ArrayList<Ponto>();
    private float width;
    private float height;
    private float x; //coordenadas iniciais do gráfico, do ponto superior esquerdo
    private float y;

    public GraficoFuzzy(float x, float y, float width, float height, ConjuntoFuzzy conjunto) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.conjunto = conjunto;
    }
    public void implementarMatriz(double[][] matriz )
    {
        conjunto.implementarMatriz(matriz);
    }

    public void plotarGrafico(Graphics g, int index) {
        desenharContainer(g, index);
        plotar(g);
        //preencher(g, xDaLinha);
    }

    public void setarPlanoDeFundo(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.white);
        g2d.fillRect((int) x, (int) y, (int) width, (int) height);
    }

    private void desenharContainer(Graphics g, int index) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.black);
        g2d.draw(new Rectangle2D.Double(x, y, width, height));
        g2d.drawString(index + "", x - 30, y + 25);

        if (index == 9 && !conjunto.getVarLinguistica().getNome().equals("Pressao")) {
            g2d.drawString(String.valueOf(conjunto.getVarLinguistica().getUniversoMin()), x - 5, y + 53);
            g2d.drawString(String.valueOf(conjunto.getVarLinguistica().getUniversoMax()), x + width - 10, y + 53);
        }

        if (index == 10 && conjunto.getVarLinguistica().getNome().equals("Pressao")) {
            g2d.drawString(String.valueOf(conjunto.getVarLinguistica().getUniversoMin()), x - 5, y + 53);
            g2d.drawString(String.valueOf(conjunto.getVarLinguistica().getUniversoMax()), x + width - 10, y + 53);
            g2d.setColor(Color.blue);
            g2d.draw(new Rectangle2D.Double(x, y, width, height));
        }
        g2d.dispose();
    }

    private void plotar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        pontos.clear();

        double deltaX = width / 500;
        double deltaY = height / 100;

        double xP;
        double yP;

        //preenchendo lista de pontos para plotar, definindo coordenadas xP e yP para cada ponto
        for (int i = 0; i < conjunto.getTotalElementos(); i++) {
            xP = x + (i + 1) * deltaX;
            yP = y - (arredondar(conjunto.getElemento(i).getPertinencia(), 2) * 100 * deltaY) + height;

            if (i == 0 && yP <= y+height) {
                //pontos.add(new Ponto(xP, yP + height));
                pontos.add(new Ponto(x, y + height));
            } else if (yP < y + height) {
                pontos.add(new Ponto(xP, yP));
            }

            if (i == conjunto.getTotalElementos() - 1 && yP <= y+height) {
                //pontos.add(new Ponto(xP, yP + height));
                pontos.add(new Ponto(x + width, y + height));
            }
        }

        if (conjunto.getVarLinguistica().getNome().equals("Pressao")) {
            g2d.setColor(Color.blue);
        }

        //unindo os pontos com linhas
        for (int i = 0; i < pontos.size() - 1; i++) {
            Line2D linha = new Line2D.Double(pontos.get(i).x, pontos.get(i).y, pontos.get(i + 1).x, pontos.get(i + 1).y);
            g2d.draw(linha);
        }

    }

    public void preencher(Graphics g, int xDaLinha) {
        Graphics2D g2d = (Graphics2D) g.create();

        int[] xPoints;
        int[] yPoints;

        int yMin = getYMin(xDaLinha);

        //vetores de pontos para fazer o preenchimento
        xPoints = new int[pontos.size()];
        yPoints = new int[pontos.size()];

        for (int i = 0; i < pontos.size(); i++) {
            xPoints[i] = (int) pontos.get(i).x;
            yPoints[i] = (int) pontos.get(i).y;

            if (pontos.get(i).y < yMin) {
                yPoints[i] = yMin;
            } else {
                yPoints[i] = (int) pontos.get(i).y;
            }
        }

        //fazendo preenchimento
        if (!conjunto.getVarLinguistica().getNome().equals("Pressao")) {
            g2d.setColor(Color.yellow);
        } else if (conjunto.getVarLinguistica().getNome().equals("Pressao")) {
            g2d.setColor(Color.blue);
        }

        g2d.fillPolygon(xPoints, yPoints, xPoints.length);
    }

    public void preencherResultado(Graphics g, int yMin) {
        Graphics2D g2d = (Graphics2D) g.create();

        int[] xPoints;
        int[] yPoints;

        //vetores de pontos para fazer o preenchimento
        xPoints = new int[pontos.size()];
        yPoints = new int[pontos.size()];

        for (int i = 0; i < pontos.size(); i++) {
            xPoints[i] = (int) pontos.get(i).x;
            yPoints[i] = (int) pontos.get(i).y;
            //yPoints[i] = yMin;


            if (pontos.get(i).y < yMin) {
                yPoints[i] = yMin;
            } else {
                yPoints[i] = (int) pontos.get(i).y;
            }
        }

        g2d.setColor(Color.blue);
        g2d.fillPolygon(xPoints, yPoints, xPoints.length);
    }

    public void preencherAreaNebulosaFinal(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int[] xPoints;
        int[] yPoints;

        //vetores de pontos para fazer o preenchimento
        xPoints = new int[pontos.size()];
        yPoints = new int[pontos.size()];

        for (int i = 0; i < pontos.size(); i++) {
            xPoints[i] = (int) pontos.get(i).x;
            yPoints[i] = (int) pontos.get(i).y;
            //yPoints[i] = yMin;


//            if (pontos.get(i).y < yMin) {
//                yPoints[i] = yMin;
//            } else {
//                yPoints[i] = (int) pontos.get(i).y;
//            }
        }

        g2d.setColor(Color.blue);
        g2d.fillPolygon(xPoints, yPoints, xPoints.length);
    }

    public double calcularCoordenadaY(double valor) {
        double deltaY = height / 100;
        double yP;
        System.out.println("CONJUNTO: " + conjunto.getValorLinguistico());
        System.out.println("VALOR DO ALFA CORTE: " + valor);
        yP = y + height - (valor * 100 * deltaY);
        System.out.println("VALOR DO PONTO: " + yP);
        System.out.println("VALOR DE Y: " + y);
        System.out.println("VALOR DE Y+height: " + (y + height) + "\n\n");
        return yP;
    }

    private int getYMin(int x) {
        for (Ponto ponto : pontos) {
            if (x == ponto.x || (ponto.x <= x + 1 && ponto.x >= x - 1)) {
                return (int) ponto.y;
            }
        }
        return (int) ((int) y + height);
    }

    public static double arredondar(double num, int casas) {
        int decimalPlace = casas;
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        num = bd.doubleValue();
        return num;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    class Ponto {

        double x;
        double y;

        Ponto(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
