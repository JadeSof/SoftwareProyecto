package Recursos;

import java.util.ArrayList;
import java.util.List;

public class GruposDisponibles {
    private Periodo periodo;
    private List<Grupo> grupos;

    public GruposDisponibles(Periodo periodo) {
        this.periodo = periodo;
        this.grupos = new ArrayList<Grupo>();
    }

    public boolean agregarGrupo(Grupo g) {
        return this.grupos.add(g);
    }

    public Aula validaDisponibilidadDeAula(String aula, int horario) {
        Aula aulaDisponible = null;
        for (Grupo g : grupos) {
            aulaDisponible = g.getAula();
            if (aulaDisponible.toString().equals(aula) && (g.getHorario() == horario)) {
                // El aula ya esta ocupada en ese horario y periodo regresa null
                return null;
            }
        }

        // Regresa la aula si esta disponible en ese horario y periodo
        return aulaDisponible;
    }

    public Docente validaHorarioDocente(int idDocente, int horario) {
        Docente docenteDisponible = null;
        for (Grupo g : grupos) {
            docenteDisponible = g.getDocente();
            if (docenteDisponible.getId() == idDocente && (g.getHorario() == horario)) {
                // El docente ya esta ocupado en ese horario y periodo regresa null
                return null;
            }
        }

        // Regresa el docente si esta disponible en ese horario y periodo
        return docenteDisponible;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

}
