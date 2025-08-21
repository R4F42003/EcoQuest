package org.devseniorcode.ecoquest.models;

import org.devseniorcode.ecoquest.enums.Ecosistema;

public class PuntoEco {

    private String id;
    private String nombre;
    private Ecosistema tipoEcosistema;

    public PuntoEco(String id, String nombre, Ecosistema tipEcosistema){
        this.id = id;
        this.nombre = nombre;
        this.tipoEcosistema = tipEcosistema;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ecosistema getTipoEcosistema() {
        return tipoEcosistema;
    }

    public void setTipoEcosistema(Ecosistema tipoEcosistema) {
        this.tipoEcosistema = tipoEcosistema;
    }

    @Override
    public String toString() {
        return "PuntoEco [id=" + id + ", nombre=" + nombre + ", tipoEcosistema=" + tipoEcosistema + "]";
    }

}
