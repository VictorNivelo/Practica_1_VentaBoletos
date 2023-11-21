/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Victor
 */
public class Boleto {
    private Integer idBoleto;
    private Date FechaSalida;
    private Integer HoraSalida;
    private Date FechaCompra;
    private String Origen;
    private String Destino;
    private Integer NumeroAsiento;
    private String CantidadBoletos;
    private Float PrecioUnitario;
    private Float PrecioFinal;
    private Integer Iva;
    private Float Descuento;

    public Boleto() {
        
    }

    public Boleto(Integer idBoleto, Date FechaSalida, Integer HoraSalida, Date FechaCompra, String Origen, String Destino, Integer NumeroAsiento, String CantidadBoletos, Float PrecioUnitario, Float PrecioFinal, Integer Iva, Float Descuento) {
        this.idBoleto = idBoleto;
        this.FechaSalida = FechaSalida;
        this.HoraSalida = HoraSalida;
        this.FechaCompra = FechaCompra;
        this.Origen = Origen;
        this.Destino = Destino;
        this.NumeroAsiento = NumeroAsiento;
        this.CantidadBoletos = CantidadBoletos;
        this.PrecioUnitario = PrecioUnitario;
        this.PrecioFinal = PrecioFinal;
        this.Iva = Iva;
        this.Descuento = Descuento;
    }

    public Integer getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Date getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(Date FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public Integer getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(Integer HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public Date getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(Date FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public Integer getNumeroAsiento() {
        return NumeroAsiento;
    }

    public void setNumeroAsiento(Integer NumeroAsiento) {
        this.NumeroAsiento = NumeroAsiento;
    }

    public String getCantidadBoletos() {
        return CantidadBoletos;
    }

    public void setCantidadBoletos(String CantidadBoletos) {
        this.CantidadBoletos = CantidadBoletos;
    }

    public Float getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(Float PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public Float getPrecioFinal() {
        return PrecioFinal;
    }

    public void setPrecioFinal(Float PrecioFinal) {
        this.PrecioFinal = PrecioFinal;
    }

    public Integer getIva() {
        return Iva;
    }

    public void setIva(Integer Iva) {
        this.Iva = Iva;
    }

    public Float getDescuento() {
        return Descuento;
    }

    public void setDescuento(Float Descuento) {
        this.Descuento = Descuento;
    }
    
}
