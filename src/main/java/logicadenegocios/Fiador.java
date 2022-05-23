/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

/**
 *  Clase que representa a un fiador de un credito fiduciario
 * 
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class Fiador {
    private String nombre;
    private int cedula;
    private double salarioBrutoMensual;
    private double salarioLiquidoMensual;
    
    /**
     * Metodo constructor de la Clase fiador
     * 
     * @param pNombre       Nombre del fiador
     * @param pCedula        Cedula del fiador
     * @param pSbruto        Salario bruto del fiador
     * @param pSliquido      Salario liquido de fiador
     */
    public Fiador(String pNombre, int pCedula, double pSbruto, double pSliquido) {
        nombre = pNombre;
        cedula = pCedula;
        salarioBrutoMensual = pSbruto;
        salarioLiquidoMensual = pSliquido;
    }
    
    //Metodos Accesores
    public String getNombre() {
        return nombre;
    }
    public int getCedula() {
        return cedula;
    }
    public double getSalarioBrutoMensual() {
        return salarioBrutoMensual;
    }
    public double getSalarioLiquidoMensual() {
        return salarioLiquidoMensual;
    }
    
    /**
     *  Metodo para establecer la información en una Cadena de caracteres
     * 
     * @return  Cadena de caracteres con la información de un fiador
     */
    @Override
    public String toString() {
        String msg = "";
        msg += "Fiador: " + nombre + "\n";
        msg += "\t Cedula: " + cedula + "\n";
        msg += "Salario bruto mensual: " + salarioBrutoMensual + "\n";
        msg += "Salario liquido mensual: " + salarioLiquidoMensual + "\n";
        return msg;
    }
}
