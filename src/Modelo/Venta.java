/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Venta {
    private Integer idVenta;
    private String MetodoPago;
    private Pasajero VentaPasajero;
    private Boleto VentaBoleto;

    public Venta() {
        
    }

    public Venta(Integer idVenta, String MetodoPago, Pasajero VentaPasajero, Boleto VentaBoleto) {
        this.idVenta = idVenta;
        this.MetodoPago = MetodoPago;
        this.VentaPasajero = VentaPasajero;
        this.VentaBoleto = VentaBoleto;
    }
    
    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public String getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(String MetodoPago) {
        this.MetodoPago = MetodoPago;
    }

    public Pasajero getVentaPasajero() {
        return VentaPasajero;
    }

    public void setVentaPasajero(Pasajero VentaPasajero) {
        this.VentaPasajero = VentaPasajero;
    }

    public Boleto getVentaBoleto() {
        return VentaBoleto;
    }

    public void setVentaBoleto(Boleto VentaBoleto) {
        this.VentaBoleto = VentaBoleto;
    }
    
}
