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

        return docenteDisponible;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public Grupo buscarGrupoPorId(int idGrupo) {
        for (Grupo g : grupos) {
            if (g.getId() == idGrupo) {
                return g;
            }
        }
        return null;
    }

    public List<Grupo> obtenerGrupos() {
        return grupos;
    }
