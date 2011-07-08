/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.hopfield.arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Neto
 */
public class ManipuladorArquivo {

    public static final String PATH_PADROES_DEFAULT = "padroes.txt";
    public static final String PATH_RUIDOS_DEFAULT = "ruidos.txt";
    public static final int BIAS_DEFAULT = -1;

    public static final int LINHAS_ARQUIVO_PADROES_DEFAULT = 4;
    public static final int LINHAS_ARQUIVO_RUIDOS_DEFAULT = 12;

    public static final int TOTAL_COLUNAS_DEFAULT = 45;

    private String path_arqPadroes;
    private String path_arqRuidos;

    private Arquivo arquivoPadroes;
    private Arquivo arquivoRuidos;

    public ManipuladorArquivo()
    {
        path_arqPadroes = PATH_PADROES_DEFAULT;
        path_arqRuidos = PATH_RUIDOS_DEFAULT;
    }

    public ManipuladorArquivo(String arqPadroes, String arqRuidos)
    {
       this.path_arqPadroes = arqPadroes;
       this.path_arqRuidos = arqRuidos;
    }

     public void carregarDados()
    {
        carregarDadosPadroes();
        carregarDadosRuidos();
    }

    private void carregarDadosPadroes()
    {
        int linhas = LINHAS_ARQUIVO_PADROES_DEFAULT;
        int colunas = TOTAL_COLUNAS_DEFAULT;

        double[][] dados_padroes = new double[linhas][colunas];
        dados_padroes = lerArquivo(path_arqPadroes, linhas, colunas);
        arquivoPadroes = new Arquivo(dados_padroes);
    }

    private void carregarDadosRuidos()
    {
        int linhas = LINHAS_ARQUIVO_RUIDOS_DEFAULT;
        int colunas = TOTAL_COLUNAS_DEFAULT;

        double[][] dados_ruidos = new double[linhas][colunas];
        dados_ruidos = lerArquivo(path_arqRuidos, linhas, colunas);
        arquivoRuidos = new Arquivo(dados_ruidos);
    }

    private double[][] lerArquivo( String arquivo, int linhas, int colunas ) {
        double[][] dados = new double[linhas][colunas];

        try {
            BufferedReader in = new BufferedReader(new FileReader(arquivo));
            String str;
            int count = 0;

            while (in.ready() && count < linhas) {
                str = in.readLine();
                dados[count] = montarLinha(str, colunas);

                count++;
            }
            in.close();

            return dados;

        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    private double[] montarLinha(String linhaString, int colunas) {
        String[] partes = new String[colunas];
        double[] resultado = new double[colunas];

        partes = linhaString.split(" ");

        for (int j = 0; j < colunas; j++) {
            resultado[j] = Double.parseDouble(partes[j]);
        }
        return resultado;
    }

    public Arquivo getArquivoPadroes()
    {
        return arquivoPadroes;
    }

    public Arquivo getArquivoRuidos()
    {
        return arquivoRuidos;
    }

}
