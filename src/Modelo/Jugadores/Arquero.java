package Modelo.Jugadores;

import Modelo.Jugador;

public class Arquero extends Jugador {
    private int atajadas;

    public Arquero(String nombre, int edad, int arranque, int correr, int resistencia, int dorsal, int atajadas) {
        super(nombre, edad, arranque, correr, resistencia, dorsal);
        this.atajadas = atajadas;
    }

    public int getAtajadas() {
        return atajadas;
    }

    @Override
    public String mostrarHabilidades() {
        return "Edad: " + getEdad() + ", Arranque: " + getArranque() + ", Correr: " + getCorrer() +
               ", Resistencia: " + getResistencia() + ", Atajadas: " + atajadas + ", Dorsal: " + getDorsal();
    }

    public String getGoles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGoles'");
    }
}
