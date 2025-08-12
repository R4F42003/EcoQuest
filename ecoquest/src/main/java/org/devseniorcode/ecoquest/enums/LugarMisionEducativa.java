package org.devseniorcode.ecoquest.enums;

public enum LugarMisionEducativa {

    COLEGIOS(1, "Colegios", "Niños"),
    COMUNIDADES_INDIGENAS(2, "Comunidades indígenas", "Población mixta"),
    CARCELES(3, "Cárceles", "Personas privadas de la libertad"),
    UNIVERSIDADES(4, "Universidades", "Jóvenes"),
    FUNDACIONES(5, "Fundaciones", "Población vulnerable"),
    BIBLIOTECAS(6, "Bibliotecas", "Comunidad general"),
    CASAS_CULTURA(7, "Casas de cultura", "Comunidad general"),
    CENTROS_COMUNITARIOS(8, "Centros comunitarios", "Comunidad general"),
    HOSPITALES(9, "Hospitales", "Pacientes, familias y comunidad medica"),
    ONGS(10, "ONGs", "La población depende del programa"),
    HOGARES_GERIATRICOS(11, "Hogares geriátricos", "Adultos mayores");

    private final int idLugar;
    private final String nombreLugar;       
    private final String tipoPoblacion;   

    LugarMisionEducativa(int idLugar, String nombreLugar, String tipoPoblacion) {
        this.idLugar = idLugar;
        this.nombreLugar = nombreLugar;
        this.tipoPoblacion = tipoPoblacion;
    }

    public int getIdLugar() { return idLugar; }
    public String getNombreLugar() { return nombreLugar; }
    public String getTipoPoblacion() { return tipoPoblacion; }

    public static LugarMisionEducativa fromIdLugar(int idLugar) {
        for (var l : values()) if (l.idLugar == idLugar) return l;
        throw new IllegalArgumentException("Código de lugar no válido: " + idLugar);
    }
}
