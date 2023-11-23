/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.Lista.ListaDinamica;
import Modelo.TipoDNI;

/**
 *
 * @author Victor
 */
public class TipoDNIDao extends DaoImplement<TipoDNI>{
    private ListaDinamica<TipoDNI> ListaTipoDNI = new ListaDinamica<>();
    private TipoDNI tipoDni;
    
    public TipoDNIDao(){
        super (TipoDNI.class);
    }

    public ListaDinamica<TipoDNI> getListaPasajeros() {
        ListaTipoDNI = all();
        return ListaTipoDNI;
    }

    public void setListaPasajeros(ListaDinamica<TipoDNI> ListaPasajeros) {
        this.ListaTipoDNI = ListaPasajeros;
    }

    public TipoDNI getTipoDni() {
        if(tipoDni == null){
            tipoDni = new TipoDNI();
        }
        return tipoDni;
    }

    public void setTipoDni(TipoDNI tipoDni) {
        this.tipoDni = tipoDni;
    }
    
    public Boolean Persist(){
        tipoDni.setIdDni(all().getLongitud()+1);
        return Persist(tipoDni);
    }
    
    public static void main(String[] args) {
        TipoDNIDao rc = new TipoDNIDao();
        rc.getTipoDni().setDescripcionDni("Es un ciudadano");
        rc.getTipoDni().setNombreDNI("Cedula");
        rc.Persist();
        rc.setTipoDni(null);
        
        rc.getTipoDni().setDescripcionDni("Es un extrangero");
        rc.getTipoDni().setNombreDNI("Pasaporte");
        rc.Persist();
        rc.setTipoDni(null);
        

    }
    
}
