/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Pasajero {
    private Integer idPersona;
    private TipoDNI TipoDni;
    private String NumeroDni;
    private String NombrePasajero;
    private String ApellidoPasajero;
    private String NumeroTelefono;
    private Integer EdadPasajero;
    private Boleto boletoPasajero;
    private String FechaNacimineto;
    
    public Pasajero() {
        
    }

    public Pasajero(Integer idPersona, TipoDNI TipoDni, String NumeroDni, String NombrePasajero, String ApellidoPasajero, String NumeroTelefono, Integer EdadPasajero, Boleto boletoPasajero, String FechaNacimineto) {
        this.idPersona = idPersona;
        this.TipoDni = TipoDni;
        this.NumeroDni = NumeroDni;
        this.NombrePasajero = NombrePasajero;
        this.ApellidoPasajero = ApellidoPasajero;
        this.NumeroTelefono = NumeroTelefono;
        this.EdadPasajero = EdadPasajero;
        this.boletoPasajero = boletoPasajero;
        this.FechaNacimineto = FechaNacimineto;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public TipoDNI getTipoDni() {
        return TipoDni;
    }

    public void setTipoDni(TipoDNI TipoDni) {
        this.TipoDni = TipoDni;
    }

    public String getNumeroDni() {
        return NumeroDni;
    }

    public void setNumeroDni(String NumeroDni) {
        this.NumeroDni = NumeroDni;
    }

    public String getNombrePasajero() {
        return NombrePasajero;
    }

    public void setNombrePasajero(String NombrePasajero) {
        this.NombrePasajero = NombrePasajero;
    }

    public String getApellidoPasajero() {
        return ApellidoPasajero;
    }

    public void setApellidoPasajero(String ApellidoPasajero) {
        this.ApellidoPasajero = ApellidoPasajero;
    }

    public String getNumeroTelefono() {
        return NumeroTelefono;
    }

    public void setNumeroTelefono(String NumeroTelefono) {
        this.NumeroTelefono = NumeroTelefono;
    }

    public Integer getEdadPasajero() {
        return EdadPasajero;
    }

    public void setEdadPasajero(Integer EdadPasajero) {
        this.EdadPasajero = EdadPasajero;
    }

    public Boleto getBoletoPasajero() {
        return boletoPasajero;
    }

    public void setBoletoPasajero(Boleto boletoPasajero) {
        this.boletoPasajero = boletoPasajero;
    }

    public String getFechaNacimineto() {
        return FechaNacimineto;
    }

    public void setFechaNacimineto(String FechaNacimineto) {
        this.FechaNacimineto = FechaNacimineto;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "idPersona=" + idPersona + ", TipoDni=" + TipoDni + ", NumeroDni=" + NumeroDni + ", NombrePasajero=" + NombrePasajero + ", ApellidoPasajero=" + ApellidoPasajero + ", NumeroTelefono=" + NumeroTelefono + ", EdadPasajero=" + EdadPasajero + ", boletoPasajero=" + boletoPasajero + ", FechaNacimineto=" + FechaNacimineto + '}';
    }
           
}
