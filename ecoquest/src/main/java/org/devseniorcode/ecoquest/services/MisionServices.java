package org.devseniorcode.ecoquest.services;

import java.util.List;

import org.devseniorcode.ecoquest.models.misiones.Mision;

public interface MisionServices{

    void agregarMisiones(Mision mision);
    List<Mision> listarMisiones();
    Mision buscarPorId(String id);
} 

