package Recursos;

public class Docente {
    private String nombre;
    private String apellidos;
    private int id;

    public Docente(String nombre, String apellidos, int id) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getId() {
        return id;
    }
}
