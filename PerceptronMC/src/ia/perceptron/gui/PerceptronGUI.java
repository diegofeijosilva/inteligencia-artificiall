/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PerceptronGUI.java
 *
 * Created on 02/07/2011, 21:10:56
 */

package ia.perceptron.gui;

import ia.perceptron.Perceptron;
import ia.perceptron.arquivo.Arquivo;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Neto
 */
public class PerceptronGUI extends javax.swing.JFrame implements Observer {

    /** Creates new form PerceptronGUI */
    public PerceptronGUI(Perceptron perceptron) {
        this.perceptron = perceptron;
        this.perceptron.addObserver((Observer) this);
        update(this.perceptron, null);
        initComponents();
        configComponents();
        
        //JOptionPane.showMessageDialog(null,"Testando!!!");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelNumeroCamadas = new javax.swing.JLabel();
        jLabelTaxaAprendizagem = new javax.swing.JLabel();
        jLabelPrecisao = new javax.swing.JLabel();
        jLabelFuncaoAtivacao = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelFatorMomentum = new javax.swing.JLabel();
        jLabelTreinadaRotulo = new javax.swing.JLabel();
        jLabelTreinada = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelTestadaRotulo = new javax.swing.JLabel();
        jLabelTestada = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTreino = new javax.swing.JTable();
        jButtonTreinar = new javax.swing.JButton();
        jButtonGerarGrafico = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelEpocas = new javax.swing.JLabel();
        jLabelEQM = new javax.swing.JLabel();
        jCheckBoxMomentum = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTeste = new javax.swing.JTable();
        jButtonTestar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabelTaxaAcerto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parâmetros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Número de Camadas:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Taxa de Aprendizagem:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Precisão:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Função de Ativação:");

        jLabelNumeroCamadas.setText("0");

        jLabelTaxaAprendizagem.setText("0.01");

        jLabelPrecisao.setText("0.000001");

        jLabelFuncaoAtivacao.setText("SIGMÓIDE");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel11.setText("Fator de Momentum:");

        jLabelFatorMomentum.setText("0.9");

        jLabelTreinadaRotulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTreinadaRotulo.setForeground(new java.awt.Color(102, 102, 102));
        jLabelTreinadaRotulo.setText("Treinada:");

        jLabelTreinada.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTreinada.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTreinada.setText("NÃO");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setText("EQM Máximo:");

        jLabel10.setText("0.03");

        jLabelTestadaRotulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTestadaRotulo.setForeground(new java.awt.Color(102, 102, 102));
        jLabelTestadaRotulo.setText("Testada:");

        jLabelTestada.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTestada.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTestada.setText("NÃO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPrecisao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFuncaoAtivacao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFatorMomentum))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNumeroCamadas))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTaxaAprendizagem)))
                        .addGap(117, 117, 117)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelTestadaRotulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelTestada, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelTreinadaRotulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTreinada, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(757, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNumeroCamadas)
                    .addComponent(jLabelTreinadaRotulo)
                    .addComponent(jLabelTreinada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelTaxaAprendizagem)
                    .addComponent(jLabelTestadaRotulo)
                    .addComponent(jLabelTestada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelPrecisao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabelFatorMomentum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelFuncaoAtivacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableTreino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Amostra", "x1", "x2", "x3", "x4", "d1", "d2", "d3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableTreino);
        jTableTreino.getColumnModel().getColumn(0).setPreferredWidth(20);

        jButtonTreinar.setText("Treinar");
        jButtonTreinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTreinarActionPerformed(evt);
            }
        });

        jButtonGerarGrafico.setText("Gerar Gráfico");
        jButtonGerarGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarGraficoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("Total de Épocas:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText("EQM Final:");

        jLabelEpocas.setText("0");

        jLabelEQM.setText("0");

        jCheckBoxMomentum.setText("Momentum");
        jCheckBoxMomentum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMomentumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1161, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBoxMomentum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 670, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEpocas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEQM, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonTreinar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGerarGrafico)
                        .addContainerGap(981, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabelEpocas)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxMomentum)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonTreinar)
                            .addComponent(jButtonGerarGrafico))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEQM)
                            .addComponent(jLabel7))
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Treino", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableTeste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Amostra", "x1", "x2", "x3", "x4", "d1", "d2", "d3", "y1", "y2", "y3", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableTeste);

        jButtonTestar.setText("Testar");
        jButtonTestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTestarActionPerformed(evt);
            }
        });

        jLabel6.setText("Taxa de Acerto:");

        jLabelTaxaAcerto.setText("0%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1161, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonTestar)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTaxaAcerto)))
                .addContainerGap(1050, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelTaxaAcerto))
                .addGap(42, 42, 42)
                .addComponent(jButtonTestar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Teste", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Teste");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTreinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTreinarActionPerformed
        perceptron.treinar();
        jLabelTreinada.setText("OK");
        jLabelTreinada.setForeground(Color.GREEN);
        jLabelEQM.setForeground(Color.BLUE);
        jLabelEQM.setText(String.valueOf(perceptron.getEQM_atual()));
        jLabelEpocas.setForeground(Color.BLUE);
        jLabelEpocas.setText(String.valueOf(perceptron.getEpocas()));
        jLabelNumeroCamadas.setText(String.valueOf(perceptron.getNumeroCamadas()));
    }//GEN-LAST:event_jButtonTreinarActionPerformed

    private void jButtonGerarGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarGraficoActionPerformed
        perceptron.gerarGrafico();
    }//GEN-LAST:event_jButtonGerarGraficoActionPerformed

    private void jButtonTestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTestarActionPerformed
        perceptron.testar();
        jLabelTestada.setText("OK");
        jLabelTestada.setForeground(Color.GREEN);
        jLabelTaxaAcerto.setText(String.valueOf(perceptron.getTaxaAcerto())+"%");
    }//GEN-LAST:event_jButtonTestarActionPerformed

    private void jCheckBoxMomentumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMomentumActionPerformed
        perceptron.setMomentum(jCheckBoxMomentum.isSelected());
    }//GEN-LAST:event_jCheckBoxMomentumActionPerformed

    private void configComponents()
    {
        jTableTeste.setDefaultRenderer(Object.class, new CellRenderer());
        jTableTreino.setDefaultRenderer(Object.class, new CellRenderer());
        jLabelNumeroCamadas.setText(String.valueOf(perceptron.getNumeroCamadas()));
       // jLabelProcessando.setVisible(false);
    }

    public void imprimirArquivoTreino()
    {
        Arquivo arquivoTreino = perceptron.getArquivoTreino();

        for (int i = 0; i < arquivoTreino.getTotalLinhas(); i++) {
            imprimirLinhaTreino(i+1,arquivoTreino.x(i),arquivoTreino.d(i));
        }
    }

    public void imprimirArquivoTeste()
    {
        Arquivo arquivoTeste = perceptron.getArquivoTeste();

        for (int i = 0; i < arquivoTeste.getTotalLinhas(); i++) {
            imprimirLinhaTeste(i+1,arquivoTeste.x(i),arquivoTeste.d(i));
        }
    }

    private void imprimirLinhaTreino(int amostra, double[] x, double[] d) {

        DefaultTableModel modelo = (DefaultTableModel) jTableTreino.getModel();

        String[] linha = new String[8];
        linha[0] = String.valueOf(amostra);

        for (int i = 1; i < 5; i++) {
            linha[i] = String.valueOf(x[i - 1]);
        }

        for (int i = 5; i < 8; i++) {
            linha[i] = String.valueOf((int)d[i - 5]);
        }

        modelo.addRow(linha);
    }

    private void imprimirLinhaTeste(int amostra, double[] x, double[] d) {

        DefaultTableModel modelo = (DefaultTableModel) jTableTeste.getModel();

        String[] linha = new String[8];
        linha[0] = String.valueOf(amostra);

        for (int i = 1; i < 5; i++) {
            linha[i] = String.valueOf(x[i - 1]);
        }

        for (int i = 5; i < 8; i++) {
            linha[i] = String.valueOf((int)d[i - 5]);
        }

        modelo.addRow(linha);
    }
    
    public void imprimirLinhaResultadoTeste(double[] y, String status, int linha)
    {
        DefaultTableModel modelo = (DefaultTableModel) jTableTeste.getModel();

        for (int i = 8; i < 11; i++) {
            modelo.setValueAt(String.valueOf((int)y[i-8]), linha, i);
        }
        modelo.setValueAt(status,linha,11);    
    }

     

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Perceptron perceptron = new Perceptron();
                perceptron.setMomentum(true);
                new PerceptronGUI(perceptron).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGerarGrafico;
    private javax.swing.JButton jButtonTestar;
    private javax.swing.JButton jButtonTreinar;
    private javax.swing.JCheckBox jCheckBoxMomentum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEQM;
    private javax.swing.JLabel jLabelEpocas;
    private javax.swing.JLabel jLabelFatorMomentum;
    private javax.swing.JLabel jLabelFuncaoAtivacao;
    private javax.swing.JLabel jLabelNumeroCamadas;
    private javax.swing.JLabel jLabelPrecisao;
    private javax.swing.JLabel jLabelTaxaAcerto;
    private javax.swing.JLabel jLabelTaxaAprendizagem;
    private javax.swing.JLabel jLabelTestada;
    private javax.swing.JLabel jLabelTestadaRotulo;
    private javax.swing.JLabel jLabelTreinada;
    private javax.swing.JLabel jLabelTreinadaRotulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableTeste;
    private javax.swing.JTable jTableTreino;
    // End of variables declaration//GEN-END:variables
    Perceptron perceptron;

    public void update(Observable o, Object arg) {
       
    }

}
