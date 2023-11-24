/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.TDA.Lista;

import Controlador.TDA.Lista.Exepciones.ListaVacia;

/**
 *
 * @author Victor
 * @param <E>
 */
public class ListaDinamica <E>{
    private Nodo<E> cabezera;
    private Nodo<E> ultimo;
    private Integer Longitud;

    public ListaDinamica() {
        cabezera = null;
        ultimo = null;
        Longitud = 0;
    }
    
    public Boolean EstaVacio(){
        return(cabezera == null || Longitud == 0 );
    }
    
    public void Agregar(E info){
        AgregarFinal(info);
    }
    
    public void AgregarCabeza(E info){
        Nodo<E> Ayuda ;
        if(EstaVacio()){
            Ayuda = new Nodo<>(info);
            cabezera = Ayuda;
            ultimo = Ayuda;
            Longitud++;
        }
        else{
            Nodo<E> CabezaAyuda = cabezera;
            Ayuda = new Nodo<>(info, CabezaAyuda);
            cabezera = Ayuda;
            Longitud++;
        }
    }
    
//    public void AgregarFinal(E info) {
//        Nodo<E> Ayuda = new Nodo<>(info, null);
//        if (EstaVacio()) {
//            this.cabezera = Ayuda;
//        } 
//        else {
//            Nodo<E> aux = cabezera;
//            while (aux.getSiguiente() != null) {
//                aux = aux.getSiguiente();
//            }
//            aux.setSiguiente(Ayuda);
//        }
//        Longitud++;
//    }
    
    public void AgregarFinal(E info){
        Nodo<E> Ayuda;
        if(EstaVacio()){
            AgregarCabeza(info);
//            Ayuda = new Nodo<>(info);
//            cabezera = Ayuda;
//            ultimo = Ayuda;
//            Longitud++;
        }
        else{
            Ayuda = new Nodo<>(info, null);
            ultimo.setSiguiente(Ayuda);
            ultimo = Ayuda;
            Longitud++;
        }
    }
    
    private E getPrimero() throws ListaVacia{
        if(EstaVacio()){
            throw new ListaVacia("La lista esta vacia");
    }
        return cabezera.getInfo();
    }
    
//    public E ObtenerPrimero(Integer pos) throws EstaVacia{
//        
//        if (!EstaVacio()) {
//            E info = null;
//            if (pos >= 0 && pos < Longitud) {
//                if (pos == 0) {
//                    info = cabezera.getInfo();
//                } 
//                else {
//                    Nodo<E> ayuda = cabezera;
//                    for (int i = 0; i < pos; i++) {
//                        ayuda = ayuda.getSiguiente();
//                    }
//                    info = ayuda.getInfo();
//                }
//
//            } 
//            else {
//                throw new EstaVacia("La lista esta vacia");
//            }
//            return cabezera.getInfo();
//        } 
//        else {
//            throw new EstaVacia("La lista esta vacia");
//        }
//    }
    
    private E getFinal() throws ListaVacia{
        if(EstaVacio()){
            throw new ListaVacia("La lista esta vacia");
        }
        return ultimo.getInfo();
    }
    
    public E getInfo(Integer indice)throws ListaVacia, IndexOutOfBoundsException{
        return ObtenerNodo(indice).getInfo();
    }
    
    private Nodo<E> ObtenerNodo(Integer indice)throws ListaVacia, IndexOutOfBoundsException{
        if(EstaVacio()){
            throw new ListaVacia("La lista esta vacia");
        }
        else if(indice < 0 || indice.intValue() == Longitud){
            throw new IndexOutOfBoundsException("Fuera de nodo");
        }
        else if(indice == 0){
            return cabezera;
        }
        else if(indice == (Longitud -1)){
            return ultimo;
        }
        else{
            Nodo<E> Buscar = cabezera;
            int contador =0;
            while(contador < indice){
                contador++;
                Buscar = Buscar.getSiguiente();
            }
            return Buscar;
        }
    }
       
//    public void AgregarPosicion (E info, Integer indice)throws ListaVacia{
//        if(EstaVacio() || indice == 0){
//            AgregarCabeza(info);
//        }
//        else if(indice.intValue() == Longitud){
//            AgregarFinal(info);
//        }
//        else{
//            Nodo<E> BuscarPrevio = ObtenerNodo(indice - 1);
//            Nodo<E> Buscar= ObtenerNodo(indice);
//            Nodo<E> Ayuda = new Nodo<>(info, Buscar);
//            BuscarPrevio.setSiguiente(Ayuda);
//            Longitud++;
//        }
//    }
    
//    public void Eliminar(Integer pos) throws IndexOutOfBoundsException, ListaVacia {
//        if (EstaVacio()) {
//            throw new ListaVacia("La lista está vacía");
//        } 
//        else if (pos >= 0 && pos < Longitud) {
//            if (pos == 0) {
//                cabezera = cabezera.getSiguiente();
//                if (Longitud == 1) {
//                    ultimo = null;
//                }
//            } 
//            else {
//                Nodo<E> anterior = ObtenerNodo(pos - 1);
//                Nodo<E> actual = anterior.getSiguiente();
//                anterior.setSiguiente(actual.getSiguiente());
//                if (pos == Longitud - 1) {
//                    ultimo = anterior;
//                }
//            }
//            Longitud--;
//        } 
//        else {
//            throw new IndexOutOfBoundsException("Posición fuera de límites");
//        }
//    }
    
    public E eliminar(Integer pos) throws ListaVacia, IndexOutOfBoundsException {
        if (!EstaVacio()) {
            E dato = null;
            if (pos >= 0 && pos < Longitud) {
                if (pos == 0) {
                    dato = cabezera.getInfo();
                    cabezera = cabezera.getSiguiente();
                    Longitud--;
                } 
                else {
                    Nodo<E> aux = cabezera;
                    
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    
                    dato = aux.getInfo();
                    Nodo<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    Longitud--;
                }
            } 
            else {
                throw new IndexOutOfBoundsException();
            }
            return dato;
        } 
        else {
            throw new ListaVacia();
        }
    }
    
    public E obtener(Integer pos) throws ListaVacia, IndexOutOfBoundsException {

        if (!EstaVacio()) {
            E dato = null;
            if (pos >= 0 && pos < Longitud) {
                if (pos == 0) {
                    dato = cabezera.getInfo();
                } 
                else {
                    Nodo<E> aux = cabezera;
                    
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    
                    dato = aux.getInfo();
                }
            } 
            else {
                throw new IndexOutOfBoundsException();
            }

            return dato;
        } 
        else {
            throw new ListaVacia();
        }

    }
    
//    public void ModificarInfo(E dato, Integer pos) throws IndexOutOfBoundsException, ListaVacia {
//    if (EstaVacio()) {
//        throw new ListaVacia("La lista está vacía");
//    } 
//    else if (pos >= 0 && pos < Longitud) {
//        Nodo<E> nodoModificar = ObtenerNodo(pos);
//        nodoModificar.setInfo(dato);
//    } 
//    else {
//        throw new IndexOutOfBoundsException("Posición fuera de límites");
//    }
//}

    public void ModificarInfo(E dato, Integer pos) throws IndexOutOfBoundsException {
        if (EstaVacio()) {
            Agregar(dato);
        } 
        else if (pos >= 0 && pos < Longitud) {
            if (pos == 0) {
                cabezera.setInfo(dato);
            } 
            else {
                Nodo<E> aux = cabezera;
                
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                
                aux.setInfo(dato);
            }
        } 
        else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    public ListaDinamica<E> ObtenerLista() {
        ListaDinamica<E> lista = new ListaDinamica<>();
        Nodo<E> actual = cabezera;

        while (actual != null) {
            lista.AgregarFinal(actual.getInfo());
            actual = actual.getSiguiente();
        }

        return lista;
    }
    
    public Object[] CovertirEnArreglo() {
        Object[] Arreglos = new Object[Longitud];
        Nodo<E> actual = cabezera;

        for (int i = 0; i < Longitud; i++) {
            Arreglos[i] = actual.getInfo();
            actual = actual.getSiguiente();
        }

        return Arreglos;
    }
    
    public ListaDinamica<E> ConvertirALista(E[] matriz) {
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.Agregar(matriz[i]);
        }
        return this;
    }

    public void vaciar() {
        this.cabezera = null;
        this.Longitud = 0;
    }

    @Override
    public String toString() {
        StringBuilder StringB = new StringBuilder("Datos de lista \n");
        try {
            EstaVacio();
            
            Nodo<E> ayuda = cabezera;
            
            while(ayuda != null){
                StringB.append(ayuda.getInfo().toString());
                ayuda = ayuda.getSiguiente();
            }
        } 
        catch (Exception e) {
            StringB.append(e.getMessage());
        }
        return StringB.toString();
    }

    public Nodo<E> getCabezera() {
        return cabezera;
    }

    public void setCabezera(Nodo<E> cabezera) {
        this.cabezera = cabezera;
    }

    public Nodo<E> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<E> ultimo) {
        this.ultimo = ultimo;
    }

    public Integer getLongitud() {
        return Longitud;
    }

    public void setLongitud(Integer Longitud) {
        this.Longitud = Longitud;
    }
}
