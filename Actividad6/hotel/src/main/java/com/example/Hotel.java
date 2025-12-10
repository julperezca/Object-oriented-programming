package com.example;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Modelo de un hotel con 10 habitaciones.
 */
public class Hotel {

    private List<Habitacion> listaHabitaciones;

    public Hotel() {
        listaHabitaciones = new ArrayList<>();

        // Habitaciones 1 a 5 -> 120000, 6 a 10 -> 160000
        for (int i = 1; i <= 10; i++) {
            double precio = (i <= 5) ? 120000.0 : 160000.0;
            listaHabitaciones.add(new Habitacion(i, true, precio));
        }
    }

    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public Habitacion buscarHabitacionPorNumero(int numero) {
        for (Habitacion h : listaHabitaciones) {
            if (h.getNumeroHabitacion() == numero) {
                return h;
            }
        }
        return null;
    }

    /**
     * ¿La habitación está ocupada?
     */
    public boolean estaHabitacionOcupada(int numero) {
        Habitacion h = buscarHabitacionPorNumero(numero);
        return h != null && !h.isDisponible();
    }

    /**
     * Devuelve la fecha de ingreso en formato yyyy-MM-dd para mostrar en la GUI.
     */
    public String obtenerFechaIngresoFormateada(int numero) {
        Habitacion h = buscarHabitacionPorNumero(numero);
        if (h == null || h.getHuesped() == null ||
            h.getHuesped().getFechaIngreso() == null) {
            return "";
        }
        Date fecha = h.getHuesped().getFechaIngreso();
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(fecha);
    }
}
