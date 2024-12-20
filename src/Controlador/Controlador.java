package Controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.Jugador;
import Modelo.Jugadores.Arquero;
import Modelo.Jugadores.Defensa;
import Modelo.Jugadores.Delantero;
import Modelo.Jugadores.Mediocampista;

public class Controlador {
    private List<Jugador> jugadores;
    private DefaultListModel<String> listModel;
    private JList<String> jList;
    private DefaultTableModel tableModel;

    // Constructor that accepts JList and DefaultTableModel
    public Controlador(JList<String> jList, DefaultTableModel tableModel) {
        jugadores = new ArrayList<>();
        listModel = new DefaultListModel<>();
        this.jList = jList;
        this.jList.setModel(listModel); // Assign the model to the JList
        this.tableModel = tableModel;
    }

    public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Choose the type of player
        String[] opciones = { "Arquero", "Defensa", "Delantero", "Mediocampista" };
        String tipoJugador = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de jugador:",
                "Tipo de Jugador", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (tipoJugador == null) {
            return; // User canceled
        }

        // Ask for common player data
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se agregó el jugador, nombre inválido.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int edad = parseEntero(JOptionPane.showInputDialog(null, "Ingrese la edad del jugador:"));
        int arranque = parseEntero(JOptionPane.showInputDialog(null, "Ingrese la habilidad de arranque:"));
        int correr = parseEntero(JOptionPane.showInputDialog(null, "Ingrese la habilidad de correr:"));
        int resistencia = parseEntero(JOptionPane.showInputDialog(null, "Ingrese la resistencia:"));
        int dorsal = parseEntero(JOptionPane.showInputDialog(null, "Ingrese el número de dorsal:"));

        // Create the specific player based on the selected type
        Jugador nuevoJugador = null;

        switch (tipoJugador) {
            case "Arquero":
                int atajadas = parseEntero(JOptionPane.showInputDialog(null, "Ingrese la cantidad de atajadas:"));
                nuevoJugador = new Arquero(nombre, edad, arranque, correr, resistencia, dorsal, atajadas);
                break;

            case "Defensa":
                int temperamento = parseEntero(JOptionPane.showInputDialog(null, "Ingrese el nivel de temperamento:"));
                nuevoJugador = new Defensa(nombre, edad, arranque, correr, resistencia, dorsal, temperamento);
                break;

            case "Delantero":
                int efectividadGoles = parseEntero(JOptionPane.showInputDialog(null, "Ingrese la efectividad de goles:"));
                nuevoJugador = new Delantero(nombre, edad, arranque, correr, resistencia, dorsal, efectividadGoles);
                break;

            case "Mediocampista":
                int precisionPase = parseEntero(JOptionPane.showInputDialog(null, "Ingrese la precisión de pase:"));
                nuevoJugador = new Mediocampista(nombre, edad, arranque, correr, resistencia, dorsal, precisionPase);
                break;
        }

        if (nuevoJugador != null) {
            jugadores.add(nuevoJugador);
            actualizarListaJugadores();
            JOptionPane.showMessageDialog(null, "Jugador agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void jButton2ActionPerformed(ActionEvent evt) {
        String dorsal = JOptionPane.showInputDialog(null, "Ingrese el dorsal del jugador a cambiar:");
        if (dorsal == null || dorsal.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dorsal inválido o vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int dorsalBuscado = parseEntero(dorsal);
        Jugador jugadorEncontrado = null;

        for (Jugador jugador : jugadores) {
            if (jugador.getDorsal() == dorsalBuscado) {
                jugadorEncontrado = jugador;
                break;
            }
        }

        if (jugadorEncontrado != null) {
            String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre:", jugadorEncontrado.getNombre());
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                jugadorEncontrado.setNombre(nuevoNombre);
            }

            jugadorEncontrado.setEdad(parseEntero(JOptionPane.showInputDialog(null, "Ingrese la nueva edad:", jugadorEncontrado.getEdad())));
            jugadorEncontrado.setArranque(parseEntero(JOptionPane.showInputDialog(null, "Ingrese la nueva habilidad de arranque:", jugadorEncontrado.getArranque())));
            jugadorEncontrado.setCorrer(parseEntero(JOptionPane.showInputDialog(null, "Ingrese la nueva habilidad de correr:", jugadorEncontrado.getCorrer())));
            jugadorEncontrado.setResistencia(parseEntero(JOptionPane.showInputDialog(null, "Ingrese la nueva resistencia:", jugadorEncontrado.getResistencia())));
            jugadorEncontrado.setDorsal(parseEntero(JOptionPane.showInputDialog(null, "Ingrese el nuevo número de dorsal:", jugadorEncontrado.getDorsal())));

            actualizarListaJugadores();
            JOptionPane.showMessageDialog(null, "Jugador actualizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún jugador con el dorsal " + dorsalBuscado, "Jugador No Encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void jButton3ActionPerformed(ActionEvent evt) {
        String busqueda = JOptionPane.showInputDialog(null, "Ingrese el dorsal del jugador a buscar:");
        if (busqueda == null || busqueda.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un dorsal válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int dorsalBuscado = parseEntero(busqueda);
        Jugador jugadorEncontrado = null;

        for (Jugador jugador : jugadores) {
     
           if (jugador.getDorsal() == dorsalBuscado) {
                jugadorEncontrado = jugador;
                break;
            }
        }

        if (jugadorEncontrado != null) {
            JOptionPane.showMessageDialog(null, "Jugador encontrado: " + jugadorEncontrado.getNombre(), "Jugador Encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún jugador con el dorsal " + dorsalBuscado, "Jugador No Encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        int index = jList.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un jugador para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este jugador?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            jugadores.remove(index); // Remove from the internal list
            actualizarListaJugadores(); // Update the graphical list
            JOptionPane.showMessageDialog(null, "Jugador eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        int index = jList.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un jugador para añadir a los 11.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String jugador = jList.getSelectedValue();
        tableModel.addRow(new Object[]{jugador, "Posición", "Titular", "Suplente", "Faltas"});
    }

    public void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tableModel.getRowCount();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un jugador en la tabla para cambiar su estado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    public void guardarJugadoresEnArchivo(String filePath) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            for (Jugador jugador : jugadores) {
                writer.write(jugador.toString() + System.lineSeparator());
            }
            JOptionPane.showMessageDialog(null, "Jugadores guardados en el archivo con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (java.io.IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarListaJugadores() {
        listModel.clear();
        for (Jugador jugador : jugadores) {
            listModel.addElement(jugador.getNombre() + " - " + jugador.mostrarHabilidades());
        }
    }

    private int parseEntero(String valor) {
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            return 0; // Default value if invalid
        }
    }
}