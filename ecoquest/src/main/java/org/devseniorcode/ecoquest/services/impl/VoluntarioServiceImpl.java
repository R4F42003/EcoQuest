package org.devseniorcode.ecoquest.services.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.devseniorcode.ecoquest.exceptions.VoluntarioIdExistenteExcepcion;
import org.devseniorcode.ecoquest.models.Voluntario;
import org.devseniorcode.ecoquest.services.VoluntarioService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VoluntarioServiceImpl implements  VoluntarioService{

    private final Map<String, Voluntario> voluntarios = new LinkedHashMap<>();    

    public VoluntarioServiceImpl(){
        cargarVoluntariosJson();
    }

    private void cargarVoluntariosJson(){
        String nombreArchivo = "voluntarios.json";
        try(InputStream is = getClass().getClassLoader().getResourceAsStream(nombreArchivo)){
            if(is == null) throw new IllegalArgumentException("No se encontro " + nombreArchivo + " en resources");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Voluntario> lista = objectMapper.readValue(is, new TypeReference<List<Voluntario>>(){});
            for (Voluntario voluntario : lista) voluntarios.put(voluntario.getId(),voluntario);
        } catch (Exception e){
            throw new RuntimeException("Error cargando "+ nombreArchivo, e);
        }
    }

    @Override
        public void agregarVoluntarios(Voluntario voluntario) throws VoluntarioIdExistenteExcepcion {
        if (voluntario == null || voluntario.getId() == null || voluntario.getId().isBlank()) {
            throw new IllegalArgumentException("El voluntario y su ID no pueden ser nulos ni vacíos");
        }

        if (voluntarios.containsKey(voluntario.getId())) {
            
            throw new VoluntarioIdExistenteExcepcion(voluntario.getId());
        }

        voluntarios.put(voluntario.getId(), voluntario);
    }

    @Override
    public List<Voluntario> listarVoluntario(){

        return new ArrayList<>(voluntarios.values());

    }

    @Override
    public Voluntario buscarPorId(String id){
        return voluntarios.get(id);
    }
}
