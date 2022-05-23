/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

/**
 *
 * @author Jose
 */
public class Prenda {
    private double monto;
    private String descripccion;
    
    public Prenda(double pMonto, String pDescripccion) {
        monto = pMonto;
        descripccion = pDescripccion;
    }
    
    public double getMonto() {
        return monto;
    }
    
    public String getDescripccion() {
        return descripccion;
    }
    
    public String toSring() {
        String msg = "";
        msg += "Descripcción: " + descripccion + "\n";
        msg += "Monto: " + monto + "\n";
        return msg;
    }
}
