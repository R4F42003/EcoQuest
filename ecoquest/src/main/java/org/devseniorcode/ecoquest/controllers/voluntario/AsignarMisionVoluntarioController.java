package org.devseniorcode.ecoquest.controllers.voluntario;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.devseniorcode.ecoquest.enums.Estado;
import org.devseniorcode.ecoquest.models.Voluntario;
import org.devseniorcode.ecoquest.services.MisionServices;
import org.devseniorcode.ecoquest.services.VoluntarioService;


public class AsignarMisionVoluntarioController {

    private final Scanner scan;
    private final MisionServices misionServices;
    private final VoluntarioService voluntarioService;

    public  AsignarMisionVoluntarioController(Scanner scan, MisionServices misionServices, VoluntarioService voluntarioService){
        this.scan = scan;
        this.misionServices = misionServices;
        this.voluntarioService = voluntarioService;
    }
    public void mostrarAsignarMisionVoluntarioController(){

        System.out.println("\n== Asignacion de misiones ==");
        System.out.println("Voluntarios disponibles: ");
        voluntarioService
            .listarVoluntario()
            .forEach(p -> System.out.println("Id: " + p.getId() + " , nombre: " + p.getNombre()));

        System.out.print("Seleccione el id del voluntario: ");
        String idVoluntario = scan.nextLine();

        System.out.println("Misiones disponibles: ");

        misionServices
            .listarMisiones()
            .stream()
            .filter(p -> p.getEstado() == Estado.PROGRAMADA)
            .forEach(p -> System.out.println("Id: " + p.getId() + ", descripcion: " + p.getDescripcion()));

        System.out.println("Seleccione las misiones que desea asignar (separadas por coma): ");
        String misionesInput = scan.nextLine();
        Set<String> misiones = new HashSet<>();
        for(String s : misionesInput.split("\\s*,\\s*")){
            if(!s.isBlank()){
                misiones.add(s);
            }
        }
        Voluntario voluntarioId = voluntarioService.buscarPorId(idVoluntario);
        if(voluntarioId != null){
            voluntarioId.setMisionesAsignadas(misiones);
        }
        System.out.println(voluntarioId);
    }

}
