package Entidades;

import java.sql.Time;

public class Horario {

    private int id_horario;
    private Ruta ruta;
    private Time hora_salida;
    private Time hora_llegada;
    private boolean estado;

    public Horario() {
    }

    public Horario(Ruta ruta, Time hora_salida, Time hora_llegada, boolean estado) {
        this.ruta = ruta;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.estado = estado;
    }

    public Horario(int id_horario, Ruta ruta, Time hora_salida, Time hora_llegada, boolean estado) {
        this.id_horario = id_horario;
        this.ruta = ruta;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.estado = estado;
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

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }

    public Time getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(Time hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Horario{" + "id_horario=" + id_horario + ", ruta=" + ruta + ", hora_salida=" + hora_salida + ", hora_llegada=" + hora_llegada + ", estado=" + estado + '}';
    }

    
    
}
