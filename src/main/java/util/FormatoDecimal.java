/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.DecimalFormat;

/**
 *
 * @author Jose
 */
public class FormatoDecimal {
    private static DecimalFormat decimalFormat = new DecimalFormat("#.00");

    
    public static String formatoDecimal(double numero){
        return decimalFormat.format(numero);
    }
}
