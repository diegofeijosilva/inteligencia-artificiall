/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.perceptron.arquivo;

/**
 *
 * @author Neto
 */
public class Arquivo {

    public static final int QTD_COLUNAS_ENTRADA_DEFAULT = 4;
    public static final int QTD_COLUNAS_SAIDA_DEFAULT = 3;

    private double[][] arquivo;
    private double[][] x;
    private double[][] d;
    
    private int linhas;
    private int colunasEntradas;
    private int colunasSaidas;

    public Arquivo(double[][] arquivo)
    {
        this.arquivo = arquivo;
        this.colunasEntradas = QTD_COLUNAS_ENTRADA_DEFAULT;
        this.colunasSaidas = QTD_COLUNAS_SAIDA_DEFAULT;
    }

    public double[] d(int k)
    {
        return d[k];
    }

    public double[] x(int k)
    {
        return x[k];
    }

    public int getTotalLinhas()
    {
        return arquivo.length;
    }

    protected void setLinhas(int linhas)
    {
        this.linhas = linhas;
    }

    protected void separarDados() {
      separarDadosEntrada();
      separarDadosSaida();
    }

    private void separarDadosEntrada()
    {
        x = new double[linhas][colunasEntradas];

        //deslocamento para leitura dos dados de entrada x[], devido ao bias
        int shiftX = 1;

         for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunasEntradas; j++) {
                x[i][j] = arquivo[i][j + shiftX];
            }
        }
        
    }

    private void separarDadosSaida()
    {
          d = new double[linhas][colunasSaidas];

        //deslocamento para leitura dos dados desejados de saída d[], devido ao bias e os dados de entrada
        int shiftD = 1 + colunasEntradas;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunasSaidas; j++) {
                d[i][j] = arquivo[i][j + shiftD];
            }
        }

    }

}
