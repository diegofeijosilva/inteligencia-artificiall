/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.perceptron.arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Neto
 */
public class ManipuladorArquivo {

    public static final String ARQUIVO_TREINO_DEFAULT = "treina.txt";
    public static final String ARQUIVO_TESTE_DEFAULT = "teste.txt";
    public static final int BIAS_DEFAULT = -1;
    
    public static final int LINHAS_ARQUIVO_TREINO_DEFAULT = 130;
    public static final int LINHAS_ARQUIVO_TESTE_DEFAULT = 18;

    private String arqTreino;
    private String arqTeste;

    private Arquivo arquivoTreino;
    private Arquivo arquivoTeste;

    public ManipuladorArquivo()
    {
        arqTreino = ARQUIVO_TREINO_DEFAULT;
        arqTeste = ARQUIVO_TESTE_DEFAULT;
    }

    public ManipuladorArquivo(String arqTreino, String arqTeste)
    {
       this();
       this.arqTreino = arqTreino;
       this.arqTeste = arqTeste;
    }

    public void carregarDados()
    {
        carregarDadosTreino();
        carregarDadosTeste();
    }
    

    private void carregarDadosTreino()
    {
        double[][] dados_treino = new double[LINHAS_ARQUIVO_TREINO_DEFAULT][totalColunas()];
        dados_treino = lerArquivo(arqTreino, LINHAS_ARQUIVO_TREINO_DEFAULT, totalColunas());
        arquivoTreino = new Arquivo(dados_treino);
        arquivoTreino.setLinhas(LINHAS_ARQUIVO_TREINO_DEFAULT);
        arquivoTreino.parseDadosArquivo();
    }

    private void carregarDadosTeste()
    {
        double[][] dados_teste = new double[LINHAS_ARQUIVO_TESTE_DEFAULT][totalColunas()];
        dados_teste = lerArquivo(arqTeste, LINHAS_ARQUIVO_TESTE_DEFAULT, totalColunas());
        arquivoTeste = new Arquivo(dados_teste);
        arquivoTeste.setLinhas(LINHAS_ARQUIVO_TESTE_DEFAULT);
        arquivoTeste.parseDadosArquivo();
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

    private int totalColunas() {
        return  Arquivo.QTD_COLUNAS_ENTRADA_DEFAULT + Arquivo.QTD_COLUNAS_SAIDA_DEFAULT + 1;
    }

    public Arquivo getArquivoTeste()
    {
        return this.arquivoTeste;
    }

    public Arquivo getArquivoTreino()
    {
        return this.arquivoTreino;
    }
}