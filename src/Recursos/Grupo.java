package Recursos;

public class Grupo {
    private int id, cupo;
    private Materia materia;
    private Docente docente;
    private Periodo periodo;
    private Aula aula;

    public Grupo(int id, int cupo, Materia materia, Docente docente, Periodo periodo, Aula aula) {
        this.id = id;
        this.cupo = cupo;
        this.materia = materia;
        this.docente = docente;
        this.periodo = periodo;
        this.aula = aula;
    }

    public int getId() {
        return id;
    }

    public int getCupo() {
        return cupo;
    }

    public Materia getMateria() {
        return materia;
    }

    public Docente getDocente() {
        return docente;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public Aula getAula() {
        return aula;
    }

}
