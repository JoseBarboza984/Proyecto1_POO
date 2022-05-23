/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

/**
 *
 * @author Jose
 */
public class Fiador {
    private String nombre;
    private int cedula;
    private double salarioBrutoMensual;
    private double salarioLiquidoMensual;
    
    public Fiador(String pNombre, int pCedula, double pSbruto, double pSliquido) {
        nombre = pNombre;
        cedula = pCedula;
        salarioBrutoMensual = pSbruto;
        salarioLiquidoMensual = pSliquido;
    }
    
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
    
    public String toString() {
        String msg = "";
        msg += "Fiador: " + nombre + "\n";
        msg += "\t Cedula: " + cedula + "\n";
        msg += "Salario bruto mensual: " + salarioBrutoMensual + "\n";
        msg += "Salario liquido mensual: " + salarioLiquidoMensual + "\n";
        return msg;
    }
}
