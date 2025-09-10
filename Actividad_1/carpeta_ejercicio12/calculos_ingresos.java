package Actividad_1.carpeta_ejercicio12;

public class calculos_ingresos {

    

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


}

