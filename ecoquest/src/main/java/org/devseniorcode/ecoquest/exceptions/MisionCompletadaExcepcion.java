package org.devseniorcode.ecoquest.exceptions;

import org.devseniorcode.ecoquest.enums.Estado;

public class MisionCompletadaExcepcion extends Exception{
    
    private final Estado estado;
    private final String idMision;

    public MisionCompletadaExcepcion(String idMision, Estado estado) {
        super("La misión con id '" + idMision + "' ya fue completada. Estado actual: " + estado);
        this.idMision = idMision;
        this.estado = estado;
    }

    public Estado getEstado(){
        return estado;
    }

    public String getIdMision() {
        return idMision;
    }

}
