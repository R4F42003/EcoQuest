package org.devseniorcode.ecoquest.enums;

import java.util.Arrays;

public enum TipoMision {

    EDUCACION(1,"\n== Misión de Educacion =="),
    LIMPIEZA(2,"\n== Misión de Limpieza =="),
    PLANTACION(3,"\n== Misión de Plantacion ==");

    private final int idTipoMision;
    private final String tituloMision;

    private TipoMision(int idTipoMision, String tituloMision){

        this.idTipoMision = idTipoMision;
        this.tituloMision = tituloMision;
    }

    public int getIdTipoMision(){
        return idTipoMision;
    }

    public String getTituloMision(){
        return tituloMision;
    }

    public static TipoMision fromIdTipoMision(int idTipoMision){
        return Arrays.stream(values())
        .filter(e-> e.idTipoMision == idTipoMision)
        .findFirst()
        .orElseThrow(()-> new IllegalArgumentException("Id de tipo de mision no valido: "+ idTipoMision));
    }
}
