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
        if (!var.getNome().equals("Pressao"))
        initLinhaVertical();
    }

    public void initGraficosFuzzy()
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

    public void initGraficosPressao()
    {
        List<ConjuntoFuzzy> conjuntos = var.getConjuntosFuzzy();

        float width = 210;
        float height = 40;

        float x = 50;
        float y = 80;

        if(var.getNome().equals("Pressao")){
            for (ConjuntoFuzzy conjuntoFuzzy : conjuntos) {
                //for (int i = 0; i < 3; i++) {
                   graficos.add(new GraficoFuzzy(x, y, width, height, conjuntoFuzzy));
                    y += 50;
                }
           // }
        }
    }

    private void initLinhaVertical()
    {
        double linhaX = graficos.get(0).getX() + (graficos.get(0).getWidth()*2/3);
        double linhaY1 = graficos.get(0).getY() - 10;
        double linhaY2 = graficos.get(graficos.size()-1).getY() + graficos.get(0).getHeight() + 30;

        linha = new Line2D.Double(linhaX, linhaY1, linhaX, linhaY2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!var.getNome().equals("Pressao")) {
            desenharLinhaVertical(g);
            plotarGraficos(g);
            setarPlanosDeFundo(g);
            preencherGraficos(g);
            plotarGraficos(g);
            desenharLinhaVertical(g); // armengue pra linha ficar por cima
        }
        else {
            preencherGraficosResultados(g);
            plotarGraficos(g);
        }
    }

    private void plotarGraficos(Graphics g)
    {
        for (int i = 0; i < graficos.size(); i++) {
            graficos.get(i).plotarGrafico(g, i+1 );
        }
    }

    private void setarPlanosDeFundo(Graphics g)
    {
        for (int i = 0; i < graficos.size(); i++) {
            graficos.get(i).setarPlanoDeFundo(g);
        }
    }

    private void preencherGraficos(Graphics g)
    {
        for (int i = 0; i < graficos.size(); i++) {
            graficos.get(i).preencher(g,(int) linha.getX1());
        }
    }

    private void preencherGraficosResultados(Graphics g)
    {
        for (int i = 0; i < graficos.size(); i++) {
            graficos.get(i).preencherResultado(g);
        }
    }

    private void desenharLinhaVertical(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.red);
        g2d.draw(linha);
    }

    public double getValorInicialLinha()
    {
        return linha.getX1();
    }

}
