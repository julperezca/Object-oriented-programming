package com.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Container;

public class VentanaNomina extends JFrame {

    private Container contenedor;
    private ListaEmpleados lista;

    public VentanaNomina(ListaEmpleados lista) {
        this.lista = lista;
        iniciarComponentes();

        setTitle("Nómina de empleados");
        setSize(350, 230);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void iniciarComponentes() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        JLabel lblTitulo = new JLabel("Lista de empleados:");
        lblTitulo.setBounds(20, 10, 200, 23);

        String[][] datos = lista.obtenerMatriz();
        String[] columnas = { "NOMBRE", "APELLIDOS", "SUELDO" };

        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 40, 310, 100);

        double total = lista.calcularTotalNomina();
        JLabel lblTotal = new JLabel(
                "Total nómina mensual = $ " + String.format("%.2f", total));
        lblTotal.setBounds(20, 150, 250, 23);

        contenedor.add(lblTitulo);
        contenedor.add(scroll);
        contenedor.add(lblTotal);
    }
}
