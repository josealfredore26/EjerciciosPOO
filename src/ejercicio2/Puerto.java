package ejercicio2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java.text.ParseException;
import java.util.Scanner;

public class Puerto {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        Barco barco = ingresarDatosBarco(scanner);
        Cliente cliente = ingresarDatosCliente(scanner);

        boolean agregarAmarre = true;
        while (agregarAmarre) {
            Amarre amarre = ingresarDatosAmarre(scanner, barco, cliente);
            cliente.agregarAmarre(amarre);

            System.out.print("¿Desea agregar otro amarre? (Sí/No): ");
            String respuesta = scanner.next().toLowerCase();
            agregarAmarre = respuesta.equals("si") || respuesta.equals("sí");
        }

        System.out.println(cliente.generarReciboCompleto());
    }

    private static Barco ingresarDatosBarco(Scanner scanner) {
        System.out.print("Ingrese la matrícula del barco: ");
        String matriculaBarco = scanner.nextLine();
        System.out.print("Ingrese la eslora del barco (en metros): ");
        double esloraBarco = scanner.nextDouble();
        System.out.print("Ingrese el año de fabricación del barco: ");
        int anoFabricacionBarco = scanner.nextInt();

        return new Barco(matriculaBarco, esloraBarco, anoFabricacionBarco);
    }

    private static Cliente ingresarDatosCliente(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        scanner.nextLine(); // Limpiar el buffer
        String nombreCliente = scanner.nextLine();

        return new Cliente(nombreCliente);
    }

    private static Amarre ingresarDatosAmarre(Scanner scanner, Barco barco, Cliente cliente) throws ParseException {
        System.out.print("Ingrese la cantidad de clientes: ");
        int cantidadClientes = scanner.nextInt();
        String fechaInicial;
        String fechaFinal;

        do {
            System.out.print("Ingrese la fecha inicial del alquiler (dd/MM/yyyy): ");
            fechaInicial = scanner.next();
            System.out.print("Ingrese la fecha final del alquiler (dd/MM/yyyy): ");
            fechaFinal = scanner.next();

            if (!verificarFechasCoherentes(fechaInicial, fechaFinal)) {
                System.out.println("Las fechas ingresadas no son coherentes. Por favor, ingréselas nuevamente.");
            }

        } while (!verificarFechasCoherentes(fechaInicial, fechaFinal));

        System.out.print("Ingrese la posición del amarre: ");
        int posicionAmarre = scanner.nextInt();

        return new Amarre(cliente.getNombre(), cantidadClientes, fechaInicial, fechaFinal, posicionAmarre, barco);
    }

    private static boolean verificarFechasCoherentes(String fechaInicial, String fechaFinal) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dateInicial = sdf.parse(fechaInicial);
            Date dateFinal = sdf.parse(fechaFinal);

            return !dateFinal.before(dateInicial);

        } catch (ParseException e) {
            return false;
        }
    }
}

