package Recursos;

public class Aula {
    private int id;
    private String acronimo;

    public Aula(int id, String acronimo) {
        this.id = id;
        this.acronimo = acronimo;
    }

    public int getId() {
        return id;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public String toString() {
        return id + acronimo;
    }
}
