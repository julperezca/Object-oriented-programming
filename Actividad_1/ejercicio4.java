package Actividad_1;

import Actividad_1.clases.calculo_edades;

public class ejercicio4 {
    public static void main(String[] args) {
        int edad_juan = 9;
        double edad_alberto = calculo_edades.edad_alberto(edad_juan);
        double edad_ana = calculo_edades.edad_ana(edad_juan);
        double edad_madre = calculo_edades.edad_madre(edad_juan, edad_ana, edad_alberto);

        System.out.println("Edad de Juan: " + edad_juan);
        System.out.println("Edad de Alberto: " + edad_alberto);
        System.out.println("Edad de Ana: " + edad_ana);
        System.out.println("Edad de la madre: " + edad_madre);
    }
}
