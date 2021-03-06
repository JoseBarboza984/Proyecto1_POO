/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.lang.Math;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import util.FormatoDecimal;

/**
 *  Clase hija de Credito, representa el credito fiduciario
 * 
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class CreditoFiduciario extends Credito {
    public ArrayList<Fiador> fiadores;
    
    /**
     * Metodo constructor del credito fiduciario
     * 
     * @param pTipo         Tipo de credito
     * @param pMonto      Monto inicial solicitado en el credito
     * @param pPlazo        Cantidad de años plazo del credito
     * @param pMoneda    Tipo de moneda en la que se pide el credito
     */
    public CreditoFiduciario(String pTipo, double pMonto, int pPlazo, String pMoneda) {
        super(pTipo, pMonto, pPlazo, pMoneda);
        super.gastosFormalizacion = pMonto * 0.03;
        double tasa = 0;
        if(pMoneda.equals("Colones"))
            tasa = 0.13;
        else if(pMoneda.equals("Dolares"))
            tasa = 0.11;
        super.tasaInteres = tasa;
        fiadores = new ArrayList<>();
        
        super.cuota = (pMonto * tasa)/1- (double) Math.pow((1.0+tasa), -pPlazo);
    }
    
    /**
     * Metodo constructor del credito fiduciario
     * 
     * @param pTipo         Tipo de credito
     * @param pMonto      Monto inicial solicitado en el credito
     * @param pPlazo        Cantidad de años plazo del credito
     * @param pMoneda    Tipo de moneda en la que se pide el credito
     */
    public CreditoFiduciario(String pTipo, double pMonto, int pPlazo, String pMoneda, String pNumeroSolicitud, String pFechaSolicitud) throws ParseException {
        super(pTipo, pMonto, pPlazo, pMoneda, pNumeroSolicitud, pFechaSolicitud);
        super.gastosFormalizacion = pMonto * 0.03;
        double tasa = 0;
        if(pMoneda.equals("Colones"))
            tasa = 0.13;
        else if(pMoneda.equals("Dolares"))
            tasa = 0.11;
        super.tasaInteres = tasa;
        fiadores = new ArrayList<>();
        
        super.cuota = (pMonto * tasa)/1- (double) Math.pow((1.0+tasa), -pPlazo);
    }
    
    /**
     * Calcula el monto final del credito
     * 
     * @return      Suma de monto inicial del credito con los gastos extras del credito
     */
    public double getMontoFinal() {
        return super.monto+super.gastosFormalizacion;
    }
    
    
    //Medotos Accesores
    public double getCuota() {
        return super.cuota;
    }
    
    /**
     * Metodo que verifica que los fiadores cumplan con la cuota
     * 
     * @param pFiadores     Array de fiadores
     * @param pMonto        Monto final del credito
     * @param pCuota        Monto de la cuota del credito
     * @return      true (Si salario liquido de los o el fiador es mayor a la cuota y si la suma de sus salarios brutos es mayor al 20% del monto del credito)
     *                              false (Si no)
     */
    public boolean verificarFiadores(Fiador[] pFiadores, double pMonto, double pCuota){
        double suma = 0;
        for(Fiador fiador:pFiadores){
            if(fiador.getSalarioLiquidoMensual() < pCuota)
                return false;
            suma += fiador.getSalarioBrutoMensual();
        }
        return suma >= pMonto*0.20;
    }
    
    /**
     * Metodo que establece los fiadores en el array del credito si cumplen con los requisitos
     * 
     * @param pFiador         Array de fiadores
     * @param pMonto        Monto inicial del credito
     * @param pCuota        Monto de la cuota del credito
     * @return      true(En caso de que cumplan los requisitos) y false(Si no)
     */
    public boolean setFiadores(Fiador[] pFiador, double pMonto, double pCuota) {
        if(!verificarFiadores(pFiador, pMonto, pCuota))
            return false;
        fiadores.addAll(Arrays.asList(pFiador));
        return true;
    }
    
    public void setFiador(Fiador pFiador) {
        fiadores.add(pFiador);
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
     * Calcula los datos de una fila "k" de la tabla de amortizacion en base al sistema frances
     *
     * @param pMonto                                Monto final del prestamo solicitado
     * @param pPlazoAnios                         Cantidad de años en lo que se va a pagar el credito
     * @param pTasaInteres                        Tasa de interes que se aplica en el credito
     * @param k                                          Numero de cuota o fila
     * @param pAmortizacionAnterior         Valor de la amortización en la cuota anterior
     * @param pMontoAnterior                    Monto de la deuda anterior
     * @return      Array de objetos que contiene los datos {Numero de cuota, Monto de cuota, Interes, Amortización, Deuda}
     */
    public Object[] calcularCuotaSF(double pMonto, int pPlazoAnios, double pTasaInteres, int k, double pAmortizacionAnterior, double pMontoAnterior) {
        Object[] array =  new Object[5];
        array[0] = k;
        double montoCuota = (pMonto * pTasaInteres)/(1- (double) Math.pow((1.0+pTasaInteres), -pPlazoAnios)); //Parentesis
        montoCuota = Math.round(montoCuota * 100.0) / 100.0;            //Integrar
        array[1] = FormatoDecimal.formatoDecimal(montoCuota);
        double interes = montoCuota*(1-(1/Math.pow(1+pTasaInteres,pPlazoAnios+1-k)));
        interes = Math.round(interes * 100.0) / 100.0;                              //Integrar
        array[2] = FormatoDecimal.formatoDecimal(interes);
        double amortizacion = montoCuota/Math.pow(1+pTasaInteres, pPlazoAnios+1-k);
        amortizacion  = Math.round(amortizacion * 100.0) / 100.0;           //Integrar
        array[3] = FormatoDecimal.formatoDecimal(amortizacion);
        array[4] = FormatoDecimal.formatoDecimal(Math.round((pMontoAnterior- pAmortizacionAnterior)* 100.0) / 100.0);  //Cambiar al monto anterior
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
    @Override                                                       //      V                           n                               i
    public Object[][] calcularTablaAmortizacion(double pMonto, int pPlazoAnios, double pTasaInteres) {
        Object[][] resultados = new Object[pPlazoAnios+3][5];
        double amortizacion = 0;
        double monto = this.getMontoFinal();
        int largo = 0;
        for(int i = 0; i < pPlazoAnios; i++) {
            resultados[i] = calcularCuotaSF(this.getMontoFinal(), pPlazoAnios, pTasaInteres, i+1, amortizacion, monto);
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
