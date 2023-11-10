package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Amarre> amarres;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.amarres = new ArrayList<>();
    }

    public void agregarAmarre(Amarre amarre) {
        amarres.add(amarre);
    }

    public List<Amarre> getAmarres() {
        return amarres;
    }

    public String generarReciboCompleto() {
        StringBuilder reciboCompleto = new StringBuilder();
        reciboCompleto.append("Recibo completo del cliente ").append(nombre).append(":\n");

        for (Amarre amarre : amarres) {
            reciboCompleto.append(amarre.generarRecibo()).append("\n");
        }

        return reciboCompleto.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

