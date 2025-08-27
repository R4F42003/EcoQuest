package org.devseniorcode.ecoquest.services;

import java.util.List;

import org.devseniorcode.ecoquest.exceptions.VoluntarioIdExistenteExcepcion;
import org.devseniorcode.ecoquest.models.Voluntario;


public interface VoluntarioService{

    void agregarVoluntarios(Voluntario voluntario) throws VoluntarioIdExistenteExcepcion;
    List<Voluntario> listarVoluntario();
    Voluntario buscarPorId(String id);

} 
