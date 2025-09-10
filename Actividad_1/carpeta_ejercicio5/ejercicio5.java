package Actividad_1.carpeta_ejercicio5;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {

        double suma, x, y;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de suma: "); // lee teclado y asigna valor a variable suma
        suma = scanner.nextDouble();

        System.out.print("Ingrese el valor de x: ");  // lee teclado y asigna valor a variable x
        x = scanner.nextDouble();

        System.out.print("Ingrese el valor de y: "); // lee teclado y asigna valor a variable y
        y = scanner.nextDouble();


        suma = calculos.calcular_suma(suma, x);
        x = calculos.calcular_x(x, y);
        suma = calculos.calcular_suma_division(suma, x, y);

        System.out.println("suma es: " + suma);
        
        scanner.close();
    }
}
