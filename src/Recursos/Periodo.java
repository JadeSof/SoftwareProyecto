package Recursos;

public class Periodo {
    private String fechaIni, fechaFin;
    private char estado;

    public Periodo(String fechaIni, String fechaFin) {
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.estado = 'A';
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String toString() {
        return fechaIni + "-" + fechaFin;
    }

}
