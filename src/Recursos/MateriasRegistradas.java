package Recursos;

import java.util.ArrayList;
import java.util.List;

public class MateriasRegistradas {
    private List<Materia> materias;

    public MateriasRegistradas() {
        this.materias = new ArrayList<Materia>();
    }

    public void agregarMateria(Materia materia) {
        this.materias.add(materia);
    }

    public Materia buscarMateria(int id) {
        for (Materia materia : materias) {
            if (materia.getId() == id) {
                return materia;
            }
        }
        return null;
    }

}
