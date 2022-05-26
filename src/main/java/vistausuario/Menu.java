package vistausuario;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logicadenegocios.*;
import util.*;
import excepciones.*;


/**
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class Menu extends javax.swing.JFrame {
    public static ArrayList<Solicitante> solicitantes;
    //funciones realizar = new funciones();

    /**
     * Constructor de la vista menu
     */
    public Menu() {
        solicitantes = new ArrayList<>();
        solicitantes = Json.leer();
        //Solicitante solicitanteBase = new Solicitante("Jose", "Daniel", "Barboza", "Campos", 702870837, 87175835, "jd.2001.bc@gmail.com",  300000.0, 950000.0, "Limon", "Poccoci", "Guapiles", "Centro");
        //solicitantes.add(solicitanteBase);
        initComponents();
        cerrar();
        this.setLocationRelativeTo(null);
        
        //Metodo para hacer transparente lo solicitado en los cajones de texto
        
        TextPrompt prueba = new TextPrompt("Nombre",Nombre);
        TextPrompt prueba12 = new TextPrompt("Segundo Nombre",sNombre);
        TextPrompt prueba2 = new TextPrompt("Apellido",Apellido);
        TextPrompt prueba13 = new TextPrompt("Segundo Apellido",sApellido);
        TextPrompt prueba3 = new TextPrompt("Cédula",Cedula);
        TextPrompt prueba4 = new TextPrompt("Teléfono",Telefono);
        TextPrompt prueba5 = new TextPrompt("Correo",Correo);
        TextPrompt prueba6 = new TextPrompt("Provincia",Provincia);
        TextPrompt prueba7 = new TextPrompt("Cantón",Canton);
        TextPrompt prueba8 = new TextPrompt("Distrito",Distrito);
        TextPrompt prueba9 = new TextPrompt("Dirección Exacta",Direccion);
        TextPrompt prueba10 = new TextPrompt("Salario Liquido",SalarioLiquido);
        TextPrompt prueba11 = new TextPrompt("Salario Bruto",SalarioBruto);
        
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
    
    //Metodo para la advertencia por medio de un popup al cerrar la ventana
    
    public void confirmarSalida(){
        int valor= JOptionPane.showConfirmDialog(this,"¿Desea cerrar la solicitud?","Adventencia",JOptionPane.YES_NO_OPTION);
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
        sNombre = new javax.swing.JTextField();
        Apellido = new javax.swing.JTextField();
        Cedula = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        Correo = new javax.swing.JTextField();
        Provincia = new javax.swing.JTextField();
        Canton = new javax.swing.JTextField();
        Distrito = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        sApellido = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        SalarioBruto = new javax.swing.JTextField();
        SalarioLiquido = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 480, 80));

        sNombre.setBackground(new java.awt.Color(102, 102, 102));
        sNombre.setForeground(new java.awt.Color(255, 255, 255));
        sNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sNombreActionPerformed(evt);
            }
        });
        jPanel3.add(sNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 300, 30));

        Apellido.setBackground(new java.awt.Color(102, 102, 102));
        Apellido.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 300, 30));

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
        jPanel3.add(Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 300, 30));

        Telefono.setBackground(new java.awt.Color(102, 102, 102));
        Telefono.setForeground(new java.awt.Color(255, 255, 255));
        Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefonoActionPerformed(evt);
            }
        });
        Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelefonoKeyTyped(evt);
            }
        });
        jPanel3.add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 300, 30));

        Correo.setBackground(new java.awt.Color(102, 102, 102));
        Correo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 300, 30));

        Provincia.setBackground(new java.awt.Color(102, 102, 102));
        Provincia.setForeground(new java.awt.Color(255, 255, 255));
        Provincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProvinciaActionPerformed(evt);
            }
        });
        jPanel3.add(Provincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 300, 30));

        Canton.setBackground(new java.awt.Color(102, 102, 102));
        Canton.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Canton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 300, 30));

        Distrito.setBackground(new java.awt.Color(102, 102, 102));
        Distrito.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Distrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 300, 30));

        Nombre.setBackground(new java.awt.Color(102, 102, 102));
        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });
        jPanel3.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 300, 30));

        sApellido.setBackground(new java.awt.Color(102, 102, 102));
        sApellido.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(sApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 300, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 530, 560));

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

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, 160));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 25, 290, 250));

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
        jPanel7.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 200, 40));

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setText("Generar PDf");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 40));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Registrar Solicitante");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 40));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 35, 220, 240));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 275, 290, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sNombreActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        VistaCredito newframe = new VistaCredito();
        
        newframe.setVisible(true);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
        VistaPDF newframe = new VistaPDF();
        
        newframe.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void CedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CedulaKeyTyped
        // Metodo para que solo acepte numeros
        char caracter=evt.getKeyChar();
        
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)){
            
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
                &&(caracter != '.' || SalarioLiquido.getText().contains("."))){
            
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_SalarioLiquidoKeyTyped

    private void SalarioBrutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalarioBrutoKeyTyped
        // Metodo para que solamente se ingrese número con puntos y comas
        
        char caracter = evt.getKeyChar();
        
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)
                &&(caracter != '.' || SalarioBruto.getText().contains("."))){
            
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_SalarioBrutoKeyTyped

    private void SalarioLiquidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalarioLiquidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalarioLiquidoActionPerformed

    private void ProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProvinciaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if("".equals(Nombre.getText()) || "".equals(Apellido.getText()) || "".equals(sApellido.getText())|| "".equals(Cedula.getText()) || "".equals(Telefono.getText()) || "".equals(Correo.getText()) || "".equals(SalarioBruto.getText()) || "".equals(SalarioLiquido.getText()) || "".equals(Provincia.getText()) || "".equals(Canton.getText()) || "".equals(Distrito.getText()) || "".equals(Direccion.getText())) {
            JOptionPane.showMessageDialog(this, "Favor ingresar todos los datos requeridos");
        } else {
            String nombre = Nombre.getText();
            String Snombre = sNombre.getText();
            String apellido = Apellido.getText();
            String Sapellido = sApellido.getText();
            int cedula = Integer.valueOf(Cedula.getText());
            int telefono = Integer.valueOf(Telefono.getText());
            String correo = Correo.getText();
            double  salarioBruto = Double.valueOf(SalarioBruto.getText());
            double salarioLiquido = Double.valueOf(SalarioLiquido.getText());
            String provincia = Provincia.getText();
            String canton = Canton.getText();
            String distrito = Distrito.getText();
            String sennas = Direccion.getText();
            Solicitante solicitante = new Solicitante(nombre, Snombre, apellido, Sapellido, cedula, telefono, correo, salarioBruto, salarioLiquido, provincia, canton, distrito, sennas);
            funciones fun = new funciones();
            try {
                fun.buscarSolicitante(cedula);
                JOptionPane.showMessageDialog(rootPane, "Ya existe un usuario ingresado con la misma cedula");
            } catch (SolicitanteDoesNotExistException ex) {
                fun.registrarSolicitante(solicitante);
                Json almacenar = new Json();
                almacenar.guardar(solicitantes);
                JOptionPane.showMessageDialog(this, "Se registro el solicitante con exito");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonoActionPerformed

    private void TelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoKeyTyped
        char caracter=evt.getKeyChar();
        
        if (((caracter < '0' || caracter > '9'))
                &&(caracter != KeyEvent.VK_BACK_SPACE)){
            
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solamente números");
        }
    }//GEN-LAST:event_TelefonoKeyTyped
    
   
     // @param args the command line arguments
     
    public static void main(String args[]) 
    {
       obtenervalores obtenerTasa = new obtenervalores();
       solicitantes = new ArrayList<>();
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
       });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellido;
    private javax.swing.JTextField Canton;
    private javax.swing.JTextField Cedula;
    private javax.swing.JTextField Correo;
    private javax.swing.JTextArea Direccion;
    private javax.swing.JTextField Distrito;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Provincia;
    private javax.swing.JTextField SalarioBruto;
    private javax.swing.JTextField SalarioLiquido;
    private javax.swing.JTextField Telefono;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel jRegistrarSolicitud;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sApellido;
    private javax.swing.JTextField sNombre;
    // End of variables declaration//GEN-END:variables

}
