/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

/**
 *
 * @author Jose
 */
public class Direccion {
    private String provincia;
    private String canton;
    private String distrito;
    private String sennas;
    
    public Direccion(String pProvincia, String pCanton, String pDistrito, String pSennas) {
        provincia = pProvincia;
        canton = pCanton;
        distrito = pDistrito;
        sennas = pSennas;
    }
    
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
