package Modelo.Dao;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.Lista.ListaDinamica;
import Modelo.Boleto;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Victor
 */
public class BoletoDao extends DaoImplement<Boleto>{
    private ListaDinamica<Boleto> ListaBoletos = new ListaDinamica<>();
    private Boleto boletos;
    
    public BoletoDao(){
        super (Boleto.class);
    }

    public ListaDinamica<Boleto> getListaBoletos() {
        return ListaBoletos;
    }

    public void setListaBoletos(ListaDinamica<Boleto> ListaBoletos) {
        this.ListaBoletos = ListaBoletos;
    }
    
    public Boleto getBoletos() {
        if(boletos == null){
            boletos = new Boleto();
        }
        return boletos;
    }

    public void setBoletos(Boleto boletos) {
        this.boletos = boletos;
    }
    
    public Boolean Persist(){
        boletos.setIdBoleto(all().getLongitud()+1);
        return Persist(boletos);
    }
}
