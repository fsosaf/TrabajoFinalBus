
package AccesoADatos;

import java.sql.Connection;


public class PasajeData {
    private Connection con = null;
    
    public PasajeData() {
        con = Conexion.getConexion();
    }
}
