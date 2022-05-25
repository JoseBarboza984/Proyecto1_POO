/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistausuario;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logicadenegocios.Credito;
import logicadenegocios.CreditoFiduciario;
import logicadenegocios.Fiador;
import util.Json;
import util.funciones;
import static vistausuario.Menu.solicitantes;
import static vistausuario.VistaCredito.moneda;
import static vistausuario.VistaCredito.monto;
import static vistausuario.VistaCredito.plazo;


/**
 *
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class VistaFiador extends javax.swing.JFrame {
    public String nombre;
    public int cedula;
    public double salarioBruto;
    public double salarioLiquido;
    public String nombre2;
    public int cedula2;
    public double salarioBruto2;
    public double salarioLiquido2;
    public int cantidad = 1;
    public boolean validar = false;
    funciones realizar;
    VistaCredito info;

    /**
     * Constructor de la vista fiador
     */
    public VistaFiador() {
        this.realizar = new funciones();
        this.info = new VistaCredito();
        initComponents();
        
        this.setLocationRelativeTo(null);
        TextPrompt nombreTP = new TextPrompt("Nombre",Nombre);
        TextPrompt nombre2TP = new TextPrompt("Nombre",Nombre2);
        TextPrompt cedulaTP = new TextPrompt("Cedula",Cedula);
        TextPrompt cedula2TP = new TextPrompt("Cedula",Cedula2);
        TextPrompt brutoTP = new TextPrompt("Salario bruto",SalarioBruto);
        TextPrompt bruto2TP = new TextPrompt("Salario bruto",SalarioBruto2);
        TextPrompt liquidoTP = new TextPrompt("Salario liquido",SalarioLiquido);
        TextPrompt liquido2TP = new TextPrompt("Salario liquido",SalarioLiquido2);
        
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
        SalarioBruto2 = new javax.swing.JTextField();
        Registrar = new javax.swing.JButton();
        Cedula = new javax.swing.JTextField();
        SalarioLiquido = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        Cedula2 = new javax.swing.JTextField();
        SalarioLiquido2 = new javax.swing.JTextField();
        Nombre2 = new javax.swing.JTextField();
        SalarioBruto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
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

        SalarioBruto2.setBackground(new java.awt.Color(51, 51, 51));
        SalarioBruto2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SalarioBruto2KeyTyped(evt);
            }
        });
        jPanel3.add(SalarioBruto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 200, 30));

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        jPanel3.add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, -1, -1));

        Cedula.setBackground(new java.awt.Color(51, 51, 51));
        Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CedulaKeyTyped(evt);
            }
        });
        jPanel3.add(Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 200, 30));

        SalarioLiquido.setBackground(new java.awt.Color(51, 51, 51));
        SalarioLiquido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SalarioLiquidoKeyTyped(evt);
            }
        });
        jPanel3.add(SalarioLiquido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 200, 30));

        Nombre.setBackground(new java.awt.Color(51, 51, 51));
        Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombreKeyTyped(evt);
            }
        });
        jPanel3.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 200, 30));

        Cedula2.setBackground(new java.awt.Color(51, 51, 51));
        Cedula2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Cedula2KeyTyped(evt);
            }
        });
        jPanel3.add(Cedula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 200, 30));

        SalarioLiquido2.setBackground(new java.awt.Color(51, 51, 51));
        SalarioLiquido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SalarioLiquido2KeyTyped(evt);
            }
        });
        jPanel3.add(SalarioLiquido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 200, 30));

        Nombre2.setBackground(new java.awt.Color(51, 51, 51));
        Nombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Nombre2KeyTyped(evt);
            }
        });
        jPanel3.add(Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 200, 30));

        SalarioBruto.setBackground(new java.awt.Color(51, 51, 51));
        SalarioBruto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SalarioBrutoKeyTyped(evt);
            }
        });
        jPanel3.add(SalarioBruto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 200, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fiador 2:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 70, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fiador 1:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 70, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 800, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 575));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        if(Nombre.getText().equals("") || Cedula.getText().equals("") || SalarioBruto.getText().equals("") || SalarioLiquido.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Favor ingresar al menos a un fiador");
        else {
            nombre = Nombre.getText();
            cedula = Integer.valueOf(Cedula.getText());
            salarioBruto = Double.valueOf(SalarioBruto.getText());
            salarioLiquido = Double.valueOf(SalarioLiquido.getText());
            if(!"".equals(Nombre2.getText()) || !"".equals(Cedula2.getText()) || !"".equals(SalarioBruto2.getText()) || !"".equals(SalarioLiquido2.getText())) {
                JOptionPane.showMessageDialog(this, "Favor ingresar al menos a un fiador");
                nombre2 = Nombre2.getText();
                cedula2 = Integer.valueOf(Cedula2.getText());
                salarioBruto2 = Double.valueOf(SalarioBruto2.getText());
                salarioLiquido2 = Double.valueOf(SalarioLiquido2.getText()); 
                cantidad = 2;
            }
            Fiador fiador;
            int cantFiadores = cantidad;
            String nombref = nombre;
            int cedulaf = cedula;
            double brutof = salarioBruto;
            double liquidof = salarioLiquido;
            fiador = new Fiador(nombref, cedulaf, brutof, liquidof);
            Fiador fiadores[];
            if(cantFiadores == 2) {
                fiadores= new Fiador[2];
                fiadores[0] = fiador;
                String nombref2 = nombre2;
                int cedulaf2 = cedula2;
                double brutof2 = salarioBruto2;
                double liquidof2 = salarioLiquido2;
                fiador = new Fiador(nombref2, cedulaf2, brutof2, liquidof2);
                fiadores[1] = fiador;
            } else {
                fiadores= new Fiador[1];
                fiadores[0] = fiador;
            }
            CreditoFiduciario credito = new CreditoFiduciario(info.tipo, monto, plazo, moneda);
            credito.setEstado(credito.verificarFiadores(fiadores, monto, credito.getCuota()));
            realizar.registrarCreditoFiduciario(info.solicitante, credito);
            Credito credito2 = realizar.buscarCredito(info.solicitante, credito.getNumeroSolicitud());
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

    private void NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreKeyTyped

    }//GEN-LAST:event_NombreKeyTyped

    private void Nombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre2KeyTyped

    }//GEN-LAST:event_Nombre2KeyTyped

    private void SalarioBrutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalarioBrutoKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)
                &&(caracter != '.' || SalarioBruto.getText().contains("."))){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_SalarioBrutoKeyTyped

    private void SalarioLiquidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalarioLiquidoKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)
                &&(caracter != '.' || SalarioLiquido.getText().contains("."))){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_SalarioLiquidoKeyTyped

    private void CedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CedulaKeyTyped
        char validar=evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_CedulaKeyTyped

    private void Cedula2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Cedula2KeyTyped
        char validar=evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_Cedula2KeyTyped

    private void SalarioBruto2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalarioBruto2KeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)
                &&(caracter != '.' || SalarioBruto2.getText().contains("."))){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_SalarioBruto2KeyTyped

    private void SalarioLiquido2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalarioLiquido2KeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)
                &&(caracter != '.' || SalarioLiquido2.getText().contains("."))){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_SalarioLiquido2KeyTyped

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaFiador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaFiador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cedula;
    private javax.swing.JTextField Cedula2;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Nombre2;
    private javax.swing.JButton Registrar;
    private javax.swing.JTextField SalarioBruto;
    private javax.swing.JTextField SalarioBruto2;
    private javax.swing.JTextField SalarioLiquido;
    private javax.swing.JTextField SalarioLiquido2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
