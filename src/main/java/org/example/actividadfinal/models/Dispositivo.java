package org.example.actividadfinal.models;

import org.example.actividadfinal.TipoAtributo;

import java.time.LocalDate;

public class Dispositivo {
    private String id;
    private LocalDate fechaCompra;
    private int precio;
    private TipoAtributo tipoAtributo;
    private String marca;
    private String modelo;

    public Dispositivo(String id, LocalDate fechaCompra, int precio, TipoAtributo tipoAtributo, String marca, String modelo) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.tipoAtributo = tipoAtributo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Dispositivo() {
    }

    public void altaDispositivo(){

    }

    public void bajaDispositivo(){

    }

    public void modificarDispositivo(){

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public TipoAtributo getTipoAtributo() {
        return tipoAtributo;
    }

    public void setTipoAtributo(TipoAtributo tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
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

    @Override
    public String toString() {
        return id + ": " + tipoAtributo + ", " + marca + ", " + modelo + ", " + fechaCompra + ", " + precio + "€";
    }


    public int compareFecha(Dispositivo dispositivo) {
        return this.fechaCompra.compareTo(dispositivo.getFechaCompra());
    }

    public int comparePrecio(Dispositivo dispositivo) {
        return this.precio - dispositivo.getPrecio();
    }

    public int compareMarca(Dispositivo dispositivo) {
        return this.marca.compareTo(dispositivo.getMarca());
    }
}
