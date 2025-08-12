package org.devseniorcode.ecoquest.models;

import java.util.List;
import java.util.Set;

public class Voluntario {
    private int ID;
    private String nombre;
    private List<String> habilidades;
    private  Set<String> misionesCompletadas;

    public Voluntario(int ID, List<String> habilidades, Set<String> misionesCompletadas, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
        this.habilidades = habilidades;
        this.misionesCompletadas = misionesCompletadas;
    }

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
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
        return "Voluntario [ID=" + ID + ", nombre=" + nombre + ", habilidades=" + habilidades + ", misionesCompletadas="
                + misionesCompletadas + "]";
    }

    

}
