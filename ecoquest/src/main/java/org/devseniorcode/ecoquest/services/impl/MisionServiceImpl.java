package org.devseniorcode.ecoquest.services.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.devseniorcode.ecoquest.exceptions.MisionInexistenteExcepcion;
import org.devseniorcode.ecoquest.models.misiones.Mision;
import org.devseniorcode.ecoquest.services.MisionServices;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MisionServiceImpl implements MisionServices{

    private final Map<String, Mision> misiones = new LinkedHashMap<>();

    public MisionServiceImpl(){
        cargarMisionesJson();
    }
    
    
    private void cargarMisionesJson(){
        String nombreArchivo = "misiones.json";
        try(InputStream is = getClass().getClassLoader().getResourceAsStream(nombreArchivo)){
            if(is == null) throw new IllegalArgumentException("No se encontro" + nombreArchivo + " en resources");
            
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<Mision> lista = objectMapper.readValue(is, new TypeReference<List<Mision>>(){});
            for (Mision mision : lista) misiones.put(mision.getId(),mision);
        } catch (Exception e){
            throw new RuntimeException("Error cargando " + nombreArchivo, e);
        }
    }
    
    @Override
    public void agregarMisiones(Mision mision){
        misiones.put(mision.getId(), mision);
    }

    @Override
    public List<Mision> listarMisiones(){

        return new ArrayList<>(misiones.values());

    }

    @Override
    public Mision buscarPorId(String id) throws MisionInexistenteExcepcion {
        Mision mision = misiones.get(id);
        if (mision == null) {
            throw new MisionInexistenteExcepcion(id);
        }
        return mision;
}



}
