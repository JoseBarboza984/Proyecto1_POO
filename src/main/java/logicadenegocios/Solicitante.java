/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.util.ArrayList;

/**
 * Clase que representa a un solicitante de un credito
 *
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class Solicitante {
    private String nombre;
    private String sNombre;
    private String apellido;
    private String sApellido;
    private int cedula;
    private int telefono;
    private String correo;
    private double  salarioBruto;
    private double salarioLiquido;
    
    public Direccion direccion;
    
    public ArrayList<Credito> creditos;
    
    /**
     * Metodo constructor de un solicitante de credito
     *
     * @param pNombre       
     * @param pSnombre
     * @param pApellido
     * @param pSapellido
     * @param pCedula
     * @param pTelefono
     * @param pCorreo
     * @param pSalarioBruto
     * @param pSalarioLiquido
     * @param pProvincia
     * @param pCanton
     * @param pDistrito
     * @param pSennas
     */
    public Solicitante(String pNombre, String pSnombre, String pApellido, String pSapellido, int pCedula, int pTelefono, String pCorreo, double pSalarioBruto, double pSalarioLiquido, String pProvincia, String pCanton, String pDistrito, String pSennas) {
        nombre = pNombre;
        sNombre = pSnombre;
        apellido = pApellido;
        sApellido = pSapellido;
        cedula = pCedula;
        telefono = pTelefono;
        correo = pCorreo;
        salarioBruto = pSalarioBruto;
        salarioLiquido = pSalarioLiquido;
        direccion = new Direccion(pProvincia, pCanton, pDistrito, pSennas);
        creditos = new ArrayList<>();
    }
    
    //Metodos Accesores
    public int getCedula() {
        return cedula;
    }
    public void setCredito(Credito pCredito) {
        creditos.add(pCredito);
    }
    public String getNombre() {
        return nombre;
    }
    public String getSNombre() {
        return sNombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getSApellido() {
        return sApellido;
    }
    public int getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public double getSalarioLiquido() {
        return salarioLiquido;
    }
    
    public String toString() {
        String msg = "";
        msg += "Solicitante: "+nombre+" "+sNombre+" "+apellido+" "+sApellido+"\t"+"Cedula: "+cedula+"\n";
        msg += "\t"+telefono+"\t"+correo+"\n";
        msg += "Salario bruto mensual: "+salarioBruto+"\t"+"Salario liquido: "+salarioLiquido+"\n";
        return msg;
    }
}
