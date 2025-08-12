package org.devseniorcode.ecoquest.controller.mision;

import java.util.Scanner;

public class SelectorMisionController {


    private final Scanner scan;

    public SelectorMisionController(Scanner scan) {
        this.scan = scan;
    }

    public void  mostrarSelectorMisiones(){

        int opcion;

        System.out.println("---Selecciona el tipo de mision---");
        System.out.println("1. Educativa");
        System.out.println("2. Limpieza");
        System.out.println("3. Plantacion");
        System.out.println("4. Cancelar registro");
        
        do{
            System.out.print("\nSelecione la opcion que desea: ");
            String number = scan.nextLine().trim();
            opcion = Integer.parseInt(number);

        switch(opcion){
            case 1 ->{
                new MisionEducacionController(scan).mostrarMisisionEducacionController();
                return;
            }
            case 2 ->{

                return;
            }
            case 3 ->{

                return;
            }
            case 4 -> {
                System.out.println("Registro Cancelado");
                return;
            }
            default -> {
                System.out.println("Numero invalido");
            }
        }
        }while(opcion != 4);
        

    }

}
