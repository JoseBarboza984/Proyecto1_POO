package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class obtenervalores {
    private String fechaInicio;
    private String fechaFinal;
    private int indicadorRequerido = 0;
    private final String nombre = "ProyectoPOO";
    private final String subNiveles = "N";
    private final String HOST = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML";
    private String url;
    private final String VALUE_TAG = "NUM_VALOR";

    public obtenervalores(){
      setFecha();
    }
    
    private void setTBP(){
        this.indicadorRequerido = 423;
    }

    private void setTED(){
        this.indicadorRequerido = 23698;
    }
    
    public double getTBP(){
        setTBP();

        double valor = Double.parseDouble(getValores());
        return valor;
    }

    public double getTED(){
        setTED();

        double valor = Double.parseDouble(getValores());
        return valor;
    }
    
    private String getValores(){
        try {
          setUrl(); //Set del Url con los Parámetros

          //Obtiene y Parsea el XML
          String data = webservice.getHTML(url);
          obtenerxml xml = new obtenerxml(data);

          //Retorna el valor del tag
          return xml.getValores(VALUE_TAG);
        } 
        catch (Exception e) {
          System.out.println("Error, no se obtuvo el valor.");
          return "0";
        }
    }

    private void setUrl(){
        String params = "Indicador="+indicadorRequerido+"&FechaInicio="+fechaInicio+"&FechaFinal="+fechaFinal+"&Nombre="+nombre+"&SubNiveles="+subNiveles+"&CorreoElectronico="+"diranacalderon@gmail.com"+"&Token="+"7ANRD2AD2I";
        this.url = HOST+"?"+params;
    }

    private void setFecha(){
        Date date = new Date();
        SimpleDateFormat fechaAuxiliar = new SimpleDateFormat("dd/MM/yyyy");

        this.fechaInicio = fechaAuxiliar.format(date);
        this.fechaFinal = fechaInicio;
    }
}
