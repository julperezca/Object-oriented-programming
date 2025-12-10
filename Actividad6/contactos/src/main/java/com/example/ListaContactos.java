package com.example;

import java.util.Vector;

public class ListaContactos {

    private Vector<Contacto> lista;

    public ListaContactos() {
        lista = new Vector<Contacto>();
    }

    public void agregarContacto(Contacto contacto) {
        lista.add(contacto);
    }

    public Vector<Contacto> getLista() {
        return lista;
    }
}
