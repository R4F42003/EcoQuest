package org.devseniorcode.ecoquest.enums;

public enum Dificultad {

    FACIL(1), 
    INTERMEDIO(2), 
    DIFICIL(3);

    private final int idDificultad;

    Dificultad(int idDificultad){
        this.idDificultad = idDificultad;
    }

    public int getIdDificultad(){return idDificultad;}

    public static Dificultad fromIdDificultad(int idDificultad){
        for (var l : values()) if (l.idDificultad == idDificultad) return l;
        throw new IllegalArgumentException("Codigo de dificultad no valido" + idDificultad);
    }

}
