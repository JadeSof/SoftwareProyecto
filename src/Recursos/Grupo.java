package Recursos;

public class Grupo {
    private int id, cupo, alumnosInscritos, horario;
    private Materia materia;
    private Docente docente;
    private Aula aula;

    public Grupo(int id, int cupo, Materia materia, Docente docente, Aula aula, int horario) {
        this.id = id;
        this.cupo = cupo;
        this.materia = materia;
        this.docente = docente;
        this.aula = aula;
        this.horario = horario;
        this.alumnosInscritos = 0;
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

    public Aula getAula() {
        return aula;
    }

    public int getAlumnosInscritos() {
        return alumnosInscritos;
    }

    public int getHorario() {
        return horario;
    }

}
