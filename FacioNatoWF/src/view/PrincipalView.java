/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author paulo
 */
public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalView
     */
    public PrincipalView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MnCadastros = new javax.swing.JMenu();
        CadPensionato = new javax.swing.JMenuItem();
        CadQuarto = new javax.swing.JMenuItem();
        CadInquilino = new javax.swing.JMenuItem();
        CadCompra = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        MnSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gerenciamento de Pensionatos");
        setLocationByPlatform(true);

        MenuBar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMenu1.setText("Arquivo");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        MenuBar.add(jMenu1);

        MnCadastros.setText("Cadastros");
        MnCadastros.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        CadPensionato.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CadPensionato.setText("Pensionato");
        CadPensionato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadPensionatoActionPerformed(evt);
            }
        });
        MnCadastros.add(CadPensionato);

        CadQuarto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CadQuarto.setText("Quarto");
        CadQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadQuartoActionPerformed(evt);
            }
        });
        MnCadastros.add(CadQuarto);

        CadInquilino.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CadInquilino.setText("Inquilino");
        CadInquilino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadInquilinoActionPerformed(evt);
            }
        });
        MnCadastros.add(CadInquilino);

        CadCompra.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CadCompra.setText("Compra");
        CadCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadCompraActionPerformed(evt);
            }
        });
        MnCadastros.add(CadCompra);

        MenuBar.add(MnCadastros);

        jMenu2.setText("Configuração");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMenuItem1.setText("Aluguel");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        MenuBar.add(jMenu2);

        MnSobre.setText("Ajuda");
        MnSobre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        MenuBar.add(MnSobre);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 819, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CadPensionatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadPensionatoActionPerformed
        PensionatoView pensionatoView = new PensionatoView();
        pensionatoView.setVisible(true);
    }//GEN-LAST:event_CadPensionatoActionPerformed

    private void CadQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadQuartoActionPerformed
        QuartoView quartoView = new QuartoView();
        quartoView.setVisible(true);
    }//GEN-LAST:event_CadQuartoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ConfigCobrancaView configCobrancaView = new ConfigCobrancaView();
        configCobrancaView.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void CadInquilinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadInquilinoActionPerformed
        InquilinoView inquilinoView = new InquilinoView();
        inquilinoView.setVisible(true);
    }//GEN-LAST:event_CadInquilinoActionPerformed

    private void CadCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadCompraActionPerformed
        CompraView compraView = new CompraView();
        compraView.setVisible(true);
    }//GEN-LAST:event_CadCompraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CadCompra;
    private javax.swing.JMenuItem CadInquilino;
    private javax.swing.JMenuItem CadPensionato;
    private javax.swing.JMenuItem CadQuarto;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MnCadastros;
    private javax.swing.JMenu MnSobre;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
