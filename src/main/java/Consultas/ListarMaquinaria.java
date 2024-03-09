package Consultas;

import Conexion.ConexionMariaDB;

import java.sql.*;

public class ListarMaquinaria {

    public static void listar() {

        PreparedStatement ps;
        ResultSet rs;

        try (Connection conexion = ConexionMariaDB.conectar("constructora")) {
            try (Statement state = conexion.createStatement()) {

                ResultSet resultSet = state.executeQuery("SELECT e.nombre, o.id, o.nombre AS nombreObra FROM maquinaria m, empleado e, obra o WHERE m.empleado=e.dni AND m.nombreObra=o.nombre");
                while (resultSet.next()) {
                    String idObra = resultSet.getString("id");
                    String nombre = resultSet.getString("nombre");
                    String obra = resultSet.getString("nombreObra");

                    System.out.println("ID de la obra: " + idObra + "\tNombre empleado: " + nombre + "\tNombre obra asignada: " + obra);
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (SQLSyntaxErrorException e) {
            System.out.println("Error en la sintaxis de la sentencia SQL: " + e.getMessage());
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("La sentencia SQL no cumple con los requisitos de integridad de la base de datos: " + e.getMessage());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}