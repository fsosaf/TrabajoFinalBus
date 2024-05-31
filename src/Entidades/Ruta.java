package Entidades;

import java.sql.Time;

public class Ruta {

    private int id_ruta;
    private String origen;
    private String destino;
    private Time duracion_estimada;
    private boolean estado;

    public Ruta() {
    }

    public Ruta(int id_ruta, String origen, String destino, Time duracion_estimada, boolean estado) {
        this.id_ruta = id_ruta;
        this.origen = origen;
        this.destino = destino;
        this.duracion_estimada = duracion_estimada;
        this.estado = estado;
    }

    public Ruta(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Time getDuracion_estimada() {
        return duracion_estimada;
    }

    public void setDuracion_estimada(Time duracion_estimada) {
        this.duracion_estimada = duracion_estimada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ruta{" + "id_ruta=" + id_ruta + ", origen=" + origen + ", destino=" + destino + ", duracion_estimada=" + duracion_estimada + '}';
    }

    
    
}
