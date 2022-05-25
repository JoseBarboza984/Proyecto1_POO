/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class PrendaDoesNotApplyException extends Exception{
    public PrendaDoesNotApplyException(String errorMessage) {
        super(errorMessage);
    }
}
