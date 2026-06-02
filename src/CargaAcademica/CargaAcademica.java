package CargaAcademica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import Recursos.Grupo;

public class CargaAcademica {
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fechaCarga;
    private DetalleCarga detalleCarga;
    private List<Grupo> grupos;

    public CargaAcademica() {
        this.grupos = new ArrayList<>();
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public LocalDate getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(LocalDate fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public DetalleCarga getDetalleCarga() {
        return detalleCarga;
    }

    public void setDetalleCarga(DetalleCarga detalleCarga) {
        this.detalleCarga = detalleCarga;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void iniciarCarga() {
        this.fechaCarga = LocalDate.now();
        this.horaInicio = LocalTime.now();
        this.detalleCarga = new DetalleCarga();
    }

    public boolean confirmarCarga() {
        if (grupos.isEmpty()) {
            return false;
        }
        this.horaFin = LocalTime.now();
        return true;
    }

    public boolean verificarColisionHorario(Grupo nuevoGrupo) {
        for (Grupo grupo : grupos) {
            if (grupo.getHorario() == nuevoGrupo.getHorario()) {
                return true;
            }
        }
        return false;
    }

    public boolean validarCreditos(int creditosMaximos) {
        int totalCreditos = 0;
        for (Grupo grupo : grupos) {
            if (grupo.getMateria() != null) {
                totalCreditos += grupo.getMateria().getCreditos();
            }
        }
        return totalCreditos <= creditosMaximos;
    }

    public boolean agregarGrupo(Grupo grupo) {
        if (grupo == null) {
            return false;
        }
        if (verificarColisionHorario(grupo)) {
            return false;
        }
        grupos.add(grupo);
        return true;
    }

    public void mostrarHorario() {
        System.out.println("Horario de carga académica:");
        for (Grupo grupo : grupos) {
            String materia = grupo.getMateria() != null ? grupo.getMateria().getNombre() : "Sin materia";
            System.out.println("Grupo " + grupo.getId() + " - " + materia + " - Horario: " + grupo.getHorario());
        }
    }
}

