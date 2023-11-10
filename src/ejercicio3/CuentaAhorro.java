package ejercicio3;

public class CuentaAhorro extends Cuenta {
    private double tasaRendimiento;

    public CuentaAhorro(Cliente cliente, double tasaRendimiento) {
        super(cliente);
        this.tasaRendimiento = tasaRendimiento;
    }

    @Override
    public void depositar(double monto) {
        double comision = calcularComisionDeposito(monto);
        saldo += monto - comision;
        System.out.println("Depósito en cuenta de ahorro realizado. Comisión: " + comision);
    }

    @Override
    public void retirar(double monto) {
        saldo -= monto;
        System.out.println("Retiro de cuenta de ahorro realizado.");
    }

    @Override
    public void aplicarInteresMensual() {
        saldo += saldo * (tasaRendimiento / 12);
        System.out.println("Interés mensual aplicado en cuenta de ahorro.");
    }

    private double calcularComisionDeposito(double monto) {
        if (monto >= 500000 && monto < 2000000) {
            return 3000 + (monto * 0.01);
        } else if (monto >= 2000000 && monto <= 10000000) {
            return 2000 + (monto * 0.005);
        } else if (monto > 10000000 && monto < 100000000) {
            return monto * 0.018;
        } else if (monto >= 100000000) {
            return monto * 0.02;
        } else {
            return 0;
        }
    }
}
