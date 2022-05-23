/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Date;

import logicadenegocios.*;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.ArrayList;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class funciones {
    static ArrayList<Solicitante> solicitantes;
    
    public static void main(String[] args) throws IOException, DocumentException {
        solicitantes = new ArrayList<>(); //String pTipo, double pMonto, int pPlazo, String pMoneda, Date pFechaSolicitud
        Solicitante solicitante = new Solicitante("Jose", "Daniel", "Barboza", "Campos", 702870837, 87175835, "jd.2001.bc@gmail.com",  300000.0, 950000.0, "Limon", "Poccoci", "Guapiles", "Centro");
        boolean respuesta = registrarSolicitante(solicitante);
        if(respuesta)
            System.out.println("Se regsitro el solicitante con exito");
        else
            System.out.println("Se regsitro el solicitante con exito");
        solicitante = buscarSolicitante(702870837);
        if(solicitante != null) {
            CreditoPersonal credito = new CreditoPersonal("Personal", 1000000, 5, "Colones");
            credito.setEstado(credito.verificarSolicitante(solicitante.getSalarioLiquido()));
            solicitante.setCredito(credito);
            System.out.println("Se regsitro el credito");
         }
         System.out.println("Se regsitro el credito");
        
        Credito cre = buscarCredito(buscarSolicitante(702870837), "CRE0001");
        System.out.println(cre.toString());
        Object[][] matriz = cre.calcularTablaAmortizacion(1000000, 5, cre.getTasaInteres());
        guardarPDF(matriz, buscarSolicitante(702870837), cre.toString());
    }
    
    public static boolean registrarSolicitante(Solicitante pSolicitante) {
        if(buscarSolicitante(pSolicitante.getCedula()) != null)
            return false;
        solicitantes.add(pSolicitante);
        return true;
    }
    
    public static Solicitante buscarSolicitante(int pCedula) {
        for(Solicitante solicitante:solicitantes) {
            if(solicitante.getCedula() == pCedula)
                return solicitante;
        }
        return null;
    }
    
    public static Credito buscarCredito(Solicitante pSolicitante, String pNumSolicitud) {
        for(Credito credito:pSolicitante.creditos) {
            if(credito.getNumeroSolicitud().equals(pNumSolicitud)) 
                return credito;
        }
        return null;
    }
    
    public static void guardarPDF(Object[][] pDatos, Solicitante pSolicitante, String infoCredito) throws IOException, DocumentException {
        Document documento = new Document();
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String nombrePDF = pSolicitante.getCedula()+"_"+formato.format(fecha);
        try {
            FileOutputStream archivo = new FileOutputStream("PDF\\"+ nombrePDF + ".pdf");  //C:\\Users\\Jose\\Documents\\NetBeansProjects\\Proyecto1\\PDF
            PdfWriter.getInstance(documento, archivo);
            documento.open(); 
            Paragraph parrafo = new Paragraph("Reporte de analisis de credito");
            parrafo.setAlignment(1);
            documento.add(parrafo);
            
            String sNombre = pSolicitante.getNombre();
            String sSNombre = pSolicitante.getSNombre();
            String sApellido = pSolicitante .getApellido();
            String sSApellido = pSolicitante.getSApellido();
            String sCedula = pSolicitante.getCedula()+"";
            String sCorreo = pSolicitante.getCorreo();
            String sTelefono = pSolicitante.getTelefono()+"";
            
            documento.add(new Paragraph("\n"+sNombre+" "+sSNombre+" "+sApellido+" "+sSApellido+"\n"+"Cedula: "+sCedula+"\n"+"Correo: "+sCorreo+"\n"+"Telefono: "+sTelefono+"\n\n"+infoCredito));
            documento.add(Chunk.NEWLINE); 

            PdfPTable tabla = new PdfPTable(5); 
            tabla.setWidthPercentage(100);
            PdfPCell noCuota = new PdfPCell(new Phrase("No.Cuota ")); 
            PdfPCell monto = new PdfPCell(new Phrase("Monto Cuota "));
            PdfPCell interes = new PdfPCell(new Phrase("Interes "));
            PdfPCell amortz = new PdfPCell(new Phrase("Amortizacion "));
            PdfPCell deuda = new PdfPCell(new Phrase("Deuda "));

            tabla.addCell(noCuota);
            tabla.addCell(monto);
            tabla.addCell(interes);
            tabla.addCell(amortz);
            tabla.addCell(deuda);


            for(Object[] row:pDatos) {
                for(Object colum:row) {
                    tabla.addCell(String.valueOf(colum));
                }
            }                            
            documento.add(tabla);
            documento.add(Chunk.NEWLINE); 
            documento.close(); 
            JOptionPane.showMessageDialog(null,"PDF Generado"); 
            enviarCorreo(nombrePDF, pSolicitante.getCorreo());
          } 
          catch (FileNotFoundException | DocumentException e) {
              System.err.println(e.getMessage());
          }
    }
    
    public static void enviarCorreo(String nombrePDF, String correo){
         try{
          Properties propiedad = new Properties();
          propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
          propiedad.setProperty("mail.smtp.starttls.enable", "true");
          propiedad.setProperty("mail.smtp.port", "587");
          propiedad.setProperty("mail.smtp.auth", "true");
          Session sesion = Session.getDefaultInstance(propiedad);
          String correoEmisor = "proyecto1POO.G1@gmail.com";
          String contra = "QWasZX123";
          String destino = correo;
          String asunto = "Reporte de solicitud de credito";
          String mensaje = "Buenas, se adjunta el reporte de su consulta.";

          BodyPart texto = new MimeBodyPart();
          texto.setContent(mensaje, "text/html");
          
   
          BodyPart pdf = new MimeBodyPart();

          FileDataSource source = new FileDataSource("PDF\\"+nombrePDF+".pdf");
          pdf.setDataHandler(new DataHandler(source));
          pdf.setFileName(nombrePDF+".pdf");

          MimeMultipart partes = new MimeMultipart(); 
          partes.addBodyPart(texto);
          partes.addBodyPart(pdf);

          MimeMessage message = new MimeMessage(sesion);
          message.setFrom(new InternetAddress(correoEmisor)); 
          message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
          message.setSubject(asunto);
          message.setContent(partes);
             try (Transport transportar = sesion.getTransport("smtp")) {
                 transportar.connect(correoEmisor, contra);
                 transportar.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
             }
          JOptionPane.showMessageDialog(null, "Correo Enviado");
        }catch(HeadlessException | MessagingException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }
}
  
