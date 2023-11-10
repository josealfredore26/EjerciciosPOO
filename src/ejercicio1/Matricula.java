package ejercicio1;

import java.util.Scanner;

public class Matricula {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombres = scanner.nextLine();
        System.out.print("Ingrese los apellidos del estudiante: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese el número de documento: ");
        String documento = scanner.nextLine();
        System.out.print("Ingrese la dirección del estudiante: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono: ");
        String telefono = scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombres, apellidos, documento, direccion, telefono);

        Carrera carreraA = new Carrera("Derecho", 20.0, 3);
        Carrera carreraB = new Carrera("Ingeniería de Sistemas y Computación", 25.0, 6);
        Carrera carreraC = new Carrera("Medicina", 30.0, Integer.MAX_VALUE);

        System.out.println("Seleccione la carrera:");
        System.out.println("1. " + carreraA.getNombre());
        System.out.println("2. " + carreraB.getNombre());
        System.out.println("3. " + carreraC.getNombre());

        int opcionCarrera = scanner.nextInt();

        calcularRecibo(estudiante, opcionCarrera, carreraA, carreraB, carreraC);
    }

    public static void calcularRecibo(Estudiante estudiante, int opcionCarrera, Carrera... carreras) {
        Carrera carreraSeleccionada = carreras[opcionCarrera - 1];
        double montoBase = 1500.0;
        double porcentajeAumento = 0.05;

        boolean materiasAplazadas = false;
        String respuesta = "";

        System.out.print("¿El estudiante tiene materias aplazadas? (si/no): ");
        do {
            respuesta = new Scanner(System.in).next();
            if(!(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no"))) System.out.print("Respuesta invalida, por favor ingrese SI o NO: ");
        } while(!(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no")));

        if(respuesta.equalsIgnoreCase("si")) materiasAplazadas = true;

        if (materiasAplazadas) {
            System.out.print("Ingrese la cantidad de créditos de las materias aplazadas: ");
            int creditosAplazados = new Scanner(System.in).nextInt();
            double costoTotal = montoBase + (creditosAplazados * carreraSeleccionada.getCostoCredito());
            System.out.println("Recibo de inscripción:");
            imprimirRecibo(estudiante, costoTotal);
        } else {
            double costoTotal = (opcionCarrera > carreraSeleccionada.getSemestreAumento()) ?
                    montoBase * (1 + porcentajeAumento) :
                    montoBase;
            System.out.println("Recibo de inscripción:");
            imprimirRecibo(estudiante, costoTotal);
        }
    }

    public static void imprimirRecibo(Estudiante estudiante, double costoTotal) {
        System.out.println("Nombre: " + estudiante.getNombres() + " " + estudiante.getApellidos());
        System.out.println("Documento: " + estudiante.getDocumento());
        System.out.println("Dirección: " + estudiante.getDireccion());
        System.out.println("Teléfono: " + estudiante.getTelefono());
        System.out.println("Costo total: $" + costoTotal);
    }
}

