package org.devseniorcode.ecoquest.models;

import org.devseniorcode.ecoquest.enums.Ecosistema;

public class PuntoEco {

    private String id;
    private String nombre;
    private Ecosistema tipoEcosistema;
    private Ubicacion ubicacion;

    public PuntoEco(String id, String nombre, int idEcosistema, Ubicacion ubicacion){
        this.id = id;
        this.nombre = nombre;
        this.tipoEcosistema = Ecosistema.fromIdEcosistema(idEcosistema);
        this.ubicacion = ubicacion;
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
     public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "PuntoEco [id=" + id + ", nombre=" + nombre + ", tipoEcosistema=" + tipoEcosistema + ", ubicacion="
                + ubicacion + "]";
    }
    
}
