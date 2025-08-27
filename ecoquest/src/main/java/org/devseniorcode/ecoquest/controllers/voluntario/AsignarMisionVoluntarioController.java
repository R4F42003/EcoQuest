package org.devseniorcode.ecoquest.controllers.voluntario;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.devseniorcode.ecoquest.enums.Estado;
import org.devseniorcode.ecoquest.exceptions.MisionCompletadaExcepcion;
import org.devseniorcode.ecoquest.exceptions.MisionInexistenteExcepcion;
import org.devseniorcode.ecoquest.models.Voluntario;
import org.devseniorcode.ecoquest.models.misiones.Mision;
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

    public void mostrarAsignarMisionVoluntarioController() {
        System.out.println("\n== Asignación de misiones ==");

        voluntarioService.listarVoluntario()
            .forEach(v -> System.out.println("Id: " + v.getId() + " , nombre: " + v.getNombre()));

        System.out.print("Seleccione el id del voluntario: ");
        String idVoluntario = scan.nextLine().trim();

        Voluntario voluntario = voluntarioService.buscarPorId(idVoluntario);
        if (voluntario == null) {
            System.out.println("Voluntario no encontrado.");
            return;
        }

        System.out.println("\nMisiones disponibles (PROGRAMADAS):");
        misionServices.listarMisiones().stream()
            .filter(m -> m.getEstado() == Estado.PROGRAMADA)
            .forEach(m -> System.out.println("Id: " + m.getId() + ", descripcion: " + m.getDescripcion()));

        System.out.println("\nSeleccione las misiones que desea asignar (separadas por coma): ");
        String misionesInput = scan.nextLine();

        Set<String> idsSolicitados = Arrays.stream(misionesInput.split("\\s*,\\s*"))
            .map(String::trim)
            .filter(s -> !s.isBlank())
            .collect(Collectors.toCollection(LinkedHashSet::new));

        if (idsSolicitados.isEmpty()) {
            System.out.println("No se ingresaron misiones.");
            return;
        }

        if (voluntario.getMisionesAsignadas() == null) {
            voluntario.setMisionesAsignadas(new LinkedHashSet<>());
        }
        Set<String> actuales = voluntario.getMisionesAsignadas();

        Set<String> asignables = new LinkedHashSet<>();

        for (String idMision : idsSolicitados) {
            try {
                Mision m = misionServices.buscarPorId(idMision);

                if (m.getEstado() == Estado.COMPLETADO) {
                    throw new MisionCompletadaExcepcion(m.getId(), m.getEstado());
                }
                if (m.getId() == null) {
                    throw new MisionInexistenteExcepcion(idMision);
                }
                asignables.add(idMision);

            } catch (MisionInexistenteExcepcion | MisionCompletadaExcepcion e) {
                System.out.println(e.getMessage());
                
            }
        }

        actuales.addAll(asignables);
        System.out.println("Mision asignada");

    }



}
