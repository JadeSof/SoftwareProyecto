package Recursos;

import java.util.ArrayList;
import java.util.List;

public class GruposDisponibles {
    List<Grupo> grupos;

    public GruposDisponibles() {
        this.grupos = new ArrayList<Grupo>();
    }

    public boolean agregarGrupo(Grupo g) {
        return this.grupos.add(g);
    }
}
