package ia.perceptron;

import ia.perceptron.arquivo.ManipuladorArquivo;
import java.util.ArrayList;
import java.util.List;
import ia.perceptron.arquivo.Arquivo;

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
    
    private double bias = -1;
    private double x[] = new double[4];  //camada de entrada
    private double d[] = new double[3];  //valores desejados de saída em uma propagação
    private double y[] = new double[3];  //valores obtidos de saída em uma propagação

    public Perceptron(int entradas) {
        x = new double[entradas];
        fileHandler.carregarDados();
        arquivoTeste = fileHandler.getArquivoTeste();
        arquivoTreino = fileHandler.getArquivoTreino();
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
    }

    private void reajustarPesos()
    {
        int indiceUltimaCamada = camadas.size()-1;
        for (int i = indiceUltimaCamada; i>-1; i--) {
            if( i==indiceUltimaCamada )
            {
                camadas.get(i).calcularGradienteLocalCamadaDeSaida(d);
            }
            else
            {
                camadas.get(i).calcularGradienteLocalCamadaIntermediaria(camadas.get(i+1));
            }
            if( i==0 )
            {
                camadas.get(i).ajustarMatrizPesos(x);
            }
            else
            {
                camadas.get(i).ajustarMatrizPesos(camadas.get(i-1).getSaida());
            }
        }
    }

    private void treinar()
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
            }
            //EQM_atual = EQM();
            epoca++;
        }
    }

//    private double EQM()
//    {
//        int totalAmostras = ManipuladorArquivo.LINHAS_ARQUIVO_TREINO_DEFAULT;
//        double resultado = 0;
//        atualizarSaida();
//
//        for (int k = 0; k < totalAmostras; k++) {
//            resultado += erroQuadratico(arquivoTreino.d(k),);
//        }
//        return resultado/totalAmostras;
//    }
    
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

    private void atualizarSaida() {
        Camada ultima = camadas.get(camadas.size() - 1);

        for (int i = 0; i < ultima.getQtdNeuronios(); i++) {
            y[i] = ultima.getNeuronio(i).getSaida();
        }
    }

    public void criarCamada(int qtdNeuronios, int qtdEntradas) {
        camadas.add(new Camada(qtdNeuronios, qtdEntradas));
    }

    public Camada getCamada(int index)
    {
        return camadas.get(index);
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public void setEntrada(double[] entrada)
    {
        if(entrada.length != x.length)
            throw new IllegalArgumentException("O vetor passado tem tamanho diferente do vetor de entrada! ");

        x = entrada;
    }
}
