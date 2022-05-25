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

import java.util.logging.Level;
import java.util.logging.Logger;


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

    public static ArrayList<Solicitante> leer() {
        JSONParser jsonParser = new JSONParser();
        
        ArrayList solicitantes = new ArrayList<Solicitante>();
        
        try(FileReader reader = new FileReader("DATA\\"+"solicitantes.txt")){
            Object obj = jsonParser.parse(reader);
            JSONArray personasList = (JSONArray) obj;
            for(Object persona:personasList){
                Solicitante solicitante = cargarInfo((JSONObject) persona);
                solicitantes.add(solicitante);
            }
            return solicitantes;
        }catch(FileNotFoundException e){
        }
        catch(IOException | ParseException e){
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        }
        return solicitantes;
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
                    credito.put("TBP", creditoT.getTBP());
                    credito.put("TED", creditoT.getTED());
                    credito.put("ingresoFamiliar", creditoT.getIngresoFamiliar());
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
            
            JSONObject Solicitante = new JSONObject();
            Solicitante.put("solicitante",solicitante);
            
            listaSolicitante.add(Solicitante);
        }
        try(FileWriter file = new FileWriter("DATA\\"+"solicitantes.txt")){
            file.write(listaSolicitante.toJSONString());
            file.flush();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private static Solicitante cargarInfo(JSONObject jsonObject) throws java.text.ParseException {
        JSONObject persona = (JSONObject) jsonObject.get("solicitante");
        
        String nombre = (String) persona.get("nombre");
        String sNombre = (String) persona.get("sNombre");
        String apellido = (String) persona.get("apellido");
        String sApellido = (String) persona.get("sApellido");
        int cedula = Integer.valueOf(String.valueOf(persona.get("cedula")));
        int telefono = Integer.valueOf(String.valueOf(persona.get("telefono")));
        String correo = (String) persona.get("correo");
        double salarioBruto = Double.valueOf(String.valueOf(persona.get("salarioBruto")));
        double salarioLiquido = Double.valueOf(String.valueOf(persona.get("salarioLiquido")));

        JSONObject direccion = (JSONObject) persona.get("direccion");
        String provincia = (String) direccion.get("provincia");
        String canton = (String) direccion.get("canton");
        String distrito = (String) direccion.get("distrito");
        String sennas = (String) direccion.get("sennas");

        Solicitante pSolicitante = new Solicitante(nombre, sNombre, apellido, sApellido, cedula, telefono, correo, salarioBruto, salarioLiquido, provincia, canton, distrito, sennas);

        JSONArray listaCreditos = (JSONArray) persona.get("creditos");
        for (Object cre: listaCreditos){
            JSONObject credito = (JSONObject) cre;
            
            String tipo = (String) credito.get("tipo");                                
            double monto = Double.valueOf(String.valueOf(credito.get("monto")));
            String moneda = (String) credito.get("moneda");
            String fechaSolicitud = (String) credito.get("fechaSolicitud");
            String numeroSolicitud = (String) credito.get("numeroSolicitud");                 
            int plazo = Integer.valueOf(String.valueOf(credito.get("plazo")));
            if(tipo.equals("Hipotecario de terreno")) {
                double avaluo = Double.valueOf(String.valueOf(credito.get("avaluo")));
                AdquisicionTerreno pCredito = new AdquisicionTerreno(tipo, monto, plazo, moneda, avaluo, numeroSolicitud, fechaSolicitud);
                pSolicitante.setCredito(pCredito);
            }
            if(tipo.equals("Hipotecario de vivienda")) {
                double avaluo = Double.valueOf(String.valueOf(credito.get("avaluo")));
                double montoBono = Double.valueOf(String.valueOf(credito.get("montoBono")));
                boolean bono = Boolean.valueOf(String.valueOf(credito.get("'bono")));
                double TBP = Double.valueOf(String.valueOf(credito.get("TBP")));
                double TED = Double.valueOf(String.valueOf(credito.get("TED")));
                double ingresoFamiliar = Double.valueOf(String.valueOf(credito.get("ingresoFamiliar")));
                ConstruccionVivienda pCredito = new ConstruccionVivienda(tipo, monto, plazo, moneda, TBP, TED, bono, ingresoFamiliar, numeroSolicitud, fechaSolicitud, montoBono);
                pSolicitante.setCredito(pCredito);
            }
            if(tipo.equals("Fiduciario")) {
                JSONArray listaFiadores = (JSONArray) credito.get("fiadores");
                CreditoFiduciario pCredito = new CreditoFiduciario(tipo, monto, plazo, moneda, numeroSolicitud, fechaSolicitud);
                for(Object fia: listaFiadores) {
                    JSONObject fiador = (JSONObject ) fia;
                    String nombreF = (String) fiador.get("nombre");
                    int cedulaF = Integer.valueOf(String.valueOf(fiador.get("cedula")));
                    double salarioBrutoF = Double.valueOf(String.valueOf(fiador.get("salarioBruto")));
                    double salarioLiquidoF = Double.valueOf(String.valueOf(fiador.get("salarioLiquido")));
                    Fiador pFiador = new Fiador(nombreF, cedulaF, salarioBrutoF, salarioLiquidoF);
                    pCredito.setFiador(pFiador);
                }
                pSolicitante.setCredito(pCredito);
            }
            if(tipo.equals("Prendiario")) {
                CreditoPrendiario pCredito = new CreditoPrendiario(tipo, monto, plazo, moneda, numeroSolicitud, fechaSolicitud);
                JSONObject prenda = (JSONObject) credito.get("prenda");
                String descripccionP = (String) prenda.get("descripccion");
                double montoP = Double.valueOf(String.valueOf(prenda.get("monto")));
                pCredito.setEstado(pCredito.setPrenda(descripccionP, montoP));
                pSolicitante.setCredito(pCredito);
            }
            if(tipo.equals("Personal")) {
                CreditoPersonal pCredito = new CreditoPersonal(tipo, monto, plazo, moneda, numeroSolicitud, fechaSolicitud);
                pCredito.setEstado(pCredito.verificarSolicitante(pSolicitante.getSalarioLiquido()));
                pSolicitante.setCredito(pCredito);
            }
        }
        return pSolicitante;
    }
}
