package org.devseniorcode.ecoquest.controllers.mision;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.devseniorcode.ecoquest.enums.Dificultad;
import org.devseniorcode.ecoquest.enums.Estado;
import org.devseniorcode.ecoquest.services.MisionServices;
import org.devseniorcode.ecoquest.utils.FechaUtils;

public class AgregarMisionController {

    
    private final Scanner scan;
    private final MisionServices misionService;

    public AgregarMisionController(Scanner scan, MisionServices misionService) {
        this.scan = scan;
        this.misionService = misionService;
    }

    public void mostrarAgregarMisionController(){

        System.out.println("\n== Registrar Mision ==");

        System.out.print("ID de la misión: ");
        String id = scan.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scan.nextLine();

        int idEstado = Estado.PROGRAMADA.getIdEstado();

        System.out.print("PuntosEco (separados por comas): ");
        String puntosEcoInput = scan.nextLine();

        List<String> puntosEcos = new ArrayList<>();
        for (String s : puntosEcoInput.split("\\s*,\\s*")) {
            if (!s.isBlank()) {
                puntosEcos.add(s);
            }
}

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

        new SelectorMisionController(scan, misionService,id, descripcion,idEstado,puntosEcos,fecha, idNivelDificultad).mostrarSelectorMisiones();
        



    }

}
