package org.devseniorcode.ecoquest.models.misiones;

import java.time.LocalDate;
import java.util.List;

import org.devseniorcode.ecoquest.enums.LugarMisionEducativa;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



    public class MisionEducacion extends Mision{

        private final LugarMisionEducativa lugarMisionEducativa;
        @JsonCreator
        public MisionEducacion(
            @JsonProperty("id") String id,
            @JsonProperty("descripcion") String descripcion,
            @JsonProperty("idEstado") int idEstado,
            @JsonProperty("puntosEcos") List<String> puntosEcos,
            @JsonProperty("fecha") LocalDate fecha,
            @JsonProperty("idNivelDificultad") int idNivelDificultad,
            @JsonProperty("idTipoMision") int idTipoMision,
            @JsonProperty("idLugar") int idLugar              
        ) {
            super(id, descripcion, idEstado, puntosEcos, fecha, idNivelDificultad, idTipoMision);
            this.lugarMisionEducativa = LugarMisionEducativa.fromIdLugar(idLugar); // enum
        }
        

            public LugarMisionEducativa getLugarMisionEducativa() {
                return lugarMisionEducativa;
            }

            public String getTipoPoblacion() {
                return lugarMisionEducativa.getTipoPoblacion();
            }

            @Override
            public String complemento() {
            return ", lugar=" + lugarMisionEducativa.getNombreLugar()
                + ", poblacion=" + lugarMisionEducativa.getTipoPoblacion();
            }


        }
