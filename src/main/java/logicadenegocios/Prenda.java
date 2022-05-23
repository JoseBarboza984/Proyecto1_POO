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
public class Prenda {
    private double monto;
    private String descripccion;
    
    /**
     * Metodo constructor de la Clase prenda
     * 
     * @param pMonto                Valor de la prenda
     * @param pDescripccion      Descripcción de la prenda
     */
    public Prenda(double pMonto, String pDescripccion) {
        monto = pMonto;
        descripccion = pDescripccion;
    }
    
    //Metodos Accesores
    public double getMonto() {
        return monto;
    }
    public String getDescripccion() {
        return descripccion;
    }
    
    /**
     *  Metodo para establecer la información en una Cadena de caracteres
     * 
     * @return  Cadena de caracteres con la información de una prenda
     */
    @Override
    public String toString() {
        String msg = "";
        msg += "Descripcción: " + descripccion + "\n";
        msg += "Monto: " + monto + "\n";
        return msg;
    }
}
