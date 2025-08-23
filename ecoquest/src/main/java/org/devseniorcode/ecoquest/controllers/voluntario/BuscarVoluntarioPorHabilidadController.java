package org.devseniorcode.ecoquest.controllers.voluntario;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.devseniorcode.ecoquest.models.Voluntario;
import org.devseniorcode.ecoquest.services.VoluntarioService;

public class BuscarVoluntarioPorHabilidadController {

    private final Scanner scan;
    private final  VoluntarioService voluntarioService;
    
    public BuscarVoluntarioPorHabilidadController(Scanner scan, VoluntarioService voluntarioService){

        this.voluntarioService = voluntarioService;
        this.scan = scan;

    }
    private static String eliminarTildes(String s) {
                if (s == null) return "";
                return java.text.Normalizer.normalize(s, java.text.Normalizer.Form.NFD)
                        .replaceAll("\\p{M}+","")
                        .toLowerCase(java.util.Locale.ROOT);
    }

    public void mostrarBuscarVoluntarioPorHabilidadController(){

        List<Voluntario> voluntarios = voluntarioService.listarVoluntario();  
        System.out.println("\n=== BUSCAR VOLUNTARIO POR HABILIDAD ===");  
        System.out.print("Digite la habilidad:");
        String habilidad = scan.nextLine().trim();

        List<Voluntario> voluntariosHabilidad = voluntarios.stream()
            .filter(v -> v.getHabilidades() != null &&
                        v.getHabilidades().stream().anyMatch(h ->
                            h != null &&
                            eliminarTildes(h).toLowerCase(Locale.ROOT)
                                .contains(eliminarTildes(habilidad).toLowerCase(Locale.ROOT))
                        ))
            .collect(Collectors.toList());
        
        System.out.println("Aprendices disponibles: ");
        for (Voluntario v : voluntariosHabilidad) {
            if (v.getNombre() != null) {
                System.out.println(v.getId()+ " " + v.getNombre()+ " "+ v.getHabilidades());
            }
        }      
    }
}
