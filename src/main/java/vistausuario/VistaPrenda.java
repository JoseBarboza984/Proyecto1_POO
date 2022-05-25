/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistausuario;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logicadenegocios.Credito;
import logicadenegocios.CreditoPrendiario;
import util.Json;
import util.funciones;
import static vistausuario.Menu.solicitantes;

import static vistausuario.VistaCredito.moneda;
import static vistausuario.VistaCredito.monto;
import static vistausuario.VistaCredito.plazo;
import static vistausuario.VistaCredito.solicitante;
import static vistausuario.VistaCredito.tipo;

/**
 *
 * @author Joshua
 */
public class VistaPrenda extends javax.swing.JFrame {
    public String descripccion;
    public double valor;
    funciones realizar;
    VistaCredito info;

    /**
     * Creates new form Creditos
     */
    public VistaPrenda() {
        this.realizar = new funciones();
        this.info = new VistaCredito();
        initComponents();
        
        this.setLocationRelativeTo(null);
        TextPrompt descripccionTP = new TextPrompt("Nombre",Descripccion);
        TextPrompt valorTP = new TextPrompt("Valor de la prenda",Valor);
        
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
        Registrar = new javax.swing.JButton();
        Descripccion = new javax.swing.JTextField();
        Valor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

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

        Descripccion.setBackground(new java.awt.Color(51, 51, 51));
        Descripccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DescripccionKeyTyped(evt);
            }
        });
        jPanel3.add(Descripccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 200, 30));

        Valor.setBackground(new java.awt.Color(51, 51, 51));
        Valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValorKeyTyped(evt);
            }
        });
        jPanel3.add(Valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 200, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Prenda");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 70, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 800, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 575));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        if(Descripccion.getText().equals("") || Valor.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Favor ingresar todos los datos");
        else {
            descripccion = Descripccion.getText();
            valor = Double.valueOf(Valor.getText());
            CreditoPrendiario credito = new CreditoPrendiario(tipo, monto, plazo, moneda);
            String descripccionP = descripccion;
            double montoP = valor;
            credito.setEstado(credito.setPrenda(descripccionP, montoP));
            realizar.registrarCreditoPrendiario(solicitante, credito);
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

    private void DescripccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DescripccionKeyTyped

    }//GEN-LAST:event_DescripccionKeyTyped

    private void ValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)
                &&(caracter != '.' || Valor.getText().contains("."))){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_ValorKeyTyped

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
            java.util.logging.Logger.getLogger(VistaPrenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Descripccion;
    private javax.swing.JButton Registrar;
    private javax.swing.JTextField Valor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
