
package AccesoADatos;

import java.sql.Connection;


public class HorarioData {
    private Connection con = null;
    
    public HorarioData() {
        con = Conexion.getConexion();
    }
}
