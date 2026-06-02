package CargaAcademica;
import Recursos.*;

public class ControladorCarga {
    private String msg;
    private GruposDisponibles gruposDisponibles;
    private CargaAcademica cargaAcademica;
    private Alumno alumno;
    private static final int CREDITOS_MAXIMOS = 20;

    public ControladorCarga() {
        this.gruposDisponibles = RecursosCarga.getGruposDisponibles();
    }

    public synchronized boolean iniciarCargaAlumno(Alumno alumno) {
        if (alumno == null) {
            msg = "El alumno no puede ser nulo.";
            return false;
        }
        this.alumno = alumno;
        this.cargaAcademica = alumno.getCargaAcademica();
        cargaAcademica.iniciarCarga();
        msg = "Carga académica iniciada.";
        return true;
    }

    public synchronized boolean seleccionarGrupo(int idGrupo) {
        if (cargaAcademica == null) {
            msg = "Debe iniciar carga académica primero.";
            return false;
        }

        Grupo grupoSeleccionado = gruposDisponibles.buscarGrupoPorId(idGrupo);
        if (grupoSeleccionado == null) {
            msg = "Grupo no encontrado.";
            return false;
        }

        if (verificarColisionHorario(grupoSeleccionado)) {
            msg = "Ya tiene un grupo en ese horario.";
            return false;
        }

        if (grupoSeleccionado.getCupo() <= grupoSeleccionado.getAlumnosInscritos()) {
            msg = "No hay cupos disponibles en este grupo.";
            return false;
        }

        if (!validarCreditos(grupoSeleccionado)) {
            msg = "Excede el número máximo de créditos permitidos.";
            return false;
        }

        if (cargaAcademica.agregarGrupo(grupoSeleccionado)) {
            msg = "Grupo agregado correctamente.";
            return true;
        } else {
            msg = "No se pudo agregar el grupo.";
            return false;
        }
    }

    private boolean verificarColisionHorario(Grupo nuevoGrupo) {
        for (Grupo grupo : cargaAcademica.getGrupos()) {
            if (grupo.getHorario() == nuevoGrupo.getHorario()) {
                return true;
            }
        }
        return false;
    }

    private boolean validarCreditos(Grupo nuevoGrupo) {
        int totalCreditos = 0;
        for (Grupo grupo : cargaAcademica.getGrupos()) {
            if (grupo.getMateria() != null) {
                totalCreditos += grupo.getMateria().getCreditos();
            }
        }
        if (nuevoGrupo.getMateria() != null) {
            totalCreditos += nuevoGrupo.getMateria().getCreditos();
        }
        return totalCreditos <= CREDITOS_MAXIMOS;
    }

    public int calcularCreditosTotal() {
        int totalCreditos = 0;
        for (Grupo grupo : cargaAcademica.getGrupos()) {
            if (grupo.getMateria() != null) {
                totalCreditos += grupo.getMateria().getCreditos();
            }
        }
        return totalCreditos;
    }

    public synchronized boolean finalizarCarga() {
        if (cargaAcademica == null) {
            msg = "No hay carga académica iniciada.";
            return false;
        }
        if (cargaAcademica.confirmarCarga()) {
            msg = "Carga académica confirmada correctamente.";
            return true;
        } else {
            msg = "Debe agregar al menos un grupo.";
            return false;
        }
    }

    public void mostrarHorario() {
        if (cargaAcademica != null) {
            cargaAcademica.mostrarHorario();
        } else {
            System.out.println("No hay carga académica iniciada.");
        }
    }

    public String getMsg() {
        return msg;
    }
}
