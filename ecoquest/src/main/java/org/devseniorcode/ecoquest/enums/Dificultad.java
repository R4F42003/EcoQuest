package org.devseniorcode.ecoquest.enums;

import java.util.Arrays;

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
        return Arrays.stream(values())
        .filter(e-> e.idDificultad == idDificultad)
        .findFirst()
        .orElseThrow(()-> new IllegalArgumentException("Id de dificultad no valido: "+ idDificultad));
    }

}
