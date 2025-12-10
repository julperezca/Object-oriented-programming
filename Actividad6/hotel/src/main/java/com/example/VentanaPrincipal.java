package com.example;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Ventana principal: menú con "Consultar habitaciones" y "Salida de huéspedes".
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private Container contenedor;
    private JMenuBar barraMenu;
    private JMenu menuOpciones;
    private JMenuItem itemConsultar;
    private JMenuItem itemSalida;

    private Hotel hotel;

    public VentanaPrincipal(Hotel hotel) {
        this.hotel = hotel;
        inicializar();

        setTitle("Hotel");
        setSize(280, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicializar() {
        contenedor = getContentPane();
        contenedor.setLayout(null);  // siguiendo el planteamiento del libro

        barraMenu = new JMenuBar();
        menuOpciones = new JMenu("Menú");
        itemConsultar = new JMenuItem("Consultar habitaciones");
        itemSalida = new JMenuItem("Salida de huéspedes");

        menuOpciones.add(itemConsultar);
        menuOpciones.add(itemSalida);

        barraMenu.add(menuOpciones);
        setJMenuBar(barraMenu);

        itemConsultar.addActionListener(this);
        itemSalida.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == itemConsultar) {
            VentanaHabitaciones v = new VentanaHabitaciones(hotel);
            v.setVisible(true);
        }

        if (fuente == itemSalida) {
            gestionarSalidaHuesped();
        }
    }

    private void gestionarSalidaHuesped() {
        try {
            String texto = JOptionPane.showInputDialog(
                    this,
                    "Ingrese número de habitación",
                    "Salida de huéspedes",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (texto == null) {
                return; // Cancelar
            }

            int numero = Integer.parseInt(texto);

            if (numero < 1 || numero > 10) {
                JOptionPane.showMessageDialog(
                        this,
                        "El número de habitación debe estar entre 1 y 10",
                        "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else if (hotel.estaHabitacionOcupada(numero)) {
                VentanaSalida vs = new VentanaSalida(hotel, numero);
                vs.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "La habitación ingresada no ha sido ocupada",
                        "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Campo nulo o error en formato de número",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}

