
package trabajofinalbus.Entidades;

import java.time.LocalDate;


public class Horario {
    private int id_horario;
    private Ruta ruta;
    private LocalDate hora_salida;
    private LocalDate hora_llegada;

    public Horario(){}
            
    public Horario( Ruta ruta, LocalDate hora_salida, LocalDate hora_llegada) {
        this.ruta = ruta;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
    }
    
    public Horario(int id_horario, Ruta ruta, LocalDate hora_salida, LocalDate hora_llegada) {
        this.id_horario = id_horario;
        this.ruta = ruta;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public LocalDate getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalDate hora_salida) {
        this.hora_salida = hora_salida;
    }

    public LocalDate getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(LocalDate hora_llegada) {
        this.hora_llegada = hora_llegada;
    }
    
}
