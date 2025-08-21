package org.devseniorcode.ecoquest.services;

import java.util.List;

import org.devseniorcode.ecoquest.models.PuntoEco;

public interface PuntoEcologicoService{

    void agregarPuntosEcologicos(PuntoEco puntoEco);
    List<PuntoEco> listarPuntosEcologicos();
    PuntoEco buscarPorId(String id);
} 
