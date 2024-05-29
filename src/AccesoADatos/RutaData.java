
package AccesoADatos;

import java.sql.Connection;


public class RutaData {
    private Connection con = null;
    
    public RutaData() {
        con = Conexion.getConexion();
    }
}
