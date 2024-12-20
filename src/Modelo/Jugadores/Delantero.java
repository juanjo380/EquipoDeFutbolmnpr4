package Modelo.Jugadores;

import Modelo.Jugador;

public class Delantero extends Jugador {
    private int efectividadGoles;

    public Delantero(String nombre, int edad, int arranque, int correr, int resistencia, int dorsal, int efectividadGoles) {
        super(nombre, edad, arranque, correr, resistencia, dorsal);
        this.efectividadGoles = efectividadGoles;
    }

    public int getEfectividadGoles() {
        return efectividadGoles;
    }

    @Override
    public String mostrarHabilidades() {
        return "Edad: " + getEdad() + ", Arranque: " + getArranque() + ", Correr: " + getCorrer() +
               ", Resistencia: " + getResistencia() + ", Efectividad Goles: " + efectividadGoles + ", Dorsal: " + getDorsal();
    }

    public String getGoles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGoles'");
    }
}
