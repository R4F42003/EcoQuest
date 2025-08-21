package org.devseniorcode.ecoquest.controllers.mision;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.devseniorcode.ecoquest.enums.TipoMision;
import org.devseniorcode.ecoquest.services.MisionServices;


public class SelectorMisionController {

    private final Scanner scan;
    private final MisionServices misionService;
    private int idTipoMision;
    private final String id;
    private final String descripcion;
    private final int idEstado;
    private final List<String> puntosEcos;
    private final LocalDate fecha;
    private final int idNivelDificultad;
 
    public SelectorMisionController(Scanner scan, MisionServices misionService,String id,String descripcion,int idEstado,List<String> puntosEcos, LocalDate fecha,  int idNivelDificultad ) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.id = id;
        this.idNivelDificultad = idNivelDificultad;
        this.misionService = misionService;
        this.puntosEcos = puntosEcos;
        this.scan = scan;
        this.idEstado = idEstado;
    }


    public void  mostrarSelectorMisiones(){

        System.out.println("---Selecciona el tipo de mision---");
        Arrays.stream(TipoMision.values())
            .forEach(tipoMision ->System.out.println(
                tipoMision.getIdTipoMision() +". " + tipoMision.name()
            ));

        do{
            System.out.print("\nSelecione la opcion que desea: ");
            String number = scan.nextLine().trim();
            idTipoMision = Integer.parseInt(number);

        switch(idTipoMision){
            case 1 ->{
                new AgregarMisionEducacionController(scan, misionService,id, descripcion,idEstado,puntosEcos,fecha,idNivelDificultad,idTipoMision).mostrarAgregarMisionEducacionController();
                return;
            }
            case 2 ->{
                new AgregarMisionLimpiezaController(scan, misionService,id, descripcion,idEstado,puntosEcos,fecha,idNivelDificultad,idTipoMision).mostrarAgregarMisionLimpiezaController();
                return;
            }
            case 3 ->{
                new AgregarMisionPlantacionController(scan, misionService,id, descripcion,idEstado,puntosEcos,fecha,idNivelDificultad,idTipoMision).mostrarAgregarMisionPlantacionController();
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
        }while(idTipoMision != 4);
        

    }

}
