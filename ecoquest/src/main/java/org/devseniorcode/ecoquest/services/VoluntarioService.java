package org.devseniorcode.ecoquest.services;

import java.util.List;

import org.devseniorcode.ecoquest.models.Voluntario;


public interface VoluntarioService{

    void agregarVoluntarios(Voluntario voluntario);
    List<Voluntario> listarVoluntario();
    Voluntario buscarPorId(String id);
} 
