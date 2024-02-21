package org.example.actividadfinal.models;

import org.example.actividadfinal.TipoAtributo;

import java.time.LocalDate;

/**
 * Clase que representa un dispositivo
 */
public class Dispositivo {
    private String id;
    private LocalDate fechaCompra;
    private int precio;
    private TipoAtributo tipoAtributo;
    private String marca;
    private String modelo;

    /**
     * Constructor de la clase
     * @param id
     * @param fechaCompra
     * @param precio
     * @param tipoAtributo
     * @param marca
     * @param modelo
     */
    public Dispositivo(String id, LocalDate fechaCompra, int precio, TipoAtributo tipoAtributo, String marca, String modelo) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.tipoAtributo = tipoAtributo;
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * Constructor de la clase sin parámetros
     */
    public Dispositivo() {
    }

    /**
     * Método que devuelve el id del dispositivo
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Método que establece el id del dispositivo
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método que devuelve la fecha de compra del dispositivo
     * @return
     */
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Método que establece la fecha de compra del dispositivo
     * @param fechaCompra
     */
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Método que devuelve el precio del dispositivo
     * @return
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Método que establece el precio del dispositivo
     * @param precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Método que devuelve el tipo de atributo del dispositivo
     * @return
     */
    public TipoAtributo getTipoAtributo() {
        return tipoAtributo;
    }

    /**
     * Método que establece el tipo de atributo del dispositivo
     * @param tipoAtributo
     */
    public void setTipoAtributo(TipoAtributo tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }

    /**
     * Método que devuelve la marca del dispositivo
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método que establece la marca del dispositivo
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método que devuelve el modelo del dispositivo
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método que establece el modelo del dispositivo
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Método que devuelve el dispositivo en formato String
     * @return
     */
    @Override
    public String toString() {
        return id + ": " + tipoAtributo + ", " + marca + ", " + modelo + ", " + fechaCompra + ", " + precio + "€";
    }


    /**
     * Compara dos dispositivos por su fecha de compra
     * @param dispositivo
     * @param ascendente
     * @return
     */
    public int compareFecha(Dispositivo dispositivo, boolean ascendente) {
        if (ascendente) {
            return this.fechaCompra.compareTo(dispositivo.getFechaCompra());
        } else {
            return dispositivo.getFechaCompra().compareTo(this.fechaCompra);
        }
    }
}
