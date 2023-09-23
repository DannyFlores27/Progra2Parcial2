  import java.util.ArrayList;
import java.util.Scanner;

class Atraccion {
    private String nombre;
    private int capacidad;
    private int boletosVendidos;

    public Atraccion(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.boletosVendidos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public boolean venderBoletos(int cantidad) {
        if (cantidad <= capacidad - boletosVendidos) {
            boletosVendidos += cantidad;
            return true;
        }
        return false;
    }
}
