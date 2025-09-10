package Actividad_1.carpeta_ejercicio17;

public class calculos_cincunferencia {

    
    public static double calcular_area_circulo(double radio){
    double valor_area = Math.PI * Math.pow(radio, 2);
    return valor_area;
    }

    public static double calcular_perimetro_circunferencia(double radio){
    double perimetro = 2 * Math.PI * radio;
    return perimetro;

    }


}

