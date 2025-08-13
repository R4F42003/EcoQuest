package org.devseniorcode.ecoquest.controllers.mision;

import java.util.Scanner;

import org.devseniorcode.ecoquest.services.MisionServices;


public class SelectorMisionController {


    private final Scanner scan;
    private final MisionServices misionService;

    public SelectorMisionController(Scanner scan, MisionServices misionService) {
        this.scan = scan;
        this.misionService = misionService;
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
                new MisionEducacionController(scan, misionService).mostrarMisisionEducacionController();
                return;
            }
            case 2 ->{
                new MisionLimpiezaController(scan, misionService).mostrarMisisionLimpiezaController();
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
