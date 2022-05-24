package vistausuario;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 * @author Joshua
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Pooproyecto1
     */
    public Menu() 
    {
        initComponents();
        cerrar();
        this.setLocationRelativeTo(null);
        
        //Metodo pata hacer transparente lo solicitado en los cajones de texto
        
        //TextPromt
    }

    /*Metodo para confirmar el cierre de la vista*/
    
    public void cerrar()
    {
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e){
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void confirmarSalida(){
        int valor= JOptionPane.showConfirmDialog(this,"¿Desea cerrar la solicitud?","Adventencia",JOptionPane.YES_OPTION);
        if(valor==JOptionPane.YES_OPTION){
            JOptionPane.showConfirmDialog(null,"Gracias por la visita","Gracias",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jRegistrarSolicitud = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Direccion = new javax.swing.JTextArea();
        Nombre = new javax.swing.JTextField();
        Apellidos = new javax.swing.JTextField();
        Cedula = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        Correo = new javax.swing.JTextField();
        Provincia = new javax.swing.JTextField();
        Cantón = new javax.swing.JTextField();
        Distrito = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        SalarioBruto = new javax.swing.JTextField();
        SalarioLiquido = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRegistrarSolicitud.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jRegistrarSolicitud.setForeground(new java.awt.Color(255, 255, 255));
        jRegistrarSolicitud.setText("Registrar Solicitud");
        jPanel2.add(jRegistrarSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, 25));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 25));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Direccion.setBackground(new java.awt.Color(51, 51, 51));
        Direccion.setColumns(20);
        Direccion.setForeground(new java.awt.Color(255, 255, 255));
        Direccion.setRows(5);
        jScrollPane1.setViewportView(Direccion);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 444, 480, 80));

        Nombre.setBackground(new java.awt.Color(102, 102, 102));
        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });
        jPanel3.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 300, 30));

        Apellidos.setBackground(new java.awt.Color(102, 102, 102));
        Apellidos.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 108, 300, 30));

        Cedula.setBackground(new java.awt.Color(102, 102, 102));
        Cedula.setForeground(new java.awt.Color(255, 255, 255));
        Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CedulaActionPerformed(evt);
            }
        });
        Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CedulaKeyTyped(evt);
            }
        });
        jPanel3.add(Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 156, 300, 30));

        Telefono.setBackground(new java.awt.Color(102, 102, 102));
        Telefono.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 204, 300, 30));

        Correo.setBackground(new java.awt.Color(102, 102, 102));
        Correo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 252, 300, 30));

        Provincia.setBackground(new java.awt.Color(102, 102, 102));
        Provincia.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Provincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 300, 30));

        Cantón.setBackground(new java.awt.Color(102, 102, 102));
        Cantón.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Cantón, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 348, 300, 30));

        Distrito.setBackground(new java.awt.Color(102, 102, 102));
        Distrito.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Distrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 396, 300, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 530, 550));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setMinimumSize(new java.awt.Dimension(250, 324));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SalarioBruto.setBackground(new java.awt.Color(102, 102, 102));
        SalarioBruto.setForeground(new java.awt.Color(255, 255, 255));
        SalarioBruto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SalarioBrutoKeyTyped(evt);
            }
        });
        jPanel5.add(SalarioBruto, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 100, 200, 30));

        SalarioLiquido.setBackground(new java.awt.Color(102, 102, 102));
        SalarioLiquido.setForeground(new java.awt.Color(255, 255, 255));
        SalarioLiquido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalarioLiquidoActionPerformed(evt);
            }
        });
        SalarioLiquido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SalarioLiquidoKeyTyped(evt);
            }
        });
        jPanel5.add(SalarioLiquido, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 200, 30));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 250, 160));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 25, 290, 225));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Otras opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Registro crédito");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 200, 40));

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setText("Generar PDf");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 200, 40));

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setText("Enviar correo");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 200, 40));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 35, 220, 260));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 290, 325));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        VistaCreditos newframe = new VistaCreditos();
        
        newframe.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
        VistaPDF newframe = new VistaPDF();
        
        newframe.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void CedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CedulaKeyTyped
        // Metodo para que solo acepte numeros
        char validar=evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_CedulaKeyTyped

    private void CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CedulaActionPerformed

    private void SalarioLiquidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalarioLiquidoKeyTyped
        // Metodo para que solamente se ingrese número con puntos y comas
        
        char caracter = evt.getKeyChar();
        
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)
                &&(caracter != '.' || SalarioLiquido.getText().contains("."))
                 &&(caracter != ',' || SalarioLiquido.getText().contains(","))){
            
            evt.consume();
            
        }
        
    }//GEN-LAST:event_SalarioLiquidoKeyTyped

    private void SalarioBrutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalarioBrutoKeyTyped
        // Metodo para que solamente se ingrese número con puntos y comas
        
        char caracter = evt.getKeyChar();
        
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)
                &&(caracter != '.' || SalarioBruto.getText().contains("."))
                &&(caracter != ',' || SalarioBruto.getText().contains(","))){
            
            evt.consume();
            
        }
    }//GEN-LAST:event_SalarioBrutoKeyTyped

    private void SalarioLiquidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalarioLiquidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalarioLiquidoActionPerformed
    
   
     // @param args the command line arguments
     
    public static void main(String args[]) 
    {
       
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Windows".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellidos;
    private javax.swing.JTextField Cantón;
    private javax.swing.JTextField Cedula;
    private javax.swing.JTextField Correo;
    private javax.swing.JTextArea Direccion;
    private javax.swing.JTextField Distrito;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Provincia;
    private javax.swing.JTextField SalarioBruto;
    private javax.swing.JTextField SalarioLiquido;
    private javax.swing.JTextField Telefono;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel jRegistrarSolicitud;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private static class TextPrompt {

        public TextPrompt() {
        }

        private TextPrompt(String nombre, JTextField Nombre) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private TextPrompt(String dirección_exacta, JTextArea Direccion) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
