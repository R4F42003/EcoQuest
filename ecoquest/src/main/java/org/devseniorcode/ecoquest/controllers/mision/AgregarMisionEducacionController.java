/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.devseniorcode.ecoquest.controllers.mision;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.devseniorcode.ecoquest.enums.LugarMisionEducativa;
import org.devseniorcode.ecoquest.models.misiones.MisionEducacion;
import org.devseniorcode.ecoquest.services.MisionServices;

class AgregarMisionEducacionController {
    
    private final Scanner scan;
    private final MisionServices misionService;
    private final int idTipoMision;
    private final String id;
    private final String descripcion;
    private final int idEstado;
    private final List<String> puntosEcos;
    private final LocalDate fecha;
    private final int idNivelDificultad;

    
    public AgregarMisionEducacionController(Scanner scan, MisionServices misionService, String id, String descripcion,int idEstado,List<String>puntosEcos, LocalDate fecha, int idNivelDificultad, int idTipoMision ) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.id = id;
        this.idNivelDificultad = idNivelDificultad;
        this.idTipoMision = idTipoMision;
        this.misionService = misionService;
        this.puntosEcos = puntosEcos;
        this.scan = scan;
        this.idEstado = idEstado;
    }

    public void mostrarAgregarMisionEducacionController() {
        System.out.println("Seleccione el lugar:");
        Arrays.stream(LugarMisionEducativa.values())
            .forEach(lugar -> System.out.println(
            lugar.getIdLugar() + ". " + lugar.name() + " (" + lugar.getTipoPoblacion() + ")"
        ));


        System.out.print("Seleccione el numero del lugar: ");
        int idLugar = Integer.parseInt(scan.nextLine().trim());

      
        MisionEducacion nuevaMision = new MisionEducacion(id, descripcion, idEstado, puntosEcos, fecha, idNivelDificultad,idTipoMision, idLugar);

        misionService.agregarMisiones(nuevaMision);
        System.out.println("Misión registrada con éxito");

        System.out.println(misionService.listarMisiones());

        
    }
    

}
