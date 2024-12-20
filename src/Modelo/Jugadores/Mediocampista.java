package Modelo.Jugadores;

import Modelo.Jugador;

public class Mediocampista extends Jugador {
    private int precisionPase;

    public Mediocampista(String nombre, int edad, int arranque, int correr, int resistencia, int dorsal, int precisionPase) {
        super(nombre, edad, arranque, correr, resistencia, dorsal);
        this.precisionPase = precisionPase;
    }

    public int getPrecisionPase() {
        return precisionPase;
    }

    @Override
    public String mostrarHabilidades() {
        return "Edad: " + getEdad() + ", Arranque: " + getArranque() + ", Correr: " + getCorrer() +
               ", Resistencia: " + getResistencia() + ", Precisión de Pase: " + precisionPase + ", Dorsal: " + getDorsal();
    }

    public String getGoles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGoles'");
    }
}
