package org.devseniorcode.ecoquest.controllers;

import java.util.Scanner;

import org.devseniorcode.ecoquest.controllers.mision.SelectorMisionController;


public class MenuPrincipalController {

    private final Scanner scan;

    public MenuPrincipalController(Scanner scan){

        this.scan = scan;

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
        System.out.println("3. Registrar punto eco");
        System.out.println("4. Asignar voluntarios a mision");
        System.out.println("5. Completar mision");
        System.out.println("6. Buscar voluntarios por habilidad");
        System.out.println("7. Mostrar reportes");
        System.out.println("8. Salir");
        System.out.print("Seleccione la opción que desea utilizar: ");
        opcion = leerEntero();

        
        switch (opcion) {
            case 1 -> {
                    
                }
            case 2 -> {
                new SelectorMisionController(scan).mostrarSelectorMisiones();
                }
            case 3 -> {
                
                }
            case 4 -> {
                    
                }
            case 5 -> {
                   
                }
            case 6 -> {
                    
                }
            case 7 -> {
                    
                }
            default -> {
                System.out.println("Numero invalido");
            }
        }

        }while(opcion != 8);

    }
    

}
