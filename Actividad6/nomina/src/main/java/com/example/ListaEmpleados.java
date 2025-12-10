package com.example;

//package nomina;

import java.util.ArrayList;
import java.util.List;

public class ListaEmpleados {

    private List<Empleado> lista;

    public ListaEmpleados() {
        lista = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        lista.add(e);
    }

    public List<Empleado> getLista() {
        return lista;
    }

    public double calcularTotalNomina() {
        double total = 0.0;
        for (Empleado e : lista) {
            total += e.calcularNomina();
        }
        return total;
    }

    /**
     * Matriz para alimentar la JTable:
     * columnas: 0 -> nombre, 1 -> apellidos, 2 -> sueldo
     */
    public String[][] obtenerMatriz() {
        String[][] datos = new String[lista.size()][3];
        for (int i = 0; i < lista.size(); i++) {
            Empleado e = lista.get(i);
            datos[i][0] = e.getNombre();
            datos[i][1] = e.getApellidos();
            datos[i][2] = String.format("%.2f", e.calcularNomina());
        }
        return datos;
    }

    /**
     * Texto para guardar en Nomina.txt
     */
    public String convertirTexto() {
        StringBuilder sb = new StringBuilder();
        for (Empleado e : lista) {
            sb.append("Nombre = ").append(e.getNombre()).append("\n");
            sb.append("Apellidos = ").append(e.getApellidos()).append("\n");
            sb.append("Cargo = ").append(e.getCargo()).append("\n");
            sb.append("Género = ").append(e.getGenero()).append("\n");
            sb.append("Salario por día = $").append(e.getSalarioDia()).append("\n");
            sb.append("Días trabajados = ").append(e.getDiasTrabajados()).append("\n");
            sb.append("Otros ingresos = $").append(e.getOtrosIngresos()).append("\n");
            sb.append("Pagos por salud = $").append(e.getPagosSalud()).append("\n");
            sb.append("Aporte pensiones = $").append(e.getAportePensiones()).append("\n");
            sb.append("---------\n");
        }
        sb.append("Total nómina = $")
          .append(String.format("%.2f", calcularTotalNomina()));
        return sb.toString();
    }
}

