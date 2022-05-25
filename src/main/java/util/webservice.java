package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class webservice {
     protected static String getHTML(String urlToRead) throws Exception {
        StringBuilder resultado = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        BufferedReader data = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String line;
        while ((line = data.readLine()) != null) {
           resultado.append(line);
        }
        data.close();
        return resultado.toString();
    }
}
