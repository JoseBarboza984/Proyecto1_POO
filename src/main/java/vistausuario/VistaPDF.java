/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistausuario;

import com.itextpdf.text.DocumentException;
import excepciones.SolicitanteDoesNotExistException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import util.*;
import logicadenegocios.*;

/**
 *
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class VistaPDF extends javax.swing.JFrame {
    funciones realizar = new funciones();
    boolean correo = false;

    /**
     * Constructor de la vista de pdf
     */
    public VistaPDF() {
        initComponents();
        this.setLocationRelativeTo(null);
        TextPrompt play = new TextPrompt("Cédula",Cedula);
        TextPrompt play1 = new TextPrompt("Número de Solicitud",NumeroSolicitud);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Guardar = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
        Cedula = new javax.swing.JTextField();
        NumeroSolicitud = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Generar PDF");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, -1, 25));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 25));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos para generar PDF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Guardar.setText("Generar PDF");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jPanel3.add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 200, -1));

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        jPanel3.add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        Cedula.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.add(Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, 200, 30));

        NumeroSolicitud.setBackground(new java.awt.Color(51, 51, 51));
        NumeroSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumeroSolicitudActionPerformed(evt);
            }
        });
        jPanel3.add(NumeroSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 120, 200, 30));

        jRadioButton1.setBackground(new java.awt.Color(51, 51, 51));
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jRadioButton1.setText("Enviar al correo");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jPanel3.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 170, 200, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 780, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 575));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        try {
            Solicitante solicitante = realizar.buscarSolicitante(Integer.valueOf(Cedula.getText()));
            Credito cre = realizar.buscarCredito(solicitante, NumeroSolicitud.getText());
            if(cre == null)
                JOptionPane.showMessageDialog(rootPane, "No existe un credito ingresado con ese identificador");
            else {
                Object[][] matriz = cre.calcularTablaAmortizacion(cre.getMonto(), cre.getPlazo(), cre.getTasaInteres());
                realizar.guardarPDF(matriz, solicitante, cre.toString(), correo);
            } 
        } catch (SolicitanteDoesNotExistException | IOException | DocumentException ex) {
            JOptionPane.showMessageDialog(rootPane, "No existe un usuario ingresado con la cedula ingresada");
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(rootPane, "El correo electronico del solicitante es incorrecto");
        }
    }//GEN-LAST:event_GuardarActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed

        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void NumeroSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumeroSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumeroSolicitudActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
            correo = true;
    }//GEN-LAST:event_jRadioButton1MouseClicked

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
            java.util.logging.Logger.getLogger(VistaPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPDF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cedula;
    private javax.swing.JButton Guardar;
    private javax.swing.JTextField NumeroSolicitud;
    private javax.swing.JButton Regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables
}
