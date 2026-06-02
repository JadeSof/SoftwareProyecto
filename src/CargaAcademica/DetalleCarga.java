package CargaAcademica;

import java.util.ArrayList;
import java.util.List;
import Recursos.Grupo;

public class DetalleCarga {
    private List<Grupo> gruposAgregados;
    private int creditosTotal;

    public DetalleCarga() {
        this.gruposAgregados = new ArrayList<>();
        this.creditosTotal = 0;
    }

    public List<Grupo> getGrupos() {
        return gruposAgregados;
    }

    public boolean agregarUnidad(Grupo grupo) {
        if (grupo == null) {
            return false;
        }
        gruposAgregados.add(grupo);
        if (grupo.getMateria() != null) {
            creditosTotal += grupo.getMateria().getCreditos();
        }
        return true;
    }

    public int calcularCreditosTotal() {
        int total = 0;
        for (Grupo grupo : gruposAgregados) {
            if (grupo.getMateria() != null) {
                total += grupo.getMateria().getCreditos();
            }
        }
        return total;
    }

    public boolean verificarCreditosMaximos(int creditosMax) {
        return calcularCreditosTotal() <= creditosMax;
    }

    public void create() {
        System.out.println("Detalle de carga académica creado.");
        System.out.println("Total de grupos: " + gruposAgregados.size());
        System.out.println("Total de créditos: " + calcularCreditosTotal());
    }
}
