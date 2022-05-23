/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;


/**
 *  Clase hija de Credito, representa el credito hipotecario de construcción de vivienda
 * 
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class ConstruccionVivienda extends Credito{
    private double avaluo;
    private double montoBono = 0;
    private boolean bono = false;
    
    /**
     * Metodo constructor del credito hipotecario de construcción de vivienda
     * 
     * @param pTipo                       Tipo de credito
     * @param pMonto                   Monto inicial solicitado en el credito
     * @param pPlazo                     Cantidad de años plazo del credito
     * @param pMoneda                 Tipo de moneda en la que se pide el credito
     * @param pTBP                       Tasa basica pasiva
     * @param pTED                       Tasa efectiva en dolares
     * @param pBono                     Boolean que indica si quiere aplicar al bono
     * @param pIngresoFamiliar     Monto del ingreso familiar
     */
    public ConstruccionVivienda (String pTipo, double pMonto, int pPlazo, String pMoneda, double pTBP, double pTED, boolean pBono, double pIngresoFamiliar) {
        super(pTipo, pMonto, pPlazo, pMoneda);
        bono = pBono;
        if("Colones".equals(pMoneda)) {
            super.tasaInteres = pTBP+0.025;
            if(bono = true) {
                montoBono = calcularMontoBonoColones(pIngresoFamiliar);
                super.honorariosLegales = calcularHonorariosColones(pMonto-montoBono);
                super.gastosFormalizacion = (pMonto-montoBono)*0.0075;
                avaluo = (pMonto-montoBono)* 0.0065;
            } else {
                super.honorariosLegales = calcularHonorariosColones(pMonto);
                super.gastosFormalizacion = pMonto*0.0075;
                avaluo = pMonto * 0.0065;
            }
        }
        
        else if(pMoneda == "Dolares"){
            super.tasaInteres = pTED+0.015;
            if(bono = true) {
                montoBono = calcularMontoBonoDolares(pIngresoFamiliar);
                super.honorariosLegales = calcularHonorariosDolares(pMonto-montoBono);
                super.gastosFormalizacion = (pMonto-montoBono)*0.0075;
                avaluo = (pMonto-montoBono)* 0.0065;
            } else {
                super.honorariosLegales = calcularHonorariosDolares(pMonto);
                super.gastosFormalizacion = pMonto*0.0075;
                avaluo = pMonto * 0.0065;
            }
        }
    }
         
    /**
     * Calcula el monto final del credito
     * 
     * @return      Suma de monto inicial del credito con los gastos extras del credito
     */
    public double getMontoFinal() {
        double Monto = super.monto;
        if(bono = true)
            Monto = Monto-montoBono;
        return avaluo+super.gastosFormalizacion+super.honorariosLegales+Monto;
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
     * @return Monto en colones de los honorarios
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
     * Calcula el monto en dolares del bono al que aplica el solicitante en base al ingreso familiar
     * 
     * @param pIngresoFamiliar  Monto que indica los ingresos familiares
     * @return      Monto asignado de bono en dolares
     */
    private double calcularMontoBonoColones(double pIngresoFamiliar) {
        double resultado;
        if(pIngresoFamiliar >= 282753) 
            resultado = 7630000;
        
        else if(pIngresoFamiliar >= 424129.5) 
            resultado = 7576000;
        
        else if(pIngresoFamiliar >= 565506) 
            resultado = 7523000;
        
        else if(pIngresoFamiliar >= 706882.5) 
            resultado = 7178000;
        
        else if(pIngresoFamiliar >= 848259) 
            resultado = 6834000;
        
        else if(pIngresoFamiliar >= 989635.5) 
            resultado = 6489000;
        
        else if(pIngresoFamiliar >= 1131012) 
            resultado = 6145000;
        
        else if(pIngresoFamiliar >= 1272388.5) 
            resultado = 5801000;
        
        else if(pIngresoFamiliar >= 1413765) 
            resultado = 5456000;
        
        else if(pIngresoFamiliar >= 1555141.5) 
            resultado = 5112000;
       
        else if(pIngresoFamiliar >= 1696518) 
            resultado = 4768000;
        
        else
            resultado = 0;
        return resultado;
    }
    
    /**
     * Calcula el monto en dolares del bono al que aplica el solicitante en base al ingreso familiar
     * 
     * @param pIngresoFamiliar  Monto que indica los ingresos familiares
     * @return      Monto asignado de bono en dolares
     */
    private double calcularMontoBonoDolares(double pIngresoFamiliar) {
        double resultado;
        if(pIngresoFamiliar >= 282753/670) 
            resultado = 7630000/670;
        
        else if(pIngresoFamiliar >= 424129.5/670) 
            resultado = 7576000/670;
        
        else if(pIngresoFamiliar >= 565506/670) 
            resultado = 7523000/670;
        
        else if(pIngresoFamiliar >= 706882.5/670) 
            resultado = 7178000/670;
        
        else if(pIngresoFamiliar >= 848259/670) 
            resultado = 6834000/670;
        
        else if(pIngresoFamiliar >= 989635.5/670) 
            resultado = 6489000/670;
        
        else if(pIngresoFamiliar >= 1131012/670) 
            resultado = 6145000/670;
        
        else if(pIngresoFamiliar >= 1272388.5/670) 
            resultado = 5801000/670;
        
        else if(pIngresoFamiliar >= 1413765/670) 
            resultado = 5456000/670;
        
        else if(pIngresoFamiliar >= 1555141.5/670) 
            resultado = 5112000/670;
       
        else if(pIngresoFamiliar >= 1696518/670) 
            resultado = 4768000/670;
        
        else
            resultado = 0;
        return resultado;
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
        Object[] array =  new Object[4];
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
            resultados[i] = calcularCuotaSF(pMonto, pPlazoAnios, pTasaInteres, i+1,  amortizacion);
            amortizacion = (double) resultados [i][3];
            largo++;
        }
        resultados[largo] = calcularTotales(resultados, pPlazoAnios);
        return resultados;
    }
    
}
