/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Jose
 */
public class FiadorDoesNotApplyException extends Exception{
    public FiadorDoesNotApplyException(String errorMessage) {
        super(errorMessage);
    }
}
