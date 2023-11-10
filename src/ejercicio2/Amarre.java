package ejercicio2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Amarre {
    private String nombreCliente;
    private int cantidadClientes;
    private Date fechaInicial;
    private Date fechaFinal;
    private int posicion;
    private Barco barco;

    public Amarre(String nombreCliente, int cantidadClientes, String fechaInicial, String fechaFinal, int posicion, Barco barco) throws ParseException {
        this.nombreCliente = nombreCliente;
        this.cantidadClientes = cantidadClientes;
        this.fechaInicial = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicial);
        this.fechaFinal = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFinal);
        this.posicion = posicion;
        this.barco = barco;
    }

    public double calcularCostoAlquiler() {
        long diferenciaEnMillis = fechaFinal.getTime() - fechaInicial.getTime();
        int diasOcupacion = (int) (diferenciaEnMillis / (24 * 60 * 60 * 1000));
        double costoBase = diasOcupacion * 25000.0;

        // Aplicar impuestos (19%)
        double impuestos = costoBase * 0.19;

        return costoBase + impuestos;
    }


    public String generarRecibo() {
        StringBuilder recibo = new StringBuilder();
        recibo.append("Recibo de Alquiler:\n");
        recibo.append("Nombre del Cliente: ").append(nombreCliente).append("\n");
        recibo.append("Cantidad de Clientes: ").append(cantidadClientes).append("\n");
        recibo.append("Fecha Inicial: ").append(new SimpleDateFormat("dd/MM/yyyy").format(fechaInicial)).append("\n");
        recibo.append("Fecha Final: ").append(new SimpleDateFormat("dd/MM/yyyy").format(fechaFinal)).append("\n");
        recibo.append("Posición del Amarre: ").append(posicion).append("\n");
        recibo.append("Datos del Barco:\n");
        recibo.append("Matrícula: ").append(barco.getMatricula()).append("\n");
        recibo.append("Eslora: ").append(barco.getEslora()).append(" metros\n");
        recibo.append("Año de Fabricación: ").append(barco.getAnoFabricacion()).append("\n");
        recibo.append("Costo Total del Alquiler: $").append(calcularCostoAlquiler()).append("\n");

        return recibo.toString();
    }
}
