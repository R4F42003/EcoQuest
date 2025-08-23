package org.devseniorcode.ecoquest.controllers;

import java.util.List;

import org.devseniorcode.ecoquest.enums.Estado;
import org.devseniorcode.ecoquest.enums.TipoMision;
import org.devseniorcode.ecoquest.models.Voluntario;
import org.devseniorcode.ecoquest.models.misiones.Mision;
import org.devseniorcode.ecoquest.models.misiones.MisionLimpieza;
import org.devseniorcode.ecoquest.models.misiones.MisionPlantacion;
import org.devseniorcode.ecoquest.services.MisionServices;
import org.devseniorcode.ecoquest.services.VoluntarioService;

public class ReporteController {

    private final MisionServices misionService;
    private final VoluntarioService voluntarioService;
    public ReporteController(MisionServices misionService, VoluntarioService voluntarioService){

        this.voluntarioService = voluntarioService;
        this.misionService = misionService;
    }

    public void mostrarReporteController(){   
        List<Voluntario> voluntarios = voluntarioService.listarVoluntario();
        List<Mision> misiones = misionService.listarMisiones();
        
        System.out.println("\n=== TOP VOLUNTARIOS ===");
        int masMisionesCompletadas = voluntarios.stream()
        .mapToInt(v -> v.getMisionesCompletadas().size())  
        .max()                                     
        .orElse(0); 
        voluntarios
            .stream()
            .filter(vt -> vt.getMisionesCompletadas().size() == masMisionesCompletadas)
            .forEach(
                vt-> System.out.println( "Voluntario: " + vt.getNombre() + " Misiones Completadas: " + vt.getMisionesCompletadas().size()));
        

        System.out.println("\n=== Misiones Programada ===");
        misiones
            .stream()
            .filter(mp-> mp.getEstado() == Estado.PROGRAMADA)
            .forEach(mp-> System.out.println("Id: " + mp.getId() + ". " + mp.getDescripcion()));
                        
        System.out.println("\n=== Misiones En Progreso ===");
        misiones
            .stream()
            .filter(mp-> mp.getEstado() == Estado.EN_PROCESO)
            .forEach(mp-> System.out.println("Id: " + mp.getId() + ". " + mp.getDescripcion()));

        System.out.println("\n=== Misiones Inconclusas ===");
        misiones
            .stream()
            .filter(mp-> mp.getEstado() == Estado.INCONCLUSA)
            .forEach(mp-> System.out.println("Id: " + mp.getId() + ". " + mp.getDescripcion()));

        System.out.println("\n=== Misione Completadas ===");
        misiones
            .stream()
            .filter(mp-> mp.getEstado() == Estado.COMPLETADO)
            .forEach(mp-> System.out.println("Id: " + mp.getId() + ". " + mp.getDescripcion()));

    
        System.out.println("\n=== Impacto ===");

        double cantBasuraRecogida = misiones
                                        .stream()
                                        .filter(m -> m instanceof MisionLimpieza) 
                                        .mapToDouble(m -> ((MisionLimpieza) m).getCantBasuraRecogida())
                                        .sum();
        System.out.println("Basura Recogida: " + cantBasuraRecogida +"kg");

        int cantPlantasPlantadas = misiones
                                        .stream()
                                        .filter(m -> m instanceof MisionPlantacion) 
                                        .mapToInt(m -> ((MisionPlantacion) m).getCantidadPlantada())
                                        .sum();
        System.out.println("Plantas plantadas: " + cantPlantasPlantadas );

        long cantCampaniaEducativas = misiones
                                            .stream()
                                            .filter(m-> m.getTipoMision() == TipoMision.EDUCACION)
                                            .count();
        System.out.println("Campañas educativas: " + cantCampaniaEducativas );
    }

}
