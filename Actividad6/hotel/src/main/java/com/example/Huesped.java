package com.example;


import java.util.Date;

/**
 * Modelo de un huésped del hotel.
 */
public class Huesped {

    private String nombres;
    private String apellidos;
    private int documentoIdentidad;
    private Date fechaIngreso;
    private Date fechaSalida;

    public Huesped(String nombres, String apellidos, int documentoIdentidad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Calcula la cantidad de días entre fechaIngreso y fechaSalida.
     */
    public int obtenerDiasAlojamiento() {
        if (fechaIngreso == null || fechaSalida == null) {
            return 0;
        }
        long milis = fechaSalida.getTime() - fechaIngreso.getTime();
        return (int) (milis / (1000L * 60L * 60L * 24L));
    }
}

