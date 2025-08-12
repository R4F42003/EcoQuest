package org.devseniorcode.ecoquest.models;

public class Ubicacion {    

    private int latitud;
    private int longitud;

    public Ubicacion(int latitud, int longitud){
        this.longitud = longitud;
        this.latitud = latitud;

    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Ubicacion [latitud=" + latitud + ", longitud=" + longitud + "]";
    }    


}
