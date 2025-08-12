package org.devseniorcode.ecoquest.enums;

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
        for (var l : values()) if (l.idEcosistema == idEcosistema) return l;
        throw new IllegalArgumentException("Código de ecosistema no válido: " + idEcosistema);
    }
}

