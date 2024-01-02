/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramado;

/**
 *
 * @author cgari
 */

//Clase abstracta
public abstract class Cotizacion extends DatosPersonales {

    //Constructor
    public Cotizacion() {
    }

    //Constructor
    public Cotizacion(String nombre, String identificacion, String tipoVehiculo, int edad, int annioVehiculo, int montoVehiculo) {
        super(nombre, identificacion, tipoVehiculo, edad, annioVehiculo, montoVehiculo);
    }

    //Método abstracto
    public abstract void CalcularCotizacion();
}
