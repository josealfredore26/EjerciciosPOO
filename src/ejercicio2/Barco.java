package ejercicio2;

public class Barco {
    private String matricula;
    private double eslora;
    private int anoFabricacion;

    public Barco(String matricula, double eslora, int anoFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anoFabricacion = anoFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getEslora() {
        return eslora;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }
}

