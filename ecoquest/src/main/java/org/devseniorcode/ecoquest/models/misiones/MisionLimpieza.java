package org.devseniorcode.ecoquest.models.misiones;

import java.time.LocalDate;
import java.util.List;

import org.devseniorcode.ecoquest.enums.Dificultad;
import org.devseniorcode.ecoquest.enums.Estado;

public class MisionLimpieza extends Mision{

    public MisionLimpieza(String id, String descripcion, Estado estado, List<String> puntosEcos, LocalDate fecha, Dificultad nivelDificultad) {
        super(id, descripcion, estado, puntosEcos, fecha, nivelDificultad);
    }

    @Override
    public String complemento() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

}
