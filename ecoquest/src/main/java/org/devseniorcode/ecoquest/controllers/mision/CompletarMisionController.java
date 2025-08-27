package org.devseniorcode.ecoquest.controllers.mision;

import java.util.Scanner;

import org.devseniorcode.ecoquest.enums.Estado;
import org.devseniorcode.ecoquest.exceptions.MisionInexistenteExcepcion;
import org.devseniorcode.ecoquest.models.misiones.Mision;
import org.devseniorcode.ecoquest.services.MisionServices;

public class CompletarMisionController {

    private final Scanner scan;
    private final MisionServices misionServices;

    public CompletarMisionController(Scanner scan, MisionServices misionServices){
        this.misionServices = misionServices;
        this.scan = scan;
    }
    public void mostrarCompletarMisionController(){

        System.out.println("\n== Completar Mision ==");

        System.out.println("Misiones disponibles: ");
        misionServices
            .listarMisiones()
            .stream()
            .filter(p -> p.getEstado() == Estado.PROGRAMADA)
            .forEach(p -> System.out.println("Id: " + p.getId() + ", descripcion: " + p.getDescripcion()));

        System.out.print("Escriba el id de la mision a completar: ");
        
        String misionId = scan.nextLine();

        try {
            Mision misionCompletada = misionServices.buscarPorId(misionId);

            if (misionCompletada.getEstado() == Estado.COMPLETADO) {
                System.out.println("La misión ya fue completada previamente.");
            } else {
                misionCompletada.setEstado(Estado.COMPLETADO);
                System.out.println("¡Misión completada con éxito!");
            }
        }catch (MisionInexistenteExcepcion e) {
            System.out.println("Error: " + e.getMessage());
            }

        System.out.println("Mision Completada con exito");
    }
}
