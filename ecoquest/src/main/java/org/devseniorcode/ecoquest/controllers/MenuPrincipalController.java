package org.devseniorcode.ecoquest.controllers;

import java.util.Scanner;

import org.devseniorcode.ecoquest.controllers.mision.AgregarMisionController;
import org.devseniorcode.ecoquest.controllers.puntoEcologico.AgregarPuntoEcologicoController;
import org.devseniorcode.ecoquest.controllers.voluntario.AgregarVoluntarioController;
import org.devseniorcode.ecoquest.services.MisionServices;
import org.devseniorcode.ecoquest.services.PuntoEcologicoService;
import org.devseniorcode.ecoquest.services.VoluntarioService;


public class MenuPrincipalController {

    private final Scanner scan;
    private final MisionServices misionService;
    private final VoluntarioService voluntarioService;
    private final PuntoEcologicoService puntoEcologicoService;

    public MenuPrincipalController(Scanner scan, MisionServices misionService, VoluntarioService voluntarioService, PuntoEcologicoService puntoEcologicoService){

        this.scan = scan;
        this.misionService = misionService;
        this.voluntarioService = voluntarioService; 
        this.puntoEcologicoService = puntoEcologicoService;        

    }

    private int leerEntero() {
        while (!scan.hasNextInt()) { System.out.print("Número válido: "); scan.nextLine(); }
        int n = scan.nextInt(); scan.nextLine(); // limpia el \n pendiente
        return n;
    }    
    

    public void mostrarInterfaz(){

        int opcion;
        do{
        System.out.println("/---------|ECOQUEST MENU|---------\\");
        System.out.println("1. Registrar voluntario");
        System.out.println("2. Registrar mision");
        System.out.println("3. Registrar punto ecologico");
        System.out.println("4. Asignar voluntarios a mision");
        System.out.println("5. Completar mision");
        System.out.println("6. Buscar voluntarios por habilidad");
        System.out.println("7. Mostrar reportes");
        System.out.println("8. Salir");
        System.out.print("Seleccione la opción que desea utilizar: ");
        opcion = leerEntero();

        
        switch (opcion) {
            case 1 -> {
                new AgregarVoluntarioController(scan,voluntarioService).mostrarAgregarVoluntarioController();
                }
            case 2 -> {
                new AgregarMisionController(scan,misionService).mostrarAgregarMisionController();
                }
            case 3 -> {
                new AgregarPuntoEcologicoController(scan, puntoEcologicoService).mostrarAgregarPuntoEcologicoController();
                }
            case 4 -> {
                    
                }
            case 5 -> {
                   
                }
            case 6 -> {
                    
                }
            case 7 -> {
                    
                }
            case 8 -> {System.out.println("Programa Finalizado");
                    
                }
            default -> {
                System.out.println("Numero invalido");
            }
        }

        }while(opcion != 8);

    }
    

}
