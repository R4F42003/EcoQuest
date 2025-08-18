package org.devseniorcode.ecoquest.controllers.voluntario;

import java.util.Scanner;

import org.devseniorcode.ecoquest.services.VoluntarioService;

public class AgregarVoluntarioController {

    private final Scanner scan;
    private final VoluntarioService voluntarioService;

    public AgregarVoluntarioController(Scanner scan, VoluntarioService voluntarioService){
        this.scan = scan;
        this.voluntarioService = voluntarioService;

    }

    public void mostrarAgregarVoluntarioController(){
        System.out.println("Digite el id:");
        String id = scan.nextLine();
        System.out.println("Digite el nombre");
  
    }

}
