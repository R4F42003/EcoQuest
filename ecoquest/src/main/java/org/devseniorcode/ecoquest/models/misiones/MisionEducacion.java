package org.devseniorcode.ecoquest.models.misiones;

import java.time.LocalDate;
import java.util.List;

import org.devseniorcode.ecoquest.enums.LugarMisionEducativa;



    public class MisionEducacion extends Mision{

        private final LugarMisionEducativa lugarMisionEducativa;


        public MisionEducacion(String id, String descripcion, int idEstado, List<String> puntosEcos, LocalDate fecha, int idNivelDificultad, int idTipoMision, int idLugar) {
            super(id, descripcion, idEstado, puntosEcos, fecha, idNivelDificultad, idTipoMision);
            this.lugarMisionEducativa = LugarMisionEducativa.fromIdLugar(idLugar);
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
