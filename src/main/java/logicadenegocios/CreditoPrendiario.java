/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.text.ParseException;
import util.FormatoDecimal;


/**
 *  Clase hija de Credito, representa el credito prendario
 * 
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class CreditoPrendiario extends Credito {
    public Prenda prenda;      
    
    /**
     * Metodo constructor del credito prendario
     * 
     * @param pTipo         Tipo de credito
     * @param pMonto      Monto inicial solicitado en el credito
     * @param pPlazo        Cantidad de años plazo del credito
     * @param pMoneda    Tipo de moneda en la que se pide el credito
     */
    public CreditoPrendiario(String pTipo, double pMonto, int pPlazo, String pMoneda) {
        super(pTipo, pMonto, pPlazo, pMoneda);
        super.gastosFormalizacion = pMonto * 0.03;
       
        if("Colones".equals(pMoneda)) {
            super.tasaInteres = 0.15;
            super.honorariosLegales = calcularHonorariosColones(pMonto);
        }
        else if("Dolares".equals(pMoneda)){
            super.tasaInteres = 0.13;
            super.honorariosLegales = calcularHonorariosDolares(pMonto);
        }
    }
    
    /**
     * Metodo constructor del credito prendario
     * 
     * @param pTipo         Tipo de credito
     * @param pMonto      Monto inicial solicitado en el credito
     * @param pPlazo        Cantidad de años plazo del credito
     * @param pMoneda    Tipo de moneda en la que se pide el credito
     */
    public CreditoPrendiario(String pTipo, double pMonto, int pPlazo, String pMoneda, String pNumeroSolicitud, String pFechaSolicitud) throws ParseException {
        super(pTipo, pMonto, pPlazo, pMoneda, pNumeroSolicitud, pFechaSolicitud);
        super.gastosFormalizacion = pMonto * 0.03;
       
        if("Colones".equals(pMoneda)) {
            super.tasaInteres = 0.15;
            super.honorariosLegales = calcularHonorariosColones(pMonto);
        }
        else if("Dolares".equals(pMoneda)){
            super.tasaInteres = 0.13;
            super.honorariosLegales = calcularHonorariosDolares(pMonto);
        }
    }
    
    /**
     * Calcula el monto final del credito
     * 
     * @return      Suma de monto inicial del credito con los gastos extras del credito
     */
    public double getMontoFinal() {
        return super.monto+super.gastosFormalizacion+super.honorariosLegales;
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
     * Metodo para estabecer la prenda si cumple con la condiciones
     * 
     * @param pDescripcionPrenda    Descripcción de la prenda
     * @param pMontoPrenda             Monto del costo de la prenda
     * @return      true (Si la el valor de la prenda es mayor al 85% del monto final del credito) y false (Si no)
     */
    public boolean setPrenda(String pDescripcionPrenda, double pMontoPrenda) {
        double limitePrenda = (super.monto + super.gastosFormalizacion + super.honorariosLegales)*0.85;
        if(pMontoPrenda < limitePrenda) 
            return false;   
        prenda = new Prenda(pMontoPrenda, pDescripcionPrenda);
        return true;
    }
    
    /**
     * Metodo para determinar si el monto calculado cumple con el minimo de honorarios en colones
     * 
     * @param pMonto    Monto en colones de los honorarios
     * @return Monto en colones de los honorarios
     */
    private double calcularMinimoHonorariosColones(double pMonto) {
        if(pMonto < 60500) 
            return 60500;
        else 
            return pMonto;
    }
    
    /**
     * Metodo para calcular los honorarios en colones
     * 
     * @param pMontoInicial     Monto inicial del credito
     * @return Monto de los honorarios calculados
     */
    private double calcularHonorariosColones(double pMontoInicial) {
        double resultado;
        double residuo;
        
        if (pMontoInicial <= 11000000){
            resultado = pMontoInicial*0.02;
        } 
        else if (pMontoInicial <= 16500000) {
            residuo = pMontoInicial - 11000000;
            resultado = (11000000*0.02)+(residuo*0.015);
        }
        else if (pMontoInicial <= 33000000) {
             residuo = pMontoInicial - 16500000;
             resultado = (11000000*0.02)+(5500000*0.015)+(residuo*0.0125);
        }
        else {
            residuo = pMontoInicial - 33000000;
            resultado = (11000000*0.02)+(5500000*0.015)+(16500000*0.0125)+(residuo*0.01);
        }        
        return calcularMinimoHonorariosColones(resultado);
    }
    
    /**
     * Metodo para determinar si el monto calculado cumple con el minimo de honorarios en dolares
     * 
     * @param pMonto    Monto en colones de los honorarios
     * @return Monto en dolares de los honorarios
     */
    private double calcularMinimoHonorariosDolares(double pMonto) {
        if(pMonto < 93) 
            return 93;
        else 
            return pMonto;
    }
    
    /**
     * Metodo para calcular los honorarios en dolares
     * 
     * @param pMontoInicial     Monto inicial del credito
     * @return Monto de los honorarios calculados
     */
    private double calcularHonorariosDolares(double pMontoInicial) {
        double resultado;
        double residuo;
        
        if (pMontoInicial <= 16418){
            resultado = pMontoInicial*0.02;
        } 
        else if (pMontoInicial <= 24627) {
            residuo = pMontoInicial - 16418;
            resultado = (16418*0.02)+(residuo*0.015);
        }
        else if (pMontoInicial <= 49254) {
             residuo = pMontoInicial - 24627;
             resultado = (16418*0.02)+(8209*0.015)+(residuo*0.0125);
        }
        else {
            residuo = pMontoInicial - 49254;
            resultado = (16418*0.02)+(8209*0.015)+(24627*0.0125)+(residuo*0.01);
        }        
        return calcularMinimoHonorariosDolares(resultado);
    }

    /**
     * Calcula los datos de una fila "k" de la tabla de amortizacion en base al sistema americano
     *
     * @param pMonto                                Monto final del prestamo solicitado
     * @param pPlazoAnios                         Cantidad de años en lo que se va a pagar el credito
     * @param pTasaInteres                        Tasa de interes que se aplica en el credito
     * @param k                                          Numero de cuota o fila                                          
     * @param pAmortizacionAnterior         Valor de la amortización en la cuota anterior
     * @return      Array de objetos que contiene los datos {Numero de cuota, Monto de cuota, Interes, Amortización, Deuda}
     */
    public Object[] calcularCuotaSAm(double pMonto, int pPlazoAnios, double pTasaInteres, int k, double pAmortizacionAnterior) {
        Object[] array =  new Object[5];
        array[0] = k;
        double interes = pTasaInteres * pMonto;
        interes = Math.round(interes * 100.0) / 100.0;
        array[2] = FormatoDecimal.formatoDecimal(interes);
        double amortizacion = 0;
        if(k == pPlazoAnios)
            amortizacion = pMonto;
        amortizacion  = Math.round(amortizacion * 100.0) / 100.0;  
        array[3] = FormatoDecimal.formatoDecimal(amortizacion);
        double mCuota = interes + amortizacion;
        mCuota = Math.round(mCuota * 100.0) / 100.0;
        array[1] = FormatoDecimal.formatoDecimal(mCuota);
        array[4] = FormatoDecimal.formatoDecimal(pMonto - pAmortizacionAnterior);
        return array;
    }
    
    /**
     * Realiza la ultima fila de la tabla de amortización
     *
     * @param pMatriz           Matriz que contiene los datos de la tabla de amortización
     * @param pPlazoAnios    Cantidad de años en lo que se va a pagar el credito
     * @return      Array de objetos que contiene los datos {"Totales", , Suma de Interes, Suma de Amortización, 0}
     */
    @Override
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
    @Override                                                      //      V                           n                               i
    public Object[][] calcularTablaAmortizacion(double pMonto, int pPlazoAnios, double pTasaInteres) {
        Object[][] resultados = new Object[pPlazoAnios+3][5];
        double amortizacion = 0;
        double monto = this.getMontoFinal();
        int largo = 0;
        for(int i = 0; i < pPlazoAnios; i++) {
            resultados[i] = calcularCuotaSAm(monto, pPlazoAnios, pTasaInteres, i+1, amortizacion);
            monto = Double.valueOf(String.valueOf(resultados [i][4]));
            amortizacion = Double.valueOf(String.valueOf(resultados [i][3]));
            largo++;
        }
        resultados[largo] = calcularTotales(resultados, pPlazoAnios);
        resultados[largo] = calcularTotales(resultados, pPlazoAnios);
        resultados[largo+1][0] = " "; 
        resultados[largo+1][1] = " ";
        resultados[largo+1][2] = " ";
        resultados[largo+1][3] = " ";
        resultados[largo+1][4] = " ";
        
        resultados[largo+2][0] = "Codigo: "; 
        resultados[largo+2][1] = super.getNumeroSolicitud();
        resultados[largo+2][2] = " ";
        resultados[largo+2][3] = "Estado: ";
        resultados[largo+2][4] = super.estado;
        return resultados;
    }
}
