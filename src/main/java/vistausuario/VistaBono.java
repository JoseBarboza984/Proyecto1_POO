/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistausuario;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logicadenegocios.ConstruccionVivienda;
import logicadenegocios.Credito;
import util.Json;
import util.funciones;
import static vistausuario.Menu.solicitantes;
import static vistausuario.VistaCredito.*;

/**
 *
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class VistaBono extends javax.swing.JFrame {
    public boolean bono;
    funciones realizar;
    VistaCredito info;

    /**
     * Constructor de la vista bono
     */
    public VistaBono() {
        this.realizar = new funciones();
        this.info = new VistaCredito();
        initComponents();
        
        this.setLocationRelativeTo(null);
        TextPrompt ingresoTP = new TextPrompt("Ingresar salario familiar bruto",Ingreso);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bono = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Registrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BotonSi = new javax.swing.JRadioButton();
        BotonNo = new javax.swing.JRadioButton();
        Ingreso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel1.setText("Créditos");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 25));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 25));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        jPanel3.add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("¿Desea aplicar al bono de vivienda?");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 290, 20));

        BotonSi.setBackground(new java.awt.Color(51, 51, 51));
        Bono.add(BotonSi);
        BotonSi.setText("Si quiero");
        BotonSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonSiMouseClicked(evt);
            }
        });
        BotonSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSiActionPerformed(evt);
            }
        });
        BotonSi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BotonSiKeyTyped(evt);
            }
        });
        jPanel3.add(BotonSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 200, 30));

        BotonNo.setBackground(new java.awt.Color(51, 51, 51));
        Bono.add(BotonNo);
        BotonNo.setText("No quiero");
        BotonNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonNoMouseClicked(evt);
            }
        });
        BotonNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNoActionPerformed(evt);
            }
        });
        BotonNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BotonNoKeyTyped(evt);
            }
        });
        jPanel3.add(BotonNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 200, 30));

        Ingreso.setBackground(new java.awt.Color(51, 51, 51));
        Ingreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IngresoKeyTyped(evt);
            }
        });
        jPanel3.add(Ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 200, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 800, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 575));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        if(bono != false && bono != true)
            JOptionPane.showMessageDialog(this, "Favor elegir una opcion");
        else {
            if(monto < 7630000 && moneda.equals("Colones")){
                JOptionPane.showMessageDialog(this, "El monto solicitado es muy pequeño para aplicar a un bono");
                bono = false;
            }
            else if(monto < 7630000/670 && moneda.equals("Dolares")){
                JOptionPane.showMessageDialog(this, "El monto solicitado es muy pequeño para aplicar a un bono");
                bono = false;
            }
            double ingreso = 0;
            if(bono = false) {
                ingreso = Double.valueOf(Ingreso.getText());
            }
            ConstruccionVivienda credito = new ConstruccionVivienda(tipo, monto, plazo, moneda, TBP, TED, bono, ingreso);
            realizar.registrarCreditoVivienda(solicitante, credito);
            Credito credito2 = realizar.buscarCredito(solicitante, credito.getNumeroSolicitud());
            Object[][] matriz = credito2.calcularTablaAmortizacion(monto, plazo, credito2.getTasaInteres());
            for(Object[] row:matriz) {
                DefaultTableModel tblModel = (DefaultTableModel) info.jTable1.getModel();
                tblModel.addRow(row);
            }
            Json almacenar = new Json();
            almacenar.guardar(solicitantes);
            info.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_RegistrarActionPerformed

    private void BotonSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonSiMouseClicked
        bono = true;        
    }//GEN-LAST:event_BotonSiMouseClicked

    private void BotonSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonSiActionPerformed

    private void BotonSiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BotonSiKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonSiKeyTyped

    private void BotonNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonNoMouseClicked
        bono = false;
    }//GEN-LAST:event_BotonNoMouseClicked

    private void BotonNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonNoActionPerformed

    private void BotonNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BotonNoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonNoKeyTyped

    private void IngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IngresoKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0' || caracter > '9'))
            &&(caracter != KeyEvent.VK_BACK_SPACE)
            &&(caracter != '.' || Ingreso.getText().contains("."))){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_IngresoKeyTyped

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
        } catch (ClassNotFoundException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaBono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaBono().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Bono;
    private javax.swing.JRadioButton BotonNo;
    private javax.swing.JRadioButton BotonSi;
    private javax.swing.JTextField Ingreso;
    private javax.swing.JButton Registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
