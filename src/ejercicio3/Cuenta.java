package ejercicio3;

public abstract class Cuenta {
    protected Cliente cliente;
    protected double saldo;

    public Cuenta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0;
    }

    public abstract void depositar(double monto);

    public abstract void retirar(double monto, boolean retiroEnCajeroDelBanco);

    public abstract void aplicarInteresMensual();

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

