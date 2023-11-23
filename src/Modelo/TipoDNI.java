/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class TipoDNI {
    private Integer idDni;
    private String NombreDNI;
    private String DescripcionDni;

    public TipoDNI() {
        
    }

    public TipoDNI(Integer idDni, String NombreDNI, String DescripcionDni) {
        this.idDni = idDni;
        this.NombreDNI = NombreDNI;
        this.DescripcionDni = DescripcionDni;
    }
    
    public Integer getIdDni() {
        return idDni;
    }

    public void setIdDni(Integer idDni) {
        this.idDni = idDni;
    }

    public String getNombreDNI() {
        return NombreDNI;
    }

    public void setNombreDNI(String NombreDNI) {
        this.NombreDNI = NombreDNI;
    }

    public String getDescripcionDni() {
        return DescripcionDni;
    }

    public void setDescripcionDni(String DescripcionDni) {
        this.DescripcionDni = DescripcionDni;
    }

    @Override
    public String toString() {
        return NombreDNI;
    }
    
}
