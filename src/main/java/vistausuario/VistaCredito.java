/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistausuario;

import excepciones.SolicitanteDoesNotExistException;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.*;
import logicadenegocios.*;


/**
 *
 * @author Joshua
 */
public class VistaCredito extends javax.swing.JFrame {
    DefaultTableModel modelo;
    String tipoMoneda = "";
    obtenervalores obtenerTasa = new obtenervalores();
    funciones realizar = new funciones();
    

    /**
     * Creates new form CreditoHipotecario
     */
    public VistaCredito() {
        initComponents();
        String[]titulos={
            "Numero de cuota",
            "Monto de cuota",
            "Intereses",
            "Amortización",
            "Deuda"
                
        };
        modelo=new DefaultTableModel(null,titulos);
        jTable1.setModel(modelo);
        this.setLocationRelativeTo(null);
        
        TextPrompt cambio = new TextPrompt("Monto",Monto);
        TextPrompt cambio1 = new TextPrompt("Cedula",Cedula);
        TextPrompt cambio2 = new TextPrompt("Plazo en años",Plazos);
        
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Moneda = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TipoCredito = new javax.swing.JComboBox<>();
        Monto = new javax.swing.JTextField();
        Cedula = new javax.swing.JTextField();
        BotonColones = new javax.swing.JRadioButton();
        BotonDolares = new javax.swing.JRadioButton();
        Generar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Regresar = new javax.swing.JButton();
        Plazos = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Limpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel1.setText("Registro de crédito");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 150, 25));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 1, 238, 25));

        TipoCredito.setBackground(new java.awt.Color(51, 51, 51));
        TipoCredito.setForeground(new java.awt.Color(102, 102, 102));
        TipoCredito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hipotecario de terreno", "Hipotecario de vivienda", "Fiduciario", "Prendario", "Personal" }));
        jPanel1.add(TipoCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 150, 200, 30));

        Monto.setBackground(new java.awt.Color(51, 51, 51));
        Monto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MontoActionPerformed(evt);
            }
        });
        Monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MontoKeyTyped(evt);
            }
        });
        jPanel1.add(Monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 200, 200, 30));

        Cedula.setBackground(new java.awt.Color(51, 51, 51));
        Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CedulaKeyTyped(evt);
            }
        });
        jPanel1.add(Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 400, 200, 30));

        BotonColones.setBackground(new java.awt.Color(51, 51, 51));
        Moneda.add(BotonColones);
        BotonColones.setText("Colones");
        BotonColones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonColonesMouseClicked(evt);
            }
        });
        BotonColones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonColonesActionPerformed(evt);
            }
        });
        jPanel1.add(BotonColones, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 300, 200, 30));

        BotonDolares.setBackground(new java.awt.Color(51, 51, 51));
        Moneda.add(BotonDolares);
        BotonDolares.setText("Dolares");
        BotonDolares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonDolaresMouseClicked(evt);
            }
        });
        jPanel1.add(BotonDolares, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 350, 200, 30));

        Generar.setBackground(new java.awt.Color(51, 51, 51));
        Generar.setText("Generar");
        Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarActionPerformed(evt);
            }
        });
        jPanel1.add(Generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 540, -1, -1));

        jLabel2.setText("Tipo de crédito");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, 200, 30));

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        jPanel1.add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 540, -1, -1));

        Plazos.setBackground(new java.awt.Color(51, 51, 51));
        Plazos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlazosActionPerformed(evt);
            }
        });
        Plazos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PlazosKeyTyped(evt);
            }
        });
        jPanel1.add(Plazos, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 250, 200, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 575));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 540, 440));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 580, 575));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonColonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColonesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonColonesActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        // TODO add your handling code here:
        
        //Menu newframe = new Menu();
        
        //newframe.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void CedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CedulaKeyTyped
        // TODO add your handling code here:
        
        char validar=evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_CedulaKeyTyped

    private void MontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MontoKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)
                &&(caracter != '.' || Monto.getText().contains("."))
                 &&(caracter != ',' || Monto.getText().contains(","))){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_MontoKeyTyped

    private void GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarActionPerformed
        // TODO add your handling code here:

        if(Monto.getText().equals("") || Cedula.getText().equals("") || tipoMoneda.equals("")) {
            JOptionPane.showMessageDialog(this, "Favor ingresar todos los datos requeridos");
        } else {
            try {
                String tipo;
                double monto = Double.valueOf(Monto.getText());
                String moneda = tipoMoneda;
                int plazo = Integer.valueOf(Plazos.getText());
                int cedula = Integer.valueOf(Cedula.getText());
                Solicitante solicitante = realizar.buscarSolicitante(cedula);
                if(TipoCredito.getSelectedItem().equals("Hipotecario de terreno")) {
                    tipo = "Hipotecario de terreno";
                    double TBP = obtenerTasa.getTBP();
                    double TED = obtenerTasa.getTED();
                    AdquisicionTerreno credito = new AdquisicionTerreno(tipo, monto, plazo, moneda, TBP, TED);
                    realizar.registrarCreditoTerreno(solicitante, credito);
                    Credito credito2 = realizar.buscarCredito(solicitante, credito.getNumeroSolicitud());
                    Object[][] matriz = credito2.calcularTablaAmortizacion(monto, plazo, credito2.getTasaInteres());
                    for(Object[] row:matriz) {
                        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
                        tblModel.addRow(row);
                    }
                }
                else if (TipoCredito.getSelectedItem().equals("Personal")) {
                    tipo = "Personal";
                    CreditoPersonal credito = new CreditoPersonal(tipo, monto, plazo, moneda);
                    realizar.registrarCreditoPersonal(solicitante, credito);
                    Credito credito2 = realizar.buscarCredito(solicitante, credito.getNumeroSolicitud());
                    Object[][] matriz = credito2.calcularTablaAmortizacion(monto, plazo, credito2.getTasaInteres());
                    for(Object[] row:matriz) {
                        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
                        tblModel.addRow(row);
                    }
                }
                /**
                for(int i = 0; i < 5; i++){
                    String datos[] = {"1", "2000", "30000", "1500", "50000"};
                    DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
                    tblModel.addRow(datos);
                }*/
            } catch (SolicitanteDoesNotExistException ex) {
                System.err.println(ex.getMessage());
            }
        }
    
    }//GEN-LAST:event_GenerarActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        // TODO add your handling code here:
        
        modelo.setRowCount(0);
        
        
    }//GEN-LAST:event_LimpiarActionPerformed

    private void MontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MontoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_MontoActionPerformed

    private void BotonColonesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonColonesMouseClicked
        tipoMoneda = BotonColones.getLabel();
    }//GEN-LAST:event_BotonColonesMouseClicked

    private void BotonDolaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonDolaresMouseClicked
        tipoMoneda = BotonDolares.getLabel();
    }//GEN-LAST:event_BotonDolaresMouseClicked

    private void PlazosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlazosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlazosActionPerformed

    private void PlazosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PlazosKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)
                &&(caracter != '.' || Plazos.getText().contains("."))
                 &&(caracter != ',' || Plazos.getText().contains(","))){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_PlazosKeyTyped

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCredito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BotonColones;
    private javax.swing.JRadioButton BotonDolares;
    private javax.swing.JTextField Cedula;
    private javax.swing.JButton Generar;
    private javax.swing.JButton Limpiar;
    public static javax.swing.ButtonGroup Moneda;
    private javax.swing.JTextField Monto;
    private javax.swing.JTextField Plazos;
    private javax.swing.JButton Regresar;
    private javax.swing.JComboBox<String> TipoCredito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
