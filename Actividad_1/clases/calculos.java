package Actividad_1.clases;

public class calculos {

    public static double edad_alberto(int edad_juan) {
        double edad_alberto = (edad_juan)*2/3;
        return edad_alberto;
    }

    public static double edad_ana(int edad_juan) {
        double edad_ana = edad_juan*4/3;
        return edad_ana;
    }
    public static double edad_madre(double edad_juan, double edad_ana, double edad_alberto) {
        double edad_madre = edad_ana + edad_alberto + edad_juan;
        return edad_madre;
    }


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

    public static double calcular_salario_bruto(double salario_hora, double horas_trabajadas){
    double resultado_salario_bruto = salario_hora * horas_trabajadas;
    return resultado_salario_bruto;
    }
    public static double calcular_porcentaje_retencion(double retencion){
    double resultado_porcentaje_retencion = retencion/100;
    return resultado_porcentaje_retencion;
    }

    public static double calcular_retencion(double salario_bruto, double retencion){
    double resultado_valor_retencion = salario_bruto * retencion;
    return resultado_valor_retencion;
    }

    public static double calcular_salario_neto(double valor_retencion, double salario_bruto){
    double resultado_salario_bruto = salario_bruto - valor_retencion;
    return resultado_salario_bruto;
    }
  

    public static double calcular_cuadrado(double numero){
    double calculo_cuadrado =  Math.pow(numero, 2);
    return calculo_cuadrado;
    }

    public static double calcular_cubo(double numero){
    double calculo_cubo = Math.pow(numero, 3);
    return calculo_cubo;
    }
    
    public static double calcular_area_circulo(double radio){
    double valor_area = Math.PI * Math.pow(radio, 2);
    return valor_area;
    }

    public static double calcular_perimetro_circunferencia(double radio){
    double perimetro = 2 * Math.PI * radio;
    return perimetro;

    }


}

