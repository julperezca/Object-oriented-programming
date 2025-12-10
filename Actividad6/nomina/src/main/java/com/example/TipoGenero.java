package com.example;

public enum TipoGenero {
    MASCULINO("Masculino"),
    FEMENINO("Femenino");

    private final String texto;

    TipoGenero(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}
