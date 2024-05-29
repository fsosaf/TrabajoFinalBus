
package AccesoADatos;

import java.sql.Connection;


public class ColectivoData {
    private Connection con = null;
    
    public ColectivoData() {
        con = Conexion.getConexion();
    }
}
