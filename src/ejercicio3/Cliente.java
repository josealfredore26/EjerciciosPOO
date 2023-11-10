package ejercicio3;

import java.util.Scanner;

public class Cliente {
    private String nombres;
    private String apellidos;
    private int edad;
    private String representante;
    private String documento;

    public Cliente(String nombres, String apellidos, int edad, String documento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.representante = "";
        this.documento = documento;
        if (edad < 18) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese nombres del representante: ");
            this.representante = scanner.nextLine();
        }
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getRepresentante() {
        return representante;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
