
package AccesoADatos;

import Entidades.Horario;
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


public class HorarioData {
    private Connection con = null;
    private RutaData rutaData;
    
    public HorarioData() {
        con = Conexion.getConexion();
        rutaData = new RutaData();
    }
    
    public void GuardarHorario(Horario horario) {
        String sql = "INSERT INTO `horarios`( `id_ruta`, `hora_salida`, `hora_llegada`, `estado`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, horario.getRuta().getId_ruta());
            ps.setTime(2, horario.getHora_salida());
            ps.setTime(3, horario.getHora_llegada());
            ps.setBoolean(4, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                horario.setId_horario(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Horario añadido con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla horarios " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();

        }
    }
    
    public List<Horario> listarHorariosDisponibles(Ruta ruta){
        List<Horario> horarios = new ArrayList<>();
        try {
            String sql = "SELECT `id_horario`, `hora_salida`, `hora_llegada` FROM `horarios` WHERE estado = 1 AND id_ruta = ?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getId_ruta());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setEstado(true);
                horario.setHora_salida(rs.getTime("hora_salida"));
                horario.setHora_llegada(rs.getTime("hora_llegada"));
                horario.setRuta(ruta);
                horario.setId_horario(rs.getInt("id_horario"));
                horarios.add(horario);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla horarios " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();
        }
        return horarios;
    }
    
    public List<Horario> buscarHorarioPorHoraSalida(Time hora){
        List<Horario> horarios = new ArrayList<>();
        String sql = "SELECT id_horario, id_ruta, hora_salida, hora_llegada, estado FROM `horarios` WHERE hora_salida = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setTime(1, hora);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setId_horario(rs.getInt("id_horario"));
                Ruta ruta = rutaData.buscarRutaPorId(rs.getInt("id_ruta"));
                horario.setRuta(ruta);
                horario.setHora_llegada(rs.getTime("hora_llegada"));
                horario.setHora_salida(hora);
                horario.setEstado(rs.getBoolean("estado"));
                horarios.add(horario);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Horarios " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return horarios;
    }
    
    public List<Horario> buscarHorarioPorRuta(Ruta ruta){
        List<Horario> horarios = new ArrayList<>();
        String sql = "SELECT * FROM `horarios` WHERE id_ruta = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getId_ruta());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setId_horario(rs.getInt("id_horario"));
                horario.setRuta(ruta);
                horario.setHora_llegada(rs.getTime("hora_llegada"));
                horario.setHora_salida(rs.getTime("hora_salida"));
                horario.setEstado(rs.getBoolean("estado"));
                horarios.add(horario);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Horarios " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return horarios;
    }
    
    public void modificarHorario(Horario horario){
        String sql = "UPDATE `horarios` SET hora_salida = ?, hora_llegada = ? WHERE id_horario = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setTime(1, horario.getHora_salida());
            ps.setTime(2, horario.getHora_llegada());
            ps.setInt(3, horario.getId_horario());
            int ok = ps.executeUpdate();
            if (ok == 1) {
                JOptionPane.showMessageDialog(null, "Horario Modificado Con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar el horario.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Horarios " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }
    
    public void eliminarHorario(Horario horario){
        String sql = "UPDATE `horarios` SET estado = 0 WHERE id_horario = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, horario.getId_horario());
            int ok = ps.executeUpdate();
            if (ok == 1) {
                JOptionPane.showMessageDialog(null, "Horario eliminado Con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el horario.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Horarios " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }

    public List<Horario> listarHorarios() {
        List<Horario> horarios = new ArrayList<>();
        Ruta ruta;
        String sql = "SELECT * FROM `horarios` WHERE estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setId_horario(rs.getInt("id_horario"));
                ruta = rutaData.buscarRutaPorId(rs.getInt("id_ruta"));
                horario.setRuta(ruta);
                horario.setHora_llegada(rs.getTime("hora_llegada"));
                horario.setHora_salida(rs.getTime("hora_salida"));
                horario.setEstado(rs.getBoolean("estado"));
                horarios.add(horario);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Horarios " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return horarios;
    }
    
    
    
}
