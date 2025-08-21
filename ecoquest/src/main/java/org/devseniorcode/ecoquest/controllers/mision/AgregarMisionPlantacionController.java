package org.devseniorcode.ecoquest.controllers.mision;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.devseniorcode.ecoquest.enums.ZonaPlantacion;
import org.devseniorcode.ecoquest.models.misiones.MisionPlantacion;
import org.devseniorcode.ecoquest.services.MisionServices;

public class AgregarMisionPlantacionController {
    private final Scanner scan;
    private final MisionServices misionService;
    private final int idTipoMision;
    private final String id;
    private final String descripcion;
    private final int idEstado;
    private final List<String> puntosEcos;
    private final LocalDate fecha;
    private final int idNivelDificultad;

    public AgregarMisionPlantacionController(Scanner scan, MisionServices misionService, String id, String descripcion,int idEstado,List<String>puntosEcos, LocalDate fecha, int idNivelDificultad, int idTipoMision ) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.id = id;
        this.idNivelDificultad = idNivelDificultad;
        this.idTipoMision = idTipoMision;
        this.misionService = misionService;
        this.puntosEcos = puntosEcos;
        this.scan = scan;
        this.idEstado = idEstado;
    }

    public void mostrarAgregarMisionPlantacionController(){
        
        System.out.println("Seleccione la zona de la plantacion:");
        Arrays.stream(ZonaPlantacion.values())
            .forEach(ZonaPlantacion -> System.out.println(
            ZonaPlantacion.getIdZonaPlantacion()  + ". " + ZonaPlantacion.getNombreZonaPlantacion()
            + "(" + ZonaPlantacion.getDescripcion() +")"
        ));

        System.out.print("Seleccione el numero de la zona deseada ");
        int idZonaPlantacion = Integer.parseInt(scan.nextLine());

        System.out.print("Digite la cantidad de plantas estimadas a plantar: ");
        int extCantPlantada = Integer.parseInt(scan.nextLine());

        int cantidadPlantada = 0;

        MisionPlantacion nuevaMision = new MisionPlantacion(id, descripcion, idEstado, puntosEcos, fecha, idNivelDificultad, idTipoMision, idZonaPlantacion, extCantPlantada, cantidadPlantada);

        misionService.agregarMisiones(nuevaMision);

        System.out.println("Misión registrada con éxito");

        System.out.println(misionService.listarMisiones());        
    }

}
