package Actividad_1.carpeta_ejercicio4;


import java.util.Scanner;
public class ejercicio4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la edad de Juan: "); // lee teclado y asigna valor a variable edad_juan
        double edad_juan_leida = scanner.nextDouble();
        
        double edad_alberto = calculos_edades.edad_alberto(edad_juan_leida);
        double edad_ana = calculos_edades.edad_ana(edad_juan_leida);
        double edad_madre = calculos_edades.edad_madre(edad_juan_leida, edad_ana, edad_alberto);

        System.out.println("Edad de Juan: " + edad_juan_leida);
        System.out.println("Edad de Alberto: " + edad_alberto);
        System.out.println("Edad de Ana: " + edad_ana);
        System.out.println("Edad de la madre: " + edad_madre);
        scanner.close();
    }
}
