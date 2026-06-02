package Recursos;

import AgregarGrupo.*;

public class RecursosCarga {
    private static GruposDisponibles gruposDisponibles;
    private static MateriasRegistradas materiasRegistradas;
    private static Periodo periodo;
    private static ControladorOferta controladorOferta;

    public RecursosCarga() {
        periodo = new Periodo("01/01/2026", "29/05/2026");
        gruposDisponibles = new GruposDisponibles(periodo);
        materiasRegistradas = new MateriasRegistradas();
        controladorOferta = new ControladorOferta();
    }

    public static GruposDisponibles getGruposDisponibles() {
        return gruposDisponibles;
    }

    public static MateriasRegistradas getMateriasRegistradas() {
        return materiasRegistradas;
    }

    public static ControladorOferta getControladorOferta() {
        return controladorOferta;
    }
}
