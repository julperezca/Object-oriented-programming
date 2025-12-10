package com.example;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.SpinnerNumberModel;

/**
 * Ventana que muestra las 10 habitaciones y su disponibilidad,
 * y permite elegir una habitación para ocuparla.
 */
public class VentanaHabitaciones extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel[] etiquetasHabitacion;
    private JLabel[] etiquetasEstado;

    private JLabel lblSeleccion;
    private JSpinner spinnerNumero;
    private JButton btnAceptar;

    private Hotel hotel;

    public VentanaHabitaciones(Hotel hotel) {
        this.hotel = hotel;
        inicializar();

        setTitle("Habitaciones");
        setSize(760, 260);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicializar() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        etiquetasHabitacion = new JLabel[10];
        etiquetasEstado = new JLabel[10];

        // Dos filas de 5 habitaciones
        for (int i = 0; i < 10; i++) {
            int numero = i + 1;

            int fila = i / 5;    // 0 o 1
            int col = i % 5;     // 0..4

            int xBase = 20 + col * 140;
            int yTitulo = (fila == 0) ? 30 : 120;
            int yEstado = (fila == 0) ? 50 : 140;

            JLabel lblHab = new JLabel("Habitación " + numero);
            lblHab.setBounds(xBase, yTitulo, 130, 23);

            JLabel lblDisp = new JLabel();
            Habitacion h = hotel.getListaHabitaciones().get(i);
            lblDisp.setText(h.isDisponible() ? "Disponible" : "No disponible");
            lblDisp.setBounds(xBase, yEstado, 100, 23);

            etiquetasHabitacion[i] = lblHab;
            etiquetasEstado[i] = lblDisp;

            contenedor.add(lblHab);
            contenedor.add(lblDisp);
        }

        lblSeleccion = new JLabel("Habitación a reservar:");
        lblSeleccion.setBounds(250, 180, 135, 23);
        contenedor.add(lblSeleccion);

        SpinnerNumberModel modelo = new SpinnerNumberModel(1, 1, 10, 1);
        spinnerNumero = new JSpinner(modelo);
        spinnerNumero.setBounds(380, 180, 40, 23);
        contenedor.add(spinnerNumero);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(500, 180, 100, 23);
        btnAceptar.addActionListener(this);
        contenedor.add(btnAceptar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            int numero = (int) spinnerNumero.getValue();

            if (!hotel.estaHabitacionOcupada(numero)) {
                VentanaIngreso vi = new VentanaIngreso(hotel, numero);
                this.setVisible(false);
                vi.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "La habitación está ocupada",
                        "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }
}

