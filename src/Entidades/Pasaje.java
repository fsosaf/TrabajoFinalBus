/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Time;
import java.time.LocalDate;


public class Pasaje {
    private int id_pasaje;
    private Pasajero pasajero;
    private Colectivo colectivo;
    private Ruta ruta;
    private LocalDate fecha_viaje;
    private Time hora_viaje;
    private int asiento;
    private float precio;

    public Pasaje(int id_pasaje, Pasajero pasajero, Colectivo colectivo, Ruta ruta, LocalDate fecha_viaje, Time hora_viaje, int asiento, float precio) {
        this.id_pasaje = id_pasaje;
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.ruta = ruta;
        this.fecha_viaje = fecha_viaje;
        this.hora_viaje = hora_viaje;
        this.asiento = asiento;
        this.precio = precio;
    }
    
    public Pasaje( Pasajero pasajero, Colectivo colectivo, Ruta ruta, LocalDate fecha_viaje, Time hora_viaje, int asiento, float precio) {
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.ruta = ruta;
        this.fecha_viaje = fecha_viaje;
        this.hora_viaje = hora_viaje;
        this.asiento = asiento;
        this.precio = precio;
    }
    
    public Pasaje(){}
  
    public int getId_pasaje() {
        return id_pasaje;
    }

    public void setId_pasaje(int id_pasaje) {
        this.id_pasaje = id_pasaje;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public LocalDate getFecha_viaje() {
        return fecha_viaje;
    }

    public void setFecha_viaje(LocalDate fecha_viaje) {
        this.fecha_viaje = fecha_viaje;
    }

    public Time getHora_viaje() {
        return hora_viaje;
    }

    public void setHora_viaje(Time hora_viaje) {
        this.hora_viaje = hora_viaje;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pasaje{" + "id_pasaje=" + id_pasaje + ", pasajero=" + pasajero + ", colectivo=" + colectivo + ", ruta=" + ruta + ", fecha_viaje=" + fecha_viaje + ", hora_viaje=" + hora_viaje + ", asiento=" + asiento + ", precio=" + precio + '}';
    }
    
    
}
