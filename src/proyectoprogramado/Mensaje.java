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
public class Mensaje extends javax.swing.JDialog {

    //Declaración de variables de instancia
    private VehiculosUsados datUsados;
    private VehiculosNuevos datNuevos;
    private String tipo;
    private int id;
    /**
     * Creates new form Mensaje
     * @param parent
     * @param modal
     */
    
    //Método constructor
    public Mensaje(javax.swing.JDialog parent, boolean modal, String tipo, int id) {
        super(parent, modal);  
        initComponents(); //Carga todo los objetos 
        this.setLocationRelativeTo(null); //Posiciona el JDialog en el centro de la pantalla  
        
        //Asigna valor a la variable de instancia
        this.tipo = tipo;        
        this.id = id;
        
        //Ejecuta el método
        this.cargarDatos();
    }
    
    public void cargarDatos(){               
        
        //Condicional para diferenciar si la información a mostrar corresponde a un vehículo usado o nuevo
        if(this.tipo.equals("Usado")){            
            datUsados = null;
            
            //Ciclo para recorrer un objeto 
            for(VehiculosUsados v : vehiculosUsados){
                
                //Condicional buscar en el arrayList el número de cotización que corresponde al id de la cotización que se desea mostrar en pantalla
                if(v.getNumeroCotizacion() == id) {
                    datUsados = v; //Asigna el objeto "v" al objeto "datUsados"
                }
            }
            
            //Asignación de valores a los labels para mostrar en pantalla
            this.lblNumCotMensaje.setText(Integer.toString(this.datUsados.getNumeroCotizacion()));
            this.lblIdentificacionMensaje.setText(this.datUsados.getIdentificacion());
            this.lblNombreMensaje.setText(this.datUsados.getNombre());
            this.lblEdadMensaje.setText(Integer.toString(this.datUsados.getEdad()));
            this.lblValorVehicMensaje.setText(Integer.toString(this.datUsados.getMontoVehiculo()));
            this.lblPrimaVehicMensaje.setText(Double.toString(this.datUsados.getPrima()));
            this.lblDescuentosMensaje.setText(Double.toString(this.datUsados.getDescTotal()));
            this.lblIVAMensaje.setText(Double.toString(this.datUsados.getIVA()));
            this.lblSubtotal.setText(Double.toString(this.datUsados.getSubTotal()));
            this.lblComisionMensaje.setText(Double.toString(this.datUsados.getComision()));
            this.lblRecargosMensaje.setText(Double.toString(this.datUsados.getRecarg()));
            this.lblTotalMensaje.setText(Double.toString(this.datUsados.getTotal()));
        }
        
        //Condicional para diferenciar si la información a mostrar corresponde a un vehículo usado o nuevo
        if (this.tipo.equals("Nuevo")){
            datNuevos = null;
            
            //Ciclo para recorrer un objeto
            for(VehiculosNuevos v : vehiculosNuevos){
                

                if(v.getNumeroCotizacion() == id) {
                    datNuevos = v;
                }
            }
            //Asignación de valores a los labels para mostrar en pantalla
            this.lblNumCotMensaje.setText(Integer.toString(this.datNuevos.getNumeroCotizacion()));
            this.lblIdentificacionMensaje.setText(this.datNuevos.getIdentificacion());
            this.lblNombreMensaje.setText(this.datNuevos.getNombre());
            this.lblEdadMensaje.setText(Integer.toString(this.datNuevos.getEdad()));
            this.lblValorVehicMensaje.setText(Integer.toString(this.datNuevos.getMontoVehiculo()));
            this.lblPrimaVehicMensaje.setText(Double.toString(this.datNuevos.getPrima()));
            this.lblDescuentosMensaje.setText(Double.toString(this.datNuevos.getDescTotal()));
            this.lblIVAMensaje.setText(Double.toString(this.datNuevos.getIVA()));
            this.lblSubtotal.setText(Double.toString(this.datNuevos.getSubTotal()));
            this.lblComisionMensaje.setText(Double.toString(this.datNuevos.getComision()));
            this.lblRecargosMensaje.setText(Double.toString(this.datNuevos.getRecarg()));
            this.lblTotalMensaje.setText(Double.toString(this.datNuevos.getTotal()));
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

        jLabel1 = new javax.swing.JLabel();
        lblNumCotMensaje = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAceptarMensaje = new javax.swing.JButton();
        lblIdentificacionMensaje = new javax.swing.JLabel();
        lblNombreMensaje = new javax.swing.JLabel();
        lblEdadMensaje = new javax.swing.JLabel();
        lblValorVehicMensaje = new javax.swing.JLabel();
        lblPrimaVehicMensaje = new javax.swing.JLabel();
        lblDescuentosMensaje = new javax.swing.JLabel();
        lblIVAMensaje = new javax.swing.JLabel();
        lblComisionMensaje = new javax.swing.JLabel();
        lblRecargosMensaje = new javax.swing.JLabel();
        lblTotalMensaje = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Número de cotización:");

        jLabel2.setText("Identificación:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Edad:");

        jLabel5.setText("Valor del vehículo:");

        jLabel6.setText("Prima pura:");

        jLabel7.setText("Total Descuentos:");

        jLabel8.setText("Total IVA:");

        jLabel9.setText("Total Comisión:");

        jLabel10.setText("Total Recargos:");

        jLabel11.setText("TOTAL A PAGAR:");

        btnAceptarMensaje.setText("Aceptar");
        btnAceptarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarMensajeActionPerformed(evt);
            }
        });

        jLabel12.setText("SUBTOTAL:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptarMensaje)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorVehicMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEdadMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIdentificacionMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumCotMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrimaVehicMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIVAMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblComisionMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecargosMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescuentosMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumCotMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblIdentificacionMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblNombreMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEdadMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblValorVehicMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPrimaVehicMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComisionMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIVAMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblDescuentosMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecargosMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(btnAceptarMensaje)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarMensajeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAceptarMensajeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarMensaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblComisionMensaje;
    private javax.swing.JLabel lblDescuentosMensaje;
    private javax.swing.JLabel lblEdadMensaje;
    private javax.swing.JLabel lblIVAMensaje;
    private javax.swing.JLabel lblIdentificacionMensaje;
    private javax.swing.JLabel lblNombreMensaje;
    private javax.swing.JLabel lblNumCotMensaje;
    private javax.swing.JLabel lblPrimaVehicMensaje;
    private javax.swing.JLabel lblRecargosMensaje;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotalMensaje;
    private javax.swing.JLabel lblValorVehicMensaje;
    // End of variables declaration//GEN-END:variables
}
