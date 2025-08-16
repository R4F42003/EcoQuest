package org.devseniorcode.ecoquest.enums;

import java.util.Arrays;

public enum Ecosistema {

    TERRESTRE(1, "Terrestre", "Bosques, selvas, desiertos, praderas, montañas, tundras"),
    ACUATICO(2, "Acuático", "Agua dulce: ríos, lagos, humedales; Marino-costero: mares, estuarios, manglares, arrecifes"),
    URBANO(3, "Urbano", "Parques, jardines, corredores verdes, humedales urbanos, techos y muros verdes"),
    RURAL(4, "Rural", "Agroecosistemas: cultivos, pastizales, bosques secundarios, sistemas silvopastoriles"),
    MIXTO(5, "Mixto", "Mosaicos periurbanos que combinan zonas urbanas, rurales y cuerpos de agua");

    
    private final int idEcosistema;
    private final String nombreEcosistema;
    private final String conformado;

    Ecosistema(int idEcosistema, String nombreEcosistema, String conformado){
        this.idEcosistema = idEcosistema;
        this.nombreEcosistema = nombreEcosistema;
        this.conformado = conformado;
    }
    public int getIdEcosistema(){
        return idEcosistema;
    }
    public String getNombreEcosistema(){
        return nombreEcosistema;
    }
    public String getConformado(){
        return conformado;
    }

    public static Ecosistema fromIdEcosistema(int idEcosistema){
        return Arrays.stream(values())
        .filter(e-> e.idEcosistema == idEcosistema)
        .findFirst()
        .orElseThrow(()-> new IllegalArgumentException("Id de ecosistema no valido: " + idEcosistema));
    }
}

