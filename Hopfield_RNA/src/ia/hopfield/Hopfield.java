/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.hopfield;

import Jama.Matrix;
import ia.hopfield.arquivo.Arquivo;
import ia.hopfield.arquivo.ManipuladorArquivo;
import ia.hopfield.gui.HopfieldGUI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neto
 */
public class Hopfield {

    //private List<Neuronio> neuronios;

    private ManipuladorArquivo fileHandler = new ManipuladorArquivo();
    private Arquivo arquivoPadroes;
    private Arquivo arquivoRuidos;

    private int qtdNeuronios;

    private double[] x;
    private double[] v;
    private Matrix i;
    private Matrix W;
    private Matrix u;

    private HopfieldGUI janela;

    public Hopfield(int qtdNeuronios)
    {
        this.qtdNeuronios = qtdNeuronios;
        fileHandler.carregarDados();
        arquivoPadroes = fileHandler.getArquivoPadroes();
        arquivoRuidos = fileHandler.getArquivoRuidos();
        u = new Matrix(Utils.converterParaMatrizColuna(new double[qtdNeuronios]));
        //inicializarNeuronios(qtdNeuronios);
        inicializarMatrizPesos();
        inicializarLimiares();
    }

    public Hopfield(int qtdNeuronios, boolean gui)
    {
        this(qtdNeuronios);
        if(gui) {
            janela = new HopfieldGUI(this);
        }
    }

    public void showInterface()
    {
        inicializarInterface();
        janela.setTitle("Hopfield RNA");
        janela.setVisible(true);
    }

    private void inicializarInterface()
    {
         janela.imprimirPadrao1();
         janela.imprimirPadrao2();
         janela.imprimirPadrao3();
         janela.imprimirPadrao4();
    }

//    private void inicializarNeuronios(int qtdNeuronios)
//    {
//        neuronios = new ArrayList();
//        for (int j = 0; j < qtdNeuronios; j++) {
//            neuronios.add(new Neuronio());
//        }
//    }

    private void inicializarMatrizPesos()
    {
        W = new Matrix(new double[qtdNeuronios][qtdNeuronios]);
        double aux = arquivoPadroes.getTotalLinhas() / qtdNeuronios;
        for (int k = 0; k < arquivoPadroes.getTotalLinhas(); k++) {
            Matrix padrao = arquivoPadroes.getPadrao(k);
            //padrao.print(5, 0);
            Matrix padraoT = padrao.transpose();
            //padraoT.print(5, 1);
            Matrix identidade = Matrix.identity(qtdNeuronios, qtdNeuronios);
            //identidade.print(5, 1);

            Matrix primeiroTermo = padrao.times(padraoT);
            //primeiroTermo.print(5, 1);
            Matrix segundoTermo = identidade.times(aux);
            //segundoTermo.print(5, 5);
            Matrix subtracao = primeiroTermo.minus(segundoTermo);
            //subtracao.print(5, 1);
            //W.print(5, 1);
            W.plusEquals(subtracao);
            //W.print(5, 1);

            //W.plus(padraoT.times(padrao).minus(identidade.times(aux)));
        }
        //W.timesEquals(1/qtdNeuronios);
        //W.print(5, 5);
    }
    
    private void inicializarLimiares()
    {
        double[] limiares = new double[qtdNeuronios];
        for (int i = 0; i < limiares.length; i++) {
            limiares[i] = -1;            
        }
        i = new Matrix(Utils.converterParaMatrizColuna(limiares));
    }

    public Matrix recuperarPadrao(Matrix padrao)
    {
        Matrix v_atual = padrao;
        //padrao.print(5, 5);
        Matrix v_ant = Matrix.random(qtdNeuronios, 1);
        //v_ant.print(5, 5);
        int epocas = 0;

        while(!igual(v_ant, v_atual))
        {
            v_ant = v_atual.copy();
            u = W.times(v_ant).plus(i);
            v_atual = sinal(u);
            epocas++;
            //System.out.println("epoca: "+epocas);
        }
        imprimirPadrao(v_atual);
        return v_atual;
    }

    private Matrix sinal(Matrix entrada)
    {
        Matrix resultado = new Matrix(new double[entrada.getRowDimension()][entrada.getColumnDimension()]);
        for (int i = 0; i < resultado.getRowDimension(); i++) {
            for (int j = 0; j < resultado.getColumnDimension(); j++) {
                resultado.set(i, j, sinal(entrada.get(i, j)));
            }
        }
        return resultado;
    }

    private int sinal(double x)
    {
        if (x >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public void imprimirPadrao(Matrix padrao)
    {
        if(padrao.getColumnDimension()>1)
        {
            throw new IllegalArgumentException("padrão de entrada deve possuir uma única coluna!");
        }

        int count = 0;
        double[] linha = new double[5];
        for (int i = 0; i < padrao.getRowDimension(); i++) {
            linha[count] = padrao.get(i, 0);
            count++;
            if(count==5) {
                for (int j = 0; j < linha.length; j++) {
                    if (linha[j] == -1) {
                        System.out.print("-");
                    } else if (linha[j] == 1) {
                        System.out.print("#");
                    }
                }
                System.out.print("\n");
                count = 0;
            }
        }
        System.out.print("\n\n");
    }

    public boolean igual(Matrix matriz1, Matrix matriz2)
    {
        if (!(matriz1.getRowDimension() == matriz2.getRowDimension() && matriz1.getColumnDimension() == matriz2.getColumnDimension())) {
            return false;
        }

        for (int i = 0; i < matriz1.getRowDimension(); i++) {
            for (int j = 0; j < matriz1.getColumnDimension(); j++) {
                if (matriz1.get(i, j) != matriz2.get(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Arquivo getArquivoPadroes()
    {
        return this.arquivoPadroes;
    }

    public Arquivo getArquivoRuidos()
    {
        return this.arquivoRuidos;
    }

    public static void main(String[] args) {
        

        Hopfield hopfield = new Hopfield(45);
        hopfield.imprimirPadrao(hopfield.getArquivoPadroes().getPadrao(0));
        hopfield.imprimirPadrao(hopfield.getArquivoPadroes().getPadrao(1));
        hopfield.imprimirPadrao(hopfield.getArquivoPadroes().getPadrao(2));
        hopfield.imprimirPadrao(hopfield.getArquivoPadroes().getPadrao(3));

          System.out.println("PRIMEIRO PADRÃO RUIDOSO:");
          hopfield.imprimirPadrao(hopfield.getArquivoRuidos().getPadrao(1));
          hopfield.recuperarPadrao(hopfield.getArquivoRuidos().getPadrao(1));

          System.out.println("SEGUNDO PADRÃO RUIDOSO:");
          hopfield.imprimirPadrao(hopfield.getArquivoRuidos().getPadrao(2));
          hopfield.recuperarPadrao(hopfield.getArquivoRuidos().getPadrao(2));

          System.out.println("TERCEIRO PADRÃO RUIDOSO:");
          hopfield.imprimirPadrao(hopfield.getArquivoRuidos().getPadrao(3));
          hopfield.recuperarPadrao(hopfield.getArquivoRuidos().getPadrao(3));

          System.out.println("QUARTO PADRÃO RUIDOSO:");
          hopfield.imprimirPadrao(hopfield.getArquivoRuidos().getPadrao(4));
          hopfield.recuperarPadrao(hopfield.getArquivoRuidos().getPadrao(4));

          System.out.println("QUINTO PADRÃO RUIDOSO:");
          hopfield.imprimirPadrao(hopfield.getArquivoRuidos().getPadrao(5));
          hopfield.recuperarPadrao(hopfield.getArquivoRuidos().getPadrao(5));

           System.out.println("SEXTO PADRÃO RUIDOSO:");
          hopfield.imprimirPadrao(hopfield.getArquivoRuidos().getPadrao(6));
          hopfield.recuperarPadrao(hopfield.getArquivoRuidos().getPadrao(6));

          System.out.println("SÉTIMO PADRÃO RUIDOSO:");
          hopfield.imprimirPadrao(hopfield.getArquivoRuidos().getPadrao(7));
          hopfield.recuperarPadrao(hopfield.getArquivoRuidos().getPadrao(7));

          System.out.println("OITAVO PADRÃO RUIDOSO:");
          hopfield.imprimirPadrao(hopfield.getArquivoRuidos().getPadrao(8));
          hopfield.recuperarPadrao(hopfield.getArquivoRuidos().getPadrao(8));

          System.out.println("NONO PADRÃO RUIDOSO:");
          hopfield.imprimirPadrao(hopfield.getArquivoRuidos().getPadrao(9));
          hopfield.recuperarPadrao(hopfield.getArquivoRuidos().getPadrao(9));

          System.out.println("DÉCIMO PADRÃO RUIDOSO:");
          hopfield.imprimirPadrao(hopfield.getArquivoRuidos().getPadrao(10));
          hopfield.recuperarPadrao(hopfield.getArquivoRuidos().getPadrao(10));

          System.out.println("DÉCIMO PRIMEIRO PADRÃO RUIDOSO:");
          hopfield.imprimirPadrao(hopfield.getArquivoRuidos().getPadrao(11));
          hopfield.recuperarPadrao(hopfield.getArquivoRuidos().getPadrao(11));
    }

}
