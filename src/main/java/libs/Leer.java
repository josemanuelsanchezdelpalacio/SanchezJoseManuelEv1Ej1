package libs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Leer {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void mostrarEnPantalla(String mensaje) {
        // Imprime el mensaje proporcionado
        System.out.print(mensaje);
    }

    public static String pedirDato(String texto, String regex) {
        // Variables para almacenar el dato y controlar errores
        String dato = "";
        boolean error = true;

        while (error) {
            try {
                // Muestra el mensaje al usuario y lee la entrada
                mostrarEnPantalla(texto);
                dato = br.readLine();

                // Comprueba si la entrada coincide con la expresión regular o si no se requiere validación
                if (regex == null || dato.matches(regex)) {
                    error = false; // El dato es válido, termina el bucle
                } else {
                    // El dato no es válido según la expresión regular, solicita al usuario que lo reintroduzca
                    mostrarEnPantalla("Por favor, vuelve a introducir el dato, no es un valor posible. ");
                    error = true;
                }
            } catch (IOException e) {
                // Ocurrió un error al leer la entrada, solicita al usuario que reintroduzca el dato
                mostrarEnPantalla("Vuelve a introducir el dato, por favor.");
                error = true;
            }
        }
        return dato; // Devuelve el dato introducido por el usuario
    }

    public static String pedirCadena(String texto) {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        String dato="";
        boolean error = true;
        while (error) {
            try {
                dato="";
                mostrarEnPantalla(texto);
                dato = dataIn.readLine();
                error=false;
            } catch (IOException e) {
                mostrarEnPantalla("Vuelve a introducir el dato, por favor. ");
                error = true;
            }
        }
        return dato;
    }


    public static int pedirEntero(String texto) {
        // Variables para almacenar el dato y controlar errores
        int dato = 0;
        boolean entradaValida = false;
        String regex = "^-?\\d+$";

        while (!entradaValida) {
            try {
                // Intenta convertir a entero
                String input = pedirDato(texto, regex);
                dato = Integer.parseInt(input);
                entradaValida = true;
            } catch (NumberFormatException e) {
                // Muestra un mensaje de error si la entrada no es válida
                mostrarEnPantalla("Entrada no válida. Introduce un número entero.");
            }
        }

        return dato;
    }

    public static double pedirDouble(String texto) {
        // Variables para almacenar el dato y controlar errores
        double dato = 0;
        boolean entradaValida = false;
        String regex = "^-?\\d+([.]\\d*)?$";

        while (!entradaValida) {
            try {
                // Intenta convertir a double
                String input = pedirDato(texto, regex);
                dato = Double.parseDouble(input);
                entradaValida = true;
            } catch (NumberFormatException e) {
                // Muestra un mensaje de error si la entrada no es válida
                mostrarEnPantalla("Entrada no válida. Introduce un número decimal.");
            }
        }

        return dato;
    }


    public static float pedirFloat(String texto) {
        // Variables para almacenar el dato y controlar errores
        float dato = 0;
        boolean entradaValida = false;
        String regex = "^-?\\d+([.]\\d*)?$";

        while (!entradaValida) {
            try {
                // Intenta convertir a float
                String input = pedirDato(texto, regex);
                dato = Float.parseFloat(input);
                entradaValida = true;
            } catch (NumberFormatException e) {
                // Muestra un mensaje de error si la entrada no es válida
                mostrarEnPantalla("Entrada no válida. Introduce un número decimal (float).");
            }
        }

        return dato;
    }

    public static Date pedirFecha(String mensaje, String formato) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        while (true) {
            try {
                String fechaStr = Leer.pedirCadena(mensaje);
                return dateFormat.parse(fechaStr);
            } catch (ParseException e) {
                System.err.println("Error al parsear la fecha: " + e.getMessage());
                System.out.println("Introduce la fecha en el formato indicado (" + formato + ").");
            }
        }
    }

    public static char pedirChar(String texto) {
        // Variable para almacenar el carácter
        char caracter = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                // Lee la entrada del usuario como una cadena
                String input = pedirDato(texto, "^[a-zA-Z]$");
                if (input.length() == 1) {
                    caracter = input.charAt(0);
                    entradaValida = true;
                } else {
                    mostrarEnPantalla("Entrada no válida. Introduce un único carácter.");
                }
            } catch (NumberFormatException e) {
                mostrarEnPantalla("Entrada no válida. Introduce un único carácter.");
            }
        }

        return caracter;
    }
}