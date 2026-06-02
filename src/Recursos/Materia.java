package Recursos;

public class Materia {
    private int id;
    private String nombre;
    private int creditos;

    public Materia(int id, String nombre, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
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

}
