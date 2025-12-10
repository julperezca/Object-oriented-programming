package com.example;

//package nomina;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private Container contenedor;
    private ListaEmpleados empleados;

    private JMenuBar barraMenu;
    private JMenu menuOpciones;
    private JMenuItem itemAgregar;
    private JMenuItem itemCalcular;
    private JMenuItem itemGuardar;

    public VentanaPrincipal() {
        empleados = new ListaEmpleados();
        iniciarComponentes();

        setTitle("Nómina");
        setSize(280, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void iniciarComponentes() {
        contenedor = getContentPane();
        contenedor.setLayout(null); // usaremos posiciones absolutas

        barraMenu = new JMenuBar();
        menuOpciones = new JMenu("Menú");

        itemAgregar = new JMenuItem("Agregar empleado");
        itemCalcular = new JMenuItem("Calcular nómina");
        itemGuardar = new JMenuItem("Guardar archivo");

        menuOpciones.add(itemAgregar);
        menuOpciones.add(itemCalcular);
        menuOpciones.add(new JSeparator());
        menuOpciones.add(itemGuardar);

        barraMenu.add(menuOpciones);
        setJMenuBar(barraMenu);

        itemAgregar.addActionListener(this);
        itemCalcular.addActionListener(this);
        itemGuardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == itemAgregar) {
            VentanaAgregarEmpleado v = new VentanaAgregarEmpleado(empleados);
            v.setVisible(true);
        }

        if (fuente == itemCalcular) {
            if (empleados.getLista().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay empleados registrados.",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            VentanaNomina v = new VentanaNomina(empleados);
            v.setVisible(true);
        }

        if (fuente == itemGuardar) {
            if (empleados.getLista().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay empleados para guardar.",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            guardarArchivo();
        }
    }

    private void guardarArchivo() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int respuesta = fc.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File directorio = fc.getSelectedFile();
            File archivo = new File(directorio, "Nomina.txt");

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                bw.write(empleados.convertirTexto());
                JOptionPane.showMessageDialog(this,
                        "El archivo Nomina.txt se creó en:\n" + archivo.getAbsolutePath(),
                        "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Error al guardar el archivo:\n" + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

