package org.devseniorcode.ecoquest.models;

import java.util.Set;

public class Voluntario {
    private final String id;
    private String nombre;
    private Set<String> habilidades;
    private  Set<String> misionesAsignadas;
    private  Set<String> misionesCompletadas;

    public Voluntario(String id, String nombre, Set<String> habilidades, Set<String> misionesAsignadas, Set<String> misionesCompletadas) {
        this.id = id;
        this.nombre = nombre;
        this.habilidades = habilidades;
        this.misionesAsignadas = misionesAsignadas;
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
    public Set<String> getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(Set<String> habilidades) {
        this.habilidades = habilidades;
    }
        public Set<String> getMisionesAsignadas() {
        return misionesAsignadas;
    }

    public void setMisionesAsignadas(Set<String> misionesAsignadas) {
        this.misionesAsignadas = misionesAsignadas;
    }

    public Set<String> getMisionesCompletadas() {
        return misionesCompletadas;
    }
    public void setMisionesCompletadas(Set<String> misionesCompletadas) {
        this.misionesCompletadas = misionesCompletadas;
    }

    @Override
    public String toString() {
        return "Voluntario [id=" + id + ", nombre=" + nombre + ", habilidades=" + habilidades + ", misionesAsignadas="
                + misionesAsignadas + ", misionesCompletadas=" + misionesCompletadas + "]";
    }


    

}
