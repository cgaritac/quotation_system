/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramado;

import javax.swing.JOptionPane;
import static proyectoprogramado.VariablesGlobales.vehiculosUsados;
import static proyectoprogramado.VariablesGlobales.vehiculosNuevos;

/**
 *
 * @author cgari
 */
public class CalculosSeguros extends javax.swing.JDialog {

    //Declaración de variables de instancia
    private boolean continuar = false;
    private int id;

    /**
     * Creates new form CalculosSeguros
     *
     * @param parent
     * @param modal
     */
    
    //Método constructor
    public CalculosSeguros(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal); 
        initComponents(); //Carga todo los objetos 
        this.setLocationRelativeTo(null); //Posiciona el JFrame en el centro de la pantalla  

        //Asignación de los radioButtons a un buttonGroup
        this.btgTipoVehiculo.add(this.rdbNuevo);
        this.btgTipoVehiculo.add(this.rdbUsado);

        //Asignación de los radioButtons a un buttonGroup
        this.btgAsistenciaVehiculo.add(rdbNo);
        this.btgAsistenciaVehiculo.add(rdbSi);

        //Asignación de los radioButtons a un buttonGroup
        this.btgEstado.add(rdbMB);
        this.btgEstado.add(rdbExc);
        this.btgEstado.add(rdbAcc);

        //Definición del estado inicial de varios objetos en pantalla
        this.rdbNo.setEnabled(false);
        this.rdbSi.setEnabled(false);
        this.lblAsistenciaVehiculo.setEnabled(false);
        this.lblKilometrajeVehiculo.setEnabled(false);
        this.txtKilometraje.setEnabled(false);
        this.lblEstadoVehiculo.setEnabled(false);
        this.rdbExc.setEnabled(false);
        this.rdbMB.setEnabled(false);
        this.rdbAcc.setEnabled(false);

        this.chkbGarantExtend.setEnabled(false);
        this.chkbVehiculoElectr.setEnabled(false);

    }

    public void cargarDatos() {

        //Declaración de variables locales
        String identificacion, nombre, edad, annio, monto, kilometraje = "", asistencia = "", estado = "", errores = "";
        boolean garantiaExt = false, vehiculoElect = false;

        Validaciones validar = new Validaciones(); //Crea un objeto "Validaciones" y lo asigna a "validar" para poder tener acceso a los métodos de la clase Validaciones

        identificacion = this.txtCedula.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
        errores += validar.StringVacios(identificacion, "cedula", 5, 11);/*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/

        nombre = this.txtNombre.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
        errores += validar.StringVacios(nombre, "nombre", 1, 50);/*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/

        edad = this.txtEdad.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
        errores += validar.EnterosVacios(edad, "edad");/*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/

        annio = this.txtAnnio.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
        errores += validar.EnterosVacios(annio, "año del vehículo");/*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/

        monto = this.txtMonto.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
        errores += validar.EnterosVacios(monto, "monto del vehículo");/*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/

        if (this.rdbUsado.isSelected()) {
            kilometraje = this.txtKilometraje.getText(); //Declara la variable local y le asigna los datos del txt field respectivo
            errores += validar.EnterosVacios(kilometraje, "kilometraje");/*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/

            if (this.rdbSi.isSelected()) {
                asistencia = "Si";
            }

            if (this.rdbNo.isSelected()) {
                asistencia = "No";
            }

            errores += validar.seleccionRadioButton(this.rdbSi.isSelected(), this.rdbNo.isSelected(), "asistencia en viaje"); /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/

            if (rdbExc.isSelected()) {
                estado = "EXCELENTE";
            } else if (rdbMB.isSelected()) {
                estado = "MUY_BIEN";
            } else if (rdbAcc.isSelected()) {
                estado = "Aceptable";
            } else {
                errores += "- Es necesario que seleccione una opción del estado del vehículo \n"; /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/
            }
        }

        if (this.rdbNuevo.isSelected()) {
            if (this.chkbGarantExtend.isSelected()) {
                garantiaExt = true;
            } else {
                garantiaExt = false;
            }

            if (this.chkbVehiculoElectr.isSelected()) {
                vehiculoElect = true;
            } else {
                vehiculoElect = false;
            }
        }

        errores += validar.seleccionRadioButton(this.rdbNuevo.isSelected(), this.rdbUsado.isSelected(), "tipo de vehículo"); /*Ejecuta un método del objeto "validar" y lo adiciona a la cadena string de la variable local "errores"*/

        //Condicional para validar si no hay errores en el código para proceder a almacenar el arrayList
        if (errores.isEmpty()) {

            //Convierte a numero los Strings ya validados
            int edadNum = Integer.parseInt(edad);
            int annioNum = Integer.parseInt(annio);
            int montoNum = Integer.parseInt(monto);

            if (this.rdbUsado.isSelected()) {
                int kilometrajeNum = Integer.parseInt(kilometraje);

                VehiculosUsados aux = new VehiculosUsados(estado, asistencia, kilometrajeNum, nombre, identificacion, "Usado", edadNum, annioNum, montoNum);
                vehiculosUsados.add(aux); //Almacena en el ArrayList

                id = aux.getNumeroCotizacion(); //Obtiene el valor del número de cotización y lo almacena en la variable de instancia "id"
            }

            if (this.rdbNuevo.isSelected()) {
                VehiculosNuevos aux = new VehiculosNuevos(garantiaExt, vehiculoElect, nombre, identificacion, "Nuevo", edadNum, annioNum, montoNum);
                vehiculosNuevos.add(aux); //Almacena en el ArrayList

                id = aux.getNumeroCotizacion(); //Obtiene el valor del número de cotización y lo almacena en la variable de instancia "id"
            }

            //Muestra un mensaje en pantalla para indicar que se ingresaron los datos correctamente
            JOptionPane.showMessageDialog(this,
                    "Datos ingresados correctamente!",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            continuar = true;

            //Cierra la ventana del formulario
            this.dispose();

        } else {
            //Muestra un mensaje en pantalla para indicar que hay error en la información ingresada e indica cuál o cuáles son los errores
            JOptionPane.showMessageDialog(this,
                    errores,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

            continuar = false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgTipoVehiculo = new javax.swing.ButtonGroup();
        btgAsistenciaVehiculo = new javax.swing.ButtonGroup();
        btgEstado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblMontoVehiculo = new javax.swing.JLabel();
        lblTipoVehiculo = new javax.swing.JLabel();
        rdbNuevo = new javax.swing.JRadioButton();
        rdbUsado = new javax.swing.JRadioButton();
        chkbGarantExtend = new javax.swing.JCheckBox();
        chkbVehiculoElectr = new javax.swing.JCheckBox();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        btnAceptarCalculos = new javax.swing.JButton();
        lblAnnio = new javax.swing.JLabel();
        txtAnnio = new javax.swing.JTextField();
        lblKilometrajeVehiculo = new javax.swing.JLabel();
        txtKilometraje = new javax.swing.JTextField();
        lblEstadoVehiculo = new javax.swing.JLabel();
        lblAsistenciaVehiculo = new javax.swing.JLabel();
        rdbSi = new javax.swing.JRadioButton();
        rdbNo = new javax.swing.JRadioButton();
        rdbExc = new javax.swing.JRadioButton();
        rdbMB = new javax.swing.JRadioButton();
        rdbAcc = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblCedula.setText("Cédula:");

        lblNombre.setText("Nombre:");

        lblEdad.setText("Edad:");

        lblMontoVehiculo.setText("Monto del vehículo:");

        lblTipoVehiculo.setText("Tipo del vehículo:");

        rdbNuevo.setText("Nuevo");
        rdbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNuevoActionPerformed(evt);
            }
        });

        rdbUsado.setText("Usado");
        rdbUsado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbUsadoActionPerformed(evt);
            }
        });

        chkbGarantExtend.setText("Garantía extendida");

        chkbVehiculoElectr.setText("Vehículo eléctrico");

        btnAceptarCalculos.setText("Calcular Seguro");
        btnAceptarCalculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarCalculosActionPerformed(evt);
            }
        });

        lblAnnio.setText("Año del vehículo:");

        lblKilometrajeVehiculo.setText("Kilometraje:");

        lblEstadoVehiculo.setText("Estado del Vehículo:");

        lblAsistenciaVehiculo.setText("Asistencia en viaje:");

        rdbSi.setText("Si");

        rdbNo.setText("No");
        rdbNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNoActionPerformed(evt);
            }
        });

        rdbExc.setText("Excelente");

        rdbMB.setText("Muy Bien");

        rdbAcc.setText("Aceptable");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptarCalculos)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblCedula)
                                    .addComponent(lblEdad)
                                    .addComponent(lblMontoVehiculo)
                                    .addComponent(lblAnnio))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblTipoVehiculo)
                                    .addGap(13, 13, 13)))
                            .addComponent(lblKilometrajeVehiculo)
                            .addComponent(lblEstadoVehiculo))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnnio, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdbNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbUsado))
                            .addComponent(txtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdbExc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbMB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbAcc))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(chkbVehiculoElectr)
                        .addComponent(chkbGarantExtend)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblAsistenciaVehiculo)
                            .addGap(22, 22, 22)
                            .addComponent(rdbSi)
                            .addGap(18, 18, 18)
                            .addComponent(rdbNo))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEdad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMontoVehiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnnio))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoVehiculo)
                    .addComponent(rdbNuevo)
                    .addComponent(rdbUsado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKilometrajeVehiculo)
                    .addComponent(txtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoVehiculo)
                    .addComponent(rdbExc)
                    .addComponent(rdbMB)
                    .addComponent(rdbAcc))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAsistenciaVehiculo)
                    .addComponent(rdbSi)
                    .addComponent(rdbNo))
                .addGap(18, 18, 18)
                .addComponent(chkbGarantExtend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkbVehiculoElectr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptarCalculos)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarCalculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarCalculosActionPerformed

        //Ejecuta el método
        cargarDatos();

        //Conticional para evaluar si los datos ingresados son correctos para poder continuar
        if (continuar == true) {

            if (this.rdbUsado.isSelected()) {
                String tipo = "Usado";

                //Crea el objeto "ventana" de la clase "CalculosSeguros" y lo inicializa mediante el método constructor "CalculosSeguros"
                Mensaje ventana = new Mensaje(new javax.swing.JDialog(), true, tipo, id);

                //Hace visible el objeto ventana
                ventana.setVisible(true);
            }

            if (this.rdbNuevo.isSelected()) {
                String tipo = "Nuevo";

                //Crea el objeto "ventana" de la clase "CalculosSeguros" y lo inicializa mediante el método constructor "CalculosSeguros"
                Mensaje ventana = new Mensaje(new javax.swing.JDialog(), true, tipo, id);

                //Hace visible el objeto ventana
                ventana.setVisible(true);
            }

            this.dispose(); //Cierra la ventana
        } else {
        }
    }//GEN-LAST:event_btnAceptarCalculosActionPerformed

    private void rdbNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNoActionPerformed


    }//GEN-LAST:event_rdbNoActionPerformed

    private void rdbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNuevoActionPerformed
        //Define el estado de los objetos en pantalla según se seleccione o no el radioButton
        this.rdbNo.setEnabled(false);
        this.rdbSi.setEnabled(false);
        this.lblAsistenciaVehiculo.setEnabled(false);
        this.lblKilometrajeVehiculo.setEnabled(false);
        this.txtKilometraje.setEnabled(false);
        this.lblEstadoVehiculo.setEnabled(false);
        this.rdbExc.setEnabled(false);
        this.rdbMB.setEnabled(false);
        this.rdbAcc.setEnabled(false);

        this.chkbGarantExtend.setEnabled(true);
        this.chkbVehiculoElectr.setEnabled(true);
    }//GEN-LAST:event_rdbNuevoActionPerformed

    private void rdbUsadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbUsadoActionPerformed
        //Define el estado de los objetos en pantalla según se seleccione o no el radioButton
        this.rdbNo.setEnabled(true);
        this.rdbSi.setEnabled(true);
        this.lblAsistenciaVehiculo.setEnabled(true);
        this.lblKilometrajeVehiculo.setEnabled(true);
        this.txtKilometraje.setEnabled(true);
        this.lblEstadoVehiculo.setEnabled(true);
        this.rdbExc.setEnabled(true);
        this.rdbMB.setEnabled(true);
        this.rdbAcc.setEnabled(true);

        this.chkbGarantExtend.setEnabled(false);
        this.chkbVehiculoElectr.setEnabled(false);
    }//GEN-LAST:event_rdbUsadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgAsistenciaVehiculo;
    private javax.swing.ButtonGroup btgEstado;
    private javax.swing.ButtonGroup btgTipoVehiculo;
    private javax.swing.JButton btnAceptarCalculos;
    private javax.swing.JCheckBox chkbGarantExtend;
    private javax.swing.JCheckBox chkbVehiculoElectr;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAnnio;
    private javax.swing.JLabel lblAsistenciaVehiculo;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEstadoVehiculo;
    private javax.swing.JLabel lblKilometrajeVehiculo;
    private javax.swing.JLabel lblMontoVehiculo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipoVehiculo;
    private javax.swing.JRadioButton rdbAcc;
    private javax.swing.JRadioButton rdbExc;
    private javax.swing.JRadioButton rdbMB;
    private javax.swing.JRadioButton rdbNo;
    private javax.swing.JRadioButton rdbNuevo;
    private javax.swing.JRadioButton rdbSi;
    private javax.swing.JRadioButton rdbUsado;
    private javax.swing.JTextField txtAnnio;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtKilometraje;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
