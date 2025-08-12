package org.devseniorcode.ecoquest.models;

import org.devseniorcode.ecoquest.enums.Ecosistema;

public class PuntoEco {

    private String ID;
    private String nombre;
    private Ecosistema tipoEcosistema;

    public PuntoEco(String ID, String nombre, Ecosistema tipEcosistema){
        this.ID = ID;
        this.nombre = nombre;
        this.tipoEcosistema = tipEcosistema;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
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
        return "PuntoEco [ID=" + ID + ", nombre=" + nombre + ", tipoEcosistema=" + tipoEcosistema + "]";
    }

}
