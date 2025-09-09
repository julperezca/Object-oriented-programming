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


}

