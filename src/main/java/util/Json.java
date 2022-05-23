/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package util;

import logicadenegocios.*;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author dirana
 */
public class Json {

    public static void main(String[] args) {

    }

    private static void leer() {
        JSONParser jsonParser = new JSONParser();
        
        try(FileReader reader = new FileReader("personas.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray personasList = (JSONArray) obj;
            System.out.println("El archivo contiene: ");
            System.out.println(personasList);
            
            for(Object persona: personasList){
                mostrarInfo((JSONObject) persona);
            }
  
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }

    private static void guardar(Solicitante pSolicitante){
        JSONObject telefono1 = new JSONObject();
        telefono1.put("telefono", "2341234");
        
        JSONObject telefono2 = new JSONObject();
        telefono2.put("telefono", "78947894");
        
        JSONArray telefonoList = new JSONArray();
        telefonoList.add(telefono1);
        telefonoList.add(telefono2);
        
        JSONObject persona1 = new JSONObject();
        persona1.put("nombre", "dirana");
        persona1.put("apellido", "calderon");
        persona1.put("codigo", 1);
        persona1.put("estatura", 1.5);
        persona1.put("telefonos", telefonoList);
        
        JSONObject datosPersona1 = new JSONObject();
        datosPersona1.put("persona", persona1);
        
        
        JSONArray listaPersona = new JSONArray();
        listaPersona.add(datosPersona1);
        
        try(FileWriter file = new FileWriter("personas.json")){
            file.write(listaPersona.toJSONString());
            file.flush();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void mostrarInfo(JSONObject jsonObject) {
        JSONObject persona = (JSONObject) jsonObject.get("persona");
        System.out.println("Persona dentro del JSON: ");
        
        String nombre = (String) persona.get("nombre");
        System.out.println("Nombre: "+nombre);
        
        String apellido = (String) persona.get("apellido");
        System.out.println("Apellido: "+apellido);
        
        Long codigo = (Long) persona.get("codigo");
        System.out.println("Codigo: "+codigo);
        
        Double estatura = (Double) persona.get("estatura");
        System.out.println("Estatura: "+estatura);
        
        JSONArray telefonosList = (JSONArray) persona.get("telefonos");
        for (Object tel: telefonosList){
            JSONObject t = (JSONObject) tel;
            System.out.println("Telefono: "+t.get("telefono"));
        }
        
    }
}
