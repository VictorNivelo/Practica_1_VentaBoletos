/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.Lista.ListaDinamica;
import Modelo.Pasajero;

/**
 *
 * @author Victor
 */
public class PasajeroDao extends DaoImplement<Pasajero>{
    private ListaDinamica<Pasajero> ListaPasajeros = new ListaDinamica<>();
    private Pasajero pasajero;
    
    public PasajeroDao(){
        super (Pasajero.class);
    }

    public ListaDinamica<Pasajero> getListaPasajeros() {
        ListaPasajeros = all();
        return ListaPasajeros;
    }

    public void setListaPasajeros(ListaDinamica<Pasajero> ListaPasajeros) {
        this.ListaPasajeros = ListaPasajeros;
    }

    public Pasajero getPasajero() {
        if(pasajero == null){
            pasajero = new Pasajero();
        }
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
    
    public Boolean Persist(){
        pasajero.setIdPersona(all().getLongitud()+1);
        return Persist(pasajero);
    }
}
