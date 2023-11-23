/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Util;

import Controlador.TDA.Lista.Exepciones.ListaVacia;
import Modelo.Dao.TipoDNIDao;
import Modelo.TipoDNI;
import javax.swing.JComboBox;

/**
 *
 * @author Victor
 */
public class UtilLista {
    public static void cargarComboTipoDni(JComboBox cbx) throws ListaVacia{
        TipoDNIDao rc = new TipoDNIDao();
        cbx.removeAllItems();
        
        if(rc.getListaPasajeros().EstaVacio()){
            throw new ListaVacia("No hay roles que mostrar");
        }
        else{
           for (int i = 0; i < rc.getListaPasajeros().getLongitud(); i++) {
            cbx.addItem(rc.getListaPasajeros().getInfo(i));
           }
        }
    }
    
    public static TipoDNI obtenerTipoDniControl(JComboBox cbx){
        return (TipoDNI) cbx.getSelectedItem();
    }
}
