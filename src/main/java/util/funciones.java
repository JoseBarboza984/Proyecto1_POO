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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;

import javax.swing.JOptionPane;

import logicadenegocios.*;
import excepciones.*;
import vistausuario.*;
import static vistausuario.Menu.solicitantes;

/**
 *
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class funciones {

    
    public void registrarSolicitante(Solicitante pSolicitante) {
        Menu.solicitantes.add(pSolicitante);
    }
    
    public Solicitante buscarSolicitante(int pCedula) throws SolicitanteDoesNotExistException{
        if(solicitantes.size() == 0)
            return null;
        for(Solicitante solicitante:Menu.solicitantes) {
            if(solicitante.getCedula() == pCedula){
                return solicitante;
            }
        }
        throw new SolicitanteDoesNotExistException(String.valueOf(pCedula));
    }
    
    public void registrarCreditoTerreno(Solicitante pSolicitante, AdquisicionTerreno pCredito) {
        pSolicitante.setCredito(pCredito);
    }
    
    public void registrarCreditoVivienda(Solicitante pSolicitante, ConstruccionVivienda pCredito) {
        pSolicitante.setCredito(pCredito);
    }
    
    public void registrarCreditoFiduciario(Solicitante pSolicitante, CreditoFiduciario pCredito) {
        pSolicitante.setCredito(pCredito);
    }
    
    public void registrarFiadores(CreditoFiduciario pCredito, Fiador[] pFiador, double pMonto, double pCuota) throws FiadorDoesNotApplyException{
        boolean validacion = pCredito.setFiadores(pFiador, pMonto, pCuota);
        if(validacion = false){
            String info = "";
            for(Fiador fiador:pFiador) 
                info += String.valueOf(fiador.getCedula());
            throw new FiadorDoesNotApplyException(info);
        }
    }
    
    public void registrarCreditoPersonal(Solicitante pSolicitante, CreditoPersonal pCredito) {
        pSolicitante.setCredito(pCredito);
    }
    
    public void registrarCreditoPrendiario(Solicitante pSolicitante, CreditoPrendiario pCredito) {
        pSolicitante.setCredito(pCredito);
    }
    
    public void registrarPrenda(CreditoPrendiario pCredito, String Descripccion, double Monto) throws PrendaDoesNotApplyException {
        boolean validacion = pCredito.setPrenda(Descripccion, Monto);
        if(validacion = false)
            throw new PrendaDoesNotApplyException(Descripccion);
    }
    
    public Credito buscarCredito(Solicitante pSolicitante, String pNumSolicitud) {
        for(Credito credito:pSolicitante.creditos) {
            if(credito.getNumeroSolicitud().equals(pNumSolicitud)) 
                return credito;
        }
        return null;
    }
    
    public void guardarPDF(Object[][] pDatos, Solicitante pSolicitante, String infoCredito, boolean pCorreo) throws IOException, DocumentException {
        Document documento = new Document();
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String nombrePDF = pSolicitante.getCedula()+"_"+formato.format(fecha);
        try {
            FileOutputStream archivo = new FileOutputStream("PDF\\"+ nombrePDF + ".pdf");  
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
            if(pCorreo)
                enviarCorreo(nombrePDF, pSolicitante.getCorreo());
          } 
          catch (FileNotFoundException | DocumentException e) {
              System.err.println(e.getMessage());
          }
    }
    
    public void enviarCorreo(String nombrePDF, String correo){
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
  
