package org.devseniorcode.ecoquest.controllers.puntoEcologico;

import java.util.Arrays;
import java.util.Scanner;

import org.devseniorcode.ecoquest.enums.Ecosistema;
import org.devseniorcode.ecoquest.models.PuntoEco;
import org.devseniorcode.ecoquest.models.Ubicacion;
import org.devseniorcode.ecoquest.services.PuntoEcologicoService;

public class AgregarPuntoEcologicoController{

    private final Scanner scan;
    private final PuntoEcologicoService puntoEcologicoService;

    public AgregarPuntoEcologicoController(Scanner scan, PuntoEcologicoService puntoEcologicoService){
        this.scan = scan;
        this. puntoEcologicoService = puntoEcologicoService;
    }

    public void mostrarAgregarPuntoEcologicoController(){

        System.out.println("\n== Registrar Punto Ecologico ==");
        System.out.print("Digite el id: ");
        String id = scan.nextLine();
        System.out.print("Digite el nombre: ");
        String nombre = scan.nextLine();
        System.out.println("Digite el ecosistema: ");
          Arrays.stream(Ecosistema.values())
            .forEach(Ecosistema -> System.out.println(
            Ecosistema.getIdEcosistema()  + ". " + Ecosistema.getNombreEcosistema()
            + "(" + Ecosistema.getConformado() +")"
        ));
        System.out.print("Seleccione el numero del ecosistema deseado: ");
        int idEcosistema = Integer.parseInt(scan.nextLine());
        System.out.println("Digite la ubicacion: ");
        System.out.print("Latitud: ");
        double Latitud = Double.parseDouble(scan.nextLine());
        System.out.print("Longitud: ");
        double Longitud = Double.parseDouble(scan.nextLine());

        Ubicacion ubicacion = new Ubicacion(Latitud, Longitud);
        PuntoEco nuevoPuntoEco = new PuntoEco(id, nombre, idEcosistema, ubicacion);

        puntoEcologicoService.agregarPuntosEcologicos(nuevoPuntoEco);
        System.out.print("Punto Ecologico registrado correctamente");
        
    }

}
