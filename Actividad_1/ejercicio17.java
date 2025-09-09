package Actividad_1;

import Actividad_1.clases.calculos;
import java.util.Scanner;
public class ejercicio17 {

    public static void main(String[] args){

    double area, perimetro;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el radio del circulo: "); // lee teclado y asigna valor a variable horas_trabajadas
    double radio_leido = scanner.nextDouble();

    perimetro =  calculos.calcular_perimetro_circunferencia(radio_leido);
    area = calculos.calcular_area_circulo(radio_leido);
    
    System.out.println("El perimetro del circulo es: " + perimetro);
    System.out.println("El área del circulo es: " + area);


    scanner.close();
}
}
