/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 

/**
 *  Clase padre de creditos, representa la base de los creditos
 * 
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public abstract class Credito {
    protected String tipo;                                 //Atributos que describen el credito
    protected double monto;
    protected String moneda;
    protected Date fechaSolicitud;
    protected String numeroSolicitud;
    protected String estado;
    
    protected double tasaInteres;                    //Atributos necesarios para calculos
    protected int plazo;
    protected double cuota;
    
    protected double gastosFormalizacion;       //Atributos que aumentan el monto final
    protected double honorariosLegales;
    
    private static int cantSolicitudes = 0;
    
    /**
     *  Metodo constructor del credito
     * 
     * @param pTipo         Tipo de credito
     * @param pMonto      Monto inicial solicitado en el credito
     * @param pPlazo        Cantidad de años plazo del credito
     * @param pMoneda    Tipo de moneda en la que se pide el credito
     */
    public Credito(String pTipo, double pMonto, int pPlazo, String pMoneda) {
        tipo = pTipo;
        monto = pMonto;
        plazo = pPlazo;
        moneda = pMoneda;
        cantSolicitudes++;
        numeroSolicitud = formatoCodigo(cantSolicitudes);
        gastosFormalizacion = 0.03;
        setFechaSolicitud();
    }
    
    /**
     *  Metodo constructor del credito
     * 
     * @param pTipo                                   Tipo de credito
     * @param pMonto                                Monto inicial solicitado en el credito
     * @param pPlazo                                  Cantidad de años plazo del credito
     * @param pMoneda                              Tipo de moneda en la que se pide el credito
     * @param pNumeroSolicitud                Identificador del credito
     * @param pFechaSolicitud                    Fecha de la solicitud del credito
     * @throws java.text.ParseException
     */
    public Credito(String pTipo, double pMonto, int pPlazo, String pMoneda, String pNumeroSolicitud, String pFechaSolicitud) throws ParseException {
        tipo = pTipo;
        monto = pMonto;
        plazo = pPlazo;
        moneda = pMoneda;
        cantSolicitudes++;
        numeroSolicitud = pNumeroSolicitud;
        gastosFormalizacion = 0.03;
        DateFormat formato = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
        fechaSolicitud = formato.parse(pFechaSolicitud);
    }
    
    /**
     * Realiza el codigo de los creditos 
     * 
     * @param pNum  Numero que representa el número de creditos
     * @return 
     */
    private  String formatoCodigo(int pNum) {
        String num = String.valueOf(pNum);
        int largo = 4-num.length();
        String codigo = "CRE";
        for(int i = 0; i < largo; i++) 
                codigo += "0";
        return codigo+num;
    }
    
    /**
     * Establece el atributo estado
     * 
     * @param pEstado
     */
    protected void setEstado(boolean pEstado) {
        if(pEstado)
            estado = "Aceptado";
        else 
            estado = "Rechazado";
    }
    
   /**
     *  Se establece la fecha del credito, que se obtenida del sistema
     * 
     */
    public void setFechaSolicitud() {
        Date fecha = new Date();
        fechaSolicitud = fecha;
    }
    
    /**
     *  Se obtiene la fecha en formato dia mes año
     * 
     * @return Cadena de caracteres con la fecha del credito
     */
    public String getFechaSolicitud() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fechaSolicitud);
    }
    
    //Metodos Accesores
    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }
    public double getTasaInteres() {
        return tasaInteres;
    }
    public String getMoneda() {
        return moneda;
    }
    public double getMonto() {
        return monto;
    }
    public int getPlazo() {
        return plazo;
    }
    public String getTipo() {
        return tipo;
    }
    public String getBaseFechaSolicitud() {
        return String.valueOf(fechaSolicitud);
    }
    
    /**
     *  Metodo para establecer la información en una Cadena de caracteres
     * 
     * @return  Cadena de caracteres con la información de un credito
     */
    @Override
    public String toString() {
        String msg = "";
        msg += "Credito "+tipo+"\n"+numeroSolicitud+"\n"+"Estado: "+estado+"\n";
        msg += "Solicitado el: "+getFechaSolicitud()+"\n"+"A "+plazo+" años plazo en "+moneda+"\n";
        return msg;
    }
    
    /**
     * Crea una matriz de objetos con los calculos de la tabla de amortización 
     *
     * @param pMonto            Monto final del prestamo solicitado
     * @param pPlazoAnios     Cantidad de años en lo que se va a pagar el credito
     * @param pTasaInteres    Tasa de interes que se aplica en el credito
     * @return      Matriz de objetos con los datos de la tabla de amortización
     */
    public abstract Object[][] calcularTablaAmortizacion(double pMonto, int pPlazoAnios, double pTasaInteres);
    
    public abstract Object[] calcularTotales(Object[][] pMatriz, int pPlazoAnios);
}
