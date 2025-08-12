package org.devseniorcode.ecoquest.models.misiones;

import java.time.LocalDate;
import java.util.List;

public class MisionLimpieza extends Mision{

    public MisionLimpieza(String id, String descripcion, int estado, List<String> puntosEcos, LocalDate fecha, int nivelDificultad) {
        super(id, descripcion, estado, puntosEcos, fecha, nivelDificultad);
    }

    @Override
    public String complemento() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

}
