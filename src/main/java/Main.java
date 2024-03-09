import Consultas.AñadirNuevoEmpleado;
import Consultas.ListarMaquinaria;
import libs.Leer;

public class Main {

    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Listar maquinaria");
            System.out.println("2. Añadir nuevo empleado");

            opcion = Leer.pedirEntero("Introduce una opción: ");

            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    ListarMaquinaria.listar();
                    break;
                case 2:
                    AñadirNuevoEmpleado.añadirDesdeXML();
                    break;
                default:
                    System.out.println("La opcion seleccionada no existe");
            }

        } while (!salir);
    }
}
