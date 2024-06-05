
package AccesoADatos;

import Entidades.Colectivo;
import Entidades.Pasaje;
import Entidades.Pasajero;
import Entidades.Ruta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PasajeData {
    private Connection con = null;
    private PasajeroData pasData;
    private ColectivoData colData;
    private RutaData rutaData;
    
    public PasajeData() {
        con = Conexion.getConexion();
        pasData = new PasajeroData();
        colData = new ColectivoData();
        rutaData = new RutaData();
    }
    
    public void GuardarPasaje(Pasaje pasaje) {
        String sql = "INSERT INTO `pasajes`(`ID_pasajero`, `ID_colectivo`, `ID_ruta`, `fecha_viaje`, `hora_viaje`, "
                + "`asiento`, `precio`) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pasaje.getPasajero().getId_pasajero());
            ps.setInt(2, pasaje.getColectivo().getId_colectivo());
            ps.setInt(3, pasaje.getRuta().getId_ruta());
            ps.setDate(4, Date.valueOf(pasaje.getFecha_viaje()));
            ps.setTime(5, pasaje.getHora_viaje());
            ps.setInt(6, pasaje.getAsiento());
            ps.setFloat(7, pasaje.getPrecio());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pasaje.setId_pasaje(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pasaje comprado con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pasajes " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();
        }
    }
    
    public List<Pasaje> listarPasajes(){
        List<Pasaje> pasajes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `pasajes`";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pasaje pasaje = new Pasaje();
                pasaje.setId_pasaje(rs.getInt("id_pasaje"));
                Pasajero p = pasData.buscarPasajeroPorId(rs.getInt("id_pasajero"));
                Colectivo c = colData.buscarColectivoPorId(rs.getInt("id_colectivo"));
                Ruta r = rutaData.buscarRutaPorId(rs.getInt("id_ruta"));
                pasaje.setPasajero(p);
                pasaje.setColectivo(c);
                pasaje.setRuta(r);
                pasaje.setFecha_viaje(rs.getDate("fecha_viaje").toLocalDate());
                pasaje.setHora_viaje(rs.getTime("hora_viaje"));
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getFloat("precio"));
                pasajes.add(pasaje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla pasajes " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();
        }
        return pasajes;
    }
    
    public List<Pasaje> listarPasajesPorRuta(Ruta ruta){
        List<Pasaje> pasajes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `pasajes` WHERE id_ruta = ?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, ruta.getId_ruta());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pasaje pasaje = new Pasaje();
                pasaje.setId_pasaje(rs.getInt("id_pasaje"));
                Pasajero p = pasData.buscarPasajeroPorId(rs.getInt("id_pasajero"));
                Colectivo c = colData.buscarColectivoPorId(rs.getInt("id_colectivo"));
                Ruta r = rutaData.buscarRutaPorId(ruta.getId_ruta());
                pasaje.setPasajero(p);
                pasaje.setColectivo(c);
                pasaje.setRuta(r);
                pasaje.setFecha_viaje(rs.getDate("fecha_viaje").toLocalDate());
                pasaje.setHora_viaje(rs.getTime("hora_viaje"));
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getFloat("precio"));
                pasajes.add(pasaje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla pasajes " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();
        }
        return pasajes;
    }
    
    public List<Pasaje> listarPasajesPorHorario(Time hora){
        List<Pasaje> pasajes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `pasajes` WHERE hora_viaje = ?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setTime(1, hora);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pasaje pasaje = new Pasaje();
                pasaje.setId_pasaje(rs.getInt("id_pasaje"));
                Pasajero p = pasData.buscarPasajeroPorId(rs.getInt("id_pasajero"));
                Colectivo c = colData.buscarColectivoPorId(rs.getInt("id_colectivo"));
                Ruta r = rutaData.buscarRutaPorId(rs.getInt("id_ruta"));
                pasaje.setPasajero(p);
                pasaje.setColectivo(c);
                pasaje.setRuta(r);
                pasaje.setFecha_viaje(rs.getDate("fecha_viaje").toLocalDate());
                pasaje.setHora_viaje(hora);
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getFloat("precio"));
                pasajes.add(pasaje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla pasajes " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();
        }
        return pasajes;
    }
    public List<Pasaje> listarPasajesPorPasajero(Pasajero pasajero){
        List<Pasaje> pasajes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `pasajes` WHERE id_pasajero = ?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setInt(1, pasajero.getId_pasajero());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pasaje pasaje = new Pasaje();
                pasaje.setId_pasaje(rs.getInt("id_pasaje"));
                Pasajero p = pasData.buscarPasajeroPorId(pasajero.getId_pasajero());
                Colectivo c = colData.buscarColectivoPorId(rs.getInt("id_colectivo"));
                Ruta r = rutaData.buscarRutaPorId(rs.getInt("id_ruta"));
                pasaje.setPasajero(p);
                pasaje.setColectivo(c);
                pasaje.setRuta(r);
                pasaje.setFecha_viaje(rs.getDate("fecha_viaje").toLocalDate());
                pasaje.setHora_viaje(rs.getTime("hora_viaje"));
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getFloat("precio"));
                pasajes.add(pasaje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla pasajes " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();
        }
        return pasajes;
    }
    
    public Pasaje buscarPasajePorId(int id){ //¿recibo?
        Pasaje pasaje = null;
        String sql = "SELECT  * FROM `pasajes` WHERE ID_pasaje = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pasaje = new Pasaje();
                pasaje.setId_pasaje(id);
                Pasajero p = pasData.buscarPasajeroPorId(rs.getInt("id_pasajero"));
                Colectivo c = colData.buscarColectivoPorId(rs.getInt("id_colectivo"));
                Ruta r = rutaData.buscarRutaPorId(rs.getInt("id_ruta"));
                pasaje.setPasajero(p);
                pasaje.setColectivo(c);
                pasaje.setRuta(r);
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setFecha_viaje(rs.getDate("fecha_viaje").toLocalDate());
                pasaje.setHora_viaje(rs.getTime("hora_viaje"));
                pasaje.setPrecio(rs.getFloat("precio"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Pasaje.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajes " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();

        }
        return pasaje;
    }
    
    public List<Integer> controlAsientos(LocalDate fecha, Time hora, Colectivo cole){
        List<Integer> asientos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `pasajes` WHERE hora_viaje = ? AND fecha_viaje = ? AND ID_colectivo = ?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setTime(1, hora);
            ps.setDate(2, Date.valueOf(fecha));
            ps.setInt(3, cole.getId_colectivo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                asientos.add(rs.getInt("asiento"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla pasajes " + ex.getMessage());
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();
        }
        return asientos;
    } 
    
    public void anularVenta(Pasaje pasaje){
        String sql = "DELETE FROM `pasajes` WHERE id_pasaje = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pasaje.getId_pasaje());
            int ok = ps.executeUpdate();
            if (ok == 1) {
                JOptionPane.showMessageDialog(null, "Pasaje eliminado Con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el pasaje.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pasajes " + e.getMessage());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }
}
