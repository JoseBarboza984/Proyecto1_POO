/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.text.ParseException;
import util.FormatoDecimal;

/**
 *  Clase hija de Credito, representa el credito personal
 * 
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class CreditoPersonal extends Credito{
    
    /**
     * Metodo constructor del credito personal
     * 
     * @param pTipo         Tipo de credito
     * @param pMonto      Monto inicial solicitado en el credito
     * @param pPlazo        Cantidad de años plazo del credito
     * @param pMoneda    Tipo de moneda en la que se pide el credito
     */
    public CreditoPersonal(String pTipo, double pMonto, int pPlazo, String pMoneda) {
        super(pTipo, pMonto, pPlazo, pMoneda);
        super.gastosFormalizacion = pMonto * 0.03;
        if("Colones".equals(pMoneda))
            super.tasaInteres = 0.18;
        else if("Dolares".equals(pMoneda))
            super.tasaInteres = 0.16;
    }
    
    /**
     * Metodo constructor del credito personal
     * 
     * @param pTipo         Tipo de credito
     * @param pMonto      Monto inicial solicitado en el credito
     * @param pPlazo        Cantidad de años plazo del credito
     * @param pMoneda    Tipo de moneda en la que se pide el credito
     */
    public CreditoPersonal(String pTipo, double pMonto, int pPlazo, String pMoneda, String pNumeroSolicitud, String pFechaSolicitud) throws ParseException {
        super(pTipo, pMonto, pPlazo, pMoneda, pNumeroSolicitud, pFechaSolicitud);
        super.gastosFormalizacion = pMonto * 0.03;
        if("Colones".equals(pMoneda))
            super.tasaInteres = 0.18;
        else if("Dolares".equals(pMoneda))
            super.tasaInteres = 0.16;
    }
    
    /**
     * Metodo para verificar un solicitante 
     * 
     * @param pSalarioLiquido   Monto del salario liquido de un solicitante
     * @return      true (Si el salario es mayor al 10% de la cuota del credito)
     */
    public boolean verificarSolicitante(double pSalarioLiquido) {
        return pSalarioLiquido > (super.cuota*0.1);
    }
    
    /**
     * Calcula el monto final del credito
     * 
     * @return      Suma de monto inicial del credito con los gastos extras del credito
     */
    public double getMontoFinal() {
        return super.monto+super.gastosFormalizacion;
    }
    
   /**
     *  Establece el atributo estado
     * @param pEstado   Variable que contiene si se debe aceptar o no el credito
     */
    @Override
   public void setEstado(boolean pEstado) {
        if(pEstado)
            estado = "Aceptado";
        else 
            estado = "Rechazado";
    }

   /**
     * Calcula los datos de una fila "k" de la tabla de amortizacion en base al sistema aleman
     *
     * @param pMonto                                Monto final del prestamo solicitado
     * @param pPlazoAnios                         Cantidad de años en lo que se va a pagar el credito
     * @param pTasaInteres                        Tasa de interes que se aplica en el credito
     * @param k                                          Numero de cuota o fila
     * @param pAmortizacionAnterior         Valor de la amortización en la cuota anterior
     * @param pCuotaAnterior                    Valor del monto de la cuota anterior
     * @param pMontoAnterior                    Monto de la deuda anterior
     * @return      Array de objetos que contiene los datos {Numero de cuota, Monto de cuota, Interes, Amortización, Deuda}
     */
    public Object[] calcularCuotaSAl(double pMonto, int pPlazoAnios, double pTasaInteres, int k, double pAmortizacionAnterior, double pCuotaAnterior, double pMontoAnterior) {
        Object[] array =  new Object[5];
        array[0] = k;
        double montoCuota;
        if (k == 1) {
            montoCuota = (pMonto/pPlazoAnios) + (pTasaInteres * pMonto);
            super.cuota = montoCuota;
        }
        else
            montoCuota = pCuotaAnterior - (pTasaInteres * (pMonto/pPlazoAnios));
        montoCuota = Math.round(montoCuota * 100.0) / 100.0;            //Integrar
        array[1] = FormatoDecimal.formatoDecimal(montoCuota);
        double interes = (pPlazoAnios-k+1) * ((pMonto*pTasaInteres)/pPlazoAnios);
        interes = Math.round(interes * 100.0) / 100.0;                              //Integrar
        array[2] =FormatoDecimal.formatoDecimal( interes);
        double amortizacion = pMonto/pPlazoAnios;
        amortizacion  = Math.round(amortizacion * 100.0) / 100.0;           //Integrar
        array[3] = FormatoDecimal.formatoDecimal(amortizacion);
        array[4] = FormatoDecimal.formatoDecimal(pMontoAnterior - pAmortizacionAnterior);
        return array;
    }
    
    /**
     * Realiza la ultima fila de la tabla de amortización
     *
     * @param pMatriz           Matriz que contiene los datos de la tabla de amortización
     * @param pPlazoAnios    Cantidad de años en lo que se va a pagar el credito
     * @return      Array de objetos que contiene los datos {"Totales", , Suma de Interes, Suma de Amortización, 0}
     */
    public Object[] calcularTotales(Object[][] pMatriz, int pPlazoAnios) {
        Object[] array = new Object[5];
        array[0] = "Totales";
        array[1] = "";
        double interes = 0;
        double amortizacion = 0;
        for (int i = 0; i < pPlazoAnios; i++) {
            interes = interes + Double.valueOf(String.valueOf(pMatriz[i][2]));
            amortizacion = amortizacion + Double.valueOf(String.valueOf(pMatriz[i][3]));
        }
        interes = Math.round(interes * 100.0) / 100.0;
        amortizacion = Math.round(amortizacion * 100.0) / 100.0;
        array[2] = FormatoDecimal.formatoDecimal(interes);
        array[3] = FormatoDecimal.formatoDecimal(amortizacion);
        array[4] = 0;
        return array;
    }
    
    /**
     * Crea una matriz de objetos con los calculos de la tabla de amortización 
     *
     * @param pMonto            Monto final del prestamo solicitado
     * @param pPlazoAnios     Cantidad de años en lo que se va a pagar el credito
     * @param pTasaInteres    Tasa de interes que se aplica en el credito
     * @return      Matriz de objetos con los datos de la tabla de amortización
     */
    @Override                                                       //      V                           n                               i
    public Object[][] calcularTablaAmortizacion(double pMonto, int pPlazoAnios, double pTasaInteres) {
        Object[][] resultados = new Object[pPlazoAnios+3][5];
        double amortizacion = 0;
        double cuota = 0;
        double monto = this.getMontoFinal();
        int largo = 0;
        for(int i = 0; i < pPlazoAnios; i++) {
            resultados[i] = calcularCuotaSAl(this.getMontoFinal(), pPlazoAnios, pTasaInteres, i+1, amortizacion, cuota, monto);
            monto = Double.valueOf(String.valueOf(resultados [i][4]));
            amortizacion = Double.valueOf(String.valueOf(resultados [i][3]));
            cuota = Double.valueOf(String.valueOf(resultados[i][1]));
            largo++;
        }
        
        resultados[largo] = calcularTotales(resultados, pPlazoAnios);
        resultados[largo+2][0] = ""; 
        resultados[largo+2][1] = "";
        resultados[largo+2][2] = "";
        resultados[largo+2][3] = "";
        resultados[largo+2][4] = "";
        
        resultados[largo+2][0] = "Codigo: "; 
        resultados[largo+2][1] = super.getNumeroSolicitud();
        resultados[largo+2][2] = "";
        resultados[largo+2][3] = "Estado: ";
        resultados[largo+2][4] = super.estado;
        return resultados;   
    }
}
