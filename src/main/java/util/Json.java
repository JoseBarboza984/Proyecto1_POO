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
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Jose Barboza, Joshua Ramírez, Diranan Calderón
 */
public class Json {
    funciones realizar = new funciones();

    public void leer() {
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
        }
        catch(IOException | ParseException e){
        }
    }

    public void guardar(ArrayList<Solicitante> pSolicitantes){
        JSONArray listaSolicitante = new JSONArray();
        for(Solicitante pSolicitante: pSolicitantes){
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
            for(Credito pCredito:pSolicitante.creditos) {
                JSONObject credito = new JSONObject();
                credito.put("tipo", pCredito.getTipo());
                credito.put("monto", pCredito.getMonto());
                credito.put("plazo", pCredito.getPlazo());
                credito.put("moneda", pCredito.getMoneda());
                credito.put("numeroSolicitud", pCredito.getNumeroSolicitud());
                credito.put("fechaSolicitud", pCredito.getBaseFechaSolicitud());
                if(pCredito.getTipo().equals("Hipotecario de terreno")) {
                    AdquisicionTerreno creditoT = (AdquisicionTerreno) realizar.buscarCredito(pSolicitante, pCredito.getNumeroSolicitud());
                    credito.put("avaluo", creditoT.getAvaluo());
                }
                else if(pCredito.getTipo().equals("Hipotecario de vivienda")) {
                    ConstruccionVivienda creditoT = (ConstruccionVivienda) realizar.buscarCredito(pSolicitante, pCredito.getNumeroSolicitud());
                    credito.put("avaluo", creditoT.getAvaluo());
                    credito.put("montoBono", creditoT.getMontoBono());
                    credito.put("bono", creditoT.getBono());
                }
                else if(pCredito.getTipo().equals("Fiduciario")) {
                    JSONArray listaFiadores = new JSONArray();
                    CreditoFiduciario creditoT = (CreditoFiduciario) realizar.buscarCredito(pSolicitante, pCredito.getNumeroSolicitud());
                    for(Fiador fiadorT:creditoT.fiadores) {
                        JSONObject fiador = new JSONObject();
                        fiador.put("nombre", fiadorT.getNombre());
                        fiador.put("cedula", fiadorT.getCedula());
                        fiador.put("salarioBruto", fiadorT.getSalarioBrutoMensual());
                        fiador.put("salarioLiquido", fiadorT.getSalarioLiquidoMensual());
                        listaFiadores.add(fiador);
                    }
                    credito.put("fiadores", listaFiadores);
                }
                else if(pCredito.getTipo().equals("Prendiario")) {
                    CreditoPrendiario creditoT = (CreditoPrendiario) realizar.buscarCredito(pSolicitante, pCredito.getNumeroSolicitud());
                    JSONObject prenda = new JSONObject();
                    prenda.put("monto", creditoT.prenda.getDescripccion());
                    prenda.put("descripccion", creditoT.prenda.getDescripccion());
                    credito.put("prenda", prenda);
                }
                else if(pCredito.getTipo().equals("Personal")) {
                    // Presenta los mismo atributos que la clase madre
                }
                listaCreditos.add(credito);
            }
            solicitante.put("creditos", listaCreditos);
            
            listaSolicitante.add(solicitante);
        }
        try(FileWriter file = new FileWriter("DATA\\"+"solicitantes.txt")){
            file.write(listaSolicitante.toJSONString());
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
