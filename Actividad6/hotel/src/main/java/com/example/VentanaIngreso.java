package com.example;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 * Ventana para registrar el ingreso de un huésped en una habitación.
 */
public class VentanaIngreso extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel lblHabitacion;
    private JLabel lblFechaIngreso;
    private JTextField txtFechaIngreso;
    private JLabel lblHuesped;
    private JLabel lblNombre;
    private JLabel lblApellidos;
    private JLabel lblDocumento;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtDocumento;
    private JButton btnAceptar;
    private JButton btnCancelar;

    private int numeroHabitacion;
    private Hotel hotel;

    public VentanaIngreso(Hotel hotel, int numeroHabitacion) {
        this.hotel = hotel;
        this.numeroHabitacion = numeroHabitacion;
        inicializar();

        setTitle("Ingreso");
        setSize(290, 250);
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
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        contenedor.add(lblHabitacion, c);

        // Fecha de ingreso
        lblFechaIngreso = new JLabel("Fecha (aaaa-mm-dd):");
        c.gridx = 0; c.gridy = 1; c.gridwidth = 1;
        contenedor.add(lblFechaIngreso, c);

        txtFechaIngreso = new JTextField();
        c.gridx = 1; c.gridy = 1;
        contenedor.add(txtFechaIngreso, c);

        // Título huésped
        lblHuesped = new JLabel("Huésped");
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2;
        contenedor.add(lblHuesped, c);

        // Nombre
        lblNombre = new JLabel("Nombre:");
        c.gridx = 0; c.gridy = 3; c.gridwidth = 1;
        contenedor.add(lblNombre, c);

        txtNombre = new JTextField();
        c.gridx = 1; c.gridy = 3;
        contenedor.add(txtNombre, c);

        // Apellidos
        lblApellidos = new JLabel("Apellidos:");
        c.gridx = 0; c.gridy = 4;
        contenedor.add(lblApellidos, c);

        txtApellidos = new JTextField();
        c.gridx = 1; c.gridy = 4;
        contenedor.add(txtApellidos, c);

        // Documento
        lblDocumento = new JLabel("Doc. Identidad:");
        c.gridx = 0; c.gridy = 5;
        contenedor.add(lblDocumento, c);

        txtDocumento = new JTextField();
        c.gridx = 1; c.gridy = 5;
        contenedor.add(txtDocumento, c);

        // Botones
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");

        c.gridx = 0; c.gridy = 6;
        contenedor.add(btnAceptar, c);

        c.gridx = 1; c.gridy = 6;
        contenedor.add(btnCancelar, c);

        btnAceptar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == btnAceptar) {
            registrarIngreso();
        } else if (fuente == btnCancelar) {
            setVisible(false);
        }
    }

    private void registrarIngreso() {
        try {
            String fechaTexto = txtFechaIngreso.getText().trim();
            String nombre = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            String docTexto = txtDocumento.getText().trim();

            if (fechaTexto.isEmpty() || nombre.isEmpty()
                    || apellidos.isEmpty() || docTexto.isEmpty()) {
                throw new IllegalArgumentException("Campos vacíos");
            }

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            formato.setLenient(false);
            Date fecha = formato.parse(fechaTexto);

            int documento = Integer.parseInt(docTexto);

            Habitacion h = hotel.buscarHabitacionPorNumero(numeroHabitacion);
            if (h == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Habitación inexistente",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Huesped huesped = new Huesped(nombre, apellidos, documento);
            huesped.setFechaIngreso(fecha);

            h.setHuesped(huesped);
            h.setDisponible(false);

            JOptionPane.showMessageDialog(
                    this,
                    "El huésped ha sido registrado",
                    "Mensaje",
                    JOptionPane.INFORMATION_MESSAGE
            );

            setVisible(false);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "La fecha no está en el formato solicitado",
                    "Mensaje",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Documento no numérico",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Campo nulo o error en formato",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}

