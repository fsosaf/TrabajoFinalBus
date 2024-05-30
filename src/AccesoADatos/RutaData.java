package AccesoADatos;

import Entidades.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JOptionPane;

public class RutaData {

    private Connection con = null;

    public RutaData() {
        con = Conexion.getConexion();
    }

    public void GuardarRuta(Ruta ruta) {
        String sql = "INSERT INTO `rutas`( `origen`, `destino`, `duracion_estimada`) VALUES (?,?,?)";
        Time duracion = Time.valueOf("00:00:00");
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setTime(3, duracion);
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
}
