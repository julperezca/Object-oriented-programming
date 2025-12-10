package com.example;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 * Ventana para registrar la salida de un huésped de una habitación.
 */
public class VentanaSalida extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel lblHabitacion;
    private JLabel lblFechaIngreso;
    private JLabel lblFechaSalida;
    private JTextField txtFechaSalida;
    private JButton btnCalcular;
    private JLabel lblCantidadDias;
    private JLabel lblTotal;
    private JButton btnRegistrarSalida;

    private Hotel hotel;
    private int numeroHabitacion;
    private Habitacion habitacionOcupada;

    public VentanaSalida(Hotel hotel, int numeroHabitacion) {
        this.hotel = hotel;
        this.numeroHabitacion = numeroHabitacion;
        this.habitacionOcupada = hotel.buscarHabitacionPorNumero(numeroHabitacion);

        inicializar();

        setTitle("Salida huéspedes");
        setSize(260, 260);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicializar() {
        contenedor = getContentPane();
        contenedor.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(3, 3, 3, 3);

        // Habitación
        lblHabitacion = new JLabel("Habitación: " + numeroHabitacion);
        c.gridx = 0; c.gridy = 0;
        contenedor.add(lblHabitacion, c);

        // Fecha ingreso (mostrada)
        String fechaIngresoTexto = hotel.obtenerFechaIngresoFormateada(numeroHabitacion);
        lblFechaIngreso = new JLabel("Fecha de ingreso: " + fechaIngresoTexto);
        c.gridx = 0; c.gridy = 1;
        contenedor.add(lblFechaIngreso, c);

        // Fecha salida
        lblFechaSalida = new JLabel("Fecha de salida (aaaa-mm-dd):");
        c.gridx = 0; c.gridy = 2;
        contenedor.add(lblFechaSalida, c);

        txtFechaSalida = new JTextField();
        c.gridx = 0; c.gridy = 3;
        contenedor.add(txtFechaSalida, c);

        // Botón calcular
        btnCalcular = new JButton("Calcular");
        c.gridx = 0; c.gridy = 4;
        contenedor.add(btnCalcular, c);
        btnCalcular.addActionListener(this);

        // Cantidad de días
        lblCantidadDias = new JLabel("Cantidad de días: ");
        c.gridx = 0; c.gridy = 5;
        contenedor.add(lblCantidadDias, c);

        // Total
        lblTotal = new JLabel("Total: $");
        c.gridx = 0; c.gridy = 6;
        contenedor.add(lblTotal, c);

        // Botón registrar salida
        btnRegistrarSalida = new JButton("Registrar salida");
        btnRegistrarSalida.setEnabled(false);
        c.gridx = 0; c.gridy = 7;
        contenedor.add(btnRegistrarSalida, c);
        btnRegistrarSalida.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == btnCalcular) {
            calcularPago();
        } else if (fuente == btnRegistrarSalida) {
            registrarSalida();
        }
    }

    private void calcularPago() {
        try {
            String fechaTexto = txtFechaSalida.getText().trim();
            if (fechaTexto.isEmpty()) {
                throw new IllegalArgumentException("Fecha vacía");
            }

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            formato.setLenient(false);
            Date fechaSalida = formato.parse(fechaTexto);

            if (habitacionOcupada == null ||
                habitacionOcupada.getHuesped() == null ||
                habitacionOcupada.getHuesped().getFechaIngreso() == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "No hay información de ingreso para esta habitación",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Date fechaIngreso = habitacionOcupada.getHuesped().getFechaIngreso();

            if (fechaIngreso.compareTo(fechaSalida) >= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "La fecha de salida es menor o igual que la de ingreso",
                        "Mensaje",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            habitacionOcupada.getHuesped().setFechaSalida(fechaSalida);
            int dias = habitacionOcupada.getHuesped().obtenerDiasAlojamiento();

            lblCantidadDias.setText("Cantidad de días: " + dias);

            double total = dias * habitacionOcupada.getPrecioDia();
            lblTotal.setText("Total: $" + total);

            btnRegistrarSalida.setEnabled(true);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "La fecha no está en el formato solicitado",
                    "Mensaje",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al calcular: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void registrarSalida() {
        habitacionOcupada.setHuesped(null);
        habitacionOcupada.setDisponible(true);

        JOptionPane.showMessageDialog(
                this,
                "Se ha registrado la salida del huésped",
                "Mensaje",
                JOptionPane.INFORMATION_MESSAGE
        );

        setVisible(false);
    }
}

