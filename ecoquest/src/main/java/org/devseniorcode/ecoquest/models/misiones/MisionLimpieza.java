package org.devseniorcode.ecoquest.models.misiones;

import java.time.LocalDate;
import java.util.List;

import org.devseniorcode.ecoquest.enums.TipoLimpieza;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MisionLimpieza extends Mision {

    private final TipoLimpieza tipoLimpieza;
    private double cantExtBasuraRecogida;
    private double cantBasuraRecogida;

    @JsonCreator
    public MisionLimpieza(
        @JsonProperty("id") String id,
        @JsonProperty("descripcion") String descripcion,
        @JsonProperty("idEstado") int idEstado,
        @JsonProperty("puntosEcos") List<String> puntosEcos,
        @JsonProperty("fecha") LocalDate fecha,
        @JsonProperty("idNivelDificultad") int idNivelDificultad,
        @JsonProperty("idTipoMision") int idTipoMision,     // discriminador (2)
        @JsonProperty("idLimpieza") int idLimpieza,         // enum via fromId
        @JsonProperty("cantExtBasuraRecogida") double cantExtBasuraRecogida,
        @JsonProperty("cantBasuraRecogida") double cantBasuraRecogida
    ) {
        super(id, descripcion, idEstado, puntosEcos, fecha, idNivelDificultad, idTipoMision);
        this.tipoLimpieza = TipoLimpieza.fromIdLimpieza(idLimpieza);
        this.cantExtBasuraRecogida = cantExtBasuraRecogida;
        this.cantBasuraRecogida = cantBasuraRecogida;
    }

    public TipoLimpieza getTipoLimpieza() {
        return tipoLimpieza;
    }

    public double getCantExtBasuraRecogida() {
        return cantExtBasuraRecogida;
    }

    public void setCantExtBasuraRecogida(double cantExtBasuraRecogida) {
        this.cantExtBasuraRecogida = cantExtBasuraRecogida;
    }

    public double getCantBasuraRecogida() {
        return cantBasuraRecogida;
    }

    public void setCantBasuraRecogida(double cantBasuraRecogida) {
        this.cantBasuraRecogida = cantBasuraRecogida;
    }

    @Override
    public String complemento() {
        return "tipoLimpieza=" + tipoLimpieza.getNombreLimpieza()
             + ", cantExtBasuraRecogida=" + cantExtBasuraRecogida
             + ", cantBasuraRecogida=" + cantBasuraRecogida;
    }
}
