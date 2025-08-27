package org.devseniorcode.ecoquest.controllers.voluntario;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.devseniorcode.ecoquest.exceptions.VoluntarioIdExistenteExcepcion;
import org.devseniorcode.ecoquest.models.Voluntario;
import org.devseniorcode.ecoquest.services.VoluntarioService;

public class AgregarVoluntarioController {

    private final Scanner scan;
    private final VoluntarioService voluntarioService;

    public AgregarVoluntarioController(Scanner scan, VoluntarioService voluntarioService){
        this.scan = scan;
        this.voluntarioService = voluntarioService;

    }

    public void mostrarAgregarVoluntarioController(){
        try{
            System.out.print("Digite el id: ");
            String id = scan.nextLine();
            System.out.print("Digite el nombre completo: ");
            String nombre = scan.nextLine();
            System.out.print("Digite las habilidades (separadas por comas): ");
            String habilidadesInput =scan.nextLine();

            Set<String> habilidades = new HashSet<>();
            for (String s : habilidadesInput.toLowerCase().split("\\s*,\\s*")){
                if(!s.isBlank()){
                    habilidades.add(s);
                }
            }

            Set<String> misionesAsignadas = new HashSet<>();

            Set<String> misionesCompletadas = new HashSet<>();
            
            Voluntario nueVoluntario = new Voluntario(id, nombre, habilidades, misionesAsignadas, misionesCompletadas);
            
            voluntarioService.agregarVoluntarios(nueVoluntario);

            System.out.println("Voluntario registrado con exito");

        } catch (VoluntarioIdExistenteExcepcion ex) {
            System.out.println( ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println(" Datos inválidos: " + ex.getMessage());
        }
    }

}
