/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;


/**
 *  Clase hija de Credito, representa el credito hipotecario de adquisición de terreno
 * 
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class AdquisicionTerreno extends Credito{
    private double avaluo;
    
    /**
     * Metodo constructor del credito hipotecario de adquisición de terreno
     * 
     * @param pTipo         Tipo de credito
     * @param pMonto      Monto inicial solicitado en el credito
     * @param pPlazo        Cantidad de años plazo del credito
     * @param pMoneda    Tipo de moneda en la que se pide el credito
     * @param pTBP           Tasa basica pasiva
     * @param pTED           Tasa efectiva en dolares
     */
    public AdquisicionTerreno(String pTipo, double pMonto, int pPlazo, String pMoneda, double pTBP, double pTED) {
        super(pTipo, pMonto, pPlazo, pMoneda);
        avaluo = pMonto * 0.0065;
        super.gastosFormalizacion = pMonto*0.0075;
        if("Colones".equals(pMoneda)) {
            super.tasaInteres = pTBP+0.025;
            super.honorariosLegales = calcularHonorariosColones(pMonto);
        }
        else if("Dolares".equals(pMoneda)) {
            super.tasaInteres = pTED+0.015;
            super.honorariosLegales = calcularHonorariosDolares(pMonto);
        }
    }
    
    /**
     * Calcula el monto final del credito
     * 
     * @return      Suma de monto inicial del credito con los gastos extras del credito
     */
    public double getMontoFinal() {
        return avaluo+super.gastosFormalizacion+super.honorariosLegales+super.monto;
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
     * @return Monto en colones de los honorarios calculados
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
     * @return Monto en dolares de los honorarios calculados
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
        montoCuota = Math.round(montoCuota * 100.0) / 100.0;            //Integrar
        array[1] = montoCuota;
        double interes = montoCuota*(1-(1/Math.pow(1+pTasaInteres,pPlazoAnios+1-k)));
        interes = Math.round(interes * 100.0) / 100.0;                              //Integrar
        array[2] = interes;
        double amortizacion = montoCuota/Math.pow(1+pTasaInteres, pPlazoAnios+1-k);
        amortizacion  = Math.round(amortizacion * 100.0) / 100.0;           //Integrar
        array[3] = amortizacion;
        array[4] = this.getMontoFinal()- pAmortizacionAnterior;
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
        array[0] = "Totales";  //Limpiar
        array[1] = "";
        double interes = 0;
        double amortizacion = 0;
        for (int i = 0; i < pPlazoAnios; i++) { 
            interes = interes + Double.valueOf(String.valueOf(pMatriz[i][2]));
            amortizacion = amortizacion + Double.valueOf(String.valueOf(pMatriz[i][3]));
        }
        interes = Math.round(interes * 100.0) / 100.0;
        amortizacion = Math.round(amortizacion * 100.0) / 100.0;
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
        double monto = this.getMontoFinal();
        int largo = 0;
        for(int i = 0; i < pPlazoAnios; i++) { 
            resultados[i] = calcularCuotaSF(monto, pPlazoAnios, pTasaInteres, i+1,  amortizacion);
            monto = (double) resultados [i][4];
            amortizacion = (double) resultados [i][3];
            largo++;
        }
        resultados[largo] = calcularTotales(resultados, pPlazoAnios);
        return resultados;
    }
    
}
