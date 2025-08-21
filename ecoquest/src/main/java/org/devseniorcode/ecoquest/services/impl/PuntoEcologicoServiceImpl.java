package org.devseniorcode.ecoquest.services.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.devseniorcode.ecoquest.models.PuntoEco;
import org.devseniorcode.ecoquest.services.PuntoEcologicoService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PuntoEcologicoServiceImpl implements PuntoEcologicoService{
    
    private final Map<String, PuntoEco> puntosEcos = new HashMap<>();    
    
    public PuntoEcologicoServiceImpl(){
        cargarPuntosEcologicosJson();
    }

    private void cargarPuntosEcologicosJson(){
        String nombreArchivo = "puntosEcologicos.json";
        try(InputStream is = getClass().getClassLoader().getResourceAsStream(nombreArchivo)){
            if(is == null) throw new IllegalArgumentException("No se encontro " + nombreArchivo + " en resources");
            ObjectMapper objectMapper = new ObjectMapper();
            List<PuntoEco> lista = objectMapper.readValue(is, new TypeReference<List<PuntoEco>>(){});
            for (PuntoEco puntoEco : lista) puntosEcos.put(puntoEco.getId(),puntoEco);
        } catch (Exception e){
            throw new RuntimeException("Error cargando "+ nombreArchivo, e);
        }
    }
    @Override
    public void agregarPuntosEcologicos(PuntoEco puntoEco){
        puntosEcos.put(puntoEco.getId(), puntoEco);
    }

    @Override
    public List<PuntoEco> listarPuntosEcologicos(){

        return new ArrayList<>(puntosEcos.values());

    }

    @Override
    public PuntoEco buscarPorId(String id){
        return puntosEcos.get(id);
    }

}
