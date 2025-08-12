package org.devseniorcode.ecoquest.enums;

import java.util.Arrays;

public enum Estado {
    COMPLETADO(1),
    EN_PROCESO(2),
    INCONCLUSA(3),
    PROGRAMADA(4);

    public final int idEstado;

    Estado(int idEstado){
        this.idEstado = idEstado;
    }

    public int getIdEstado(){return idEstado;}

    public static Estado fromIdEstado(int idEstado){
        return Arrays.stream(values())
        .filter(e -> e.idEstado == idEstado)
        .findFirst()
        .orElseThrow(()-> new IllegalArgumentException("Id de estado no valido: " + idEstado));
    }
}
