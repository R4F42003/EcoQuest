package org.devseniorcode.ecoquest.models.misiones;

import java.time.LocalDate;
import java.util.List;

import org.devseniorcode.ecoquest.enums.TipoLimpieza;

public class MisionLimpieza extends Mision{

    private final TipoLimpieza tipoLimpieza;
    public double  cantidadBasura;

    public MisionLimpieza(String id, String descripcion, int idEstado, List<String> puntosEcos, LocalDate fecha, int idNivelDificultad, int idLimpieza, double cantidadBasura) {
        super(id, descripcion, idEstado, puntosEcos, fecha, idNivelDificultad);
        this.tipoLimpieza = TipoLimpieza.fromIdLimpieza(idLimpieza);
        this.cantidadBasura = cantidadBasura;
    }

    public TipoLimpieza getTipoLimpieza(){
        return tipoLimpieza;
    }

    public double getCantidadBasura(){
        return cantidadBasura;
    }

    public void  setCantidadBasura(double cantidadBasura){
        this.cantidadBasura = cantidadBasura;
    }

    @Override
    public String complemento(){
        return "tipo limpieza="+ tipoLimpieza.getNombreLimpieza()
        + ", descripcion=" + tipoLimpieza.getDescripcionLimpieza()
        + ", cantidadBasura=" + cantidadBasura;
    }
}
