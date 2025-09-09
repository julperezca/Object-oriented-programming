package Actividad_1;

import Actividad_1.clases.calculos;

public class ejercicio4 {
    public static void main(String[] args) {
        int edad_juan = 9;
        double edad_alberto = calculos.edad_alberto(edad_juan);
        double edad_ana = calculos.edad_ana(edad_juan);
        double edad_madre = calculos.edad_madre(edad_juan, edad_ana, edad_alberto);

        System.out.println("Edad de Juan: " + edad_juan);
        System.out.println("Edad de Alberto: " + edad_alberto);
        System.out.println("Edad de Ana: " + edad_ana);
        System.out.println("Edad de la madre: " + edad_madre);
    }
}
