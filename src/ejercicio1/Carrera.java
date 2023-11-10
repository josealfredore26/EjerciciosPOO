package ejercicio1;

public class Carrera {
    private String nombre;
    private double costoCredito;
    private int semestreAumento;

    public Carrera(String nombre, double costoCredito, int semestreAumento) {
        this.nombre = nombre;
        this.costoCredito = costoCredito;
        this.semestreAumento = semestreAumento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCostoCredito() {
        return costoCredito;
    }

    public int getSemestreAumento() {
        return semestreAumento;
    }
}

