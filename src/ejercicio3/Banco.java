package ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Banco {
    private List<Cuenta> cuentas;

    private List<Cliente> clientes;

    public Banco() {
        this.cuentas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void abrirCuenta(Cliente cliente, int tipoCuenta, double deposito) {
        if(!clientes.contains(cliente)) clientes.add(cliente);
        if (tipoCuenta == 1) {
            cuentas.add(new CuentaAhorro(cliente, 0.022));
            System.out.println("Cuenta de ahorro creada con éxito.");
            cuentas.get(cuentas.size()-1).depositar(deposito);
        } else if (tipoCuenta == 2) {
            cuentas.add(new CuentaCorriente(cliente, 0.015, 3000));
            System.out.println("Cuenta corriente creada con éxito. " + deposito);
            cuentas.get(cuentas.size()-1).depositar(deposito);
        } else {
            System.out.println("Tipo de cuenta no válido.");
        }
    }

    public void realizarTransferencia(int cuentaOrigenIndex, int cuentaDestinoIndex, String documentoOrigen, String documentoDestino, double monto) {
        Cuenta cuentaOrigen = devolverCuenta(cuentaOrigenIndex, documentoOrigen);
        Cuenta cuentaDestino = devolverCuenta(cuentaDestinoIndex, documentoDestino);

        if (cuentaOrigen.getSaldo() < monto) {
            System.out.println("Saldo insuficiente en la cuenta de origen. Operación cancelada.");
            return;
        }

        cuentaOrigen.retirar(monto, new Random().nextBoolean());
        cuentaDestino.depositar(monto);

        System.out.println("Transferencia realizada con éxito.");
    }

    public void cajeroAutomatico(int opcionCuenta, int tipoTransaccion, double monto, String documento) {
        Cuenta cuentaSeleccionada = devolverCuenta(opcionCuenta, documento);
        System.out.println(cuentaSeleccionada.getCliente().getNombres());

        if (tipoTransaccion == 1) {
            cuentaSeleccionada.depositar(monto);
        } else if (tipoTransaccion == 2) {
            cuentaSeleccionada.retirar(monto, new Random().nextBoolean());
        } else if (tipoTransaccion == 3){
            System.out.println("El saldo de la cuenta es: " + cuentaSeleccionada.getSaldo());
        } else {
            System.out.println("Tipo de transacción no válido.");
        }
    }

    public String cierreMes(int opcionCuenta, String documento) {
        Cuenta cuentaSeleccionada = devolverCuenta(opcionCuenta, documento);
        cuentaSeleccionada.aplicarInteresMensual();
        return "Cierre de mes realizado.\nSaldo Nuevo: " + cuentaSeleccionada.getSaldo();
    }

    public Cuenta devolverCuenta(int opcionCuenta, String documento) {
        List<Cuenta> cuentasAux = cuentas.stream().filter(c -> c.getCliente().getDocumento().equals(documento)).collect(Collectors.toList());
        if (opcionCuenta <= 0 || opcionCuenta > cuentasAux.size()) {
            System.out.println("Cuenta no válida. Operación cancelada.");
            return null;
        }

        Cuenta cuentaSeleccionada = cuentasAux.get(opcionCuenta - 1);
        return cuentaSeleccionada;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
