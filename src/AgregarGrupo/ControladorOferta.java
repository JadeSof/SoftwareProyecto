package AgregarGrupo;

import Recursos.*;

public class ControladorOferta {
    private String msg;
    private GruposDisponibles gruposDisponibles;
    private MateriasRegistradas materiasRegistradas;

    public ControladorOferta() {
        this.gruposDisponibles = RecursosCarga.getGruposDisponibles();
        this.materiasRegistradas = RecursosCarga.getMateriasRegistradas();
    }

    public synchronized boolean IntroducirDatos(String claveMateria, String claveGrupo, String horario,
            String idDocente,
            String idAula, int cupo) {
        if (claveMateria.isEmpty() || claveGrupo.isEmpty() || horario.isEmpty() || idDocente.isEmpty()
                || idAula.isEmpty() || cupo <= 0) {
            msg = "Todos los campos deben ser llenados.";
            return false;
        }
        // Validar que el aula no este ocupada en el mismo horario y periodo
        Aula aulaDisponible;
        if ((aulaDisponible = gruposDisponibles.validaDisponibilidadDeAula(idAula,
                Integer.parseInt(horario))) == null) {
            msg = "El aula ya está ocupada en ese horario y periodo.";
            return false;
        }
        // Validar que el docente no este ocupado en el mismo horario y periodo
        Docente docenteDisponible;
        if ((docenteDisponible = gruposDisponibles.validaHorarioDocente(Integer.parseInt(idDocente),
                Integer.parseInt(horario))) == null) {
            msg = "El docente ya está ocupado en ese horario.";
            return false;
        }
        Materia materiaAsignada = materiasRegistradas.buscarMateria(Integer.parseInt(claveMateria));
        Grupo nuevoGrupo = new Grupo(Integer.parseInt(claveGrupo), cupo, materiaAsignada,
                docenteDisponible, aulaDisponible, Integer.parseInt(horario));

        gruposDisponibles.agregarGrupo(nuevoGrupo);
        msg = "Grupo agregado exitosamente.";
        return true;
    }

    public String getMsg() {
        return msg;

    }

}
