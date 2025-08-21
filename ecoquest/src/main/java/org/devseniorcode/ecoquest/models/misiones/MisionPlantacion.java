package org.devseniorcode.ecoquest.models.misiones;

import java.time.LocalDate;
import java.util.List;

import org.devseniorcode.ecoquest.enums.ZonaPlantacion;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MisionPlantacion extends Mision {

    private final ZonaPlantacion zonaPlantacion;
    private int extCantPlantada;
    private int cantidadPlantada;

    @JsonCreator
    public MisionPlantacion(
        @JsonProperty("id") String id,
        @JsonProperty("descripcion") String descripcion,
        @JsonProperty("idEstado") int idEstado,
        @JsonProperty("puntosEcos") List<String> puntosEcos,
        @JsonProperty("fecha") LocalDate fecha,
        @JsonProperty("idNivelDificultad") int idNivelDificultad,
        @JsonProperty("idTipoMision") int idTipoMision,        // discriminador
        @JsonProperty("idZonaPlantacion") int idZonaPlantacion, // enum
        @JsonProperty("extCantPlantada") int extCantPlantada,
        @JsonProperty("cantidadPlantada") int cantidadPlantada
    ) {
        super(id, descripcion, idEstado, puntosEcos, fecha, idNivelDificultad, idTipoMision);
        this.zonaPlantacion = ZonaPlantacion.fromIdZonaPlantacion(idZonaPlantacion);
        this.extCantPlantada = extCantPlantada;
        this.cantidadPlantada = cantidadPlantada;
    }

    public ZonaPlantacion getZonaPlantacion() {
        return zonaPlantacion;
    }

    public int getExtCantPlantada() {
        return extCantPlantada;
    }

    public void setExtCantPlantada(int extCantPlantada) {
        this.extCantPlantada = extCantPlantada;
    }

    public int getCantidadPlantada() {
        return cantidadPlantada;
    }

    public void setCantidadPlantada(int cantidadPlantada) {
        this.cantidadPlantada = cantidadPlantada;
    }

    @Override
    public String complemento() {
        return "zonaPlantacion=" + zonaPlantacion.getNombreZonaPlantacion()
             + ", extCantPlantada=" + extCantPlantada
             + ", cantidadPlantada=" + cantidadPlantada;
    }
}
