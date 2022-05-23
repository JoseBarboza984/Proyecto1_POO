/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Clase hija de Credito, representa el credito fiduciario
 * 
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class CreditoFiduciario extends Credito {
    ArrayList<Fiador> fiadores;
    
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
        
        if(pMoneda.equals("Colones"))
            super.tasaInteres = 0.13;
        else if(pMoneda.equals("Dolares"))
            super.tasaInteres = 0.11;
        fiadores = new ArrayList<>();
    }
    
    /**
     * Calcula el monto final del credito
     * 
     * @return      Suma de monto inicial del credito con los gastos extras del credito
     */
    double getMontoFinal() {
        return super.monto+super.gastosFormalizacion;
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
     * @param pMonto        Monto final del credito
     * @param pCuota        Monto de la cuota del credito
     * @return      true(En caso de que cumplan los requisitos) y false(Si no)
     */
    public boolean setFiadores(Fiador[] pFiador, double pMonto, double pCuota) {
        if(!verificarFiadores(pFiador, pMonto, pCuota))
            return false;
        fiadores.addAll(Arrays.asList(pFiador));
        return true;
    }
    
    /**
     *  Establece el atributo estado
     * @param pEstado   Variable que contiene si se debe aceptar o no el credito
     */
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
     * @return      Array de objetos que contiene los datos {Numero de cuota, Monto de cuota, Interes, Amortización, Deuda}
     */
    public Object[] calcularCuotaSF(double pMonto, int pPlazoAnios, double pTasaInteres, int k, double pAmortizacionAnterior) {
        Object[] array =  new Object[5];
        array[0] = k;
        double montoCuota = (pMonto * pTasaInteres)/1- (double) Math.pow((1.0+pTasaInteres), -pPlazoAnios);
        array[1] = montoCuota;
        double interes = montoCuota*(1-(1/Math.pow(1+pTasaInteres,pPlazoAnios+1-k)));
        array[2] = interes;
        double amortizacion = montoCuota/Math.pow(1+pTasaInteres, pPlazoAnios+1-k);
        array[3] = amortizacion;
        array[4] = pMonto- pAmortizacionAnterior;
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
        array[0] = "Totales'";
        array[1] = "";
        double interes = 0;
        double amortizacion = 0;
        for (int i = 0; i < pPlazoAnios; i++) {
            interes = interes + Double.valueOf(String.valueOf(pMatriz[i][2]));
            amortizacion = amortizacion + Double.valueOf(String.valueOf(pMatriz[i][3]));
        }
        array[2] = interes;
        array[3] = amortizacion;
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
        Object[][] resultados = new Object[pPlazoAnios+1][5];
        double amortizacion = 0;
        int largo = 0;
        for(int i = 0; i < pPlazoAnios; i++) {
            resultados[i] = calcularCuotaSF(pMonto, pPlazoAnios, pTasaInteres, i+1, amortizacion);
            amortizacion = (double) resultados [i][3];
            largo++;
        }
        resultados[largo] = calcularTotales(resultados, pPlazoAnios);
        return resultados;
    }
    
}
