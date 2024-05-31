package AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Entidades.Colectivo;

public class ColectivoData {

    private Connection con = null;

    public ColectivoData() {
        con = Conexion.getConexion();
    }

    public void guardarColectivo(Colectivo colectivo) {
        String sql = "INSERT INTO `colectivos`( `matricula`, `marca`, `modelo`, `capacidad`, `estado`) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, colectivo.getMatricula());
            ps.setString(2, colectivo.getMarca());
            ps.setString(3, colectivo.getModelo());
            ps.setInt(4, colectivo.getCapacidad());
            ps.setBoolean(5, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                colectivo.setId_colectivo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Colectivo añadido con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla colectivos " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();

        }
    }

    public void modificarColectivo(Colectivo colectivo) {
        String sql = "UPDATE `colectivos` SET `matricula`= ?,`marca`= ?, `modelo`=?,`capacidad`= ? WHERE id_colectivo = ? AND estado = 1 ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, colectivo.getMatricula());
            ps.setString(2, colectivo.getMarca());
            ps.setString(3, colectivo.getModelo());
            ps.setInt(4, colectivo.getCapacidad());
            ps.setInt(5, colectivo.getId_colectivo());
            int ok = ps.executeUpdate();
            if (ok == 1) {
                JOptionPane.showMessageDialog(null, "Colectivo Modificado Con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el colectivo.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Colectivos " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }

    public Colectivo buscarColectivoPorId(int id) {
        Colectivo colectivo = null;
        String sql = "SELECT  `matricula`, `marca`, `modelo`, `capacidad` FROM `colectivos` WHERE ID_colectivo = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                colectivo = new Colectivo();
                colectivo.setId_colectivo(id);
                colectivo.setMatricula(rs.getString("matricula"));
                colectivo.setMarca(rs.getString("marca"));
                colectivo.setModelo(rs.getString("modelo"));
                colectivo.setCapacidad(rs.getInt("capacidad"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe colectivo.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla colectivos " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return colectivo;
    }

    public Colectivo buscarColectivoPorMatricula(String matricula) {
        Colectivo colectivo = null;
        String sql = "SELECT  `id_colectivo`, `marca`, `modelo`, `capacidad` FROM `colectivos` WHERE matricula = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                colectivo = new Colectivo();
                colectivo.setId_colectivo(rs.getInt("id_colectivo"));
                colectivo.setMatricula(matricula);
                colectivo.setMarca(rs.getString("marca"));
                colectivo.setModelo(rs.getString("modelo"));
                colectivo.setCapacidad(rs.getInt("capacidad"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe colectivo.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla colectivos " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return colectivo;
    }

    public void EliminarColectivo(Colectivo colectivo) {
        String sql = "UPDATE `colectivos` SET `estado`= 0 WHERE id_colectivo = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, colectivo.getId_colectivo());
            int ok = ps.executeUpdate();
            if (ok == 1) {
                JOptionPane.showMessageDialog(null, "Colectivo Eliminado Con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el colectivo.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Colectivos " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }

}
