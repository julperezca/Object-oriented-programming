package Actividad_1.carpeta_ejercicio5;


public class calculos {

    
    public static double calcular_suma(double suma, double x ){
        double resultado_suma = suma + x;
        return resultado_suma;
    }
    public static double calcular_x(double x, double y){
        double resultado_x = x + Math.pow(y,2);
        return resultado_x;
    }
    public static double calcular_suma_division(double suma, double x, double y){
        double suma_division = suma + (x/y);
        return suma_division;
    }
}