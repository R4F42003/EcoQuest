package org.devseniorcode.ecoquest.enums;

import java.util.Arrays;

public enum ZonaPlantacion {

    RURAL_AGRICOLA(1, "Rurales agrícolas", "Incluyen valles, planicies y llanuras aluviales; suelos fértiles y con buena disponibilidad de agua"),
    MONTAÑOSA(2, "Montañosas", "Comprenden laderas, cordilleras y altiplanos de diferentes pisos térmicos"),
    TROPICAL_HUMEDA(3, "Tropicales húmedas", "Regiones con alta humedad, bosques lluviosos, selvas y zonas ribereñas"),
    ARIDA_SEMIARIDA(4, "Áridas o semiáridas", "Áreas secas con baja precipitación; desiertos, sabanas secas y estepas"),
    PERIURBANA(5, "Periurbanas", "Espacios ubicados en la periferia de las ciudades, que combinan usos residenciales y agrícolas");

    private final int idZonaPlantacion;
    private final String nombreZonaPlantacion;
    private final String descripcion;

    ZonaPlantacion(int idZonaPlantacion, String nombreZonaPlantacion, String descripcion) {
        this.idZonaPlantacion = idZonaPlantacion;
        this.nombreZonaPlantacion = nombreZonaPlantacion;
        this.descripcion = descripcion;
    }

    public int getIdZonaPlantacion() {
        return idZonaPlantacion;
    }

    public String getNombreZonaPlantacion() {
        return nombreZonaPlantacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static ZonaPlantacion fromIdZonaPlantacion(int idZonaPlantacion){
        return Arrays.stream(values())
            .filter(e -> e.idZonaPlantacion == idZonaPlantacion)
            .findFirst()
            .orElseThrow(() -> 
                new IllegalArgumentException("Id de zona de plantación inválido: " + idZonaPlantacion));
    }

    @Override
    public String toString() {
        return "[" + idZonaPlantacion + "] " + nombreZonaPlantacion + " — " + descripcion;
    }
}
