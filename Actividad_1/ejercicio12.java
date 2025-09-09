package Actividad_1;

import Actividad_1.clases.calculos;
import java.util.Scanner;

public class ejercicio12 {
    // trabajo de 48 h/semana
    // y devenga 5000 $ /h. 
    // Porcentaje de retención en la fuente 12.5%  del salario bruto
    // se necesita saber el salario bruto, retencion y el salario neto
    public static void main(String[] args) {


        double salario_bruto, salario_neto, valor_retencion, porcentaje_retencion;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de horas trabajadas: "); // lee teclado y asigna valor a variable horas_trabajadas
        double horas_trabajadas = scanner.nextDouble();

        System.out.print("Ingrese el valor de salario por hora: "); // lee teclado y asigna valor a variable salario_hora
        double valor_por_hora = scanner.nextDouble();

        System.out.print("Ingrese el valor del porcentaje de retención: "); // lee teclado y asigna valor a variable retencion
        double retencion = scanner.nextDouble();
        scanner.close();

        salario_bruto = calculos.calcular_salario_bruto(valor_por_hora, horas_trabajadas);
        porcentaje_retencion = calculos.calcular_porcentaje_retencion(retencion);
        valor_retencion = calculos.calcular_retencion(salario_bruto, porcentaje_retencion);
        salario_neto = calculos.calcular_salario_neto(valor_retencion, salario_bruto);

        System.out.println("Salario bruto: " + salario_bruto);
        System.out.println("Valor retención: " + valor_retencion);
        System.out.println("Salario neto: " + salario_neto);
    }   
}

