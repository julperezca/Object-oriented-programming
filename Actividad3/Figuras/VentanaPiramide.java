package Actividad3.Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
* Esta clase denominada Ventanapiramide define una ventana para
* ingresar los datos de una piramide y calcular su volumen y superficie.
* @version 1.2/2020
*/
public class VentanaPiramide extends JFrame implements
ActionListener {
// Un contenedor de elementos gráficos
private Container contenedor;
/* Etiquetas estáticas para identificar los campos de texto a ingresar
y calcular */
private JLabel base, altura, apotema, volumen, superficie;
// Campos de texto a ingresar
private JTextField campoBase, campoAltura, campoApotema;
// Botón para realizar los cálculos numéricos
private JButton calcular;
/**
* Constructor de la clase Ventanapiramide
*/
public VentanaPiramide() {
inicio();
setTitle("piramide"); // Establece el título de la ventana
setSize(280,240); // Establece el t  amaño de la ventana
setLocationRelativeTo(null); /* La ventana se posiciona en el
centro de la pantalla */
setResizable(false); 
setVisible(true);
/* Establece que el botón de cerrar permitirá

salir de la aplicación */
}
/**
* Método que crea la ventana con sus diferentes componentes
* gráficos
*/
private void inicio() {
contenedor = getContentPane(); /* Obtiene el panel de
contenidos de la ventana */
contenedor.setLayout(null); /* Establece que el contenedor no
tiene un layout */
/* Establece la etiqueta y campo de texto para la base de la
piramide */
base = new JLabel();
base.setText("Base (cms):");
// Establece la posición de la etiqueta de la base de la piramide
base.setBounds(20, 20, 135, 23);
campoBase = new JTextField();
/* Establece la posición del campo de texto de la base de la
piramide */
campoBase.setBounds(120, 20, 135, 23);
/* Establece la etiqueta y campo de texto para la altura de la
piramide */
altura = new JLabel();
altura.setText("Altura (cms):");
// Establece la posición de la etiqueta de la altura de la piramide
altura.setBounds(20, 50, 135, 23);
campoAltura = new JTextField();
/* Establece la posición del campo de texto de la altura de la
piramide */
campoAltura.setBounds(120, 50, 135, 23);
/* Establece la etiqueta y campo de texto para el apotema de la
piramide */
apotema = new JLabel();
apotema.setText("Apotema (cms):");
// Establece la posición de la etiqueta del apotema de la piramide
apotema.setBounds(20, 80, 135, 23);
campoApotema = new JTextField();
/* Establece la posición del campo de texto del apotema de la
piramide */
campoApotema.setBounds(120, 80, 135, 23);
/* Establece el botón para calcular volumen y superficie de la
piramide */
calcular = new JButton();
calcular.setText("Calcular");
calcular.setBounds(120, 110, 135, 23); /* Establece la posición
del botón calcular */
/* Agrega al botón un ActionListener para que gestione eventos
del botón */
calcular.addActionListener(this);
// Establece la etiqueta y el valor del volumen de la piramide
volumen = new JLabel();
volumen.setText("Volumen (cm3):");
// Establece la posición de la etiqueta de volumen de la piramide
volumen.setBounds(20, 140, 135, 23);
// Establece la etiqueta y el valor de la superficie de la piramide
superficie = new JLabel();
superficie.setText("Superficie (cm2):");
// Establece la posición de la etiqueta de superficie de la piramide
superficie.setBounds(20, 170, 135, 23);
// Se añade cada componente gráfico al contenedor de la ventana
contenedor.add(base);
contenedor.add(campoBase);
contenedor.add(altura);
contenedor.add(campoAltura);
contenedor.add(apotema);
contenedor.add(campoApotema);
contenedor.add(calcular);
contenedor.add(volumen);
contenedor.add(superficie);
}
/**
* Método que gestiona los eventos generados en la ventana de la
* esfera throws Exception Excepción al ingresar un campo nulo o
* error en formato de número
*/
public void actionPerformed(ActionEvent event) {
Piramide piramide;
boolean error = false;
double base = 0;
double altura = 0;
double apotema = 0;
try {
// Se obtiene y convierte el valor numérico de la base
base = Double.parseDouble(campoBase.getText());
// Se obtiene y convierte el valor numérico de la altura
altura = Double.parseDouble(campoAltura.getText());
// Se obtiene y convierte el valor numérico del apotema
apotema = Double.parseDouble(campoApotema.getText());
// Se crea un objeto piramide
piramide = new Piramide(base, altura, apotema);
// Se muestra el volumen
volumen.setText("Volumen (cm3): " + String.format("%.2f",
piramide.calcularVolumen()));
// Se muestra la superficie
superficie.setText("Superficie (cm2): " + String.format("%.2f",
piramide.calcularSuperficie()));
} catch (Exception e) {
error = true; // Si ocurre una excepción
} finally {
if (error) { /* Si ocurre una excepción, se muestra un mensaje
de error */
JOptionPane.showMessageDialog(
    null,
    "Campo nulo o\nerror en formato de número",
    "Error",
    JOptionPane.ERROR_MESSAGE
);
}
}
}
}