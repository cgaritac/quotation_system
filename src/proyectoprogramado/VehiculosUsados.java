/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramado;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author cgari
 */
public class VehiculosUsados extends Cotizacion implements Serializable {

    //Declaración de las variables de instancia
    protected String asistencia/*, estadoVehiculo*/;
    protected int kilometraje;
    protected double prima, comision, IVA, descTotal, recarg, total, subTotal;
    protected EstadoVehiculo estadoVehiculo;

    protected final double tarifa = 0.0089;

    //Constructor
    public VehiculosUsados() {
    }

    //Constructor
    public VehiculosUsados(String estadVehiculo, String asistencia, int kilometraje, String nombre, String identificacion, String tipoVehiculo, int edad, int annioVehiculo, int montoVehiculo) {
        super(nombre, identificacion, tipoVehiculo, edad, annioVehiculo, montoVehiculo);
        this.asistencia = asistencia;
        this.kilometraje = kilometraje;
        //this.estadoVehiculo = estadoVehiculo;

        estadoVehiculo = EstadoVehiculo.valueOf(estadVehiculo);

        this.CalcularCotizacion();
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
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

    public EstadoVehiculo getEstadoVehiculo() {
        return estadoVehiculo;
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

        double descEstado = 0;

        switch (estadoVehiculo) {
            case EXCELENTE:
                descEstado = subTotal * 0.10;
                break;
            default:
                break;
        }

        descTotal = descEdad + descEstado;

        recarg = 0;

        if (asistencia.equals("Si")) {
            recarg = subTotal + 15000;
        }

        total = subTotal + recarg - descTotal;
    }
}
