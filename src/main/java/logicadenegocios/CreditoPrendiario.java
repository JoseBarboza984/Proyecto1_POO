/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;


/**
 *
 * @author Jose
 */
public class CreditoPrendiario extends Credito {
    private Prenda prenda;      //Validar cuando no existe una prenda registrada
    
    public CreditoPrendiario(String pTipo, double pMonto, int pPlazo, String pMoneda) {
        super(pTipo, pMonto, pPlazo, pMoneda);
        super.gastosFormalizacion = pMonto * 0.03;
       
        if(pMoneda == "Colones") {
            super.tasaInteres = 0.15;
            super.honorariosLegales = calcularHonorariosColones(pMonto);
        }
        else if(pMoneda == "Dolares"){
            super.tasaInteres = 0.13;
            super.honorariosLegales = calcularHonorariosDolares(pMonto);
        }
    }
    
    public double getMontoFinal() {
        return super.monto+super.gastosFormalizacion+super.honorariosLegales;
    }
    
    public void setEstado(boolean pEstado) {
        if(pEstado)
            estado = "Aceptado";
        else 
            estado = "Rechazado";
    }
    
    /**
     * 
     * @param pDescripcionPrenda
     * @param pMontoPrenda
     * @return 
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
        double residuo = 0;
        
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
     * @return Monto en colones de los honorarios
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
        double residuo = 0;
        
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

    public Object[] calcularCuotaSAm(double pMonto, int pPlazoAnios, double pTasaInteres, int k, int n, double pAmortizacionAnterior) {
        Object[] array =  new Object[5];
        array[0] = k;
        double interes = pTasaInteres * pMonto;
        array[2] = interes;
        double amortizacion = 0;
        if(k == n)
            amortizacion = pMonto;
        array[3] = amortizacion;
        double mCuota = interes + amortizacion;
        array[1] = mCuota;
        array[4] = pMonto - pAmortizacionAnterior;
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
            resultados[i] = calcularCuotaSAm(pMonto, pPlazoAnios, pTasaInteres, i+1, pPlazoAnios, amortizacion);
            amortizacion = (double) resultados [i][3];
            largo++;
        }
        
        resultados[largo] = calcularTotales(resultados, pPlazoAnios);
        return resultados;
    }
}
