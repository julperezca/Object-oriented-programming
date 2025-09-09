package Actividad_1;

import java.util.Scanner;

import Actividad_1.clases.calculos;

public class ejercicio14 {
    public static void main(String[] args){
        
        double cuadrado, cubo;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero a leer: "); // lee teclado y asigna valor a variable horas_trabajadas
        double numero_leido = scanner.nextDouble();

        cuadrado = calculos.calcular_cuadrado(numero_leido);
        cubo = calculos.calcular_cuadrado(numero_leido);

        System.out.println("El numero leído es: " + numero_leido);
        System.out.println("El cuadrado del número es: " + cuadrado);
        System.out.println("El cubo del numero es: " + cubo);

        scanner.close();
    }
}
