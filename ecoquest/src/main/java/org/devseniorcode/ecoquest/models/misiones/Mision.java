package org.devseniorcode.ecoquest.models.misiones;

import java.time.LocalDate;
import java.util.List;

import org.devseniorcode.ecoquest.enums.Dificultad;
import org.devseniorcode.ecoquest.enums.Estado;

public abstract class Mision {

    private final String id;
    private String descripcion;
    private Estado estado;
    private List<String> puntosEcos;
    private LocalDate fecha;
    private Dificultad nivelDificultad;
    
    public Mision(String id, String descripcion, int idEstado, List<String> puntosEcos, LocalDate fecha,int idNivelDificultad) {
        this.id = id;
        this.estado = Estado.fromIdEstado(idEstado);
        this.descripcion = descripcion;
        this.puntosEcos = puntosEcos;
        this.fecha = fecha;
        this.nivelDificultad = Dificultad.fromIdDificultad(idNivelDificultad);
    }

    public String getId() {
        return id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
        public List<String> getPuntosEcos() {
        return puntosEcos;
    }

    public void setPuntosEcos(List<String> puntosEcos) {
        this.puntosEcos = puntosEcos;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Dificultad getNivelDificultad() {
        return nivelDificultad;
    }
    public void setNivelDificultad(Dificultad nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public abstract String complemento();


    @Override
    public String toString() {
        return "Mision [id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", puntosEcos=" + puntosEcos
                + ", fecha=" + fecha + ", nivelDificultad=" + nivelDificultad + complemento()+"]";
    }


  
}
