/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.TDA.Lista.ListaDinamica;
import Modelo.TipoDNI;

/**
 *
 * @author Victor
 */
public class TipoDniControlador {
    private ListaDinamica<TipoDNI> tipoDni;
    
    public TipoDniControlador() {
        tipoDni = new ListaDinamica<>();
        tipoDni.Agregar(new TipoDNI(1, "Cedula", "Es un ciudadano"));
        tipoDni.Agregar(new TipoDNI(2, "Pasaporte", "Es un extrangero"));
    }

    public ListaDinamica<TipoDNI> getRoles() {
        return tipoDni;
    }

    public void setRoles(ListaDinamica<TipoDNI> roles) {
        this.tipoDni = roles;
    }

}
