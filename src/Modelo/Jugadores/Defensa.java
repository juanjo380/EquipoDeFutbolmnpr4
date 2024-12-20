package Modelo.Jugadores;

import Modelo.Jugador;

public class Defensa extends Jugador {
    private int temperamento;

    public Defensa(String nombre, int edad, int arranque, int correr, int resistencia, int dorsal, int temperamento) {
        super(nombre, edad, arranque, correr, resistencia, dorsal);
        this.temperamento = temperamento;
    }

    public int getTemperamento() {
        return temperamento;
    }

    @Override
    public String mostrarHabilidades() {
        return "Edad: " + getEdad() + ", Arranque: " + getArranque() + ", Correr: " + getCorrer() +
               ", Resistencia: " + getResistencia() + ", Temperamento: " + temperamento + ", Dorsal: " + getDorsal();
    }

    public String getGoles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGoles'");
    }
}
