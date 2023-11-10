package ejercicio1;

import java.util.Scanner;


public class Matricula {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Estudiante estudiante = ingresarDatosEstudiante(scanner);

        Carrera carreraA = new Carrera("Derecho", 20.0, 5);
        Carrera carreraB = new Carrera("Ingeniería de Sistemas y Computación", 25.0, 5);
        Carrera carreraC = new Carrera("Medicina", 30.0, 5);

        imprimirOpcionesCarreras(carreraA, carreraB, carreraC);

        int opcionCarrera = scanner.nextInt();

        calcularRecibo(estudiante, opcionCarrera, carreraA, carreraB, carreraC);
    }

    private static Estudiante ingresarDatosEstudiante(Scanner scanner) {
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
        System.out.print("Ingrese el semestre que quiere matricular: ");
        int semestreActual = Integer.parseInt(scanner.next());

        return new Estudiante(nombres, apellidos, documento, direccion, telefono, semestreActual);
    }

    private static void imprimirOpcionesCarreras(Carrera... carreras) {
        System.out.println("Seleccione la carrera:");
        for (int i = 0; i < carreras.length; i++) {
            System.out.println((i + 1) + ". " + carreras[i].getNombre());
        }
    }

    private static void calcularRecibo(Estudiante estudiante, int opcionCarrera, Carrera... carreras) {
        Carrera carreraSeleccionada = carreras[opcionCarrera - 1];
        double montoBase = 1500.0;
        double porcentajeAumento = 0.05;

        boolean materiasAplazadas = verificarMateriasAplazadas();

        if (materiasAplazadas) {
            int creditosAplazados = ingresarCreditosAplazados();
            double costoTotal = montoBase + (creditosAplazados * carreraSeleccionada.getCostoCredito());
            double aumentoPorSemestre = (estudiante.getSemestreActual() >= carreraSeleccionada.getSemestreAumento()) ?
                    montoBase * porcentajeAumento * (1 + (estudiante.getSemestreActual() - carreraSeleccionada.getSemestreAumento())) :
                    0;
            imprimirRecibo(estudiante, costoTotal, true, aumentoPorSemestre, creditosAplazados);
        } else {
            double aumentoPorSemestre = (estudiante.getSemestreActual() >= carreraSeleccionada.getSemestreAumento()) ?
                    montoBase * porcentajeAumento * (1 + (estudiante.getSemestreActual() - carreraSeleccionada.getSemestreAumento())) :
                    0;
            double costoTotal = montoBase + aumentoPorSemestre;
            imprimirRecibo(estudiante, costoTotal, false, aumentoPorSemestre, 0);
        }
    }



    private static boolean verificarMateriasAplazadas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿El estudiante tiene materias aplazadas? (si/no): ");
        String respuesta;
        do {
            respuesta = scanner.next().toLowerCase();
            if (!(respuesta.equals("si") || respuesta.equals("no"))) {
                System.out.print("Respuesta inválida, por favor ingrese SI o NO: ");
            }
        } while (!(respuesta.equals("si") || respuesta.equals("no")));

        return respuesta.equals("si");
    }

    private static int ingresarCreditosAplazados() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de créditos de las materias aplazadas: ");
        return scanner.nextInt();
    }

    private static void imprimirRecibo(Estudiante estudiante, double costoTotal, boolean materiasAplazadas, double aumentoPorSemestre, int creditosAplazados) {
        System.out.println("Recibo de inscripción:");
        System.out.println("Nombre: " + estudiante.getNombres() + " " + estudiante.getApellidos());
        System.out.println("Documento: " + estudiante.getDocumento());
        System.out.println("Dirección: " + estudiante.getDireccion());
        System.out.println("Teléfono: " + estudiante.getTelefono());
        System.out.println("Costo base: $" + 1500);
        System.out.println("Costo total: $" + costoTotal);

        if (materiasAplazadas) {
            System.out.println("Se pagan créditos aplazados: " + creditosAplazados);
        }

        if (aumentoPorSemestre > 0) {
            System.out.println("Aumento por semestre: $" + aumentoPorSemestre);
        }
    }

}
