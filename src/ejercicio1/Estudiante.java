package ejercicio1;

import java.util.Scanner;

public class Estudiante {
    private String nombres;
    private String apellidos;
    private String documento;
    private String direccion;
    private String telefono;
    private int semestreActual;

    public Estudiante(String nombres, String apellidos, String documento, String direccion, String telefono, int semestreActual) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.semestreActual = semestreActual;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getSemestreActual() {
        return semestreActual;
    }

    public void setSemestreActual(int semestreActual) {
        this.semestreActual = semestreActual;
    }
}

