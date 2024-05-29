
package trabajofinalbus;

import AccesoADatos.PasajeroData;
import trabajofinalbus.Entidades.Pasajero;


public class TrabajoFinalBus {

    
    public static void main(String[] args) {
        Pasajero p = new Pasajero(1,"Ezequiel","Hermoso","43749036","hermoso@gmail.com","2612406033");
        PasajeroData pasaData = new PasajeroData();
        //pasaData.guardarPasajero(p);
        //System.out.println(pasaData.buscarPasajeroPorId(1));
        //System.out.println(pasaData.buscarPasajeroPorDni("43749036"));
        pasaData.modificarPasajero(p);
    }
    
}
