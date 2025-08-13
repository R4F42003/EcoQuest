package org.devseniorcode.ecoquest.controllers.mision;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.devseniorcode.ecoquest.enums.Dificultad;
import org.devseniorcode.ecoquest.enums.Estado;
import org.devseniorcode.ecoquest.enums.TipoLimpieza;
import org.devseniorcode.ecoquest.models.misiones.MisionLimpieza;
import org.devseniorcode.ecoquest.services.MisionServices;
import org.devseniorcode.ecoquest.utils.FechaUtils;

public class MisionLimpiezaController {
        
    private final Scanner scan;
    private final MisionServices misionService;

    public MisionLimpiezaController(Scanner scan, MisionServices misionService){
        this.scan = scan;
        this.misionService = misionService;

    }

    public void mostrarMisisionLimpiezaController() {
        System.out.println("\n== Registro de Misión de Limpieza ==");

        System.out.print("ID de la misión: ");
        String id = scan.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scan.nextLine();

        int idEstado = Estado.PROGRAMADA.getIdEstado();

        System.out.print("PuntosEco (separados por comas): ");
        String puntosEcoInput = scan.nextLine();
        List<String> puntosEcos = List.of(puntosEcoInput.split(","));


        FechaUtils fechaUtils = new FechaUtils(scan);
        System.out.println("Digite la fecha de la misión:");
        LocalDate fecha = fechaUtils.leerFechaCompleta();

        System.out.println("Seleccione la dificultad: ");
        Arrays.stream(Dificultad.values())
            .forEach(dificultad -> System.out.println(
                dificultad.getIdDificultad() +". " + dificultad.name() 
            ));
        

        System.out.print("Seleccione el numero de la dificultad: ");
        int idNivelDificultad = Integer.parseInt(scan.nextLine());
        

        System.out.println("Seleccione el tipo de limpieza:");
        Arrays.stream(TipoLimpieza.values())
            .forEach(limpieza -> System.out.println(
            limpieza.getIdLimpieza()  + ". " + limpieza.getNombreLimpieza() + " (" + limpieza.getDescripcionLimpieza() + ")"
        ));

        System.out.print("Seleccione el numero del tipo de limpieza: ");
        int idLimpieza = Integer.parseInt(scan.nextLine());

        System.out.print("Digite la cantidad de basura estimaada en kilogramos(Kg): ");
        double cantidadBasura = Double.parseDouble(scan.nextLine());

        MisionLimpieza m = new MisionLimpieza(id, descripcion, idEstado, puntosEcos, fecha, idNivelDificultad, idLimpieza, cantidadBasura);

        misionService.agregarMisiones(m);

        System.out.println("Misión registrada con éxito");

        System.out.println(misionService.listarMisiones());

        
    }

}
