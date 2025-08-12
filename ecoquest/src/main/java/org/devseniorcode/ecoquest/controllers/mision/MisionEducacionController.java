/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.devseniorcode.ecoquest.controllers.mision;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.devseniorcode.ecoquest.enums.Dificultad;
import org.devseniorcode.ecoquest.enums.Estado;
import org.devseniorcode.ecoquest.enums.LugarMisionEducativa;
import org.devseniorcode.ecoquest.models.misiones.MisionEducacion;
import org.devseniorcode.ecoquest.services.MisionServices;
import org.devseniorcode.ecoquest.services.impl.MisionServiceImpl;
import org.devseniorcode.ecoquest.utils.FechaUtils;

class MisionEducacionController {
    
    private final Scanner scan;
    
    public MisionEducacionController(Scanner scan){
        
        this.scan = scan;
    }

    public void mostrarMisisionEducacionController() {
        System.out.println("\n== Registro de Misión Educativa ==");

        System.out.print("ID de la misión: ");
        String id = scan.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scan.nextLine();

        int idEstado = Estado.PROGRAMADA.getIdEstado();

        System.out.print("PuntosEco (separados por comas): ");
        String puntosEcoInput = scan.nextLine();
        List<String> puntosEcos = List.of(puntosEcoInput.split(","));


        FechaUtils fechaUtils = new FechaUtils(scan);
        System.out.println("Digite la fecha de la misión:");
        LocalDate fecha = fechaUtils.leerFechaCompleta();

        System.out.println("Seleccione la dificulatad: ");
        Arrays.stream(Dificultad.values())
            .forEach(dificultad -> System.out.println(
                dificultad.getIdDificultad() +". " + dificultad.name() 
            ));
        

        System.out.print("Seleccione el numero de la dificultad: ");
        int idNivelDificultad = Integer.parseInt(scan.nextLine());
        

        System.out.println("Seleccione el lugar:");
        Arrays.stream(LugarMisionEducativa.values())
            .forEach(lugar -> System.out.println(
            lugar.getIdLugar() + ". " + lugar.name() + " (" + lugar.getTipoPoblacion() + ")"
        ));


        System.out.print("Seleccione el numero del lugar: ");
        int idLugar = Integer.parseInt(scan.nextLine());

        MisionEducacion mision = new MisionEducacion(
            id, descripcion, idEstado, puntosEcos, fecha, idNivelDificultad, idLugar
        );


        MisionServices services = new MisionServiceImpl();
        services.agregarMisiones(mision);
        System.out.println("✅ Misión registrada con éxito");

        System.out.println(services.listarMisiones());

        
    }

}
