package com.example;


import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregarEmpleado extends JFrame implements ActionListener {

    private Container contenedor;
    private ListaEmpleados lista;

    private JLabel lblNombre, lblApellidos, lblCargo, lblGenero,
                   lblSalarioDia, lblDias, lblOtros, lblSalud, lblPension;

    private JTextField txtNombre, txtApellidos, txtSalarioDia,
                       txtOtros, txtSalud, txtPension;

    private JComboBox<String> comboCargo;
    private JRadioButton rbMasculino, rbFemenino;
    private ButtonGroup grupoGenero;

    private JSpinner spDias;
    private JButton btnAgregar, btnLimpiar;

    public VentanaAgregarEmpleado(ListaEmpleados lista) {
        this.lista = lista;
        iniciarComponentes();

        setTitle("Agregar Empleado");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void iniciarComponentes() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        // Nombre
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 135, 23);
        txtNombre = new JTextField();
        txtNombre.setBounds(160, 20, 100, 23);

        // Apellidos
        lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(20, 50, 135, 23);
        txtApellidos = new JTextField();
        txtApellidos.setBounds(160, 50, 100, 23);

        // Cargo
        lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(20, 80, 135, 23);
        comboCargo = new JComboBox<>(new String[] {
                "Directivo", "Estratégico", "Operativo"
        });
        comboCargo.setBounds(160, 80, 100, 23);

        // Género
        lblGenero = new JLabel("Género:");
        lblGenero.setBounds(20, 110, 100, 23);
        rbMasculino = new JRadioButton("Masculino", true);
        rbMasculino.setBounds(160, 110, 100, 23);
        rbFemenino = new JRadioButton("Femenino");
        rbFemenino.setBounds(160, 135, 100, 23);
        grupoGenero = new ButtonGroup();
        grupoGenero.add(rbMasculino);
        grupoGenero.add(rbFemenino);

        // Salario por día
        lblSalarioDia = new JLabel("Salario por día:");
        lblSalarioDia.setBounds(20, 170, 135, 23);
        txtSalarioDia = new JTextField();
        txtSalarioDia.setBounds(160, 170, 100, 23);

        // Días trabajados (spinner 1..31)
        lblDias = new JLabel("Días trabajados:");
        lblDias.setBounds(20, 200, 135, 23);
        spDias = new JSpinner(new SpinnerNumberModel(30, 1, 31, 1));
        spDias.setBounds(160, 200, 50, 23);

        // Otros ingresos
        lblOtros = new JLabel("Otros ingresos:");
        lblOtros.setBounds(20, 230, 135, 23);
        txtOtros = new JTextField();
        txtOtros.setBounds(160, 230, 100, 23);

        // Pagos salud
        lblSalud = new JLabel("Pagos por salud:");
        lblSalud.setBounds(20, 260, 135, 23);
        txtSalud = new JTextField();
        txtSalud.setBounds(160, 260, 100, 23);

        // Aporte pensión
        lblPension = new JLabel("Aportes pensiones:");
        lblPension.setBounds(20, 290, 135, 23);
        txtPension = new JTextField();
        txtPension.setBounds(160, 290, 100, 23);

        // Botones
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(20, 320, 100, 23);
        btnAgregar.addActionListener(this);

        btnLimpiar = new JButton("Borrar");
        btnLimpiar.setBounds(160, 320, 80, 23);
        btnLimpiar.addActionListener(this);

        // Añadir al contenedor
        contenedor.add(lblNombre);
        contenedor.add(txtNombre);
        contenedor.add(lblApellidos);
        contenedor.add(txtApellidos);
        contenedor.add(lblCargo);
        contenedor.add(comboCargo);
        contenedor.add(lblGenero);
        contenedor.add(rbMasculino);
        contenedor.add(rbFemenino);
        contenedor.add(lblSalarioDia);
        contenedor.add(txtSalarioDia);
        contenedor.add(lblDias);
        contenedor.add(spDias);
        contenedor.add(lblOtros);
        contenedor.add(txtOtros);
        contenedor.add(lblSalud);
        contenedor.add(txtSalud);
        contenedor.add(lblPension);
        contenedor.add(txtPension);
        contenedor.add(btnAgregar);
        contenedor.add(btnLimpiar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();
        if (fuente == btnAgregar) {
            agregarEmpleado();
        } else if (fuente == btnLimpiar) {
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtSalarioDia.setText("");
        spDias.setValue(30);
        txtOtros.setText("");
        txtSalud.setText("");
        txtPension.setText("");
        rbMasculino.setSelected(true);
    }

    private void agregarEmpleado() {
        try {
            String nombre = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();

            if (nombre.isEmpty() || apellidos.isEmpty()) {
                throw new IllegalArgumentException("Nombre o apellidos vacíos");
            }

            String cargoSel = (String) comboCargo.getSelectedItem();
            TipoCargo cargo;
            if ("Directivo".equals(cargoSel)) {
                cargo = TipoCargo.DIRECTIVO;
            } else if ("Estratégico".equals(cargoSel)) {
                cargo = TipoCargo.ESTRATEGICO;
            } else {
                cargo = TipoCargo.OPERATIVO;
            }

            TipoGenero genero = rbMasculino.isSelected()
                    ? TipoGenero.MASCULINO
                    : TipoGenero.FEMENINO;

            double salarioDia = Double.parseDouble(txtSalarioDia.getText().trim());
            int dias = (Integer) spDias.getValue();

            double otros = txtOtros.getText().trim().isEmpty()
                    ? 0.0
                    : Double.parseDouble(txtOtros.getText().trim());
            double salud = txtSalud.getText().trim().isEmpty()
                    ? 0.0
                    : Double.parseDouble(txtSalud.getText().trim());
            double pension = txtPension.getText().trim().isEmpty()
                    ? 0.0
                    : Double.parseDouble(txtPension.getText().trim());

            Empleado emp = new Empleado(
                    nombre,
                    apellidos,
                    cargo,
                    genero,
                    salarioDia,
                    dias,
                    otros,
                    salud,
                    pension
            );

            lista.agregarEmpleado(emp);

            JOptionPane.showMessageDialog(this,
                    "Empleado agregado correctamente.",
                    "Mensaje",
                    JOptionPane.INFORMATION_MESSAGE);

            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error en el formato de números.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

