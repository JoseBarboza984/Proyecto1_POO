/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

/**
 *
 * @author Jose
 */
public class CreditoPersonal extends Credito{
    
    public CreditoPersonal(String pTipo, double pMonto, int pPlazo, String pMoneda) {
        super(pTipo, pMonto, pPlazo, pMoneda);
        super.gastosFormalizacion = pMonto * 0.03;
        if(pMoneda == "Colones")
            super.tasaInteres = 0.18;
        else if(pMoneda == "Dolares")
            super.tasaInteres = 0.16;
    }
    
    public boolean verificarSolicitante(double pSalarioLiquido) {
        return pSalarioLiquido > (super.cuota*0.1);
    }
    
    public double getMontoFinal() {
        return super.monto+super.gastosFormalizacion;
    }
    
   public void setEstado(boolean pEstado) {
        if(pEstado)
            estado = "Aceptado";
        else 
            estado = "Rechazado";
    }

    public Object[] calcularCuotaSAl(double pMonto, int pPlazoAnios, double pTasaInteres, int k, int n, double pAmortizacionAnterior, double pCuotaAnterior) {
        Object[] array =  new Object[5];
        array[0] = k;
        double cuota;
        if (k == 1) 
            cuota = (pMonto/pPlazoAnios) + (pTasaInteres * pMonto);
        else
            cuota = pCuotaAnterior - (pTasaInteres * (pMonto/pPlazoAnios));
        array[1] = cuota;
        double interes = (pPlazoAnios-k+1) * ((pMonto*pTasaInteres)/pPlazoAnios);
        array[2] = interes;
        double amortizacion = pMonto/pPlazoAnios;
        array[3] = amortizacion;
        array[4] = pMonto - pAmortizacionAnterior;
        return array;
    }
    
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
        array[2] = interes;
        array[3] = amortizacion;
        array[4] = 0;
        return array;
    }
    
    @Override                                                       //      V                           n                               i
    public Object[][] calcularTablaAmortizacion(double pMonto, int pPlazoAnios, double pTasaInteres) {
        Object[][] resultados = new Object[pPlazoAnios+1][5];
        double amortizacion = 0;
        double cuota = 0;
        int largo = 0;
        for(int i = 0; i < pPlazoAnios; i++) {
            resultados[i] = calcularCuotaSAl(pMonto, pPlazoAnios, pTasaInteres, i+1, pPlazoAnios, amortizacion, cuota);
            amortizacion = (double) resultados [i][3];
            cuota = (double) resultados[i][1];
            largo++;
        }
        
        resultados[largo] = calcularTotales(resultados, pPlazoAnios);
        return resultados;   
    }
}
