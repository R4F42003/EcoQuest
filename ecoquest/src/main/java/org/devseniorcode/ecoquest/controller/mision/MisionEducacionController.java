/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.devseniorcode.ecoquest.controller.mision;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.devseniorcode.ecoquest.enums.Dificultad;
import org.devseniorcode.ecoquest.enums.Estado;
import org.devseniorcode.ecoquest.enums.LugarMisionEducativa;
import org.devseniorcode.ecoquest.models.misiones.MisionEducacion;
import org.devseniorcode.ecoquest.services.MisionServices;
import org.devseniorcode.ecoquest.services.impl.MisionServiceImpl;

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

        Estado estado = Estado.PROGRAMADA;

        System.out.print("PuntosEco (separados por comas): ");
        String puntosEcoInput = scan.nextLine();
        List<String> puntosEcos = List.of(puntosEcoInput.split(","));

        LocalDate fecha = LocalDate.now();

        Dificultad dificultad = Dificultad.FACIL;
        

        System.out.println("Seleccione el lugar:");
        for (LugarMisionEducativa lugar : LugarMisionEducativa.values()) {
            System.out.println(lugar.getIdLugar() + ". " + lugar.name() +
                            " (" + lugar.getTipoPoblacion() + ")");
        }

        System.out.print("Seleccione la id del lugar: ");
        int idLugar = Integer.parseInt(scan.nextLine());

        MisionEducacion mision = new MisionEducacion(
            id, descripcion, estado, puntosEcos, fecha, dificultad, idLugar
        );
        

        MisionServices services = new MisionServiceImpl();
        services.agregarMisiones(mision);
        System.out.println("✅ Misión registrada con éxito");

        System.out.println(services.listarMisiones());

        
    }

}
