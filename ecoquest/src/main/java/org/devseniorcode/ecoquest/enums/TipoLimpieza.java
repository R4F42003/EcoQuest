package org.devseniorcode.ecoquest.enums;

import java.util.Arrays;

public enum TipoLimpieza {
    TERRESTRE(1,"Terrestre","Retiro de basura y residuos en áreas urbanas, rurales o naturales."),
    COSTERA_Y_PLAYAS(2,"Costera y Playas"," Eliminación de plásticos, redes y restos orgánicos acumulados en la orilla"),
    FLUVIAL_Y_LACUSTRE(3,"Fluvial y lacustres","Recolección de desechos en ríos, lagos y embalses, flotantes o sumergidos."),
    MARINA(4,"Marina","Retiro de basura, redes y contaminantes en alta mar o zonas portuarias.");

    private final int idLimpieza;
    private final String nombreLimpieza;
    private final String descripcionLimpieza;

    private TipoLimpieza(int idLimpieza, String nombreLimpieza, String descripcionLimpieza) {
        this.idLimpieza = idLimpieza;
        this.nombreLimpieza = nombreLimpieza;
        this.descripcionLimpieza = descripcionLimpieza;
    }

    public int getIdLimpieza(){return idLimpieza;}
    public String getNombreLimpieza(){return nombreLimpieza;}
    public String getDescripcionLimpieza(){return descripcionLimpieza;}

    public static TipoLimpieza fromIdLimpieza(int idLimpieza){
        return Arrays.stream(values())
        .filter(e-> e.idLimpieza == idLimpieza)
        .findFirst()
        .orElseThrow(()-> new IllegalArgumentException("Id de limpieza no valido: " + idLimpieza));
    }
    
}
