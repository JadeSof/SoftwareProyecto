package Recursos;

public class Materia {
    private int id;
    private String nombre;
    private int creditos;
    private int semestre;

    public Materia(int id, String nombre, int creditos, int semestre) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getSemestre() {
        return semestre;
    }
}
