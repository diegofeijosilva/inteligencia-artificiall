package ia.perceptron;

import ia.perceptron.arquivo.ManipuladorArquivo;
import java.util.ArrayList;
import java.util.List;
import ia.perceptron.arquivo.Arquivo;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Larissa
 */
public class Perceptron {

    public static final double TAXA_APRENDIZAGEM = 0.1;
    public static final double PRECISAO = 0.000001;

    private List<Camada> camadas = new ArrayList<Camada>();

    private ManipuladorArquivo fileHandler = new ManipuladorArquivo();
    private Arquivo arquivoTeste;
    private Arquivo arquivoTreino;

    private boolean momentum;
    private double bias = -1;
    private double x[] = new double[4];  //camada de entrada
    private double d[] = new double[3];  //valores desejados de saída em uma propagação
    private double y[] = new double[3];  //valores obtidos de saída em uma propagação
    private double Y[][]; //valores de saída obtidos para todas as amostras de entrada;
    double[] y_aux = new double[3];

    final XYSeries series = new XYSeries ("Data");

    public Perceptron()
    {
        fileHandler.carregarDados();
        arquivoTeste = fileHandler.getArquivoTeste();
        arquivoTreino = fileHandler.getArquivoTreino();
        Y = new double[arquivoTreino.getTotalLinhas()][3];
    }

    public Perceptron(int entradas)
    {
        this();
        x = new double[entradas]; 
    }


    protected void propagarEntradas() {
        for (int i = 0; i < camadas.size(); i++) {
            if (i == 0) {
                camadas.get(i).processar(x);
            } else {
                Camada anterior = camadas.get(i - 1);
                camadas.get(i).processar(anterior.getSaida());
            }
        }
        atualizarSaida();
    }

    public void treinar()
    {
        double EQM_ant = 999999999;
        double EQM_atual = 0;
        double epoca = 0;

        while( Math.abs(EQM_atual - EQM_ant) > PRECISAO )
        {
            EQM_ant = EQM_atual;
            for (int i = 0; i < arquivoTreino.getTotalLinhas(); i++) {
                x = arquivoTreino.x(i);
                d = arquivoTreino.d(i);
                propagarEntradas();
                reajustarPesos();
                Y[i] = y_aux;
            }
            EQM_atual = EQM();
            epoca++;
            System.out.println("EQM: " + EQM_atual);
            series.add(epoca,EQM_atual);
        }
        System.out.println("epoca: " + epoca);
        gerarGráfico();
    }

    public void testar()
    {
        boolean sucesso = true;
        for (int i = 0; i < arquivoTeste.getTotalLinhas(); i++) {
            sucesso = true;
            x = arquivoTeste.x(i);
            d = arquivoTeste.d(i);
            propagarEntradas();
            posProcessamento();

            for (int j = 0; j < d.length; j++) {
                if( y[j]!=d[j] )
                    sucesso = false;
            }
            if(sucesso)
                System.out.println("OK   ---->  "+y[0]+"  "+y[1]+"  "+y[2]);
            else
                System.out.println("ERRO ---->  "+y[0]+"  "+y[1]+"  "+y[2]);
        }
    }

    private void posProcessamento() {
        for (int i = 0; i < y.length; i++) {
            if (y[i] >= 0.5) {
                y[i] = 1;
            } else {
                y[i] = 0;
            }
        }
    }

    private double EQM()
    {
        int totalAmostras = arquivoTreino.getTotalLinhas();
        double resultado = 0;
        atualizarSaida();

        for (int k = 0; k < totalAmostras; k++) {
            resultado += erroQuadratico(arquivoTreino.d(k),Y[k]);
        }
        return resultado/totalAmostras;
    }
    
    private double erroQuadratico(double[] esperado, double[] obtido) {
        double resultado = 0;

        if (esperado.length != obtido.length) {
            throw new IllegalArgumentException("Os vetores devem ter o mesmo tamanho!");
        }
        for (int i = 0; i < esperado.length; i++) {
            double erro = esperado[i] - obtido[i];
            resultado += Math.pow(erro, 2);
        }
        return resultado / 2;
    }

    private void reajustarPesos() {
        int indexUltimaCamada = camadas.size() - 1;
        for (int i = indexUltimaCamada; i > -1; i--) {
            if (i == indexUltimaCamada) {
                camadas.get(i).calcularGradienteLocalCamadaDeSaida(d);
            } else {
                camadas.get(i).calcularGradienteLocalCamadaIntermediaria(camadas.get(i + 1));
            }

            if (i == 0) {
                camadas.get(i).ajustarMatrizPesos(i, isMomentum(), x);
            } else {
                camadas.get(i).ajustarMatrizPesos(i, isMomentum(), camadas.get(i - 1).getSaida());
            }
        }
    }


    private void atualizarSaida() {
        Camada ultima = camadas.get(camadas.size() - 1);
        y_aux = new double[3];
        for (int i = 0; i < ultima.getQtdNeuronios(); i++) {
            //y[i] = ultima.getSaida()[i];
            y_aux[i] = ultima.getSaida()[i];

        }
    }

    public void gerarGráfico(){
         JFrame frame = new JFrame("Erro quadrático X Épocas");
         frame.setSize(new Dimension(1024,1024));

         final XYSeriesCollection data = new XYSeriesCollection(series);
         final JFreeChart chart = ChartFactory.createXYLineChart("Erro quadrático X quantidade de épocas", "Épocas", "Erro quadrático",
                 data,PlotOrientation.VERTICAL , true,true, false);
         final ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension (1024, 1024));
            chartPanel.setVisible(true);

            frame.setContentPane(chartPanel);
            frame.setVisible(true);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

    public void criarCamada(int qtdNeuronios, int qtdEntradas) {
        camadas.add(new Camada(qtdNeuronios, qtdEntradas));
    }

    public boolean isMomentum() {
        return momentum;
    }

    public void setMomentum(boolean momentum) {
        this.momentum = momentum;
    }

    public Camada getCamada(int index)
    {
        return camadas.get(index);
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    protected void setEntrada(double[] entrada)
    {
        if(entrada.length != x.length)
            throw new IllegalArgumentException("O vetor passado tem tamanho diferente do vetor de entrada! ");

        x = entrada;
    }

    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron(4);
        perceptron.setBias(-1);

        perceptron.criarCamada(15, 4);
        perceptron.criarCamada(3, 15);

        perceptron.setMomentum(false);
        perceptron.treinar();
        perceptron.testar();

    }
}
