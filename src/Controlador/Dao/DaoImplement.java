/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Dao;

import Controlador.TDA.Lista.ListaDinamica;
import com.thoughtworks.xstream.XStream;
import java.io.FileReader;
import java.io.FileWriter;


/**
 *
 * @author Victor
 */
public class DaoImplement<T> implements DaoInterface<T>{
    private Class<T> clazz;
    private XStream conection;
    private String URL;
    
    public DaoImplement(Class<T> clazz) {
        this.clazz = clazz;
        conection = Bridge.getConection();
        URL = Bridge.URL + clazz.getSimpleName() + ".json";
    }
    
    
    
    @Override
    public Boolean Persist(T dato) {
        ListaDinamica<T> ld = all();
        ld.Agregar(dato);
        
        try {
            conection.toXML(ld,new FileWriter(URL));
            return true;
        } 
        catch (Exception e) {
            return false;
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean Merge(T data, Integer index) {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListaDinamica<T> all() {
        ListaDinamica<T> dl = new ListaDinamica<>();
        try {
            dl = (ListaDinamica<T>)conection.fromXML(new FileReader(URL));
        } 
        catch (Exception e) {
            
        }
        return dl;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//    
//    public void modificar(T dato, Integer pos) throws FileNotFoundException, JAXBException{
//        ListaDinamica<T> lista = listar();
//        try {
//            lista.modificarPosicion(dato, pos);
//            FileOutputStream file = new FileOutputStream(URL);
//            JAXBContext jaxbc = JAXBContext.newInstance(new Class[]{ListaDinamica.class, this.clazz});
//            Marshaller marshaller = jaxbc.createMarshaller(); //Transforma el objeto a xml
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(lista, file);
//        } 
//        catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    
//    public ListaDinamica<T> listar() {
//        ListaDinamica<T> lista = new ListaDinamica<>();
//        try {
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            Document doc = db.parse(URL);
//            NodeList datos = doc.getElementsByTagName(this.clazz.getSimpleName().toLowerCase()); //Encontrar en el archivo las etiquetas de la clase que se busca
//            
//            for(int i = 0; i<datos.getLength();i++){
//                Node n1 = datos.item(i);
//                NodeList nodo1 = n1.getChildNodes();
//                T obj = this.clazz.newInstance();
//                
//                for(int j = 0; j <nodo1.getLength(); j++){
//                    Node dato = nodo1.item(j);
//                    if(dato.getNodeName() != null && !dato.getNodeName().equalsIgnoreCase("")&& 
//                            dato.getTextContent() != null && !dato.getTextContent().equalsIgnoreCase("") && !dato.getNodeName().equalsIgnoreCase("#Text")){
//                        
//                        Method metodo = null; //llamar al método para fijar las etiquetas a un objeto de la clase que se pide
//                        for(Method met : this.clazz.getMethods()){
//                            if(met.getName().equalsIgnoreCase((("set"+Utiles.capitalizar(dato.getNodeName()))))){
//                                metodo = met;
//                                break;
//                            }
//                        }
//                        metodo.invoke(obj, 
//                         Utiles.transformarDato(Utiles.obtenerAtributo(clazz, dato.getNodeName()), dato.getTextContent()));
//                    }
//                }
//                lista.Agregar(obj);
//            }
//        } 
//        catch (Exception e) {
//            System.out.println(e);
//        }
//        return lista;
//    }
//
//    public T obtener(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
