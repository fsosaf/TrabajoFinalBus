
package AccesoADatos;

import java.sql.Connection;


public class PasajeroData {
    private Connection con = null;
    
    public PasajeroData() {
        con = Conexion.getConexion();
    }
}
