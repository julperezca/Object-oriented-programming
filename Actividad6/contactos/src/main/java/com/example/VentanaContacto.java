package com.example;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

/**
 * formulario de contacto + lista de contactos a la derecha.
 */
public class VentanaContacto extends JFrame {

    // Etiquetas
    private JLabel lblNombres       = new JLabel("Nombres:");
    private JLabel lblApellidos     = new JLabel("Apellidos:");
    private JLabel lblFechaNac      = new JLabel("Fecha nacimiento:");
    private JLabel lblDireccion     = new JLabel("Dirección:");
    private JLabel lblTelefono      = new JLabel("Teléfono:");
    private JLabel lblCorreo        = new JLabel("Correo:");

    // Campos de texto
    private JTextField txtNombres   = new JTextField();
    private JTextField txtApellidos = new JTextField();
    private JTextField txtFechaNac  = new JTextField();  // ej: 2000-01-01
    private JTextField txtDireccion = new JTextField();
    private JTextField txtTelefono  = new JTextField();
    private JTextField txtCorreo    = new JTextField();

    // Lista gráfica
    private DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private JList<String> lista = new JList<>(modeloLista);

    // Botón
    private JButton btnAgregar = new JButton("Agregar");

    // Lista
    private ListaContactos listaContactos = new ListaContactos();

    public VentanaContacto() {
        setTitle("Detalles del contacto");
        setSize(650, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        Container contenedor = getContentPane();
        contenedor.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Columna 0: etiquetas
        c.gridx = 0; c.gridy = 0;
        contenedor.add(lblNombres, c);
        c.gridy = 1;
        contenedor.add(lblApellidos, c);
        c.gridy = 2;
        contenedor.add(lblFechaNac, c);
        c.gridy = 3;
        contenedor.add(lblDireccion, c);
        c.gridy = 4;
        contenedor.add(lblTelefono, c);
        c.gridy = 5;
        contenedor.add(lblCorreo, c);

        // Columna 1: campos
        c.gridx = 1; c.gridy = 0; c.weightx = 0.5;
        contenedor.add(txtNombres, c);
        c.gridy = 1;
        contenedor.add(txtApellidos, c);
        c.gridy = 2;
        contenedor.add(txtFechaNac, c);
        c.gridy = 3;
        contenedor.add(txtDireccion, c);
        c.gridy = 4;
        contenedor.add(txtTelefono, c);
        c.gridy = 5;
        contenedor.add(txtCorreo, c);

        //  Agregar 
        c.gridx = 0; c.gridy = 6; c.gridwidth = 2;
        contenedor.add(btnAgregar, c);

        // lista con scroll
        JScrollPane scroll = new JScrollPane(lista);
        c.gridx = 2; c.gridy = 0; c.gridwidth = 1; c.gridheight = 7;
        c.weightx = 0.5; c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        contenedor.add(scroll, c);

        // boton
        btnAgregar.addActionListener(e -> agregarContacto());
    }

    private void agregarContacto() {
        String a = txtNombres.getText().trim();
        String b = txtApellidos.getText().trim();
        String c = txtFechaNac.getText().trim();
        String d = txtDireccion.getText().trim();
        String e = txtTelefono.getText().trim();
        String f = txtCorreo.getText().trim();

        // Validar campos vacíos 
        if (a.isEmpty() || b.isEmpty() || c.isEmpty()
                || d.isEmpty() || e.isEmpty() || f.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se permiten campos vacíos",
                    "Mensaje",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        // Crear contacto y almacenar 
        Contacto contacto = new Contacto(a, b, c, d, e, f);
        listaContactos.agregarContacto(contacto);

        // Representación en la lista gráfica
        String data = a + " - " + b + " - " + c + " - "
                    + d + " - " + e + " - " + f;
        modeloLista.addElement(data);

        // Limpiar campos
        txtNombres.setText("");
        txtApellidos.setText("");
        txtFechaNac.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaContacto v = new VentanaContacto();
            v.setVisible(true);
        });
    }
}
