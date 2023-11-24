/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.TDA.Lista.Exepciones.ListaVacia;
import Controlador.TDA.Lista.ListaDinamica;
import Modelo.Boleto;
import Modelo.Dao.PasajeroDao;
import Modelo.Pasajero;
import Modelo.TipoDNI;
import Vista.Modelo.ModeloTablaVenta;
import Vista.Util.UtilLista;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class VistaPrincipal extends javax.swing.JFrame {
    
    ModeloTablaVenta mtv = new ModeloTablaVenta();
    PasajeroDao pasajeroControlDao = new PasajeroDao();
    ListaDinamica<Pasajero> ListaPasajero = new ListaDinamica<>();

    /**
     * Creates new form VistaPrincipal
     * @throws Controlador.TDA.Lista.Exepciones.ListaVacia
     */
    public VistaPrincipal() throws ListaVacia {
        initComponents();
        this.setLocationRelativeTo(null);
        UtilLista.cargarComboTipoDni(cbxTipoDni);
        CargarTabla();
    }
    
    private void CargarTabla() {
        mtv.setPasajerosTabla(pasajeroControlDao.getListaPasajeros());
        tblVentas.setModel(mtv);
        tblVentas.updateUI();
        cbxTipoDni.setSelectedIndex(-1);
        cbxOrigen.setSelectedIndex(-1);
        cbxDestino.setSelectedIndex(-1);
        cbxHoraSalida.setSelectedIndex(-1);
        tblVentas.setModel(mtv);
        tblVentas.updateUI();
    }
    
//    private void CargarTabla() {
//        mtv.setPasajerosTabla(pasajeroControlDao.getListaPasajeros());
//        tblVentas.setModel(mtv);
//        tblVentas.updateUI();
//        cbxTipoDni.setSelectedIndex(-1);
//        cbxOrigen.setSelectedIndex(-1);
//        cbxDestino.setSelectedIndex(-1);
//        cbxHoraSalida.setSelectedIndex(-1);
//    }
    
    private Boolean Validar() {
        return (!txtNumeroDNI.getText().trim().isEmpty() && !txtNombre.getText().trim().isEmpty() && !txtApellido.getText().trim().isEmpty()
                && !txtTelefono.getText().trim().isEmpty() && !txtFechaNacimiento.getText().trim().isEmpty() && !txtCantidadBoletos.getText().trim().isEmpty()
                && !txtFechaBoletoSalida.getText().trim().isEmpty() && !txtNumeroAsientos.getText().trim().isEmpty()
                && !txtPrecioFinal.getText().trim().isEmpty() && !txtPrecioUnitario.getText().trim().isEmpty() && !txtDescuento.getText().trim().isEmpty());
    }

    private void Limpiar() throws ListaVacia {
        txtApellido.setText("");
        txtNombre.setText("");
        txtNumeroDNI.setText("");
        txtNumeroAsientos.setText("");
        cbxTipoDni.setSelectedIndex(-1);
        cbxOrigen.setSelectedIndex(-1);
        cbxDestino.setSelectedIndex(-1);
        cbxHoraSalida.setSelectedIndex(-1);
        txtTelefono.setText("");
        txtPrecioFinal.setText("");
        txtPrecioUnitario.setText("");
        txtFechaNacimiento.setText("");
        txtFechaBoletoSalida.setText("");
        txtCantidadBoletos.setText("");
        txtDescuento.setText("");
        pasajeroControlDao.setPasajero(null);
        CargarTabla();

    }
    
    private static int calcularEdad(Date fechaNacimiento) {
        LocalDate fechaNacimientoLocal = fechaNacimiento.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaActual = LocalDate.now();

        return Period.between(fechaNacimientoLocal, fechaActual).getYears();
    }

    private void Guardar() throws ListaVacia, ParseException {

        if (cbxTipoDni.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar combo dni", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtNumeroDNI.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar numero dni", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar nombre", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar apellido", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar numero celular", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtFechaNacimiento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar fecha nacimiento", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (cbxOrigen.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar combo de origen", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (cbxDestino.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar combo de destino", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(txtCantidadBoletos.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Falta llenar cantidad boletos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(txtFechaBoletoSalida.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Falta llenar fecha salida", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (cbxHoraSalida.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar combo hora salida", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(txtNumeroAsientos.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Falta llenar numero asientos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            
            Date fechaActual = new Date();

            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MMMM-yyyy HH:mm");
            String fechaComoString = formatoFecha.format(fechaActual);

            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
            String FechaNacido = txtFechaNacimiento.getText();
            Date fechaSeleccionada = formatoDeFecha.parse(FechaNacido);

            int edad = calcularEdad(fechaSeleccionada);

            Float precioUnitario = 15.5f;
            String Descuento = "";
            if (edad >= 65) {
                precioUnitario = precioUnitario * 0.9f;
                Descuento = "Aplica descuento 10%";
            } 
            else {
                Descuento = "No aplica descuentos";
            }

            Integer IdPersona = ListaPasajero.getLongitud() + 1;
            String Origen = cbxOrigen.getSelectedItem().toString();
            String Destino = cbxDestino.getSelectedItem().toString();
            Integer CantidadBoleto = Integer.parseInt(txtCantidadBoletos.getText());
            String FechaSalida = txtFechaBoletoSalida.getText();
            String HoraSalida = cbxHoraSalida.getSelectedItem().toString();
            String FechaCompra = fechaComoString;
            Integer NumeroAsientos = Integer.valueOf(txtNumeroAsientos.getText());

            Float precioFinal = precioUnitario * CantidadBoleto;

            Boleto BoletoPasajero = new Boleto(IdPersona, Origen, Destino, CantidadBoleto, FechaSalida, HoraSalida,FechaCompra, NumeroAsientos, 15.5f, 14, Descuento, precioFinal);

            pasajeroControlDao.getPasajero().setIdPersona(IdPersona);

            pasajeroControlDao.getPasajero().setTipoDni(UtilLista.obtenerTipoDniControl(cbxTipoDni));

            pasajeroControlDao.getPasajero().setNumeroDni(txtNumeroDNI.getText());
            pasajeroControlDao.getPasajero().setNombrePasajero(txtNombre.getText());
            pasajeroControlDao.getPasajero().setApellidoPasajero(txtApellido.getText());
            pasajeroControlDao.getPasajero().setNumeroTelefono(txtTelefono.getText());
            pasajeroControlDao.getPasajero().setEdadPasajero(edad);
            pasajeroControlDao.getPasajero().setFechaNacimineto(FechaNacido);

            pasajeroControlDao.getPasajero().setBoletoPasajero(BoletoPasajero);

            if (pasajeroControlDao.Persist()) {
                JOptionPane.showMessageDialog(null, "Boleto comprado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                CargarTabla();

                pasajeroControlDao.setPasajero(null);
            } 
            else {
                JOptionPane.showMessageDialog(null, "No se pudo comprar", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        Limpiar();
    }

    private void CargarVista(){
        int fila = tblVentas.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else{
            try {
                pasajeroControlDao.setPasajero(mtv.getPasajerosTabla().getInfo(fila));
                
                txtNombre.setText(pasajeroControlDao.getPasajero().getNombrePasajero());
                txtApellido.setText(pasajeroControlDao.getPasajero().getApellidoPasajero());
                txtNumeroDNI.setText(pasajeroControlDao.getPasajero().getNumeroDni());
                txtTelefono.setText(pasajeroControlDao.getPasajero().getNumeroTelefono());
                txtCantidadBoletos.setText(pasajeroControlDao.getPasajero().getBoletoPasajero().getCantidadBoletos().toString());
                txtNumeroAsientos.setText(pasajeroControlDao.getPasajero().getBoletoPasajero().getNumeroAsiento().toString());
                txtPrecioUnitario.setText(pasajeroControlDao.getPasajero().getBoletoPasajero().getPrecioUnitario().toString());
                txtPrecioFinal.setText(pasajeroControlDao.getPasajero().getBoletoPasajero().getPrecioFinal().toString());
                txtDescuento.setText(pasajeroControlDao.getPasajero().getBoletoPasajero().getDescuento());
                txtFechaNacimiento.setText(pasajeroControlDao.getPasajero().getFechaNacimineto());
                txtFechaBoletoSalida.setText(pasajeroControlDao.getPasajero().getBoletoPasajero().getFechaSalida());
                txtCantidadBoletos.setText(pasajeroControlDao.getPasajero().getBoletoPasajero().getCantidadBoletos().toString());

                
                cbxTipoDni.setSelectedIndex(pasajeroControlDao.getPasajero().getTipoDni().getIdDni()-1);
                
                cbxOrigen.setSelectedItem(pasajeroControlDao.getPasajero().getBoletoPasajero().getOrigen());
                cbxDestino.setSelectedItem(pasajeroControlDao.getPasajero().getBoletoPasajero().getDestino());
                cbxHoraSalida.setSelectedItem(pasajeroControlDao.getPasajero().getBoletoPasajero().getHoraSalida());
                
            } 
            catch (ListaVacia | IndexOutOfBoundsException e) {
                
            }
        }
    }
    
//    public static void cargarCombosFecha(JComboBox dia, JComboBox mes, JComboBox anio) {
//        dia.removeAllItems();
//        mes.removeAllItems();
//        anio.removeAllItems();
//
//        for (int i = 1; i <= 31; i++) {
//            dia.addItem(i);
//        }
//
//        String[] nombresMeses = new DateFormatSymbols().getMonths();
//
//        for (int i = 0; i < 12; i++) {
//            mes.addItem(nombresMeses[i]);
//        }
//
//        Integer anio_actual = new Date().getYear() + 1900;
//        
//        for (int i = anio_actual; i >= (anio_actual - 100); i--) {
//            anio.addItem(i);
//        }
//    }
//    
//    public static boolean validarFecha(String fecha) {
//        
//        try {
//            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
//            formatoFecha.setLenient(false);
//            formatoFecha.parse(fecha);
//        } 
//        catch (ParseException e) {
//            return false;
//        }
//        return true;
//        
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxOrigen = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxDestino = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxHoraSalida = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtNumeroAsientos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        txtPrecioFinal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtCantidadBoletos = new javax.swing.JTextField();
        txtFechaBoletoSalida = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbxTipoDni = new javax.swing.JComboBox<>();
        txtNumeroDNI = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        btnComprarBoleto = new javax.swing.JButton();
        PanelRegistroVentas = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnElimnar = new javax.swing.JButton();
        btnSeleccinar = new javax.swing.JButton();
        btnCalcularVentas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VENTA DE BOLETOS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VENTA DE BOLETOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");

        jLabel1.setText("Origen");

        cbxOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Ríos", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora-Chinchipe" }));

        jLabel3.setText("Destino");

        cbxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Ríos", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora-Chinchipe" }));

        jLabel4.setText("Cantidad de boletos");

        jLabel5.setText("Fecha de salida");

        jLabel6.setText("Hora de salida");

        cbxHoraSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30" }));

        jLabel7.setText("Numero asientos");

        txtNumeroAsientos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setText("Precio Unitario");

        jLabel10.setText("Precio final");

        jLabel11.setText("Descuento");

        txtPrecioUnitario.setEditable(false);
        txtPrecioUnitario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPrecioFinal.setEditable(false);
        txtPrecioFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDescuento.setEditable(false);
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("INFORMACION BOLETO");

        txtCantidadBoletos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtFechaBoletoSalida.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxDestino, 0, 468, Short.MAX_VALUE)
                            .addComponent(cbxHoraSalida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumeroAsientos)
                            .addComponent(txtPrecioUnitario)
                            .addComponent(txtPrecioFinal)
                            .addComponent(txtDescuento)
                            .addComponent(txtCantidadBoletos)
                            .addComponent(txtFechaBoletoSalida)
                            .addComponent(cbxOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidadBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFechaBoletoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumeroAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("INFORAMACION DE USUARIO");

        jLabel13.setText("Tipo de DNI");

        jLabel14.setText("Numero DNI");

        jLabel15.setText("Nombre");

        jLabel16.setText("Apellido");

        jLabel17.setText("Numero celular");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Fecha nacimineto");

        txtNumeroDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtFechaNacimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaNacimientoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNumeroDNI, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFechaNacimiento)
                            .addComponent(cbxTipoDni, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbxTipoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNumeroDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnComprarBoleto.setText("COMPRAR BOLETO");
        btnComprarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarBoletoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("REGISTRO DE VENTAS");

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVentas);

        btnModificar.setText("MODIFICAR SELECCIONADA");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnElimnar.setText("ELIMNAR");
        btnElimnar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimnarActionPerformed(evt);
            }
        });

        btnSeleccinar.setText("SELECCIONAR");
        btnSeleccinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccinarActionPerformed(evt);
            }
        });

        btnCalcularVentas.setText("CALCULAR TOTAL VENTAS");
        btnCalcularVentas.setToolTipText("");
        btnCalcularVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRegistroVentasLayout = new javax.swing.GroupLayout(PanelRegistroVentas);
        PanelRegistroVentas.setLayout(PanelRegistroVentasLayout);
        PanelRegistroVentasLayout.setHorizontalGroup(
            PanelRegistroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelRegistroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1130, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroVentasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCalcularVentas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElimnar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccinar)))
                .addContainerGap())
        );
        PanelRegistroVentasLayout.setVerticalGroup(
            PanelRegistroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelRegistroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnElimnar)
                    .addComponent(btnSeleccinar)
                    .addComponent(btnCalcularVentas))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelRegistroVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 1005, Short.MAX_VALUE)
                        .addComponent(btnComprarBoleto))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComprarBoleto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelRegistroVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarBoletoActionPerformed
        if (cbxTipoDni.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar combo dni", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtNumeroDNI.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar numero dni", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar nombre", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar apellido", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar numero celular", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtFechaNacimiento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar fecha nacimiento", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (cbxOrigen.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar combo de origen", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (cbxDestino.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar combo de destino", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtCantidadBoletos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar cantidad boletos", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtFechaBoletoSalida.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar fecha salida", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (cbxHoraSalida.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Falta seleccionar combo hora salida", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtNumeroAsientos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar numero asientos", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else {
            try {

                String Fechasalidaboleto = txtFechaBoletoSalida.getText();

                SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
                String Fe = txtFechaNacimiento.getText();
                Date fechaSeleccionada = formatoDeFecha.parse(Fe);
                Date FechaSalidaBoletoV = formatoDeFecha.parse(Fechasalidaboleto);

                int edad = calcularEdad(fechaSeleccionada);

                Date fechaActual = new Date();

                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String fechaComoString = formatoFecha.format(fechaActual);

                if (FechaSalidaBoletoV.before(fechaActual)) {
                    JOptionPane.showMessageDialog(null, "La fecha seleccionada ya ha pasado", "FECHA PASADO", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    Float precioUnitario = 15.5f;
                    String Descuento = "";
                    if (edad >= 65) {
                        precioUnitario = precioUnitario * 0.9f;
                        Descuento = "Aplica descuento 10%";
                    } else {
                        Descuento = "No aplica descuentos";
                    }
                    Integer IdPersona = ListaPasajero.getLongitud() + 1;
                    String Origen = cbxOrigen.getSelectedItem().toString();
                    String Destino = cbxDestino.getSelectedItem().toString();
                    Integer CantidadBoleto = Integer.parseInt(txtCantidadBoletos.getText());
                    String FechaSalida = fechaComoString;
                    String HoraSalida = cbxHoraSalida.getSelectedItem().toString();
                    String FechaCompra = fechaComoString;
                    Integer NumeroAsientos = Integer.valueOf(txtNumeroAsientos.getText());
                    
                    Float precioFinal = precioUnitario * CantidadBoleto;

                    Boleto BoletoPasajero = new Boleto(IdPersona, Origen, Destino, CantidadBoleto, FechaSalida, HoraSalida, FechaCompra, NumeroAsientos, 15.5f, 14, Descuento, precioFinal);

                    TipoDNI tipoDNI = UtilLista.obtenerTipoDniControl(cbxTipoDni);
                    String NumeroDNI = txtNumeroDNI.getText();
                    String NombrePasajero = txtNombre.getText();
                    String ApellidoPasajero = txtApellido.getText();
                    String NumeroTelefono = txtTelefono.getText();

                    Pasajero PasajeroGuardar = new Pasajero(IdPersona, tipoDNI, NumeroDNI, NombrePasajero, ApellidoPasajero, NumeroTelefono, edad, BoletoPasajero, Fe);

                    ListaPasajero.Agregar(PasajeroGuardar);

                    Guardar();

                    System.out.println("" + ListaPasajero);
                }
            } 
            catch (ParseException ex) {
                Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (ListaVacia ex) {
                Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnComprarBoletoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int fila = tblVentas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } 
        else {
            try {
                
                

                SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
                String Fe = txtFechaNacimiento.getText();
                Date fechaSeleccionada = formatoDeFecha.parse(Fe);

                int edad = calcularEdad(fechaSeleccionada);
                
                Float precioUnitario = 15.5f;
                String Descuento = "";
                if (edad >= 65) {
                    precioUnitario = precioUnitario * 0.9f;
                    
                    Descuento = "Aplica descuento 10%";
                } 
                else {
                    Descuento = "No aplica descuentos";
                }
                
                Date fechaActual = new Date();

                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String fechaComoString = formatoFecha.format(fechaActual);

                Integer IdPersona = ListaPasajero.getLongitud() + 1;
                String Origen = cbxOrigen.getSelectedItem().toString();
                String Destino = cbxDestino.getSelectedItem().toString();
                Integer CantidadBoleto = Integer.parseInt(txtCantidadBoletos.getText());
                String FechaSalida = fechaComoString;
                String HoraSalida = cbxHoraSalida.getSelectedItem().toString();
                String FechaCompra = fechaComoString;
                Integer NumeroAsientos = Integer.valueOf(txtNumeroAsientos.getText());
                
                Float precioFinal = precioUnitario * CantidadBoleto;

                Boleto BoletoPasajero = new Boleto(IdPersona, Origen, Destino, CantidadBoleto, FechaSalida, HoraSalida, FechaCompra, NumeroAsientos, 15.5f, 14, Descuento, precioFinal);

                TipoDNI tipoDNI = UtilLista.obtenerTipoDniControl(cbxTipoDni);
                String NumeroDNI = txtNumeroDNI.getText();
                String NombrePasajero = txtNombre.getText();
                String ApellidoPasajero = txtApellido.getText();
                String NumeroTelefono = txtTelefono.getText();

                Pasajero PasajeroM = new Pasajero(IdPersona, tipoDNI, NumeroDNI, NombrePasajero, ApellidoPasajero, NumeroTelefono, edad, BoletoPasajero, Fe);

                pasajeroControlDao.Merge(PasajeroM, fila);

                CargarTabla();
                Limpiar();
            } 
            catch (ListaVacia | NumberFormatException | ParseException e) {

            }
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtFechaNacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaNacimientoKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        boolean slash = key == 47;
        boolean delete = key == 8;

        Character c = evt.getKeyChar();

        if (!(Character.isDigit(c) || slash || delete)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo ingreso de numeros y simbolo /", "TEXTO NO VALIDO", JOptionPane.WARNING_MESSAGE);
        }
        if (txtFechaNacimiento.getText().length() >= 10) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtFechaNacimientoKeyTyped

    private void btnElimnarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimnarActionPerformed
        // TODO add your handling code here:
        int fila = tblVentas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } 
        else {
            pasajeroControlDao.Eliminar(fila - 1);
            CargarTabla();
        }
    }//GEN-LAST:event_btnElimnarActionPerformed

    private void btnSeleccinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccinarActionPerformed
        // TODO add your handling code here:
        CargarVista();
    }//GEN-LAST:event_btnSeleccinarActionPerformed

    private void btnCalcularVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularVentasActionPerformed
        // TODO add your handling code here:
        double sumaPrecioFinal = mtv.sumarColumna(16);
        
        JOptionPane.showMessageDialog(null, "La suma de todos los voletos vendidos es: $ "+sumaPrecioFinal);
        
    }//GEN-LAST:event_btnCalcularVentasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            try {
                new VistaPrincipal().setVisible(true);
            } catch (ListaVacia ex) {
                Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelRegistroVentas;
    private javax.swing.JButton btnCalcularVentas;
    private javax.swing.JButton btnComprarBoleto;
    private javax.swing.JButton btnElimnar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccinar;
    private javax.swing.JComboBox<String> cbxDestino;
    private javax.swing.JComboBox<String> cbxHoraSalida;
    private javax.swing.JComboBox<String> cbxOrigen;
    private javax.swing.JComboBox<String> cbxTipoDni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCantidadBoletos;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtFechaBoletoSalida;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroAsientos;
    private javax.swing.JTextField txtNumeroDNI;
    private javax.swing.JTextField txtPrecioFinal;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
