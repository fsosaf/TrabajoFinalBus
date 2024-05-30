package trabajofinalbus;

import AccesoADatos.ColectivoData;
import AccesoADatos.PasajeroData;
import AccesoADatos.RutaData;
import Entidades.Colectivo;
import java.util.List;
import Entidades.Pasajero;
import Entidades.Ruta;

public class TrabajoFinalBus {

    public static void main(String[] args) {

        PasajeroData pasaData = new PasajeroData();
        //Pasajero p = pasaData.buscarPasajeroPorId(2);
        //pasaData.EliminarPasajero(p);
        //pasaData.guardarPasajero(p);
        //System.out.println(pasaData.buscarPasajeroPorId(2));
        //System.out.println(pasaData.buscarPasajeroPorDni("4375976"));
        //pasaData.modificarPasajero(p);
        //List<Pasajero> pasajeros = pasaData.listarPasajeros();
        //System.out.println(pasajeros);
        //System.out.println(pasaData.buscarPasajeroPorNombreyApellido("debora", "Moyano"));
        Colectivo colectivo = new Colectivo(2, "abc123", "ford", "324", 30);
        ColectivoData colData = new ColectivoData();
        //colData.guardarColectivo(colectivo);
        //colData.modificarColectivo(colectivo);
        //System.out.println(colData.buscarColectivoPorMatricula("abc123"));
        //colData.EliminarColectivo(colectivo);
        Ruta ruta = new Ruta("la punta", "san luis");
        RutaData rutaData = new RutaData();
        rutaData.GuardarRuta(ruta);

    }

}
