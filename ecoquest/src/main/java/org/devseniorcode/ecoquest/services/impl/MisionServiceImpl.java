package org.devseniorcode.ecoquest.services.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.devseniorcode.ecoquest.models.misiones.Mision;
import org.devseniorcode.ecoquest.services.MisionServices;

public class MisionServiceImpl implements MisionServices{

    private final Map<String, Mision> misiones = new LinkedHashMap<>();    

    @Override
    public void agregarMisiones(Mision mision){

        misiones.put(mision.getId(), mision);
    }

    @Override
    public List<Mision> listarMisiones(){

        return new ArrayList<>(misiones.values());

    }

    @Override
    public Mision buscarPorId(String id){
        
        return misiones.get(id);
    }


}
