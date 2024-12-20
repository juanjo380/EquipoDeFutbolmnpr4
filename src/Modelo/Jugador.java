package Modelo;

public class Jugador {
    private String nombre;
    private int edad;
    private int arranque;
    private int correr;
    private int resistencia;
    private int dorsal;

    public Jugador(String nombre, int edad, int arranque, int correr, int resistencia, int dorsal) {
        this.nombre = nombre;
        this.edad = edad;
        this.arranque = arranque;
        this.correr = correr;
        this.resistencia = resistencia;
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getArranque() {
        return arranque;
    }

    public void setArranque(int arranque) {
        this.arranque = arranque;
    }

    public int getCorrer() {
        return correr;
    }

    public void setCorrer(int correr) {
        this.correr = correr;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String mostrarHabilidades() {
        return "Edad: " + edad + ", Arranque: " + arranque + ", Correr: " + correr +
               ", Resistencia: " + resistencia + ", Dorsal: " + dorsal;
    }
}