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
    private double x[] = new double[4];  //camada de entrada
    private double y[] = new double[3];  //valores de saída

    public Perceptron() {
        fileHandler.carregarDados();
        arquivoTeste = fileHandler.getArquivoTeste();
        arquivoTreino = fileHandler.getArquivoTreino();
        initCamadasDefault();
    }

    private void processarEntradas() {
        for (int i = 0; i < camadas.size(); i++) {
            if (i == 0) {
                camadas.get(i).processar(x);
            } else {
                Camada anterior = camadas.get(i - 1);
                camadas.get(i).processar(anterior.getSaida());
            }
        }
    }

    private void initCamadasDefault() {
        criarCamada(15, 4);
        criarCamada(3, 15);
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
}
