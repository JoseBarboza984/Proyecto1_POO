/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

/**
 *  Clase que representa una dirección de un solicitante
 * 
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class Direccion {
    private String provincia;
    private String canton;
    private String distrito;
    private String sennas;
    
    /**
     * Metodo constructor del la Clase dirección
     * 
     * @param pProvincia
     * @param pCanton
     * @param pDistrito
     * @param pSennas
     */
    public Direccion(String pProvincia, String pCanton, String pDistrito, String pSennas) {
        provincia = pProvincia;
        canton = pCanton;
        distrito = pDistrito;
        sennas = pSennas;
    }
    
    //Metodos Accesores
    public String getProvincia() {
        return provincia;
    }
    public String getCanton() {
        return canton;
    }
    public String getDistrito() {
        return distrito;
    }
    public String getSennas() {
        return sennas;
    }
    
    /**
     *  Metodo para establecer la información en una Cadena de caracteres
     * 
     * @return  Cadena de caracteres con la información de dirección
     */
    @Override
    public String toString() {
        String msg = "";
        msg += "Provincia: " + provincia + "\n";
        msg += "Canton " + canton + "\n";
        msg += "Distrito " + distrito + "\n";
        msg += "Señas: " + sennas + "\n";
        return msg;
    }
}
