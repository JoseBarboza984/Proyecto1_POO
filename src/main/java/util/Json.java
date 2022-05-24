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

    public static void leer() {
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

    public static void guardar(Solicitante pSolicitante){
        
        JSONObject direccion = new JSONObject();
        direccion.put("provincia", pSolicitante.direccion.getProvincia());
        direccion.put("canton", pSolicitante.direccion.getCanton());
        direccion.put("distrito", pSolicitante.direccion.getDistrito());
        direccion.put("sennas", pSolicitante.direccion.getSennas());
        
        JSONObject solicitante = new JSONObject();
        solicitante.put("nombre", pSolicitante.getNombre());
        solicitante.put("sNombre", pSolicitante.getSNombre());
        solicitante.put("apellido", pSolicitante.getApellido());
        solicitante.put("sApellido", pSolicitante.getSApellido());
        solicitante.put("cedula", pSolicitante.getCedula());
        solicitante.put("telefono", pSolicitante.getTelefono());
        solicitante.put("correo", pSolicitante.getCorreo());
        solicitante.put("salarioBruto", pSolicitante.getSalarioBruto());
        solicitante.put("salarioLiquido", pSolicitante.getSalarioLiquido());
        solicitante.put("direccion", direccion);
        JSONArray listaCreditos = new JSONArray();
        for(Credito credito:pSolicitante.creditos) {
            listaCreditos.add(credito);
        }
        solicitante.put("creditos", listaCreditos);
        try(FileWriter file = new FileWriter("DATA\\"+pSolicitante.getCedula()+".txt")){
            file.write(solicitante.toJSONString());
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
