package Recursos;
import CargaAcademica.*;
public class Alumno {
    private CargaAcademica cargaAcademica; 
    public Alumno(){
        this.cargaAcademica = new CargaAcademica();
    }

    public CargaAcademica getCargaAcademica() {
        return cargaAcademica;
    }
}
