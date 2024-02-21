package org.example.actividadfinal.models;

import org.example.actividadfinal.TipoAtributo;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa un dispositivo
 * @author Guillem Ruiz
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
     * @param id id del dispositivo
     * @param fechaCompra fecha de compra del dispositivo
     * @param precio precio del dispositivo
     * @param tipoAtributo tipo de dispositivo
     * @param marca marca del dispositivo
     * @param modelo modelo del dispositivo
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
     * @return id del dispositivo
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
     * @return fecha compra del dispositivo
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
     * @return precio del dispositivo
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
     * @return tipo de dispositivo
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
     * @return marca del dispositivo
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
     * @return modelo del dispositivo
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
     * @return string con los atributos del dispositivo
     */
    @Override
    public String toString() {
        return id + ": " + tipoAtributo + ", " + marca + ", " + modelo + ", " + fechaCompra + ", " + precio + "€";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dispositivo that)) return false;
        return getPrecio() == that.getPrecio() && Objects.equals(getId(), that.getId()) && Objects.equals(getFechaCompra(), that.getFechaCompra()) && getTipoAtributo() == that.getTipoAtributo() && Objects.equals(getMarca(), that.getMarca()) && Objects.equals(getModelo(), that.getModelo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFechaCompra(), getPrecio(), getTipoAtributo(), getMarca(), getModelo());
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
