package org.devseniorcode.ecoquest.enums;

import java.util.Arrays;

public enum Ecosistema {

    TERRESTRE (1,""),
    ACUATICO (2,""),
    URBANO (3,""),
    RURAL (4,""),
    MIXTO (5,"");

    
    private final int idEcosistema;
    private final String nombreEcosistema;

    Ecosistema(int idEcosistema, String nombreEcosistema){
        this.idEcosistema = idEcosistema;
        this.nombreEcosistema = nombreEcosistema;
    }
    public int getIdEcosistema(){return idEcosistema;}
    public String getNombreEcosistema(){return nombreEcosistema;}

    public static Ecosistema fromIdEcosistema(int idEcosistema){
        return Arrays.stream(values())
        .filter(e-> e.idEcosistema == idEcosistema)
        .findFirst()
        .orElseThrow(()-> new IllegalArgumentException("Id de ecosistema no valido: " + idEcosistema));
    }
}

