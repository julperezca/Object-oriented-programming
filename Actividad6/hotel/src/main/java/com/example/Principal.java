package com.example;


/**
 *  *  */
public class Principal {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        VentanaPrincipal v = new VentanaPrincipal(hotel);
        v.setVisible(true);
    }
}

