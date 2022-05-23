/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Jose
 */
public class SolicitanteAlreadyExistException extends Exception{
    public SolicitanteAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
