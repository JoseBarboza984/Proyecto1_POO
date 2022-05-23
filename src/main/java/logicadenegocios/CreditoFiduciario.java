/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jose
 */
public class CreditoFiduciario extends Credito {
    ArrayList<Fiador> fiadores;
    
    public CreditoFiduciario(String pTipo, double pMonto, int pPlazo, String pMoneda) {
        super(pTipo, pMonto, pPlazo, pMoneda);
        super.gastosFormalizacion = pMonto * 0.03;
        
        if(pMoneda.equals("Colones"))
            super.tasaInteres = 0.13;
        else if(pMoneda.equals("Dolares"))
            super.tasaInteres = 0.11;
        fiadores = new ArrayList<>();
    }
    
    double getMontoFinal() {
        return super.monto+super.gastosFormalizacion;
    }
    
    public boolean verificarFiadores(Fiador[] pFiadores, double pMonto, double pCuota){
        double suma = 0;
        for(Fiador fiador:pFiadores){
            if(fiador.getSalarioLiquidoMensual() < pCuota)
                return false;
            suma += fiador.getSalarioBrutoMensual();
        }
        return suma >= pMonto*0.20;
    }
    
    public boolean setFiadores(Fiador[] pFiador, double pMonto, double pCuota) {
        if(!verificarFiadores(pFiador, pMonto, pCuota))
            return false;
        fiadores.addAll(Arrays.asList(pFiador));
        return true;
    }
    
    public void setEstado(boolean pEstado) {
        if(pEstado)
            estado = "Aceptado";
        else 
            estado = "Rechazado";
    }
    
    public Object[] calcularCuotaSF(double pMonto, int pPlazoAnios, double pTasaInteres, int k, double pAmortizacionAnterior) {
        Object[] array =  new Object[5];
        array[0] = k;
        double cuota = (pMonto * pTasaInteres)/1- (double) Math.pow((1.0+pTasaInteres), -pPlazoAnios);
        array[1] = cuota;
        double interes = cuota*(1-(1/Math.pow(1+pTasaInteres,pPlazoAnios+1-k)));
        array[2] = interes;
        double amortizacion = cuota/Math.pow(1+pTasaInteres, pPlazoAnios+1-k);
        array[3] = amortizacion;
        array[4] = pMonto- pAmortizacionAnterior;
        return array;
    }
    
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
