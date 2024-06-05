package AccesoADatos;

import Entidades.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RutaData {

    private Connection con = null;

    public RutaData() {
        con = Conexion.getConexion();
    }

    public void GuardarRuta(Ruta ruta) {
        String sql = "INSERT INTO `rutas`( `origen`, `destino`, `duracion_estimada`, `estado`) VALUES (?,?,?,?)";
        Time duracion = Time.valueOf("01:15:00");
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setTime(3, duracion);
            ps.setBoolean(4, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ruta.setId_ruta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ruta añadida con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla rutas " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();

        }
    }
    
    public List<Ruta> listarRutas(){
        List<Ruta> rutas = new ArrayList<>();
        try {
            String sql = "SELECT id_ruta, origen, destino, duracion_estimada FROM `rutas` WHERE estado = 1";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setId_ruta(rs.getInt("id_ruta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracion_estimada(rs.getTime("duracion_estimada"));
                rutas.add(ruta);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Rutas " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();
        }
        return rutas;
    }
    
    public List<Ruta> buscarRutasPorOrigen(String origen){
        List<Ruta> rutas = new ArrayList<>();
        String sql = "SELECT id_ruta, origen, destino, duracion_estimada, estado FROM `rutas` WHERE origen = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, origen);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setId_ruta(rs.getInt("id_ruta"));
                ruta.setOrigen(origen);
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracion_estimada(rs.getTime("duracion_estimada"));
                ruta.setEstado(rs.getBoolean("estado"));
                rutas.add(ruta);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Rutas " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return rutas;
    }
    
    public List<Ruta> buscarRutasPorDestino(String destino){
        List<Ruta> rutas = new ArrayList<>();
        String sql = "SELECT id_ruta, origen, origen, duracion_estimada, estado FROM `rutas` WHERE destino = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, destino);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setId_ruta(rs.getInt("id_ruta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(destino);
                ruta.setDuracion_estimada(rs.getTime("duracion_estimada"));
                ruta.setEstado(rs.getBoolean("estado"));
                rutas.add(ruta);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Rutas " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return rutas;
    }
    
    public Ruta buscarRutaPorId(int id){
        Ruta ruta = null;
        String sql = "SELECT * FROM `rutas` WHERE ID_ruta = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ruta = new Ruta();
                ruta.setId_ruta(id);
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracion_estimada(rs.getTime("duracion_estimada"));
                ruta.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la ruta.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Rutas " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return ruta;
    }
    
    public void modificarRuta(Ruta ruta){
        String sql = "UPDATE `rutas` SET origen = ?, destino = ?, duracion_estimada = ? WHERE id_ruta = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setTime(3, ruta.getDuracion_estimada());
            ps.setInt(4, ruta.getId_ruta());
            int ok = ps.executeUpdate();
            if (ok == 1) {
                JOptionPane.showMessageDialog(null, "Ruta Modificada Con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar la ruta.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Rutas " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }
    
    public void eliminarRuta(Ruta ruta){
        String sql = "UPDATE `rutas` SET estado = 0 WHERE id_ruta = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getId_ruta());
            int ok = ps.executeUpdate();
            if (ok == 1) {
                JOptionPane.showMessageDialog(null, "Ruta eliminada Con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la ruta.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Rutas " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }
}
