package Entidades;

public class Colectivo {

    private int id_colectivo;
    private String matricula;
    private String marca;
    private String modelo;
    private int capacidad;
    private boolean estado;

    public Colectivo() {
    }

    public Colectivo(int id_colectivo, String matricula, String marca, String modelo, int capacidad, boolean estado) {
        this.id_colectivo = id_colectivo;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Colectivo(String matricula, String marca, String modelo, int capacidad, boolean estado) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getId_colectivo() {
        return id_colectivo;
    }

    public void setId_colectivo(int id_colectivo) {
        this.id_colectivo = id_colectivo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
    @Override
    public String toString() {
        return "Colectivo {" + "id_colectivo:" + id_colectivo + ", matricula:" + matricula + ", marca:" + marca + ", modelo:" + modelo + ", capacidad:" + capacidad + "}\n";
    }

}
