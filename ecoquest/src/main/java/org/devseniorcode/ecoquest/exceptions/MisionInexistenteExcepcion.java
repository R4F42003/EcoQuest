package org.devseniorcode.ecoquest.exceptions;

public class MisionInexistenteExcepcion extends Exception{

    private final String idMision;

    public MisionInexistenteExcepcion(String idMision){
        
        super("Mision inexistente: " + idMision);
        this.idMision = idMision;
    }

    public String getIdMision(){
        
        return idMision;
    }

}
