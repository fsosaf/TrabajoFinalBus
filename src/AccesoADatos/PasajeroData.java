package AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Entidades.Pasajero;

public class PasajeroData {

    private Connection con = null;

    public PasajeroData() {
        con = Conexion.getConexion();
    }

    public void guardarPasajero(Pasajero pasajero) {
        String sql = "INSERT INTO `pasajeros`( `nombre`, `apellido`, `dni`, `correo`, `telefono`, `estado`) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setString(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
            ps.setBoolean(6, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pasajero.setId_pasajero(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pasajero añadido con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajero " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();

        }
    }

    public Pasajero buscarPasajeroPorId(int id_pasajero) {
        Pasajero pasajero = null;
        String sql = "SELECT  * FROM `pasajeros` WHERE ID_pasajero = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_pasajero);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setId_pasajero(id_pasajero);
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe Pasajero.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajero " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return pasajero;
    }
    
    public Pasajero buscarPasajeroPorIdBorrado(int id_pasajero) {
        Pasajero pasajero = null;
        String sql = "SELECT  * FROM `pasajeros` WHERE ID_pasajero = ? AND estado = 0";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_pasajero);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setId_pasajero(id_pasajero);
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe Pasajero.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajero " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return pasajero;
    }

    public Pasajero buscarPasajeroPorDni(String dni) {
        Pasajero pasajero = null;
        String sql = "SELECT  `ID_pasajero`,`nombre`, `apellido`, `correo`, `telefono` FROM `pasajeros` WHERE dni = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setDni(dni);
                pasajero.setId_pasajero(rs.getInt("id_pasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe Pasajero.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajero " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return pasajero;
    }

    public List<Pasajero> buscarPasajeroPorNombreyApellido(String nombre, String apellido) {
        List<Pasajero> pasajeros = new ArrayList<>();
        String sql = "SELECT `ID_pasajero`, `nombre`, `apellido`, `dni`, `correo`, `telefono` FROM `pasajeros` WHERE nombre= ? AND apellido= ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setNombre(nombre);
                pasajero.setApellido(apellido);
                pasajero.setId_pasajero(rs.getInt("id_pasajero"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
                pasajeros.add(pasajero);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajero " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return pasajeros;
    }

    public void modificarPasajero(Pasajero pasajero) {
        String sql = "UPDATE `pasajeros` SET `nombre`= ?,`apellido`= ?,`dni`= ?,`correo`= ?,`telefono`= ? WHERE id_pasajero = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setString(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
            ps.setInt(6, pasajero.getId_pasajero());
            int ok = ps.executeUpdate();
            if (ok == 1) {
                JOptionPane.showMessageDialog(null, "Pasajero Modificado Con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el pasajero.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajero " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }

    public List<Pasajero> listarPasajeros() {
        List<Pasajero> pasajeros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `pasajeros` WHERE estado = 1";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setId_pasajero(rs.getInt("id_pasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
                pasajeros.add(pasajero);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Pasajero " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();
        }
        return pasajeros;
    }
    
    public List<Pasajero> listarPasajerosBorrados() {
        List<Pasajero> pasajeros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `pasajeros` WHERE estado = 0";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setId_pasajero(rs.getInt("id_pasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
                pasajeros.add(pasajero);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Pasajero " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();
        }
        return pasajeros;
    }

    public void EliminarPasajero(Pasajero p) {
        String sql = "UPDATE `pasajeros` SET `estado`= 0 WHERE id_pasajero = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId_pasajero());
            int ok = ps.executeUpdate();
            if (ok == 1) {
                JOptionPane.showMessageDialog(null, "Pasajero Eliminado Con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el pasajero.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }

    }
    
    public void RecuperarPasajero(int id) {
        String sql = "UPDATE `pasajeros` SET `estado`= 1 WHERE id_pasajero = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int ok = ps.executeUpdate();
            if (ok == 1) {
                JOptionPane.showMessageDialog(null, "Pasajero recuperado con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo recuperar el pasajero.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajeros " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }

    }

}
