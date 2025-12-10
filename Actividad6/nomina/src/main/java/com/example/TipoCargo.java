package com.example;

//package nomina;

public enum TipoCargo {
    DIRECTIVO("Directivo"),
    ESTRATEGICO("Estratégico"),
    OPERATIVO("Operativo");

    private final String texto;

    TipoCargo(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}

