package org.devseniorcode.ecoquest.exceptions;

public class VoluntarioIdExistenteExcepcion extends Exception {

    private final String idVoluntario;

    public VoluntarioIdExistenteExcepcion(String idVoluntario){

        super("Ya existe un voluntario con el ID: " + idVoluntario);
        this.idVoluntario = idVoluntario;

    }

    public String getIdVoluntario(){
        return  idVoluntario;
    }

}
