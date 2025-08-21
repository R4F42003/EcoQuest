package org.devseniorcode.ecoquest.controllers.mision;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.devseniorcode.ecoquest.enums.TipoLimpieza;
import org.devseniorcode.ecoquest.models.misiones.MisionLimpieza;
import org.devseniorcode.ecoquest.services.MisionServices;

public class AgregarMisionLimpiezaController {
        
    private final Scanner scan;
    private final MisionServices misionService;
    private final int idTipoMision;
    private final String id;
    private final String descripcion;
    private final int idEstado;
    private final List<String> puntosEcos;
    private final LocalDate fecha;
    private final int idNivelDificultad;

    public AgregarMisionLimpiezaController(Scanner scan, MisionServices misionService, String id, String descripcion,int idEstado,List<String>puntosEcos, LocalDate fecha, int idNivelDificultad, int idTipoMision ) {
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

    public void mostrarAgregarMisionLimpiezaController() {

        System.out.println("Seleccione el tipo de limpieza:");
        Arrays.stream(TipoLimpieza.values())
            .forEach(limpieza -> System.out.println(
            limpieza.getIdLimpieza()  + ". " + limpieza.getNombreLimpieza() + " (" + limpieza.getDescripcionLimpieza() + ")"
        ));

        System.out.print("Seleccione el numero del tipo de limpieza: ");
        int idLimpieza = Integer.parseInt(scan.nextLine());

        System.out.print("Digite la cantidad de basura estimaada en kilogramos(Kg): ");
        double cantExtBasuraRecogida = Double.parseDouble(scan.nextLine());

        double cantBasuraRecogida = 0;

        MisionLimpieza nuevaMision = new MisionLimpieza(id, descripcion, idEstado, puntosEcos, fecha, idNivelDificultad, idTipoMision, idLimpieza, cantExtBasuraRecogida, cantBasuraRecogida);

        misionService.agregarMisiones(nuevaMision);

        System.out.println("Misión registrada con éxito");

        System.out.println(misionService.listarMisiones());

        
    }

}
