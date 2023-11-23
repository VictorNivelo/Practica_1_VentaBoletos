/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Modelo;

import Controlador.TDA.Lista.Exepciones.ListaVacia;
import Controlador.TDA.Lista.ListaDinamica;
import Modelo.Pasajero;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaVenta extends AbstractTableModel {

    private ListaDinamica<Pasajero> pasajerosTabla;

    public ListaDinamica<Pasajero> getPasajerosTabla() {
        return pasajerosTabla;
    }

    public void setPasajerosTabla(ListaDinamica<Pasajero> pasajerosTabla) {
        this.pasajerosTabla = pasajerosTabla;
    }
    
    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return pasajerosTabla.getLongitud();
    }

    @Override
    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return 17;
    }

    @Override
    public Object getValueAt(int Fila, int Columna) {

        try {
            Pasajero p = pasajerosTabla.getInfo(Fila);

            switch (Columna) {
                case 0:
                    return (p != null) ? p.getIdPersona() : "";
                case 1:
                    return (p != null) ? p.getTipoDni() : "";
                case 2:
                    return (p != null) ? p.getNumeroDni() : "";
                case 3:
                    return (p != null) ? p.getNombrePasajero() : "";
                case 4:
                    return (p != null) ? p.getApellidoPasajero() : "";
                case 5:
                    return (p != null) ? p.getNumeroTelefono() : "";
                case 6:
                    return (p != null) ? p.getEdadPasajero() : "";
                case 7:
                    return (p != null) ? p.getBoletoPasajero().getOrigen() : "";
                case 8:
                    return (p != null) ? p.getBoletoPasajero().getDestino() : "";
                case 9:
                    return (p != null) ? p.getBoletoPasajero().getCantidadBoletos(): "";
                case 10:
                    return (p != null) ? p.getBoletoPasajero().getFechaCompra() : "";
                case 11:
                    return (p != null) ? p.getBoletoPasajero().getFechaSalida() : "";
                case 12:
                    return (p != null) ? p.getBoletoPasajero().getHoraSalida() : "";
                case 13:
                    return (p != null) ? p.getBoletoPasajero().getNumeroAsiento() : "";
                case 14:
                    return (p != null) ? p.getBoletoPasajero().getPrecioUnitario() : "";
                case 15:
                    return (p != null) ? p.getBoletoPasajero().getDescuento() : "";
                case 16:
                    return (p != null) ? p.getBoletoPasajero().getPrecioFinal() : "";

                default:
                    return null;

            }
        } 
        catch (ListaVacia ex) {

        } 
        catch (IndexOutOfBoundsException ex) {

        }
        return pasajerosTabla;
    }


    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id venta";
            case 1:
                return "Tipo DNI";
            case 2:
                return "Numero DNI";
            case 3:
                return "Nombre";
            case 4:
                return "Apellido";
            case 5:
                return "Numero celular";
            case 6:
                return "Edad";
            case 7:
                return "Origen";
            case 8:
                return "Destino";
            case 9:
                return "Cantidad voletos";
            case 10:
                return "Fecha scompra";
            case 11:
                return "Fecha salida";
            case 12:
                return "Hora salida";
            case 13:
                return "Numero Asientos";
            case 14:
                return "Precio Unitario";
            case 15:
                return "Descuento";
            case 16:
                return "Precio Final";

            default:
                return null;
        }
    }
}
