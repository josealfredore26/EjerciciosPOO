package ejercicio3;

public class CuentaCorriente extends Cuenta {
    private double tasaMantenimiento;
    private double comisionCheque;

    public CuentaCorriente(Cliente cliente, double tasaMantenimiento, double comisionCheque) {
        super(cliente);
        this.tasaMantenimiento = tasaMantenimiento;
        this.comisionCheque = comisionCheque;
    }

    @Override
    public void depositar(double monto) {
        double comision = calcularComisionDeposito(monto);
        saldo += monto - comision;
        System.out.println("Depósito en cuenta corriente realizado. Comisión: " + comision);
    }

    @Override
    public void retirar(double monto, boolean retiroEnCajeroDelBanco) {
        saldo -= (monto + comisionCheque);
        if(retiroEnCajeroDelBanco) {
            saldo -= 4500;
            System.out.println("Se realizo cobro por retiro en cajero externo al banco.");
        }
        System.out.println("Retiro de cuenta corriente realizado. Comisión de cheque: " + comisionCheque);
    }

    @Override
    public void aplicarInteresMensual() {
        saldo -= saldo * tasaMantenimiento;
        System.out.println("Tasa de mantenimiento mensual aplicada en cuenta corriente.");
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
