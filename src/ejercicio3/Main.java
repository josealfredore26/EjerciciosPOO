package ejercicio3;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Aperturas de Cuentas");
            System.out.println("2. Transferencias");
            System.out.println("3. Cajero Automático");
            System.out.println("4. Cierre de Mes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    abrirCuenta(banco);
                    break;
                case 2:
                    realizarTransferencia(banco);
                    break;
                case 3:
                    cajeroAutomatico(banco);
                    break;
                case 4:
                    cierreDeMes(banco);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 5);
    }

    private static void abrirCuenta(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el documento del cliente: ");
        String documento = scanner.next();
        List<Cuenta> aux = banco.getCuentas().stream().filter(c -> c.getCliente().getDocumento().equals(documento)).collect(Collectors.toList());
        boolean centinela = aux.isEmpty();
        Cliente cliente = null;
        if(centinela == true) {
            scanner.nextLine();
            System.out.print("Ingrese nombres del cliente: ");
            String nombres = scanner.nextLine();
            System.out.print("Ingrese apellidos del cliente: ");
            String apellidos = scanner.nextLine();
            System.out.print("Ingrese edad del cliente: ");
            int edad = scanner.nextInt();

            cliente = new Cliente(nombres, apellidos, edad, documento);
        } else {
            cliente = aux.get(0).getCliente();
        }
        System.out.println("Seleccione tipo de cuenta:");
        System.out.println("1. Cuenta de Ahorro");
        System.out.println("2. Cuenta Corriente");
        int tipoCuenta = scanner.nextInt();
        double deposito = 0;
        do {
            System.out.println("Cuanto desea depositar? El minimo es de 200.000");
            deposito = scanner.nextDouble();
        } while(deposito < 200000);

        banco.abrirCuenta(cliente, tipoCuenta, deposito);
    }

    private static void realizarTransferencia(Banco banco) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su documento: ");
        String documento1 = scanner.next();
        scanner.nextLine();
        System.out.println("Seleccione cuenta para transacción:");
        List<Cuenta> cuentas = banco.getCuentas().stream().filter(c -> c.getCliente().getDocumento().equals(documento1)).collect(Collectors.toList());
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println((i + 1) + ". " + cuentas.get(i).getClass().getSimpleName());
        }
        int opcionCuenta1 = scanner.nextInt();
        //scanner.nextLine();

        System.out.println("Ingrese el numero de documento de quien recibe: ");
        String documento2 = scanner.next();
        scanner.nextLine();
        System.out.println("Seleccione cuenta para transacción:");
        cuentas = banco.getCuentas().stream().filter(c -> c.getCliente().getDocumento().equals(documento2)).collect(Collectors.toList());
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println((i + 1) + ". " + cuentas.get(i).getClass().getSimpleName());
        }
        int opcionCuenta2 = scanner.nextInt();



        System.out.print("Ingrese monto a transferir: ");
        double monto = scanner.nextDouble();

        banco.realizarTransferencia(opcionCuenta1, opcionCuenta2, documento1, documento2, monto);
    }

    private static void cajeroAutomatico(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su documento: ");
        String documento = scanner.next();
        scanner.nextLine();
        System.out.println("Seleccione cuenta para transacción:");
        List<Cuenta> cuentas = banco.getCuentas().stream().filter(c -> c.getCliente().getDocumento().equals(documento)).collect(Collectors.toList());
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println((i + 1) + ". " + cuentas.get(i).getClass().getSimpleName());
        }
        int opcionCuenta = scanner.nextInt();

        System.out.println("Seleccione tipo de transacción:");
        System.out.println("1. Depósito");
        System.out.println("2. Retiro");
        System.out.println("3. Ver saldo");
        int tipoTransaccion = scanner.nextInt();

        if( tipoTransaccion == 3) {
            banco.cajeroAutomatico(opcionCuenta, tipoTransaccion, 0, documento);
        } else {
            System.out.print("Ingrese monto: ");
            double monto = scanner.nextDouble();

            banco.cajeroAutomatico(opcionCuenta, tipoTransaccion, monto, documento);
        }
    }

    private static void cierreDeMes(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su documento: ");
        String documento = scanner.next();
        scanner.nextLine();
        System.out.println("Seleccione cuenta para transacción:");
        List<Cuenta> cuentas = banco.getCuentas().stream().filter(c -> c.getCliente().getDocumento().equals(documento)).collect(Collectors.toList());
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println((i + 1) + ". " + cuentas.get(i).getClass().getSimpleName());
        }
        int opcionCuenta = scanner.nextInt();

        System.out.println(banco.cierreMes(opcionCuenta, documento));
    }

}
