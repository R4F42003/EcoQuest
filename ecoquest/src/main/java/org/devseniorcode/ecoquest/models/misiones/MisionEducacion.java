package org.devseniorcode.ecoquest.models.misiones;

import java.time.LocalDate;
import java.util.List;

import org.devseniorcode.ecoquest.enums.Dificultad;
import org.devseniorcode.ecoquest.enums.Estado;
import org.devseniorcode.ecoquest.enums.LugarMisionEducativa;



    public class MisionEducacion extends Mision{

        private final LugarMisionEducativa lugarMisionEducativa;


        public MisionEducacion(String id, String descripcion, Estado estado, List<String> puntosEcos, LocalDate fecha, Dificultad nivelDificultad,int idLugar) {
            
            super(id, descripcion, estado, puntosEcos, fecha, nivelDificultad);
            this.lugarMisionEducativa = LugarMisionEducativa.fromId(idLugar);
        
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
