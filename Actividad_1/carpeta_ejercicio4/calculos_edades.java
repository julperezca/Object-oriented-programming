package Actividad_1.carpeta_ejercicio4;


public class calculos_edades{

    public static double edad_alberto(double edad_juan) {
        double edad_alberto = (edad_juan)*2/3;
        return edad_alberto;
    }

    public static double edad_ana(double edad_juan) {
        double edad_ana = edad_juan*4/3;
        return edad_ana;
    }
    public static double edad_madre(double edad_juan, double edad_ana, double edad_alberto) {
        double edad_madre = edad_ana + edad_alberto + edad_juan;
        return edad_madre;
    }
}

