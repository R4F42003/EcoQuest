package org.devseniorcode.ecoquest.models;

import java.util.List;
import java.util.Set;

public class Voluntario {
    private final String id;
    private String nombre;
    private List<String> habilidades;
    private  Set<String> misionesCompletadas;

    public Voluntario(String id, List<String> habilidades, Set<String> misionesCompletadas, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.habilidades = habilidades;
        this.misionesCompletadas = misionesCompletadas;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<String> getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
    public Set<String> getMisionesCompletadas() {
        return misionesCompletadas;
    }
    public void setMisionesCompletadas(Set<String> misionesCompletadas) {
        this.misionesCompletadas = misionesCompletadas;
    }

    @Override
    public String toString() {
        return "Voluntario [Id=" + id + ", nombre=" + nombre + ", habilidades=" + habilidades + ", misionesCompletadas="
                + misionesCompletadas + "]";
    }

    

}
