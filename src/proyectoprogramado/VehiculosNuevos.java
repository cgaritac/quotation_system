/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramado;

import java.io.Serializable;

/**
 *
 * @author cgari
 */
public class VehiculosNuevos extends Cotizacion implements Serializable {
    
    //Declaración de las variables de instancia
    protected boolean garantiaExtendida, vehiculoelectrico;
    protected final double tarifa = 0.0099;
    protected double prima, comision, IVA, descTotal, recarg, total, subTotal; 

    //Constructor
    public VehiculosNuevos() {
    }

    //Constructor
    public VehiculosNuevos(boolean garantiaExtendida, boolean vehiculoelectrico, String nombre, String identificacion, String tipoVehiculo, int edad, int annioVehiculo, int montoVehiculo) {
        super(nombre, identificacion, tipoVehiculo, edad, annioVehiculo, montoVehiculo);
        this.garantiaExtendida = garantiaExtendida;
        this.vehiculoelectrico = vehiculoelectrico;
        this.CalcularCotizacion();
    }

    public boolean isGarantiaExtendida() {
        return garantiaExtendida;
    }

    public void setGarantiaExtendida(boolean garantiaExtendida) {
        this.garantiaExtendida = garantiaExtendida;
    }

    public boolean isVehiculoelectrico() {
        return vehiculoelectrico;
    }

    public void setVehiculoelectrico(boolean vehiculoelectrico) {
        this.vehiculoelectrico = vehiculoelectrico;
    }

    public double getPrima() {
        return prima;
    }

    public double getComision() {
        return comision;
    }

    public double getIVA() {
        return IVA;
    }

    public double getDescTotal() {
        return descTotal;
    }

    public double getRecarg() {
        return recarg;
    }

    public double getTotal() {
        return total;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }   
    
    //Método que viene de la clase abstarct
    @Override
    public void CalcularCotizacion() {
        prima = montoVehiculo * tarifa;

        comision = prima * 0.08;

        IVA = prima * 0.13;

        subTotal = prima + comision + IVA;

        double descEdad = 0;

        if (edad >= 65) {
            descEdad = subTotal * 0.02;
        }

        double descTipoVehic = 0;

        if (vehiculoelectrico == true) {
            descTipoVehic = subTotal * 0.15;
        }

        descTotal = descEdad + descTipoVehic;

        recarg = 0;

        if (garantiaExtendida = true) {
            recarg = subTotal + 59000;
        }

        total = subTotal + recarg - descTotal;
    }
}
