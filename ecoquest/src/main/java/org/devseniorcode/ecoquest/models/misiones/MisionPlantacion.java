package org.devseniorcode.ecoquest.models.misiones;

import java.time.LocalDate;
import java.util.List;

import org.devseniorcode.ecoquest.enums.ZonaPlantacion;

public class MisionPlantacion extends Mision{

    private final ZonaPlantacion zonaPlantacion;
    private int extCantPlantada;
    private int cantidadPlantada;

    public MisionPlantacion(String id, String descripcion, int idEstado, List<String> puntosEcos, LocalDate fecha, int idNivelDificultad, int idTipoMision, int idZonaPlantacion,int extCantPlantada,int cantidadPlantada) {
        super(id, descripcion, idEstado, puntosEcos, fecha, idNivelDificultad, idTipoMision);
        this.zonaPlantacion = ZonaPlantacion.fromIdZonaPlantacion(idZonaPlantacion);
        this.extCantPlantada = extCantPlantada;
        this.cantidadPlantada = cantidadPlantada;
    }

    public ZonaPlantacion zonaPlantacion1(){
        return zonaPlantacion;
    }

    public int getExtCantPlantada(){
        return extCantPlantada;
    }
    public void setExtCantPlantada(int extCantPlantada){
        this.extCantPlantada = extCantPlantada;
    }

    public int getCantidadPlantada(){
        return cantidadPlantada;
    }
    public void setCantidadPlantada(int cantidadPlantada){
        this.cantidadPlantada = cantidadPlantada;
    }


    @Override
    public String complemento(){
        return "nombre_zona_plantacion= " + zonaPlantacion.getNombreZonaPlantacion()
        +", extCantPlantada=" + extCantPlantada+", CantidadPlantada=" + cantidadPlantada;
    }
   
}
